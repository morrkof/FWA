DROP table IF EXISTS users;
CREATE table users
(
    ID IDENTITY,
    FIRSTNAME VARCHAR(100) not null,
    LASTNAME  VARCHAR(100) not null,
    EMAIL     VARCHAR(100) not null,
    PHONE     VARCHAR(20)  not null,
    PASSWORD  VARCHAR(50)  not null
);
