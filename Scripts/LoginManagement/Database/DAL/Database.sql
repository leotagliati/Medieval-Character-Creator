-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema gradesdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema gradesdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gradesdb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `gradesdb` ;

-- -----------------------------------------------------
-- Table `gradesdb`.`tb_subject`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gradesdb`.`tb_subject` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `SUBJECT` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `SUBJECT_UNIQUE` (`SUBJECT` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `gradesdb`.`tb_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gradesdb`.`tb_user` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` VARCHAR(50) NULL DEFAULT NULL,
  `PASSWORD` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  INDEX `USERNAME` (`ID` ASC) VISIBLE,
  INDEX `idx_Username` (`USERNAME` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `gradesdb`.`tb_exams`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gradesdb`.`tb_exams` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `ID_USER` INT(11) NOT NULL,
  `ID_SUBJECT` INT(11) NOT NULL,
  `EXAMTYPE` VARCHAR(50) NULL DEFAULT NULL,
  `GRADE` FLOAT NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  INDEX `ID_USER_UNIQUE` (`ID_USER` ASC) VISIBLE,
  INDEX `ID_SUBJECT_UNIQUE` (`ID_SUBJECT` ASC) VISIBLE,
  CONSTRAINT `FK_SUBJECT`
    FOREIGN KEY (`ID_SUBJECT`)
    REFERENCES `gradesdb`.`tb_subject` (`ID`),
  CONSTRAINT `FK_USERNAME`
    FOREIGN KEY (`ID_USER`)
    REFERENCES `gradesdb`.`tb_user` (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
