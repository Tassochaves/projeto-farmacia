CREATE TABLE tb_remedio(
    id BIGINT NOT NULL auto_increment,
    nome VARCHAR(100) NOT NULL,
    via VARCHAR(100) NOT NULL,
    lote VARCHAR(100) NOT NULL,
    quantidade INT(20) NOT NULL,
    validade VARCHAR(100) NOT NULL,
    laboratorio VARCHAR(100) NOT NULL,

    PRIMARY KEY (id)
);