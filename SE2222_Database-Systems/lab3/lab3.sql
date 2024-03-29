
-- 1. for student ’70557’, change their department to Finance.
UPDATE student set dept_name = 'Finance' where ID = 70557;
-- 2. increase the salary of all instructors in Comp. Sci. by %10.
UPDATE instructor set salary = salary+(salary*0.10) where dept_name = 'Comp. Sci.';
-- 3. insert a new record into the student table.
INSERT INTO student values(99999,'emre','Comp. Sci.',120);
-- 4. delete all courses from the database that haven’t been selected by any student.
DELETE FROM course where course_id not in (Select course_id from takes);
-- 5. add a rating column to the course table, where the rating is a decimal between 1 and 5.
ALTER TABLE course add rating decimal(2,1) CONSTRAINT check (rating between 1 and 5);
-- 6. set the rating of all courses to 5.
UPDATE course set rating = 5;
-- 7. display students who never failed a course.
Select S.ID, S.name, T.grade from student S, takes T where S.ID = T.ID and T.grade <> 'F';
-- 8. display the total number of student enrollments for courses in each department for the Spring 2018 semester
select d.dept_name, count(t.course_id) from course c,takes t, department d where c.course_id = t.course_id and d.dept_name = c.dept_name and semester = 'Spring' and year = '2018' group by d.dept_name;
-- 9. display students who have taken courses in at least two different departments
select t.ID, count(distinct d.dept_name) from course c,takes t, department d where c.course_id = t.course_id and d.dept_name = c.dept_name group by t.ID having count(distinct d.dept_name) > 1;
-- 10. display department names, semester, year, and count of courses offered by each department each semester
select d.dept_name, t.semester, t.year, count(distinct t.course_id) from course c,takes t, department d where c.course_id = t.course_id and d.dept_name = c.dept_name group by d.dept_name, t.semester, t.year;