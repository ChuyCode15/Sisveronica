CREATE TABLE nota_ventas (

    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    folio INT UNIQUE,
    fecha DATETIME  NOT NULL,
    cliente_id BIGINT NOT NULL,
    contrato_id BIGINT,
    partida VARCHAR(100) NOT NULL,
    total_general DECIMAL(10,2) NOT NULL,
    activo BOOLEAN NOT NULL

);
