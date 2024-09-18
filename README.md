# evaluacionJava
Esta es una API RESTful para la creación y gestión de usuarios, implementada con Java, Spring Boot, JPA, H2 como base de datos en memoria, y JWT para la autenticación.

Requisitos Previos

Antes de comenzar, asegúrate de tener instalados los siguientes requisitos:

Java 8+
Maven o Gradle (según la herramienta de build que utilices)
Git (para clonar el repositorio)

Clonar el Proyecto
Primero, clona el repositorio a tu máquina local:

git clone https://github.com/magosc/evaluacionJava.git
cd evaluacionJava

Construir el Proyecto
Para construir el proyecto, ejecuta el siguiente comandos en la raíz del proyecto:

mvn clean install

Ejecutar la Aplicación
Una vez que el proyecto ha sido construido, puedes ejecutar la aplicación utilizando los siguientes comandos.

mvn spring-boot:run

Esto iniciará la API en http://localhost:8080.

Probar el Servicio
Puedes probar el servicio de varias maneras: utilizando Swagger, Postman o cURL. A continuación se detallan las formas de probar los principales endpoints de la API.

1. Probar con Swagger
Swagger es una herramienta integrada en el proyecto que permite probar la API directamente desde una interfaz gráfica web.

Accede a la interfaz de Swagger UI en la siguiente URL:

http://localhost:8080/swagger-ui/

En Swagger, encontrarás todos los endpoints disponibles. El más importante es el de crear un nuevo usuario. Usa el formulario para enviar la solicitud POST al endpoint /users.

2. Probar con Postman
También puedes utilizar Postman para probar los endpoints de la API:

Endpoint: Crear Usuario
Método: POST

URL: http://localhost:8080/users

Body: Selecciona raw y elige JSON para enviar los datos en formato JSON.

Ejemplo del Body:

json
{
  "name": "Luis Barboza",
  "email": "luis@barboza.org",
  "password": "Ligjm5@",
  "phones": [
    {
      "number": "987654321",
      "citycode": "15084",
      "contrycode": "51"
    }
  ]
}

Adjunto la captura del diagrama de la solución.

![Captura de Pantalla 2024-09-18 a la(s) 00 14 20](https://github.com/user-attachments/assets/d6a0a0e3-e0b7-421d-aed4-28b891204663)

