CREATE DATABASE `root`

DROP TABLE IF EXIST `board`;

CREATE TABLE `board` (
    `no` int NOT NULL AUTO_INCREMENT,
    `title` varchar(100) NOT NULL,
    `writer` varchar(100) NOT NULL,
    `content` text,
    `reg_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `upd_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `views` int NOT NULL DEFAULT '0',
    PRIMARY KEY (`no`)
)
COMMENT=`게시판`;

INSERT INTO `board` (`title`,`writer`,`content`)
VALUE
("dummy1", "dummy1", "dummy1"),
("dummy2", "dummy2", "dummy2"),
("dummy3", "dummy3", "dummy3"),
("dummy4", "dummy4", "dummy4"),
("dummy5", "dummy5", "dummy5"),
("dummy6", "dummy6", "dummy6"),
("dummy7", "dummy7", "dummy7"),
("dummy8", "dummy8", "dummy8"),
("dummy9", "dummy9", "dummy9"),
("dummy10", "dummy10", "dummy10");