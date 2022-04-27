DROP table IF EXISTS users;
CREATE table users
(
    ID        serial       not null primary key,
    FIRSTNAME varchar(256) not null,
    LASTNAME  varchar(256) not null,
    EMAIL     varchar(256) not null,
    PHONE     varchar(256) not null,
    PASSWORD  varchar(256) not null,
    AVATAR    int
);
