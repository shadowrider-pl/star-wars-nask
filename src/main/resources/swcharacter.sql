CREATE TABLE IF NOT EXISTS swcharacter (
    `id` INT,
    `name` VARCHAR(14) CHARACTER SET utf8,
    `height` INT,
    `mass` INT,
    `hairColor` VARCHAR(5) CHARACTER SET utf8,
    `skinColor` VARCHAR(4) CHARACTER SET utf8,
    `eyeColor` VARCHAR(4) CHARACTER SET utf8,
    `birthYear` VARCHAR(5) CHARACTER SET utf8,
    `gender` VARCHAR(4) CHARACTER SET utf8
);
INSERT INTO swcharacter VALUES
    (1,'Luke Skywalker',172,77,'blond','fair','blue','19BBY','male');
