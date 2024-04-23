
CREATE TABLE patients
(
    id bigint NOT NULL auto_increment,
    email varchar(50) NOT NULL UNIQUE,
    phone CHAR(13) NOT NULL UNIQUE,
    cpf CHAR(11) NOT NULL UNIQUE,
    public_place VARCHAR(100) NOT NULL,
    neighborhood VARCHAR(100) NOT NULL,
    cep CHAR(9) NOT NULL,
    city VARCHAR(100) NOT NULL,
    fu CHAR(2) NOT NULL,
    complement VARCHAR(100) NOT NULL,
    number VARCHAR(100) NOT NULL,

    PRIMARY KEY(id)
);
