CREATE TABLE productos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    partida VARCHAR(50),
    categoria_id VARCHAR(100),
    unidad_medida VARCHAR(50) NOT NULL,
    precio_compra DECIMAL(10,2),
    precio_venta DECIMAL(10,2),
    activo Boolean
);