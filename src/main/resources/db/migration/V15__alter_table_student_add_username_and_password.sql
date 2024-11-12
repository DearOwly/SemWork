ALTER TABLE student
    ADD password VARCHAR(255);

ALTER TABLE student
    ADD username VARCHAR(255);

ALTER TABLE student
    ALTER COLUMN password SET NOT NULL;

ALTER TABLE student
    ALTER COLUMN username SET NOT NULL;