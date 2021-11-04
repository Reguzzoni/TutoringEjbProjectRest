-- Table: my_ejb_project_rest.padrone

-- DROP TABLE my_ejb_project_rest.padrone;

CREATE SCHEMA my_ejb_project_rest;

CREATE TABLE IF NOT EXISTS my_ejb_project_rest.padrone
(
    padrone_id integer NOT NULL,
    nome character varying(50) COLLATE pg_catalog."default" NOT NULL,
    cognome character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT padrone_pkey PRIMARY KEY (padrone_id)
)

TABLESPACE pg_default;

ALTER TABLE my_ejb_project_rest.padrone
    OWNER to postgres;
-- Table: my_ejb_project_rest.gatto

-- DROP TABLE my_ejb_project_rest.gatto;

CREATE TABLE IF NOT EXISTS my_ejb_project_rest.gatto
(
    gatto_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    nome character varying(50) COLLATE pg_catalog."default" NOT NULL,
    razza character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT gatto_pkey PRIMARY KEY (gatto_id)
)

TABLESPACE pg_default;

ALTER TABLE my_ejb_project_rest.gatto
    OWNER to postgres;
-- Table: my_ejb_project_rest.cane

-- DROP TABLE my_ejb_project_rest.cane;

CREATE TABLE IF NOT EXISTS my_ejb_project_rest.cane
(
    cane_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    nome character varying(50) COLLATE pg_catalog."default" NOT NULL,
    razza character varying(50) COLLATE pg_catalog."default" NOT NULL,
    padrone_id integer,
    CONSTRAINT cane_pkey PRIMARY KEY (cane_id)
)

TABLESPACE pg_default;

ALTER TABLE my_ejb_project_rest.cane
    OWNER to postgres;



--sequences
-- SEQUENCE: my_ejb_project_rest.padrone_sequence

-- DROP SEQUENCE my_ejb_project_rest.padrone_sequence;

CREATE SEQUENCE my_ejb_project_rest.padrone_sequence
    INCREMENT 1
    START 10
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE my_ejb_project_rest.padrone_sequence
    OWNER TO postgres;




-- SEQUENCE: my_ejb_project_rest.cane_sequence

-- DROP SEQUENCE my_ejb_project_rest.cane_sequence;

CREATE SEQUENCE my_ejb_project_rest.cane_sequence
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE my_ejb_project_rest.cane_sequence
    OWNER TO postgres;