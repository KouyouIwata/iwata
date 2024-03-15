CREATE TABLE `diarys` (
	`diary_id` SERIAL NOT NULL,
	`content` VARCHAR(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
	PRIMARY KEY (`diary_id`)
) ENGINE=InnoDB;