# ForoHub API - Challenge Alura Latam

[![Java](https://img.shields.io/badge/Java-21-blue.svg)](https://www.java.com)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.x-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Security](https://img.shields.io/badge/Security-JWT-blueviolet.svg)](https://jwt.io/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

El objetivo principal es demostrar la implementación de una API completa, segura y bien estructurada, aplicando las mejores prácticas de desarrollo de software.

## 👨‍💻 Autor

**Juan Camilo Bermeo Diaz**

- 📍 Cali, Colombia
- 📧 **Email**: [bermeocamilo12@gmail.com](mailto:bermeocamilo12@gmail.com)
- 💼 **LinkedIn**: [camilo-bermeo-programador-java](https://www.linkedin.com/in/camilo-bermeo-programador-java)
- 🐙 **GitHub**: [Chitiva09](https://github.com/Chitiva09)


**ForoHub** es una API RESTful desarrollada como parte del Challenge de **Oracle Next Education (ONE) en colaboración con Alura Latam**. El proyecto simula el backend de un foro de discusión, permitiendo a los usuarios registrarse, autenticarse y participar en debates creando y gestionando tópicos.

El objetivo principal es demostrar la implementación de una API completa, segura y bien estructurada, aplicando las mejores prácticas de desarrollo de software.

## ✨ Características Principales

- **Autenticación y Autorización**: Sistema de seguridad basado en **JSON Web Tokens (JWT)**.
- **Gestión de Usuarios**: Registro y login de usuarios.
- **CRUD de Tópicos**:
  - Crear, leer, actualizar y eliminar tópicos.
  - Listar todos los tópicos.
  - Buscar un tópico por su ID o por su nombre.
- **Validaciones**: Reglas de negocio y validaciones de datos de entrada.
- **Documentación de API**: Documentación interactiva y automática con **SpringDoc (Swagger)**.

## 🏛️ Arquitectura y Patrones de Diseño

El proyecto está construido siguiendo los principios de la **Arquitectura Limpia (Hexagonal)** para garantizar un bajo acoplamiento y alta cohesión. Se utilizan patrones de diseño como:
- **Value Object**: Para representar conceptos del dominio de forma inmutable y segura.
- **Builder**: Para la construcción de objetos complejos de forma legible.
- **Mapper**: Para la transformación de datos entre las capas de la aplicación (DTOs, Entidades).
- **Separación por Capas**: Clara delimitación de responsabilidades (Controladores, Servicios, Repositorios).

## 🛠️ Stack Tecnológico

- **Lenguaje**: Java 21
- **Framework**: Spring Boot 3
- **Seguridad**: Spring Security, JWT (java-jwt)
- **Persistencia**: Spring Data JPA, Hibernate
- **Base de Datos**: PostgreSQL
- **Migraciones**: Flyway
- **Validaciones**: Jakarta Bean Validation
- **Documentación**: SpringDoc (Swagger UI)
- **Build Tool**: Maven
- **Librerías**: Lombok

## 🚀 Instalación y Ejecución

### Prerrequisitos
- JDK 21 o superior.
- Maven 3.8 o superior.
- Docker y Docker Compose (Recomendado para la base de datos).

### 1. Clonar el Repositorio
```bash
git clone <URL_DEL_REPOSITORIO>
cd foroHub
```

### 2. Configurar Variables de Entorno

Este proyecto requiere variables de entorno para la conexión a la base de datos y para el secreto del JWT. Puedes crear un archivo `.env` en la raíz del proyecto o configurarlas directamente en tu sistema.

Crea un archivo `application.properties` en `src/main/resources` o modifica el existente con la siguiente información:

```properties
# PostgreSQL Database
spring.datasource.url=jdbc:postgresql://localhost:5432/forohub_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña

# JWT Secret
api.security.secret=${JWT_SECRET}
```

**Nota:** Asegúrate de reemplazar `tu_usuario` y `tu_contraseña` y de definir la variable de entorno `JWT_SECRET` con un valor seguro y largo.

### 3. Levantar la Base de Datos (Recomendado con Docker)

Si tienes Docker instalado, puedes levantar una instancia de PostgreSQL fácilmente:
```bash
docker run --name forohub-postgres -e POSTGRES_DB=forohub_db -e POSTGRES_USER=tu_usuario -e POSTGRES_PASSWORD=tu_contraseña -p 5432:5432 -d postgres
```

### 4. Ejecutar la Aplicación

Utiliza el Maven Wrapper incluido para compilar y ejecutar el proyecto:

- En Windows:
  ```bash
  mvnw.cmd spring-boot:run
  ```
- En Linux o macOS:
  ```bash
  ./mvnw spring-boot:run
  ```

La API estará disponible en `http://localhost:8080`.

## 📖 Documentación de la API (Swagger)

La documentación completa y interactiva de la API está generada con SpringDoc. Una vez que la aplicación esté en ejecución, puedes acceder a ella en tu navegador:

**http://localhost:8080/swagger-ui.html**

Desde esta interfaz podrás ver todos los endpoints, sus parámetros, y probarlos directamente.

## 🔑 Flujo de Autenticación

1.  **Registrar un usuario** (si es necesario) a través del endpoint correspondiente.
2.  **Autenticarse**: Envía una petición `POST` a `/login` con el email y la contraseña del usuario en el cuerpo.
    ```bash
    {
      "email": "user@example.com",
      "clave": "123456"
    }
    ```
3.  **Recibir el Token**: La respuesta contendrá el token JWT.
4.  **Acceder a Endpoints Protegidos**: Para acceder a los endpoints que requieren autenticación (ej. `POST /topicos`), incluye el token en el encabezado `Authorization` de tus peticiones.
    ```
    Authorization: Bearer <tu_token_jwt>
    ```

## 💡 Ejemplos de Casos de Uso

A continuación se muestran flujos de trabajo comunes para interactuar con la API. Los ejemplos usan `cURL`, pero pueden ser replicados fácilmente en herramientas como Postman o Insomnia.

### Caso de Uso 1: Autenticación de un Usuario

Para interactuar con los endpoints protegidos, primero se debe obtener un token JWT.

**Petición:** Se envía una solicitud `POST` a `http://localhost:8080/login` con las credenciales del usuario.

```bash
# Petición con cURL para obtener un token
curl -X POST http://localhost:8080/login \
-H "Content-Type: application/json" \
-d '{
  "email": "juan.perez@example.com",
  "clave": "password123"
}' \
```

**Respuesta:** Si las credenciales son válidas, la API devuelve el token.

```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ..."
}
```

**Paso 2: El usuario crea un nuevo tópico usando el token.**

El token obtenido se utiliza en el encabezado `Authorization` para autenticar la siguiente petición.

```bash
# Petición con cURL
curl -X POST -H "Content-Type: application/json" \
-H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ..." \
-d '{
  "titulo": "¿Cuál es el mejor enfoque para aprender Spring Boot?",
  "mensaje": "Hola comunidad, estoy empezando con Spring y me gustaría saber sus recomendaciones y mejores prácticas.",
  "curso": "Spring Boot"
}' \
http://localhost:8080/topicos
```

Si la petición es exitosa, la API responderá con un código `201 Created` y los datos del tópico recién creado.

### Caso de Uso 2: Un usuario consulta y actualiza su tópico

**Paso 1: El usuario consulta un tópico específico por su ID.**

Utilizando el mismo token JWT, el usuario puede solicitar los detalles de un tópico que creó anteriormente.

```bash
# Petición con cURL
curl -X GET -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ..." \
http://localhost:8080/topicos/1
```

**Paso 2: El usuario actualiza el mensaje del tópico.**

Si el usuario decide modificar su publicación, envía una petición `PUT` con los nuevos datos. Solo el autor del tópico puede modificarlo.

```bash
# Petición con cURL
curl -X PUT -H "Content-Type: application/json" \
-H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ..." \
-d '{
  "mensaje": "Hola comunidad, he actualizado mi pregunta. Agradezco sus recomendaciones y mejores prácticas para iniciar en el mundo de Spring."
}' \
http://localhost:8080/topicos/1
```

La API responderá con `200 OK` y los datos del tópico actualizado.

## 🗃️ Migraciones de Base de Datos

El proyecto utiliza **Flyway** para gestionar las migraciones de la base de datos. Las tablas y la estructura inicial se crearán y actualizarán automáticamente la primera vez que se ejecute la aplicación después de un cambio en los scripts de migración ubicados en `src/main/resources/db/migration`.

## 📄 Licencia

Este proyecto está distribuido bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.
