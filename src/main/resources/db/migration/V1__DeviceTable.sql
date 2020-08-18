CREATE TABLE devices
(
    id number NOT NULL,
    local_date_time timestamp without time zone NOT NULL,
    status character varying(255) COLLATE pg_catalog."default" NOT NULL,
    param_id number,
    CONSTRAINT devices_pkey PRIMARY KEY (id)
);