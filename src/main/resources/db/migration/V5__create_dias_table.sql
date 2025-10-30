
    CREATE TABLE dias (
        id BIGINT NOT NULL AUTO_INCREMENT,
        fecha DATE NOT NULL UNIQUE,
        dia_semana VARCHAR(10),
        total_venta_diaria DECIMAL(10, 2) NOT NULL DEFAULT 0.00,
        activo BOOLEAN NOT NULL DEFAULT TRUE,
        PRIMARY KEY (id)
    );
