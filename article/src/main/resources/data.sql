DROP TABLE IF EXISTS articles;
 
CREATE TABLE articles (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  date_article DATE NOT NULL,
  content VARCHAR(500) NOT NULL,
  id_commentaires INT NULL,
  id_category INT NOT NULL,
  id_user INT NOT NULL
  
);
 
ALTER TABLE articles 
ALTER COLUMN date_article SET DEFAULT CURRENT_TIMESTAMP;

INSERT INTO articles (date_article, content, commentaires,id_category,id_user) VALUES
  (CURRENT_TIMESTAMP();,'Test article1', '1','1','1'),
  (CURRENT_TIMESTAMP();,'Test article2', '2','2','2'),
  (CURRENT_TIMESTAMP();,'Test article3', '3','3','3');