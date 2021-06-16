-- Database: tttt

-- DROP DATABASE tttt;

CREATE TABLE weather (
	city varchar(80),
	temp_lo int,
	temp_hi int,
	prcp    real,
	date    date,
	umiditate int
);
DROP TABLE vremea;
DROP TABLE weather;


INSERT INTO weather(city, temp_lo, temp_hi,prcp, date, umiditate )
VALUES ('Chisinau', 17, 32, 30.2, '2021-6-15', 52. );

INSERT INTO weather(city, temp_lo, temp_hi,prcp, date, umiditate )
VALUES ('Balti', 13, 25, 20.2, '2021-6-14', 20 );

INSERT INTO weather(city, temp_lo, temp_hi,prcp, date, umiditate )
VALUES ('Cahul', 18, 33, 45, '2021-6-14', 56 );

SELECT city FROM weather;

SELECT city, ( temp_lo + temp_hi) / 2 AS med_weather, date FROM weather;

SELECT * FROM weather WHERE city = 'Chisinau' AND temp_hi <= 35 AND temp_lo > 12; 

SELECT * FROM weather ORDER BY temp_lo;

SELECT * FROM weather ORDER BY umiditate DESC;

SELECT * FROM weather ORDER BY prcp DESC;