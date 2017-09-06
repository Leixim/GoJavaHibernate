CREATE SCHEMA IF NOT EXISTS `initdb` DEFAULT CHARACTER SET utf8 ;
USE `initdb` ;

CREATE TABLE IF NOT EXISTS `initdb`.`companies` (
  `company_id` INT NOT NULL AUTO_INCREMENT,
  `company_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`company_id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `initdb`.`customers` (
  `customer_id` INT NOT NULL AUTO_INCREMENT,
  `customer_name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`customer_id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `initdb`.`developers` (
  `dev_id` INT NOT NULL AUTO_INCREMENT,
  `dev_name` VARCHAR(100) NOT NULL,
  `dev_salary` INT NULL DEFAULT NULL,
  `company_id` INT NOT NULL,
  PRIMARY KEY (`dev_id`),
  INDEX `fk_company_idx` (`company_id` ASC),
  CONSTRAINT `fk_company`
  FOREIGN KEY (`company_id`)
  REFERENCES `initdb`.`companies` (`company_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `initdb`.`projects` (
  `project_id` INT NOT NULL,
  `project_name` VARCHAR(100) NOT NULL,
  `project_cost` INT NOT NULL,
  `company_id` INT NOT NULL,
  `customer_id` INT NOT NULL,
  PRIMARY KEY (`project_id`),
  INDEX `fk_projects_companies1_idx` (`company_id` ASC),
  INDEX `fk_projects_customers1_idx` (`customer_id` ASC),
  CONSTRAINT `fk_companies`
  FOREIGN KEY (`company_id`)
  REFERENCES `initdb`.`companies` (`company_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_customers`
  FOREIGN KEY (`customer_id`)
  REFERENCES `initdb`.`customers` (`customer_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `initdb`.`dev_projects` (
  `dev_id` INT NOT NULL,
  `project_id` INT NOT NULL,
  PRIMARY KEY (`dev_id`, `project_id`),
  INDEX `fk_developers_has_projects_projects1_idx` (`project_id` ASC),
  INDEX `fk_developers_has_projects_developers1_idx` (`dev_id` ASC),
  CONSTRAINT `fk_developers_has_projects_developers1`
  FOREIGN KEY (`dev_id`)
  REFERENCES `initdb`.`developers` (`dev_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_developers_has_projects_projects1`
  FOREIGN KEY (`project_id`)
  REFERENCES `initdb`.`projects` (`project_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `initdb`.`skills` (
  `skill_id` INT NOT NULL AUTO_INCREMENT,
  `skill_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`skill_id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


CREATE TABLE IF NOT EXISTS `initdb`.`dev_skills` (
  `dev_id` INT NOT NULL,
  `skill_id` INT NOT NULL,
  PRIMARY KEY (`dev_id`, `skill_id`),
  INDEX `fk_developers_has_skills_skills1_idx` (`skill_id` ASC),
  INDEX `fk_developers_has_skills_developers_idx` (`dev_id` ASC),
  CONSTRAINT `fk_developers_has_skills_developers`
  FOREIGN KEY (`dev_id`)
  REFERENCES `initdb`.`developers` (`dev_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_developers_has_skills_skills1`
  FOREIGN KEY (`skill_id`)
  REFERENCES `initdb`.`skills` (`skill_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

