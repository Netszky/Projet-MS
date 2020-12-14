DROP TABLE IF EXISTS articles;
 
CREATE TABLE articles (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  date DATE NOT NULL,
  content VARCHAR(500) NOT NULL,
  commentaires VARCHAR(500) NULL,
  id_category INT NOT NULL,
  id_user INT NOT NULL
  
);
 
INSERT INTO articles (content, commentaires,id_category,id_user) VALUES
  ('Test article1', 'Test comment','1','1'),
  ('Test article2', 'Test comment2','2','2'),
  ('Test article3', 'Test comment','3','3');