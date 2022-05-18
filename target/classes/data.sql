insert into hardware(code, name, price, hardware_type, amount)
    values ('1', 'Intel Core i7 11700', 323.99, 'CPU', 2);

insert into hardware(code, name, price, hardware_type, amount)
    values ('2', 'Kingston NV1 1TB NVME SSD', 89.99, 'STORAGE', 12);

insert into hardware(code, name, price, hardware_type, amount)
    values ('3', 'Corsair Vengeance LPX DDR4 2x8GB 3200MHz', 99.99, 'RAM', 23);

insert into hardware(code, name, price, hardware_type, amount)
    values ('4', 'Nvidia GTX 1060 6GB', 199.99, 'GPU', 7);


insert into review(id, title, content, grade, hardware_Id)
    values(1, 'Core i7 11700 review', 'Powerful CPU', 5, 1);

insert into review(id, title, content, grade, hardware_Id)
    values(2, 'Core i7 11700 review 2', 'Too expensive', 3, 1);

insert into review(id, title, content, grade, hardware_Id)
    values(3, 'Kingston NV1 1TB review', 'Fast NVME storage', 4, 2);

insert into review(id, title, content, grade, hardware_Id)
    values(4, 'Kingston NV1 1TB review 2', 'Not enough storage', 2, 2);

insert into review(id, title, content, grade, hardware_Id)
    values(5, 'Corsair Vengeance LPX review', 'Fast and good looking', 5, 3);

insert into review(id, title, content, grade, hardware_Id)
    values(6, 'Nvidia GTX 1060 6GB review', 'Old but still reliable', 4, 4);


insert into user(id, username, password)
    values
        (1, 'user', '$2a$12$XiXxSbAP2O8F2haGfDuwFeXs7KFY0zgKt.YE6VgzpcUbByuY0hGcm'),
        (2, 'admin', '$2a$12$h3fGG7atOBwnKgOzfJG2hOcTmFnOIuuIkZaJhB4TxLaGt8v5ehBuW');

insert into authority(id, authority_name)
    values
        (1, 'ROLE_ADMIN'),
        (2, 'ROLE_USER');

insert into user_authority(user_id, authority_id)
    values
        (1, 2),
        (2, 1);