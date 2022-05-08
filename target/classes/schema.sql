create table hardware (
    code identity,
    name varchar(255) not null,
    price decimal not null,
    hardware_type varchar(10),
    amount int
);

create table review (
    id identity,
    title varchar(255) not null,
    content varchar(255) not null,
    grade integer not null,
    hardware_Id integer not null,
    foreign key(hardware_Id) references hardware(code)
);