CREATE TABLE event_participant
(
    event_id       UUID NOT NULL,
    participant_id UUID NOT NULL,
    FOREIGN KEY (event_id) REFERENCES event (id),
    FOREIGN KEY (participant_id) REFERENCES student (id)
);