CREATE TABLE IF NOT EXISTS PERSON (
  ID IDENTITY PRIMARY KEY NOT NULL,
  FIRSTNAME VARCHAR(50) NOT NULL,
  LASTNAME VARCHAR(50) NOT NULL,
  BIRTHDATE DATE
);