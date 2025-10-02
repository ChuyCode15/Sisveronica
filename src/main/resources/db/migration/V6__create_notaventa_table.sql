CREATE TABLE notaventa (

    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    fecha DATE NOT NULL,
    cliente_id BIGINT NOT NULL,
    partida VARCHAR(100) NOT NULL,
    dia_id BIGINT NOT NULL,
    total_general DECIMAL(10,2) NOT NULL,
    activo TINYINT(1) NOT NULL

);
