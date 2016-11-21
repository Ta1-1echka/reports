CREATE SCHEMA IF NOT EXISTS `reports` DEFAULT CHARACTER SET utf8 ;
USE `reports` ;

-- -----------------------------------------------------
-- Table `reports`.`reports`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `reports`.`reports` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `StartDate` DATE NOT NULL,
  `EndDate` DATE NOT NULL,
  `Performer` VARCHAR(100) NOT NULL,
  `Activity` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;