ALTER TABLE student
    ADD type SMALLINT;

ALTER TABLE student
    ALTER COLUMN type SET NOT NULL;

ALTER TABLE student
    DROP COLUMN position;