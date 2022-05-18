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
    foreign key(hardware_Id) references hardware(code) on delete cascade
);

create table user (
    id identity,
    username varchar(50) not null unique,
    password varchar(1000) not null
);

create table authority (
    id identity,
    authority_name varchar(255) not null unique
);

create table user_authority (
    user_id bigint not null,
    authority_id bigint not null,
    constraint fk_user foreign key (user_id) references user(id),
    constraint fk_authority foreign key (authority_id) references authority(id)
);