-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema art_gallery
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `art_gallery` ;

-- -----------------------------------------------------
-- Schema art_gallery
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `art_gallery` ;
USE `art_gallery` ;

-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(200) NOT NULL,
  `active` TINYINT NULL,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artwork`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `artwork` ;

CREATE TABLE IF NOT EXISTS `artwork` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(500) NULL,
  `artwork_image` VARCHAR(500) NULL,
  `creation_year` VARCHAR(200) NULL,
  `description` VARCHAR(2000) NULL,
  `user_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_artwork_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_artwork_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `comment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `comment` ;

CREATE TABLE IF NOT EXISTS `comment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `comment_text` VARCHAR(2000) NULL,
  `create_time` DATETIME NULL,
  `update_time` DATETIME NULL,
  `artwork_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`, `artwork_id`, `user_id`),
  INDEX `fk_comment_artwork_idx` (`artwork_id` ASC),
  INDEX `fk_comment_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_comment_artwork`
    FOREIGN KEY (`artwork_id`)
    REFERENCES `artwork` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comment_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rating`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rating` ;

CREATE TABLE IF NOT EXISTS `rating` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `rate` VARCHAR(45) NULL,
  `create_time` DATETIME NULL,
  `artwork_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`, `artwork_id`, `user_id`),
  INDEX `fk_rating_artwork1_idx` (`artwork_id` ASC),
  INDEX `fk_rating_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_rating_artwork1`
    FOREIGN KEY (`artwork_id`)
    REFERENCES `artwork` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_rating_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artwork_copy1`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `artwork_copy1` ;

CREATE TABLE IF NOT EXISTS `artwork_copy1` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `artwork_image` BLOB NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS artist;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'artist' IDENTIFIED BY 'artist';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'artist';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `art_gallery`;
INSERT INTO `user` (`id`, `first_name`, `last_name`, `username`, `password`, `active`, `role`) VALUES (1, 'Ieshia', 'Parker', 'ieshiak', 'esha', true, 'admin');
INSERT INTO `user` (`id`, `first_name`, `last_name`, `username`, `password`, `active`, `role`) VALUES (2, 'Jane', 'Howards', 'jane', 'jane', true, 'user');

COMMIT;


-- -----------------------------------------------------
-- Data for table `artwork`
-- -----------------------------------------------------
START TRANSACTION;
USE `art_gallery`;
INSERT INTO `artwork` (`id`, `title`, `artwork_image`, `creation_year`, `description`, `user_id`) VALUES (1, 'Pink Dragon', 'images/PinkDragon.JPG', '2022', 'Lost in space or more like getting in danger. Yikes!', 1);
INSERT INTO `artwork` (`id`, `title`, `artwork_image`, `creation_year`, `description`, `user_id`) VALUES (2, 'Busy Body', 'images/BusyBody.PNG', '2023', 'My desires are the root to all ambition.', 1);
INSERT INTO `artwork` (`id`, `title`, `artwork_image`, `creation_year`, `description`, `user_id`) VALUES (3, 'Motivational Diamond', 'MotivationalDiamond.PNG', '2022', 'The dollar $ign paired with girls best friend, with big dreams and adoring things.', 1);
INSERT INTO `artwork` (`id`, `title`, `artwork_image`, `creation_year`, `description`, `user_id`) VALUES (4, 'Beautie Full Moon', 'images/BeautieFullMoon.JPG', '2020', 'Tonight lets stare at the Virgo Moon and gaze at its Beauty. ', 1);
INSERT INTO `artwork` (`id`, `title`, `artwork_image`, `creation_year`, `description`, `user_id`) VALUES (5, 'Water Colors ', 'images/WaterColors.JPG', '2021', 'Can you imagine the rainbow?', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `comment`
-- -----------------------------------------------------
START TRANSACTION;
USE `art_gallery`;
INSERT INTO `comment` (`id`, `comment_text`, `create_time`, `update_time`, `artwork_id`, `user_id`) VALUES (1, 'lovely', NULL, NULL, 1, 1);
INSERT INTO `comment` (`id`, `comment_text`, `create_time`, `update_time`, `artwork_id`, `user_id`) VALUES (2, 'this is amazing!', NULL, NULL, 1, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `rating`
-- -----------------------------------------------------
START TRANSACTION;
USE `art_gallery`;
INSERT INTO `rating` (`id`, `rate`, `create_time`, `artwork_id`, `user_id`) VALUES (1, 'Love', NULL, 1, 1);
INSERT INTO `rating` (`id`, `rate`, `create_time`, `artwork_id`, `user_id`) VALUES (2, 'Love', NULL, 2, 1);
INSERT INTO `rating` (`id`, `rate`, `create_time`, `artwork_id`, `user_id`) VALUES (3, 'Like', NULL, 4, 1);

COMMIT;

