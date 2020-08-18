CREATE TABLE params
(
    id number NOT NULL,
    root_threshold real NOT NULL,
    rotor_speed integer NOT NULL,
    slack real NOT NULL,
    CONSTRAINT params_pkey PRIMARY KEY (id)
)