DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(25) NOT NULL,
  mail VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL
);

INSERT INTO users (name, mail, password) VALUES
  ('Julien','julien@mail.fr', 'JulienMDP'),
  ('Lilian', 'lilian@mail.fr', 'LilianMDP'),
  ('Rafael', 'rafael@mail.fr' , 'RafaelMDP');
