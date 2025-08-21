
CREATE TABLE ingredient (
                            id INT PRIMARY KEY auto_increment,
                            name VARCHAR(50) NOT NULL
);

CREATE TABLE categorie(
                          id INT PRIMARY KEY auto_increment,
                          name VARCHAR(50)
);

CREATE TABLE recipe (
                        id INT PRIMARY KEY auto_increment,
                        recipe_name VARCHAR(50) NOT NULL,
                        prep_time INT NOT NULL,
                        cook_time INT NOT NULL,
                        difficulty INT NOT null,
                        id_categorie INT NOT NULL,
                        FOREIGN KEY(id_categorie) REFERENCES categorie(id)
);

CREATE TABLE ingredient_recipe (
					   id INT PRIMARY KEY auto_increment,
					   id_ingredient INT NOT NULL,
					   id_recipe INT NOT NULL,
					   quantity VARCHAR(50) NOT NULL,
					   FOREIGN KEY (id_ingredient) REFERENCES ingredient(id) ON DELETE CASCADE,
					   FOREIGN KEY (id_recipe) REFERENCES recipe(id) ON DELETE CASCADE
);

CREATE TABLE comments (
                          id INT PRIMARY KEY auto_increment,
                          text_comment VARCHAR(250) NOT NULL,
                          id_recipe INT NOT NULL,
                          FOREIGN KEY (id_recipe) REFERENCES recipe(id) ON DELETE CASCADE
);

CREATE TABLE step (
                      id SERIAL PRIMARY KEY,
                      text_step VARCHAR(250),
                      id_recipe INT NOT NULL,
                      FOREIGN KEY (id_recipe) REFERENCES recipe(id) ON DELETE CASCADE
);




