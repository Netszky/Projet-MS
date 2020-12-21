DROP TABLE IF EXISTS comments;

CREATE TABLE comments (
  id INT AUTO_INCREMENT PRIMARY KEY,
  on_article_id INT NOT NULL,
  post_date DATE NOT NULL,
  content VARCHAR(500) NOT NULL,
  user_id INT NOT NULL
);

ALTER TABLE comments 
ALTER COLUMN post_date SET DEFAULT CURRENT_TIMESTAMP;

INSERT INTO comments (on_article_id, post_date, content, user_id) VALUES
  ('1', CURRENT_TIMESTAMP(), 'Test comment 1','1'),
  ('2', CURRENT_TIMESTAMP(), 'Test comment 2','2'),
  ('3', CURRENT_TIMESTAMP(), 'Test comment 3','3');
