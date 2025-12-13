CREATE TABLE orden_compra_detalles (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    orden_compra_id BIGINT NOT NULL,
    fecha DATE NOT NULL,
    lunes DOUBLE,
    martes DOUBLE,
    miercoles DOUBLE,
    jueves DOUBLE,
    viernes DOUBLE,
    sabado DOUBLE,
    domingo DOUBLE,
    activo BOOLEAN NOT NULL DEFAULT TRUE,

    CONSTRAINT fk_ocd_orden_compra
        FOREIGN KEY (orden_compra_id) REFERENCES orden_compra(id)
        ON DELETE CASCADE
);
