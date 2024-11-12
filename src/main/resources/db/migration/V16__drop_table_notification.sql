ALTER TABLE notification
    DROP CONSTRAINT notification_receiver_id_fkey;

DROP TABLE notification CASCADE;