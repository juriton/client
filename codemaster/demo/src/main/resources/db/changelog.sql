
  CREATE TABLE "user" (
    id SERIAL CONSTRAINT user_pkey PRIMARY KEY,
    user_name VARCHAR(50),
    password varchar(50)
  );

  CREATE TABLE client (
    id SERIAL CONSTRAINT client_pkey PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    user_name VARCHAR(255),
    email VARCHAR (255),
    address VARCHAR (255),
    country VARCHAR (255),
  );

  ALTER TABLE client ADD COLUMN user_id BIGINT;
  ALTER TABLE client
  ADD CONSTRAINT user_client_fkey
  FOREIGN KEY (user_id)
  REFERENCES "user" (id);

  CREATE TABLE country (
    id SERIAL CONSTRAINT client_pkey PRIMARY KEY,
    name VARCHAR(255),
  );
