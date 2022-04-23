DROP table IF EXISTS image;
CREATE table image
(
    ID            serial       not null primary key,
    USERID        int          not null,
    ORIGINAL_NAME varchar(255) not null,
    UNIQUE_NAME   varchar(255) not null,
    FILEPATH      varchar(255) not null,
    FILESIZE      bigint       not null,
    MIMETYPE      varchar(100)
);