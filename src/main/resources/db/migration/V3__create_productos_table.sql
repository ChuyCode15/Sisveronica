CREATE TABLE contratos (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    contrato VARCHAR(255) NOT NULL,
    cliente_id BIGINT NOT NULL,
    partida VARCHAR(50) NOT NULL,
    fecha_inicio DATE,
    fecha_termino DATE,
    activo BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);
