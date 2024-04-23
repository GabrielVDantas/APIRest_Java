

create table doctors
(

    id bigint NOT NULL auto_increment,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone CHAR(13) NOT NULL UNIQUE,
    crm CHAR(6) NOT NULL UNIQUE,
    specialty VARCHAR(25) NOT NULL,
    publicPlace VARCHAR(100) NOT NULL,
    neighborhood VARCHAR(100) NOT NULL,
    cep char(9) NOT NULL,
    city VARCHAR(100) NOT NULL,
    fu char(2) NOT NULL,
    complement VARCHAR(100) NOT NULL,
    number VARCHAR(100) NOT NULL,

    primary key(id)
);