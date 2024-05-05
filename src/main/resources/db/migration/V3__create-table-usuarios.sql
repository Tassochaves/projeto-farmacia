CREATE TABLE tb_usuario(
    id BIGINT NOT NULL auto_increment,
    username VARCHAR(100) NOT NULL,
    senha VARCHAR(100) NOT NULL,

    PRIMARY KEY (id)
);