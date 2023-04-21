create table if not exists item (
    id identity,
    name varchar(50) not null,
    yearCreated int not null,
    price int not null,
    brand varchar(50) not null
);
