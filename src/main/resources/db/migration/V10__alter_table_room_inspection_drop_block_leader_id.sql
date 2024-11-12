ALTER TABLE room_inspection
    DROP CONSTRAINT room_inspection_block_leader_id_fkey;

ALTER TABLE room_inspection
    DROP COLUMN block_leader_id;