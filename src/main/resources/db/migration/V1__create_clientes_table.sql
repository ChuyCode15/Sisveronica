CREATE TABLE clientes (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255),
    rfc VARCHAR(50),
    calle VARCHAR(255),
    numero INT,
    fraccionamiento VARCHAR(255),
    c_p VARCHAR(50) NOT NULL,
    municipio VARCHAR(255),
    estado VARCHAR(255),
    activo BOOLEAN
);