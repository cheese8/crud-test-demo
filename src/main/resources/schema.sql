CREATE TABLE `user` (
    `id` int unsigned NOT NULL AUTO_INCREMENT,
    `username` varchar(64) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
    `mobile` varchar(16) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
    `age` int NOT NULL DEFAULT '0',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `user` (id, username, mobile, age) VALUES(1, 'cheese8', '12345678901', 18);
INSERT INTO `user` (id, username, mobile, age) VALUES(2, 'dbunit', '12345678901', 18);
