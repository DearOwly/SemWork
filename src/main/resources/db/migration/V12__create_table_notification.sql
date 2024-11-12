CREATE TABLE notification
(
    id          UUID          NOT NULL PRIMARY KEY,
    date        date          NOT NULL,
    title       VARCHAR(255)  NOT NULL,
    description VARCHAR(1023) NOT NULL,
    receiver_id UUID          NOT NULL,
    viewed      BOOLEAN       NOT NULL DEFAULT FALSE,
    FOREIGN KEY (receiver_id) REFERENCES student (id)
);