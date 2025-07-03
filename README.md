
# 📚 Sistema de Calificaciones - Proyecto Java Spring Boot 3

Este proyecto implementa una API REST para consultar el precio final y la tarifa que aplica a un producto de una cadena entre unas fechas determinadas.

## 🚀 Tecnologías utilizadas

- Java 21
- Spring Boot 3.2
- Spring Data JPA
- Maven
- H2 (Base de datos en memoria)
- OpenAPI / Swagger UI

## 📦 Requisitos previos

- Java JDK 21+
- Maven 3.8+
- Tener instalado Postman (puedes descargarlo desde https://www.postman.com/downloads/)
- Descargar la colección de Postman incluida en el proyecto, ubicada en `src/main/resources/postman/postman_collection.json`


## Estructura del proyecto


* `domain/`: Lógica de negocio y modelos de dominio  
    * `exception/`: Excepciones del dominio
    * `model/`: Modelos del dominio
    * `repository/`: Interfaces para especificar las operaciones de acceso a datos
* `infrastructure/`: Adaptadores, repositorios, controladores REST.  
    * `database/`: Implementaciones concretas de cómo interactuar con la base de datos
        * `h2/`: En este caso se implementa la base de datos en memoria H2  
			* `adapter/`: Adaptadores encargados de conectar la lógica de negocio con repositorios de la base de datos
			* `entity/`: Entidades de la base de datos
			* `mapper/`: Clases encargadas de mapear objetos
			* `repository/`: Interfaces que actúan como capa de acceso a datos
    * `rest/`: Adaptadores REST que se encargan de manejar las interacciones con el exterior
		* `controller/`: Controladores HTTP
		* `exception/`: Excepciones específicas del adaptador REST
		* `formatter/`: Clases encargadas de dar formato a objetos
		* `mapper/`: Clases encargadas de mapear objetos
		* `util/`: Clase utilitaria
* `usecase/`: Contiene la lógica de negocio específica para un caso de uso concreto del sistema  


## 🛠️ Descarga del repositorio y compilación

1. Clonar el repositorio:
   
```bash
   git clone https://tu-repositorio.git
```
 
2. Generar el código fuente desde el contrato OpenAPI:

```bash
  cd pricing
  mvn compile
```

3. Compilar el proyecto completo:

```bash
mvn clean install
```
   

## ▶️ Ejecución

Puedes ejecutar el proyecto de las siguiente manera:

```bash
mvn spring-boot:run
```

## ▶️ Ejecutar tests

Puedes ejecutar sólo los test de la siguiente manera

```bash
mvn test
```

## 🧪 Base de datos H2

Puedes acceder a la consola de H2 en:

```
http://localhost:8080/h2-console
```

- **JDBC URL**: `jdbc:h2:mem:testdb`
- **User**: `sa`
- **Password**: *(dejar vacío)*

## 🌐 Realizar pruebas con Postman

1. Abrir Postman.

2. Importar la colección:
   - Haz clic en **Import** (arriba a la izquierda).
   - Selecciona la pestaña **File**.
   - Navega y selecciona el archivo `postman_collection.json` que se encuentra en `src/main/resources` de este proyecto.
   - Haz clic en **Import**.

3. La colección aparecerá en la barra lateral izquierda con todas las solicitudes configuradas.

4. Selecciona la colección o alguna solicitud específica para probar.

5. Ajusta los valores de los parámetros si es necesario (por ejemplo, `applicationDate`, `productId`, `brandId`).

6. Haz clic en **Send** para enviar la solicitud.

7. Revisa la respuesta recibida en la pestaña **Body**.

## 📚 Endpoint Principal

| Método | Endpoint                            | Descripción                                      														|
|--------|-------------------------------------|--------------------------------------------------------------------------------------------------------|
| GET    | `/inditex/prices`                   | Obtiene el precio final y la tarifa del producto con mayor prioridad calificaciones por profesor       |

Ejemplo de URL configurada:
http://localhost:8080/prices?applicationDate=2023-12-31-10:00:00&productId=35455&brandId=1

## Notas importantes

- Asegúrate que la API esté corriendo en el puerto y URL configurados en la colección (por defecto `http://localhost:8080`).
- La fecha `applicationDate` debe tener el formato `yyyy-MM-dd HH:mm:ss`.
- Puedes editar los valores de los parámetros en las solicitudes de la colección para hacer pruebas con diferentes datos.