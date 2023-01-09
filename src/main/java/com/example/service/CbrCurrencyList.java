package com.example.service;

import com.example.entity.Currency;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class CbrCurrencyList implements CurrencyFromWWW {

    private final NumberFormat format;
    private final DocumentBuilder db;


    public CbrCurrencyList() {
        this.format = NumberFormat.getInstance(Locale.forLanguageTag("RU"));
        try {
            db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Currency> getCurrencyRates() {
        // TODO: check if we need to refresh the currency info prior pulling from CBR
        try {
            return this.pullFromCBR();
        } catch (IOException | SAXException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Currency> pullFromCBR() throws IOException, SAXException, ParseException {
        URL url = new URL("http://www.cbr.ru/scripts/XML_daily.asp");

        URLConnection urlConnection = url.openConnection();
        InputStream input = urlConnection.getInputStream();
        Document doc = db.parse(input);
        input.close();
        NodeList currencyXmlList = doc.getElementsByTagName("Valute");

        return parseXmlCurrencyList(currencyXmlList);
    }

    private List<Currency> parseXmlCurrencyList(NodeList currencyXmlList) throws ParseException {
        List<Currency> newList = new ArrayList<>();
        for (int i = 0; i < currencyXmlList.getLength(); i++) {
            Element currencyXmlElement = (Element) currencyXmlList.item(i);

            Currency currency = new Currency(currencyXmlElement.getElementsByTagName("CharCode").item(0).getTextContent(),
                    currencyXmlElement.getElementsByTagName("Name").item(0).getTextContent(),
                    format.parse(currencyXmlElement.getElementsByTagName("Value").item(0).getTextContent()).floatValue(),
                    Integer.parseInt(currencyXmlElement.getElementsByTagName("Nominal").item(0).getTextContent()));

            newList.add(currency);

        }

        return newList;
    }
}
