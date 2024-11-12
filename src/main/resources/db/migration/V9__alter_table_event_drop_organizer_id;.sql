ALTER TABLE event
    DROP CONSTRAINT event_organizer_id_fkey;

ALTER TABLE event
    DROP COLUMN organizer_id;