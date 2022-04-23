DROP table IF EXISTS users;
CREATE table users
(
    ID        serial       not null primary key,
    FIRSTNAME varchar(100) not null,
    LASTNAME  varchar(100) not null,
    EMAIL     varchar(100) not null,
    PHONE     varchar(20)  not null,
    PASSWORD  varchar(256) not null,
    AVATAR    int
);
