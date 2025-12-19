CREATE TABLE orden_compras (

    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    cliente_id BIGINT NOT NULL,
    contrato_id BIGINT NOT NULL,
    partida VARCHAR(100) NOT NULL,
    fecha_inicio_semana DATE NOT NULL,
    fecha_fin_semana DATE NOT NULL,
    activo BOOLEAN NOT NULL DEFAULT TRUE,

    CONSTRAINT fk_orden_compra_cliente
        FOREIGN KEY (cliente_id) REFERENCES clientes(id),

    CONSTRAINT fk_orden_compra_contrato
        FOREIGN KEY (contrato_id) REFERENCES contratos(id)
);
