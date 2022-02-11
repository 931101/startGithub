DROP TABLE free_board;
CREATE TABLE free_board (
board_id VARCHAR2(20) NOT NULL PRIMARY KEY,
uname  VARCHAR2(20) NOT NULL,
title  VARCHAR2(20) NOT NULL,
category  VARCHAR2(6),
content LONG,
viewcount NUMBER,
wdate TIMESTAMP
);
