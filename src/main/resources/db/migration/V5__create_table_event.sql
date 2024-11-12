CREATE TABLE event
(
    id           UUID    NOT NULL PRIMARY KEY,
    date         date    NOT NULL,
    points       INTEGER NOT NULL,
    organizer_id UUID    NOT NULL,
    FOREIGN KEY (organizer_id) REFERENCES student (id)
);