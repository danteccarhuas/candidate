create table CANDIDATES(
id bigint primary key auto_increment,
name varchar(255) not null, 
email varchar(200) not null, 
gender varchar(15) not null, 
salary_expected decimal(6,2) not null,
currency char(10) not null,
profession varchar(255) not null,
native_language varchar(40)
);