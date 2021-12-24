## El presente repositorio presenta una solución a la necesidad de obtener la sucursal más cercana dado una ubicación (latitud y longitud)

### La API propuesta se construyó utilizando el framework Spring Boot v2.6.2 y provee 4 servicios 

  ##### Obtencioń de todas las sucursales guardadas en la base de datos
  
  ###### GET Request /sucursales/: 
  ```
  http://localhost:8090/sucursales
  ```
  ###### Response:
  ```
  [
  {"id":1001,"direccion":"San Martin 1162","latitud":-32.889577,"longitud":-68.839284},
  {"id":1002,"direccion":"España 1554","latitud":-32.884875,"longitud":-68.840873},
  {"id":1003,"direccion":"Acceso Este 3280","latitud":-32.901681,"longitud":-68.79822}
  ]
  ```
  ##### Obtencioń de una sucursal por id
  ###### GET Request /sucursales/{id}:
  ```
  http://localhost:8090/sucursales/1001
  ```
  ###### Response:
  ```
  {"id":1001,"direccion":"San Martin 1162","latitud":-32.889577,"longitud":-68.839284}
  ```
  
  ##### Obtencioń la sucursal más cercana dado un punto (latitud y longitud)
  ###### GET Request /sucursales/{latitud}/{longitud}:
  ```
  http://localhost:8090/sucursales/-32.890399/-68.839576
  ```
  ##### Response:
  ```
  {"id":1001,"direccion":"San Martin 1162","latitud":-32.889577,"longitud":-68.839284}
  ```
  
  ##### Creación de una sucursal -> Este servicio puede ser probado utilizando la aplicación Postman enviando en el cuerpo de la request el objeto debajo descripto
  ###### POST Request /sucursales/:
  ```
  http://localhost:8090/sucursales/
  
  {
        "direccion": "Panamerica 2875",
        "latitud": -32.954939,
        "longitud": -68.858527
   }
    
  ```
  ##### Response:
  ```
  Status: 201 Created
  ```

### Base de Datos
Se utilizo una base de datos SQL embebida que provee Spring Boot la cual una vez iniciada la aplicación puede ser accedida a través de una navegador web 
en la siguiente URL: http://localhost:8090/h2-console.
La consola de login al iniciar la base de datos debe verse como la siguiente imagen:

![configuracion bd](https://github.com/rojobe/sucursal-cercana/blob/master/src/main/resources/h2_console_working_values.png)

Seleccionar connect para acceder a la base de datos.

Los datos son generados a través de un archivo con nombre data.sql guardado bajo la carpeta resources. Cada vez que se inicia la aplicación la base de datos, 
la tabla y los datos son recreados.


### Documentación utilizando Swagger-ui
Para documentar la API se utilizó Swagger, una vez iniciada la aplicación esta documentación puede ser accedida a través de una navegador web en la siguiente 
URL: http://localhost:8090/swagger-ui.html/. Además de la documentación de la API, también nos muestra la información del schema de datos.

### Ejecución de la aplicación
#### NOTA: Para poder iniciar la aplicación es necesario contar con maven instalado en el sistema
#### NOTA1: Para poder iniciar la aplicación es necesario contar con una versión de Java mayor o igual a Java 11

1. Iniciar una terminal
1. Clonar el presente repositorio
1. Navegar hasta la carpeta raiz
1. Ejecutar el siguiente código:  ``` mvn package ```. Esto realizará las acciones necesarias para generar un build de la aplicación el cual tendrá un nombre similar a **demo-0.0.1-SNAPSHOT.jar**
1. Navegar a la carpeta target (recientemente creada) y ejecutar el siguiente código ``` java -jar demo-0.0.1-SNAPSHOT.jar ```.
1. Si la ejecución fue correcta al final deberemos leer una sentencia igual a: _Completed initialization in 1 ms_
1. A través de un navegador ya podemos comenzar a utilizar los servicios propuestos anteriormente utilizando la URL: http://localhost:8090/sucursales/

