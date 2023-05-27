-- MEMBUAT TABEL --
CREATE TABLE tabel (
	id integer PRIMARY KEY NOT NULL,
	name varchar(100) NOT NULL,
	parent_id integer
);

-- MEMASUKKAN DATA --
INSERT INTO tabel VALUES
(1, 'Zaki', 2),
(2, 'Ilham', NULL),
(3, 'Irwan', 2),
(4, 'Arka', 3);

-- OUTPUT DATA YANG DIINGINKAN --
SELECT a.id, a.name, b.name AS parent_name
FROM tabel AS a
LEFT JOIN tabel AS b ON a.parent_id = b.id
ORDER BY a.id;
	