CREATE TABLE chat_message (
    id BIGSERIAL PRIMARY KEY,
    type VARCHAR(20) NOT NULL,
    content TEXT NOT NULL,
    sender VARCHAR(255) NOT NULL,
    session_id VARCHAR(255) NOT NULL
);