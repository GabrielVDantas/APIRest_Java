
CREATE TABLE users
(
    id bigint NOT NULL auto_increment,
    login VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,

    PRIMARY KEY(id)
);