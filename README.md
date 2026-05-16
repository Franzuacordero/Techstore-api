# TechStore Chile — Microservicio de Gestión de Productos

Microservicio RESTful desarrollado con Java 17 y Spring Boot para administrar el catálogo de productos de TechStore Chile.

## Tecnologías

- Java 17
- Spring Boot 3.2.0
- Spring Security + JWT
- Spring Data JPA + PostgreSQL
- Maven
- Docker + Docker Compose

## Requisitos previos

- Java 17
- Maven 3.9+
- Docker Desktop

## Cómo ejecutar el proyecto

### 1. Clonar el repositorio

```powershell
git clone https://github.com/Franzuacordero/Techstore-api
cd techstore-api
```

### 2. Levantar PostgreSQL con Docker

```powershell
docker run --name techstore_db -e POSTGRES_DB=techstore -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=admin123 -p 5432:5432 -d postgres:15
```

### 3. Generar el JAR con Maven

```powershell
mvn clean package -DskipTests
```

### 4. Ejecutar el microservicio

```powershell
java -jar target/techstore-api-1.0.0.jar
```

### 5. O levantar todo con Docker Compose

```powershell
docker compose up --build
```

## Endpoints disponibles

Todos los endpoints excepto `/auth/login` requieren token JWT en el header:
```
Authorization: Bearer <token>
```

### Autenticación

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST | /auth/login | Obtener token JWT |

Body:
```json
{
  "username": "admin@techstore.cl",
  "password": "Admin1234"
}
```

### Productos

| Método | Endpoint | Descripción | HTTP |
|--------|----------|-------------|------|
| GET | /api/productos | Listar todos | 200 |
| POST | /api/productos | Crear producto | 201 |
| PUT | /api/productos/{id} | Modificar producto | 200 |
| DELETE | /api/productos/{id} | Eliminar (lógico) | 204 |

Body para crear/modificar:
```json
{
  "nombre": "Laptop Lenovo IdeaPad",
  "descripcion": "Notebook 15.6 pulgadas, 8GB RAM, 512GB SSD",
  "precio": 499990,
  "stock": 15,
  "categoria": "Computación",
  "activo": true
}
```

## Estructura del proyecto

```
src/main/java/cl/techstore/api/
├── controller/
│   ├── AuthController.java
│   └── ProductoController.java
├── service/
│   └── ProductoService.java
├── repository/
│   └── ProductoRepository.java
├── model/
│   └── Producto.java
├── security/
│   ├── JwtUtil.java
│   ├── JwtFilter.java
│   └── SecurityConfig.java
└── dto/
    ├── LoginRequest.java
    ├── LoginResponse.java
    └── ProductoDTO.java
```

## Control de versiones

- `main` — código estable y funcional
- `dev` — desarrollo activo
