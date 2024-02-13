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
  PRIMARY KEY (`id`),
  INDEX `fk_comment_artwork_idx` USING BTREE (`artwork_id`),
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
  PRIMARY KEY (`id`),
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
INSERT INTO `user` (`id`, `first_name`, `last_name`, `username`, `password`, `active`, `role`) VALUES (3, 'Tia', 'Washington', 'tia', 'tia', true, 'user');

COMMIT;


-- -----------------------------------------------------
-- Data for table `artwork`
-- -----------------------------------------------------
START TRANSACTION;
USE `art_gallery`;
INSERT INTO `artwork` (`id`, `title`, `artwork_image`, `creation_year`, `description`, `user_id`) VALUES (1, 'Pink Dragon', 'images/PinkDragon.JPG', '2022', 'Lost in space or more like getting in danger. Yikes!', 1);
INSERT INTO `artwork` (`id`, `title`, `artwork_image`, `creation_year`, `description`, `user_id`) VALUES (2, 'Busy Body', 'images/BusyBody.PNG', '2023', 'My desires are the root to all ambition.', 1);
INSERT INTO `artwork` (`id`, `title`, `artwork_image`, `creation_year`, `description`, `user_id`) VALUES (3, 'Motivational Diamond', 'images/MotivationalDiamond.PNG', '2022', 'The dollar $ign paired with girls best friend, with big dreams and adoring things.', 1);
INSERT INTO `artwork` (`id`, `title`, `artwork_image`, `creation_year`, `description`, `user_id`) VALUES (4, 'Beautie Full Moon', 'images/BeautieFullMoon.JPG', '2020', 'Tonight lets stare at the Virgo Moon and gaze at its Beauty. ', 1);
INSERT INTO `artwork` (`id`, `title`, `artwork_image`, `creation_year`, `description`, `user_id`) VALUES (5, 'Water Colors ', 'images/WaterColors.JPG', '2021', 'Can you imagine the rainbow?', 1);
INSERT INTO `artwork` (`id`, `title`, `artwork_image`, `creation_year`, `description`, `user_id`) VALUES (6, 'Bang Bang', 'images/BangBang.PNG', '2023', 'I shot you down, a Kill Bill reference.', 1);
INSERT INTO `artwork` (`id`, `title`, `artwork_image`, `creation_year`, `description`, `user_id`) VALUES (7, 'Cry Me A River', 'images/CryMeARiver.PNG', '2018', 'Tears are for the weak, so I was told as I wiped them away.', 1);
INSERT INTO `artwork` (`id`, `title`, `artwork_image`, `creation_year`, `description`, `user_id`) VALUES (8, 'Esha', 'images/Esha.PNG', '2019', 'Me, myself, and Ieshia!', 1);
INSERT INTO `artwork` (`id`, `title`, `artwork_image`, `creation_year`, `description`, `user_id`) VALUES (9, 'Flowers', 'images/Flowers.PNG', '2018', NULL, 1);
INSERT INTO `artwork` (`id`, `title`, `artwork_image`, `creation_year`, `description`, `user_id`) VALUES (10, 'Heart BREAK Wedding', 'images/HeartBREAKWedding.PNG', '2023', 'Look what you caused, bloody fears, dreadful tears, regretted years.', 1);
INSERT INTO `artwork` (`id`, `title`, `artwork_image`, `creation_year`, `description`, `user_id`) VALUES (11, 'Jump To The Moon', 'images/JumpToTheMoon.PNG', '2018', 'He always said he loves me to the moon and back.', 1);
INSERT INTO `artwork` (`id`, `title`, `artwork_image`, `creation_year`, `description`, `user_id`) VALUES (12, 'King and Queen', 'images/KingQueen.PNG', '2018', 'Oh I just can\'t wait to be King! IMK', 1);
INSERT INTO `artwork` (`id`, `title`, `artwork_image`, `creation_year`, `description`, `user_id`) VALUES (13, 'Liquid Wind', 'images/LiquidWind.PNG', '2020', 'A trip to forever remember.', 1);
INSERT INTO `artwork` (`id`, `title`, `artwork_image`, `creation_year`, `description`, `user_id`) VALUES (14, 'Medusa', 'images/Medusa.PNG', '2017', 'Be aware, in case you stare.', 1);
INSERT INTO `artwork` (`id`, `title`, `artwork_image`, `creation_year`, `description`, `user_id`) VALUES (15, 'Misty', 'images/Misty.PNG', '2021', NULL, 1);
INSERT INTO `artwork` (`id`, `title`, `artwork_image`, `creation_year`, `description`, `user_id`) VALUES (16, 'Personality Glitch', 'images/PersonalityGlitch.PNG', '2023', 'Who, When, and Where?', 1);
INSERT INTO `artwork` (`id`, `title`, `artwork_image`, `creation_year`, `description`, `user_id`) VALUES (17, 'Rowdy Girl', 'images/RowdyGirl.JPG', '2021', 'Dedicated to my forever love, RIP.', 1);
INSERT INTO `artwork` (`id`, `title`, `artwork_image`, `creation_year`, `description`, `user_id`) VALUES (18, 'She Is', 'images/SheIs.PNG', '2019', 'She Is everything and everything She Is.', 1);
INSERT INTO `artwork` (`id`, `title`, `artwork_image`, `creation_year`, `description`, `user_id`) VALUES (19, 'Sunflower Gem', 'images/SunflowerGem.PNG', '2020', 'A beautiful pattern that brings gems to your days.', 1);
INSERT INTO `artwork` (`id`, `title`, `artwork_image`, `creation_year`, `description`, `user_id`) VALUES (20, 'Sun Shine', 'images/SunShine.jpeg', '2022', 'Aint no sunshine when she is gone.', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `comment`
-- -----------------------------------------------------
START TRANSACTION;
USE `art_gallery`;
INSERT INTO `comment` (`id`, `comment_text`, `create_time`, `update_time`, `artwork_id`, `user_id`) VALUES (1, 'lovely', NULL, NULL, 1, 1);
INSERT INTO `comment` (`id`, `comment_text`, `create_time`, `update_time`, `artwork_id`, `user_id`) VALUES (2, 'this is amazing!', NULL, NULL, 2, 2);
INSERT INTO `comment` (`id`, `comment_text`, `create_time`, `update_time`, `artwork_id`, `user_id`) VALUES (3, 'keep your dreams alive', NULL, NULL, 3, 3);
INSERT INTO `comment` (`id`, `comment_text`, `create_time`, `update_time`, `artwork_id`, `user_id`) VALUES (4, 'adoring', NULL, NULL, 4, 1);
INSERT INTO `comment` (`id`, `comment_text`, `create_time`, `update_time`, `artwork_id`, `user_id`) VALUES (5, 'Love, love, love! ', NULL, NULL, 5, 2);
INSERT INTO `comment` (`id`, `comment_text`, `create_time`, `update_time`, `artwork_id`, `user_id`) VALUES (6, 'ooooweee', NULL, NULL, 6, 3);
INSERT INTO `comment` (`id`, `comment_text`, `create_time`, `update_time`, `artwork_id`, `user_id`) VALUES (7, 'Big like from me! ', NULL, NULL, 7, 1);
INSERT INTO `comment` (`id`, `comment_text`, `create_time`, `update_time`, `artwork_id`, `user_id`) VALUES (8, 'Like', NULL, NULL, 8, 2);
INSERT INTO `comment` (`id`, `comment_text`, `create_time`, `update_time`, `artwork_id`, `user_id`) VALUES (9, 'I see you!!!!!!!!', NULL, NULL, 9, 3);
INSERT INTO `comment` (`id`, `comment_text`, `create_time`, `update_time`, `artwork_id`, `user_id`) VALUES (10, 'Love this lots', NULL, NULL, 10, 1);
INSERT INTO `comment` (`id`, `comment_text`, `create_time`, `update_time`, `artwork_id`, `user_id`) VALUES (11, 'its different for sure', NULL, NULL, 11, 2);
INSERT INTO `comment` (`id`, `comment_text`, `create_time`, `update_time`, `artwork_id`, `user_id`) VALUES (12, 'nice', NULL, NULL, 12, 3);
INSERT INTO `comment` (`id`, `comment_text`, `create_time`, `update_time`, `artwork_id`, `user_id`) VALUES (13, 'do you have any for sale?', NULL, NULL, 13, 1);
INSERT INTO `comment` (`id`, `comment_text`, `create_time`, `update_time`, `artwork_id`, `user_id`) VALUES (14, 'That is DOPE', NULL, NULL, 14, 2);
INSERT INTO `comment` (`id`, `comment_text`, `create_time`, `update_time`, `artwork_id`, `user_id`) VALUES (15, 'cute', NULL, NULL, 15, 3);
INSERT INTO `comment` (`id`, `comment_text`, `create_time`, `update_time`, `artwork_id`, `user_id`) VALUES (16, 'can you make me one?', NULL, NULL, 16, 1);
INSERT INTO `comment` (`id`, `comment_text`, `create_time`, `update_time`, `artwork_id`, `user_id`) VALUES (17, 'sweet', NULL, NULL, 17, 2);
INSERT INTO `comment` (`id`, `comment_text`, `create_time`, `update_time`, `artwork_id`, `user_id`) VALUES (18, 'it\'s okay, i guess', NULL, NULL, 18, 3);
INSERT INTO `comment` (`id`, `comment_text`, `create_time`, `update_time`, `artwork_id`, `user_id`) VALUES (19, 'LOOOOOOVVVVVEEEE', NULL, NULL, 19, 1);
INSERT INTO `comment` (`id`, `comment_text`, `create_time`, `update_time`, `artwork_id`, `user_id`) VALUES (20, 'This is fantastic! I love it!', NULL, NULL, 20, 2);

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

-- Drop the existing foreign key constraint
ALTER TABLE rating DROP FOREIGN KEY fk_rating_artwork1;

-- Add the new foreign key constraint with ON DELETE CASCADE
ALTER TABLE rating
ADD CONSTRAINT fk_rating_artwork1
FOREIGN KEY (artwork_id)
REFERENCES artwork (id)
ON DELETE CASCADE;

