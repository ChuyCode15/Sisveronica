# SIGCOP – Sistema Interno de Gestión y Control de Pedidos

**¡Bienvenido a SIGCOP!**  
Sistema backend desarrollado con **Java y Spring Boot** que gestiona clientes, contratos y pedidos internos, optimizando la operación de cada departamento y generando reportes de rendimiento y metas económicas.

---

## 📝 Descripción

Este proyecto implementa un backend modular para gestión de pedidos, contratos y clientes:

- API RESTful para gestión de **Clientes** y **Contratos**.
- Manejo de operaciones CRUD, actualización parcial (PATCH) y eliminación lógica.
- Validaciones de datos con **Jakarta Validation**.
- Persistencia con **Spring Data JPA** y **MySQL**.
- Manejo centralizado de excepciones y mensajes de error claros.
- DTOs para entrada y salida de datos, separando lógica de negocio y persistencia.
- Arquitectura modular lista para evolucionar hacia microservicios por partidas.

---

## 📌 Funcionalidades principales

### ✅ Gestión de Clientes
- Registrar nuevos clientes.
- Consultar clientes existentes.
- Actualizar información de clientes.
- Eliminar clientes (eliminación lógica).

### ✅ Gestión de Contratos
- Registrar contratos asociados a clientes.
- Consultar contratos activos.
- Actualización parcial de contratos con PATCH.
- Eliminación lógica de contratos.
- Validaciones de reglas de negocio básicas.

### ✅ Operaciones adicionales
- Manejo de errores con mensajes claros.
- DTOs para separar la capa de dominio y la presentación.
- Preparado para integrar **JWT** y seguridad en el futuro.
- Documentación de API con **Swagger** (pendiente de completar).

---

## 🛠️ Tecnologías utilizadas

- 💻 **Lenguaje:** Java 17
- ⚙️ **Framework:** Spring Boot
- 🗄️ **Persistencia:** JPA / Hibernate con **MySQL**
- 🏷️ **Manejo de datos:** DTOs y **Jackson**
- 🔧 **Validación:** Jakarta Validation (`@Valid`)
- 📝 **Migraciones de base de datos:** Flyway
- 🛠️ **Productividad:** Lombok (`@Getter`, `@Setter`, `@AllArgsConstructor`)
- 🌐 **API REST:** `ResponseEntity` y status codes
- 📊 **Documentación:** Swagger (pendiente)
- 🔒 **Seguridad:** JWT (pendiente)

---

## 🚀 Cómo ejecutar el proyecto

1. Clona el repositorio:

```bash
git clone <url-del-repositorio>
```

2. Configura la base de datos en `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/sigcop
spring.datasource.username=usuario
spring.datasource.password=contraseña
spring.jpa.hibernate.ddl-auto=update
```

3. Instala dependencias:

```bash
mvn install
```

4. Ejecuta la aplicación:

```bash
mvn spring-boot:run
```

5. Accede a la API (pendiente de documentación Swagger):

```
http://localhost:8080
```



## 📄 Estado actual del proyecto

✅ Funcionalidades implementadas:
- CRUD de **Clientes**
- CRUD de **Contratos**
- Actualización parcial (PATCH)
- Eliminación lógica
- Manejo básico de errores

🛠️ Mejoras previstas:
- Integración de **JWT** y seguridad de endpoints.
- Documentación completa con **Swagger**.
- Implementación de microservicios por partidas.
- Dashboards y reportes automáticos de operaciones y métricas.

---

## 📄 Licencia

Proyecto bajo **licencia MIT**:

```text
MIT License
Copyright (c) 2025 Jesús Medina Casas
```

---

## 👨‍💻 Desarrollador

**Jesús Medina Casas**
- 💻 Apasionado por desarrollo backend con Java y Spring Boot
- 🎓 Estudiante de Oracle Next Education (ONE)
- 🌐 [LinkedIn](https://www.linkedin.com/in/jesus-medina-casas/)
- 🧑‍💻 [GitHub](https://github.com/chuyBigger)
