CREATE TABLE IF NOT EXISTS starship (
    `list_name` VARCHAR(16) CHARACTER SET utf8,
    `list_model` VARCHAR(25) CHARACTER SET utf8,
    `list_manufacturer` VARCHAR(20) CHARACTER SET utf8,
    `list_costInCredits` INT,
    `list_length` NUMERIC(3, 1),
    `list_maxAtmosphericSpeed` INT,
    `list_crew` INT,
    `list_passengers` INT,
    `list_cargoCapacity` INT,
    `list_consumables` VARCHAR(8) CHARACTER SET utf8,
    `list_hyperdriveRating` NUMERIC(2, 1),
    `list_mglt` INT,
    `list_starshipClass` VARCHAR(26) CHARACTER SET utf8
);
INSERT INTO starship VALUES
    ('X-wing','T-65 X-wing','Incom Corporation',149999,12.5,1050,1,0,110,'1 week',1.0,100,'Starfighter'),
    ('Imperial shuttle','Lambda-class T-4a shuttle','Sienar Fleet Systems',240000,20,850,6,20,80000,'2 months',1.0,50,'Armed government transport');
