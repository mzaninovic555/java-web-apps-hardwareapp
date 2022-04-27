create table hardware (
    code identity,
    name varchar(255) not null,
    price decimal not null,
    hardwareType varchar(10),
    amount int
);