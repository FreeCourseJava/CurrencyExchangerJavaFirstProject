--liquibase formatted sql
--changeset fff:1
CREATE TABLE IF NOT EXISTS public.currencies
(
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    denomination integer NOT NULL,
    abbrev character varying(4) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT currency_pkey PRIMARY KEY (id),
    CONSTRAINT uq_abbrev UNIQUE (abbrev)
    );