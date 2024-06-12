-- Creating database...
CREATE DATABASE NAWY


-- Creating tables...
CREATE TABLE colleges(
id INTEGER PRIMARY KEY,
name VARCHAR(50) NOT NULL
);

CREATE TABLE students (
    id INTEGER PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    collegeId INTEGER,
    FOREIGN KEY (collegeId) REFERENCES colleges(id)
);

CREATE TABLE rankings (
    studentId INTEGER,
    ranking INTEGER NOT NULL,
    year INTEGER NOT NULL,
    FOREIGN KEY (studentId) REFERENCES students(id)
);

-- Inserting sample date...

-- Colleges sample data
INSERT INTO colleges (id, name) VALUES
(1, 'College A'),
(2, 'College B'),
(3, 'College C');

-- Students sample data
INSERT INTO students (id, name, collegeId) VALUES
(1, 'Student 1', 1),
(2, 'Student 2', 1),
(3, 'Student 3', 2),
(4, 'Student 4', 2),
(5, 'Student 5', 3);

-- Rankings sample data
INSERT INTO rankings (studentId, ranking, year) VALUES
(1, 1, 2015),
(2, 2, 2015),
(3, 3, 2015),
(4, 4, 2015),
(5, 5, 2015);

SELECT * FROM colleges;
SELECT * FROM students;
SELECT * FROM rankings;



----  query that lists all colleges that have at least one student with a ranking between 1 and 3 (both inclusive), for the year 2015
SELECT
    c.name AS college_name,
    MIN(r.ranking) AS best_ranking,
    COUNT(*) AS num_students_with_top_ranking
FROM
    colleges c
JOIN
    students s ON c.id = s.collegeId
JOIN
    rankings r ON s.id = r.studentId
WHERE
    r.year = 2015
    AND r.ranking BETWEEN 1 AND 3
GROUP BY
    c.name
HAVING
    COUNT(*) > 0;