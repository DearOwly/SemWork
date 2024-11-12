CREATE TABLE announcement
(
    id          UUID          NOT NULL PRIMARY KEY,
    date        date          NOT NULL,
    title       VARCHAR(255)  NOT NULL,
    description VARCHAR(1023) NOT NULL
);