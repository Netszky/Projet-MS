DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(25) NOT NULL,
  mail VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL
);

INSERT INTO comments (on_article_id, post_date, content) VALUES
  ('Julien','julien@mail.fr', 'JulienMDP'),
  ('Lilian', 'lilian@mail.fr', 'LilianMDP'),
  ('Rafael', 'rafael@mail.fr' , 'RafaelMDP');
