
create table doctors(

    id bigint not null auto_increment,
    name varchar(100) not null,
    email varchar(100) not null unique,
    phone varchar(13) not null unique,
    crm varchar(6) not null unique,
    specialty varchar(25) not null,
    publicPlace varchar(100) not null,
    neighborhood varchar(100) not null,
    cep char(9) not null,
    city varchar(100) not null,
    fu char(2) not null,
    complement varchar(100) not null,
    number varchar(100) not null,

    primary key(id)
);