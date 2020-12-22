DROP TABLE IF EXISTS articles;
DROP TABLE IF EXISTS category;
 
CREATE TABLE articles (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  date_article DATE NOT NULL,
  title VARCHAR(500) NOT NULL,
  content VARCHAR(500) NOT NULL,
  id_category INT NOT NULL,
  id_user INT NOT NULL
  
);

CREATE TABLE category (
  id_category INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL
);

INSERT INTO category (name) VALUES
  ('Sport'),
  ('Politique'),
  ('Troll');
 
ALTER TABLE articles 
ALTER COLUMN date_article SET DEFAULT CURRENT_TIMESTAMP;

INSERT INTO articles (date_article, title, content, id_category, id_user) VALUES
  (CURRENT_TIMESTAMP(),'Titre1','Test article1', '1','1'),
  (CURRENT_TIMESTAMP(),'Titre2','Test article2', '2','2'),
  (CURRENT_TIMESTAMP(),'Titre3','Test article3', '3','3');