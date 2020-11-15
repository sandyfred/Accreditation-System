CREATE TABLE deptinfo (
deptid int,
deptname varchar(255),
deptcode varchar(255),
userid int,
PRIMARY KEY (deptid),
FOREIGN KEY (userid) REFERENCES userinfo(userid)
);
INSERT INTO deptinfo
VALUES
(1, 'civil', 'CE', 2),
(2, 'mechanical', 'ME', 4),
(3, 'electrical', 'EEE', 3);

