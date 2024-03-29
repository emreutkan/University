
-- 1.
SELECT * from course where credits > 3;
-- 2.
SELECT * from course where course_id like 'CS-1%';
-- 3.
select name, id from student;
-- 4.
select department.dept_name, course.course_id from department, course where department.dept_name = course.dept_name;
-- 5.
select department.dept_name, COUNT(*) from department, student where department.dept_name = student.dept_name group by dept_name;
-- 6.
select instructor.name, AVG(salary) from instructor group by instructor.name;
-- 7.
select department.dept_name, COUNT(*) from department, instructor where department.dept_name = instructor.dept_name group by department.dept_name;
-- 8.
select dept_name from department where budget = (SELECT max(budget) from department);
-- 9. 
select dept_name from course group by dept_name having count(course_id) > 3;
-- 10.
select building, SUM(budget) from department group by building;
-- 11.
select dept_name from instructor group by dept_name having AVG(salary) > 70000;
-- 12.
select name,tot_cred from student where tot_cred = (select max(tot_cred)from sxtudent);
-- 13.
select course.title from course, department where course.dept_name = department.dept_name and department.budget > 80000;
-- 14. 
 select distinct student.name from student, takes,course where student.id = takes.id and takes.course_id = course.course_id and course.dept_name = 'Comp. Sci.';
-- 15. 
select distinct instructor.name from instructor, teaches where instructor.id = teaches.id
and teaches.semester = 'Spring' and teaches.year = '2018' group by instructor.name 
having count(teaches.course_id) > 1;
