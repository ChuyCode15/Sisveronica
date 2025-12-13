CREATE TABLE nota_venta_detalles (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cantidad INTEGER NOT NULL,
    producto_id BIGINT NOT NULL,
    precio_venta DECIMAL(10,2) NOT NULL,
    sub_total DECIMAL(10,2) NOT NULL,
    notaventa_id BIGINT NOT NULL,
    activo BOOLEAN NOT NULL DEFAULT TRUE

);
