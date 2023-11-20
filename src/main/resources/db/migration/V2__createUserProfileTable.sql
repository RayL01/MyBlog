CREATE TABLE UserProfiles (
    user_id INTEGER PRIMARY KEY,
    profile_picture_url VARCHAR(255),
    bio TEXT,
    FOREIGN KEY (user_id) REFERENCES Users(id)
);