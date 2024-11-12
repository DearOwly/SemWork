CREATE TABLE application
(
    id           UUID     NOT NULL PRIMARY KEY,
    date         date     NOT NULL,
    applicant_id UUID     NOT NULL,
    type         SMALLINT NOT NULL,
    completed    BOOLEAN  NOT NULL,
    FOREIGN KEY (applicant_id) REFERENCES student (id)
);