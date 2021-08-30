# Introducción

Este repositorio incluye la resolución al ejercicio del cupon, como así también sus instrucciones.

# Estructura del proyecto:

El proyecto cuenta con dos packages:

1. "main": conteniendo los ejercicios de nivel 1 y nivel 2.
2. "test": conteniendo los test automatizados.

En el primer paquete encontraremos la siguiente estructura, comenzada con "com.example":

1. Cupon: conteniendo a:

* controllers: controladores utilizados para resolver el ejercicio.
* requestmodels: modelos creados para procesar las solicitudes que recibirán los endpoints del proyecto.
* resources: modelos creados para devolver las respuestas de los services hacía los controllers.
* responses: modelos creados para ser utilizados como respuesta desde los endpoints hacía el sitio donde hayan sido llamados.
* services: clases que contienen los servicios utilizados para resolver el ejercicio.

2. Por otro lado, tenemos el package "test" conteniendo las pruebas realizadas para este proyecto.


# Nivel 1

Para ejecutar el nivel 1 del ejercicio, podemos ir directamente a la clase "Nivel 1" ubicada en: "com.example.Cupon.Nivel1".
Esta clase cuenta con un main que cuenta con el ejemplo entregado en el ejercicio. Y, en la misma clase por simplicidad, el metodo calculate solicitado.
Para ejecutarlo, puede ejecutarse el metodo main de esa clase, para ver los resultados.

# Nivel 2

Este nivel incluye la creación de una Api para obtener la cantidad de items favoritos que puedo adquirir, más el monto total de la suma de dichos items, enviando mi lista de items en favoritos y el monto del cupon. 

Para ejecutar la api debemos ir a la clase CuponAplication y ejecutar el main que se encuentra en la misma. Esto levantará la aplicación de Spring Boot en el puerto 8080, que es el puerto por defecto utilizado por TomCat Server. Url: "http://localhost:8080/"


Se utiliza un ejemplo como el siguiente:

* Metodo: Post

* Dirección: http://localhost:8080/coupon

* Body:

{
"item_ids": ["MLA654897743","MLA654897743"], 
"amount": 1000
}

Con respuesta:

{
    "item_ids": [
        "MLA654897743"
    ],
    "total": 532.0
}

Devolviendo un codigo 200-Ok en caso de exito y, de no encontrarase un item que cumpla las condiciones (o algún campo vacío) se devuelve un 404-Not Found.


# Nivel 3

Para hostear la aplicación decidí utilizar Azure, creando un App Service para alojar la aplicación.

La dirección a utilizar es: http://spring-ejercicio-cupon.azurewebsites.net

Y para ejecutar la api:

* Metodo: Post

* Dirección: http://spring-ejercicio-cupon.azurewebsites.net/coupon

* Body: debe utilizarse el mismo formato para enviar.

