use ourhome;

DROP TABLE IF EXISTS `article`;
DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
	`id` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `user_id` varchar(50) NOT NULL UNIQUE,
    `password` varchar(50) NOT NULL,
    `name` varchar(30) NOT NULL,
    `birth` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `gender` char(1) CHECK (`gender` in ('M', 'F')),
    `img` blob
);

CREATE TABLE `article` (
	`article_id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `user_id` INT,
    `title` VARCHAR(100) NOT NULL,
    `content` TEXT NOT NULL,
    `registered_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (`user_id`) REFERENCES `user`(`id`)
);

INSERT INTO `user` (`user_id`, `password`, `name`, `gender`) 
VALUES ('test', '1234', 'name', 'M');

select * from `user`;

INSERT INTO `article` (`user_id`, `title`, `content`) VALUES (1, 'testTitle', 'testContent');

SELECT * FROM `article`;
