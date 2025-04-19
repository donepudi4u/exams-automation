
drop table student_test_paper;
drop table test_paper_questions;
drop table test_paper;
drop table user_subject;
drop table questions;
drop table user;
drop table complexity;
drop table subject;
drop table student;








use `exams-automation`;
select * from user;
select * from subject;
select * from question;

select * from test_paper_questions;


ALTER TABLE questions DROP FOREIGN KEY questions_ibfk_1;
ALTER TABLE user_subject DROP FOREIGN KEY user_subject_ibfk_2;
ALTER TABLE test_paper DROP FOREIGN KEY test_paper_ibfk_1;

ALTER TABLE subject DROP PRIMARY KEY;

ALTER TABLE subject MODIFY COLUMN id INT AUTO_INCREMENT;




ALTER TABLE subject DROP PRIMARY KEY;

-- Add the new auto-incrementing primary key
ALTER TABLE subject ADD COLUMN id INT AUTO_INCREMENT PRIMARY KEY;