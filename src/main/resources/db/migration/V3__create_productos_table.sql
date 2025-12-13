CREATE TABLE productos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL UNIQUE,
    partida VARCHAR(50),
    categoria_id BIGINT,
    unidad_medida VARCHAR(50) NOT NULL,
    precio_compra DECIMAL(10,2),
    precio_venta DECIMAL(10,2),
    activo Boolean NOT NULL DEFAULT TRUE

--    CONSTRAINT fk_productos_categoria
--            FOREIGN KEY (categoria_id) REFERENCES categorias(id)

);

