
create table student
(
    id       bigserial,
    name varchar(255) not null,
    age int not null,
    primary key (id)
);

insert into student(name, age)
values ('Igor', 20),('Alex', 25),('Slava', 23);
