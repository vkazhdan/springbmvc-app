--
-- PostgreSQL database dump
--

-- Dumped from database version 10.5
-- Dumped by pg_dump version 10.5

-- Started on 2019-03-04 10:58:02 EET

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 13241)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 3141 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 200 (class 1259 OID 16804)
-- Name: bookmark; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.bookmark (
    id bigint NOT NULL,
    user_id bigint NOT NULL,
    title character varying(64),
    url character varying(255)
);


ALTER TABLE public.bookmark OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 16408)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 16403)
-- Name: message; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.message (
    id integer NOT NULL,
    text character varying(255)
);


ALTER TABLE public.message OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 16666)
-- Name: user_role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_role (
    user_id bigint NOT NULL,
    roles character varying(255)
);


ALTER TABLE public.user_role OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 16669)
-- Name: usr; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usr (
    id bigint NOT NULL,
    active boolean NOT NULL,
    password character varying(255),
    username character varying(255)
);


ALTER TABLE public.usr OWNER TO postgres;

--
-- TOC entry 3133 (class 0 OID 16804)
-- Dependencies: 200
-- Data for Name: bookmark; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.bookmark (id, user_id, title, url) FROM stdin;
2	1	Google	http://google.com
1	1	Baeldung	https://www.baeldung.com/
\.


--
-- TOC entry 3129 (class 0 OID 16403)
-- Dependencies: 196
-- Data for Name: message; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.message (id, text) FROM stdin;
1	Hello
2	Nice Day
3	Hello Everybody
\.


--
-- TOC entry 3131 (class 0 OID 16666)
-- Dependencies: 198
-- Data for Name: user_role; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.user_role (user_id, roles) FROM stdin;
1	USER
2	ADMIN
4	USER
5	USER
5	ADMIN
6	USER
7	USER
\.


--
-- TOC entry 3132 (class 0 OID 16669)
-- Dependencies: 199
-- Data for Name: usr; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usr (id, active, password, username) FROM stdin;
1	t	$2a$10$nOgTxOmhgH343/ClYWYgpeIfo3i9rQQmHKeynh6gUbUoiZj8bC2Ym	u
2	t	$2a$10$nOgTxOmhgH343/ClYWYgpeIfo3i9rQQmHKeynh6gUbUoiZj8bC2Ym	a
4	t	$2a$10$nOgTxOmhgH343/ClYWYgpeIfo3i9rQQmHKeynh6gUbUoiZj8bC2Ym	uu
5	t	$2a$10$nOgTxOmhgH343/ClYWYgpeIfo3i9rQQmHKeynh6gUbUoiZj8bC2Ym	aa
6	t	$2a$10$nOgTxOmhgH343/ClYWYgpeIfo3i9rQQmHKeynh6gUbUoiZj8bC2Ym	u3
7	t	$2a$10$nOgTxOmhgH343/ClYWYgpeIfo3i9rQQmHKeynh6gUbUoiZj8bC2Ym	u4
\.


--
-- TOC entry 3142 (class 0 OID 0)
-- Dependencies: 197
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 10, true);


--
-- TOC entry 3005 (class 2606 OID 16808)
-- Name: bookmark bookmark_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bookmark
    ADD CONSTRAINT bookmark_pkey PRIMARY KEY (id);


--
-- TOC entry 3001 (class 2606 OID 16407)
-- Name: message message_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.message
    ADD CONSTRAINT message_pkey PRIMARY KEY (id);


--
-- TOC entry 3003 (class 2606 OID 16676)
-- Name: usr usr_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usr
    ADD CONSTRAINT usr_pkey PRIMARY KEY (id);


--
-- TOC entry 3007 (class 2606 OID 16809)
-- Name: bookmark fk3claygmi8gds4yd97ofdtrtnu; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bookmark
    ADD CONSTRAINT fk3claygmi8gds4yd97ofdtrtnu FOREIGN KEY (user_id) REFERENCES public.usr(id);


--
-- TOC entry 3006 (class 2606 OID 16677)
-- Name: user_role fkfpm8swft53ulq2hl11yplpr5; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_role
    ADD CONSTRAINT fkfpm8swft53ulq2hl11yplpr5 FOREIGN KEY (user_id) REFERENCES public.usr(id);


-- Completed on 2019-03-04 10:58:02 EET

--
-- PostgreSQL database dump complete
--

