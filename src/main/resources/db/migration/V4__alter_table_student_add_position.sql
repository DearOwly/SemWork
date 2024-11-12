ALTER TABLE student
    ADD position SMALLINT;

ALTER TABLE student
    ALTER COLUMN position SET NOT NULL;