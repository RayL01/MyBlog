CREATE TYPE user_role AS ENUM ('user', 'admin', 'editor');
ALTER TABLE Users ADD COLUMN role user_role NOT NULL DEFAULT 'user';