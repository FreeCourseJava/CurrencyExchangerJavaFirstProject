package com.example.service;

import com.example.entity.Currency;
import com.example.service.GetCurrencies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    private final GetCurrencies getCurrencies;
    String botToken;

    @Autowired
    public TelegramBot(TelegramBotsApi telegramBotsApi, GetCurrencies getCurrencies,
                       @Value ("${BOT_TOKEN}") String token) throws TelegramApiException {
        this.botToken = token;
        telegramBotsApi.registerBot(this);
        this.getCurrencies = getCurrencies;


    }

    @Override
    public String getBotUsername() {
        return "FFFCurrExchangeJavaBOT";
    }

   @Override
    public String getBotToken() {
        return botToken;
    }



    @Override
    public void onUpdateReceived(Update update) {


        Long chatId = update.getMessage().getChatId();
        String inputText = update.getMessage().getText();

        if (inputText.startsWith("/start")) {
            SendMessage message = new SendMessage();
            message.setChatId(chatId);
            message.setText("Это учебный бот для пересчета курса валют. Команды бота:\n" +
                    "/showcourses - Показать курсы валют\n"
                    + "/convert - Произвести конвертацию валют. Параметры через пробел: " +
                    "количество валюты, аббревиатура конвертируемой валюты, " +
                    "аббревиатура сконвертированной валюты");
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

        if (inputText.startsWith("/showcourses")) {
            SendMessage message = new SendMessage();
            message.setChatId(chatId);

            List<Currency> listCurrencies = getCurrencies.getAllCurrencies();
            for (Currency currCurrency : listCurrencies) {
                message.setText(currCurrency.toString());

                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }

        if (inputText.startsWith("/convert")) {
            SendMessage message = new SendMessage();
            message.setChatId(chatId);
            Currency currFrom = null;
            Currency currTo = null;
            Float amount = 0f;
            Float newAmount = 0f;
            String[] params = inputText.split(" ");
            if (params.length == 4) {
                currFrom = getCurrencies.getCurrency(params[2]);
                currTo = getCurrencies.getCurrency(params[3]);
                try {
                    amount = Float.parseFloat(params[1]);
                } catch (IllegalArgumentException e) {
                    amount = 0f;
                }
            }
            if (currFrom == null || currTo == null || amount == 0f) {
                message.setText("Неверные параметры");
            } else {
                newAmount = amount * currFrom.getCurrencyRate() / currFrom.getCurrencyDenomination() /
                        currTo.getCurrencyRate() * currTo.getCurrencyDenomination();
                message.setText(newAmount.toString());
            }
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}
