CREATE TABLE room_inspection
(
    id              UUID     NOT NULL PRIMARY KEY,
    date            date     NOT NULL,
    room_id         SMALLINT NOT NULL,
    points          INTEGER  NOT NULL,
    block_leader_id UUID     NOT NULL,
    FOREIGN KEY (block_leader_id) REFERENCES student (id),
    FOREIGN KEY (room_id) REFERENCES room (id)
);