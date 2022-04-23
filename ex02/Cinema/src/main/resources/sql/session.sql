DROP table IF EXISTS session;
CREATE table session
(
    ID          serial      not null primary key,
    USERID      int         not null,
    SESSIONDATE date        not null,
    SESSIONTIME time(0)     not null,
    IP          varchar(15) not null
);