CREATE TABLE contratos (

    id BIGINT PRIMARY KEY AUTO_INCREMENT,

    contrato VARCHAR(100) NOT NULL UNIQUE,

    cliente_id BIGINT NOT NULL,

    fecha_inicio DATE NOT NULL,
    fecha_termino DATE NOT NULL,

    presupuesto DECIMAL(12,2) NOT NULL,

    activo BOOLEAN NOT NULL DEFAULT TRUE,

    CONSTRAINT fk_contratos_cliente
        FOREIGN KEY (cliente_id) REFERENCES clientes(id)

);
