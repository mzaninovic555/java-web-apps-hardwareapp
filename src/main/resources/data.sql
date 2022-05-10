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
    values(2, 'Core i7 11700 review 2', 'Powerful but expensive CPU', 4, 1);

insert into review(id, title, content, grade, hardware_Id)
    values(3, 'Kingston NV1 1TB review', 'Fast storage', 5, 2);

insert into review(id, title, content, grade, hardware_Id)
    values(4, 'Kingston NV1 1TB review 2', 'Powerful and fast NVME', 5, 2);

insert into review(id, title, content, grade, hardware_Id)
    values(5, 'Corsair Vengeance LPX review', 'Fast RAM', 4, 3);

insert into review(id, title, content, grade, hardware_Id)
    values(6, 'Nvidia GTX 1060 6GB review', 'Old but reliable', 3, 4);