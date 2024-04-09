CREATE TABLE tb_client(
    id varchar(255) NOT NULL,
    name varchar(255) NOT NULL,
    register varchar(255) UNIQUE NOT NULL,
    email varchar(255) UNIQUE NOT NULL,
    password varchar(50) NOT NULL,
    wallet decimal(10,2),
    type varchar(30) NOT  NULL,
    PRIMARY KEY (id)
);