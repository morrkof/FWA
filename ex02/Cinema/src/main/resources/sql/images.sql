DROP table IF EXISTS images;
CREATE table images
(
    ID       serial       not null primary key,
    USERID   int          not null references users (id),
    FILENAME varchar(255) not null,
    FILEPATH varchar(255) not null,
    FILE     bytea        not null,
    FILESIZE bigint       not null,
    MIMETYPE varchar(100),
    ISAVATAR bool
);