DROP table IF EXISTS sessions;
CREATE table sessions
(
    ID          serial      not null primary key,
    USERID      int         not null references users (id),
    SESSIONDATE date        not null,
    SESSIONTIME time(0)     not null,
    IP          varchar(15) not null
);