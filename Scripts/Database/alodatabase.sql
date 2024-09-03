-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema characterdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema characterdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `characterdb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `characterdb` ;

-- -----------------------------------------------------
-- Table `characterdb`.`tb_character`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `characterdb`.`tb_character` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `class` VARCHAR(45) NULL DEFAULT NULL,
  `eye_color` INT(11) NULL DEFAULT NULL,
  `skin_color` INT(11) NULL DEFAULT NULL,
  `helm_type` INT(11) NULL DEFAULT NULL,
  `chest_type` INT(11) NULL DEFAULT NULL,
  `legs_type` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
