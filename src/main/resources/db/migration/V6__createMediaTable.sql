CREATE TABLE Media(
  id SERIAL PRIMARY KEY ,
  post_id INTEGER NOT NULL ,
  media_url VARCHAR(255) NOT NULL ,
  media_type VARCHAR(50) NOT NULL CHECK (media_type IN ('image', 'video')),
  FOREIGN KEY (post_id) REFERENCES Posts(id)
);