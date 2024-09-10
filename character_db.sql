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
-- Table `characterdb`.`tb_users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `characterdb`.`tb_users` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` VARCHAR(45) NOT NULL,
  `PASSWORD` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `characterdb`.`tb_character`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `characterdb`.`tb_character` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `users_id` INT(11) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `class` VARCHAR(45) NOT NULL,
  `eye_color` INT(11) NOT NULL,
  `skin_color` INT(11) NOT NULL,
  `helm_type` INT(11) NOT NULL,
  `chest_type` INT(11) NOT NULL,
  `legs_type` INT(11) NOT NULL,
  `gender` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_ID_idx` (`users_id` ASC) VISIBLE,
  CONSTRAINT `FK_ID`
    FOREIGN KEY (`users_id`)
    REFERENCES `characterdb`.`tb_users` (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 21
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
