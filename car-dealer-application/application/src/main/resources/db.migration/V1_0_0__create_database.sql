CREATE TABLE IF NOT EXISTS `file`
(
    `id` INT NOT NULL AUTO_INCREMENT,
    `provider` VARCHAR(100) NOT NULL,
    `email` VARCHAR(255) NOT NULL,
    `password` VARCHAR(100),
    PRIMARY KEY ( id )
);
