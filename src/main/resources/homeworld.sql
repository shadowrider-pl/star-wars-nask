CREATE TABLE IF NOT EXISTS homeworld (
    `name` VARCHAR(8) CHARACTER SET utf8,
    `rotationPeriod` INT,
    `orbitalPeriod` INT,
    `diameter` INT,
    `climate` VARCHAR(4) CHARACTER SET utf8,
    `gravity` VARCHAR(10) CHARACTER SET utf8,
    `terrain` VARCHAR(6) CHARACTER SET utf8,
    `surfaceWater` INT,
    `population` INT
);
INSERT INTO homeworld VALUES
    ('Tatooine',23,304,10465,'arid','1 standard','desert',1,200000);
