DROP DATABASE IF EXISTS `ourhome`;
CREATE DATABASE `ourhome`;
USE ourhome;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
	`id` BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `user_id` varchar(50) NOT NULL UNIQUE,
    `password` varchar(50) NOT NULL,
    `name` varchar(30) NOT NULL,
    `birth` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `gender` char(1) CHECK (`gender` in ('M', 'F')),
    `img` blob
);
INSERT INTO `user` (`user_id`, `password`, `name`, `gender`) 
VALUES ('test', '1234', 'name', 'M');

select * from `user`;

DROP TABLE IF EXISTS `home`;
CREATE TABLE `home`(
	`id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `address` VARCHAR(50) NOT NULL,
    `type` VARCHAR(10) NOT NULL,
    `jeonsae` INT DEFAULT 0,
    `monthly_deposit` INT DEFAULT 0,
    `monthly_pay` INT DEFAULT 0,
    `area` DOUBLE NOT NULL,
    `room_cnt` INT NOT NULL,
    `phone` VARCHAR(20) NOT NULL,
    `registered_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    CONSTRAINT chk_home_type CHECK (`type` IN ("아파트", "원룸"))
);

DROP TABLE IF EXISTS `favorite_home`;
CREATE TABLE `favorite_home`(
	`user_id` BIGINT,
	`home_id` BIGINT,
    `registered_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    CONSTRAINT fk_favorite_home_home FOREIGN KEY (`home_id`) REFERENCES `home`(`id`),
    CONSTRAINT fk_favorite_home_user FOREIGN KEY (`user_id`) REFERENCES `user`(`id`),
    CONSTRAINT pk_favorite_home PRIMARY KEY (`home_id`, `user_id`)
);

DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
	`id` BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `user_id` BIGINT,
    `home_id` BIGINT,
    `title` VARCHAR(100) NOT NULL,
    `content` TEXT NOT NULL,
    `registered_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    CONSTRAINT fk_post_user FOREIGN KEY (`user_id`) REFERENCES `user`(`id`),
    CONSTRAINT fk_post_home FOREIGN KEY (`home_id`) REFERENCES `home`(`id`)
);
INSERT INTO `post` (`user_id`, `title`, `content`) VALUES (1, 'testTitle', 'testContent');

SELECT * FROM `post`;

DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
	`id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `home_id` BIGINT,
    `created_date` TIMESTAMP,
    
    CONSTRAINT fk_room_home FOREIGN KEY (`home_id`) REFERENCES `home`(`id`)
);

DROP TABLE IF EXISTS `entered_room`;
CREATE TABLE `entered_room` (
	`user_id` BIGINT,
    `room_id` BIGINT,
    `registered_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    CONSTRAINT fk_entered_room_user FOREIGN KEY (`user_id`) REFERENCES `user`(`id`),
    CONSTRAINT fk_entered_room_room FOREIGN KEY (`room_id`) REFERENCES `room`(`id`),
    CONSTRAINT pk_entered_room PRIMARY KEY (`user_id`, `room_id`)
);

DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
	`id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `room_id` BIGINT,
    `user_id` BIGINT,
    `registered_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `content` TEXT,
    
    CONSTRAINT fk_message_user FOREIGN KEY (`user_id`) REFERENCES `user`(`id`),
    CONSTRAINT fk_message_room FOREIGN KEY (`room_id`) REFERENCES `room`(`id`)
);

DROP TABLE IF EXISTS `message_status`;
CREATE TABLE `message_status` (   
	`user_id` BIGINT,
    `message_id` BIGINT,
    `is_readed` BOOLEAN,
    
    CONSTRAINT fk_message_status_user FOREIGN KEY (`user_id`) REFERENCES `user`(`id`),
    CONSTRAINT fk_message_status_message FOREIGN KEY (`message_id`) REFERENCES `message`(`id`)
);