CREATE TABLE checklist(
id int,
item varchar(255),
itemstatus bool,
deptid int,
PRIMARY KEY (id),
FOREIGN KEY (deptid) REFERENCES deptinfo(deptid)
);
INSERT INTO checklist
VALUES
(1, 'seminar marks', 1, 1),
(2, 'project reports', 1, 1);

UPDATE checklist
SET item = 'seminar reports',itemstatus = 0
WHERE id = 1;
UPDATE checklist
SET itemstatus = 0
WHERE id = 2;
INSERT INTO checklist
VALUES
(3, 'semester marks', 0, 1),
(4, 'pass percentage', 0, 1),
(5, 'project reports', 0, 2),
(6, 'project expo', 0, 2),
(7, 'techfest', 0, 2),
(8, 'placement stats', 0, 2),
(9, 'semester marks', 0, 3),
(10, 'pass percentage', 0, 3),
(11, 'placement stats', 0, 3),
(12, 'project expo', 0, 3);

