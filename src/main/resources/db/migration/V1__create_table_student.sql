CREATE TABLE student
(
    id            UUID         NOT NULL PRIMARY KEY,
    full_name     VARCHAR(255) NOT NULL,
    gender        SMALLINT     NOT NULL,
    institute     VARCHAR(255) NOT NULL,
    year_of_study INTEGER      NOT NULL
);