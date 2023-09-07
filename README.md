# Inditex - Tarea técnica inicial

## ¿Qué encontrará en el presente repositorio?

El presente repositorio contiene el código que da cumplimiento a la tarea técnica que a continuación es descrita.

## Planteamiento de la tarea técnica inicial

En la base de datos de comercio electrónico de la compañía disponemos de la tabla PRICES que refleja el precio final (pvp) y la tarifa que aplica a un producto de una cadena entre unas fechas determinadas. A continuación se muestra un ejemplo de la tabla con los campos relevantes:

PRICES

| BRAND_ID | START_DATE          | END_DATE            | PRICE_LIST | PRODUCT_ID | PRIORITY | PRICE | CURR |
|----------|---------------------|---------------------|------------|------------|----------|-------|------|
| 1        | 2020-06-14-00.00.00 | 2020-12-31-23.59.59 | 1          | 35455      | 0        | 35.50 | EUR  |
| 1        | 2020-06-14-15.00.00 | 2020-06-14-18.30.00 | 2          | 35455      | 1        | 25.45 | EUR  |
| 1        | 2020-06-15-00.00.00 | 2020-06-15-11.00.00 | 3          | 35455      | 1        | 30.50 | EUR  |
| 1        | 2020-06-15-16.00.00 | 2020-12-31-23.59.59 | 4          | 35455      | 1        | 38.95 | EUR  |

Campos:

BRAND_ID: foreign key de la cadena del grupo (1 = ZARA).
START_DATE , END_DATE: rango de fechas en el que aplica el precio tarifa indicado.
PRICE_LIST: Identificador de la tarifa de precios aplicable.
PRODUCT_ID: Identificador código de producto.
PRIORITY: Desambiguador de aplicación de precios. Si dos tarifas coinciden en un rago de fechas se aplica la de mayor prioridad (mayor valor numérico).
PRICE: precio final de venta.
CURR: iso de la moneda.

Se pide:

Construir una aplicación/servicio en SpringBoot que provea una end point rest de consulta  tal que:

Acepte como parámetros de entrada: fecha de aplicación, identificador de producto, identificador de cadena.
Devuelva como datos de salida: identificador de producto, identificador de cadena, tarifa a aplicar, fechas de aplicación y precio final a aplicar.

Se debe utilizar una base de datos en memoria (tipo h2) e inicializar con los datos del ejemplo, (se pueden cambiar el nombre de los campos y añadir otros nuevos si se quiere, elegir el tipo de dato que se considere adecuado para los mismos).

Desarrollar unos test al endpoint rest que  validen las siguientes peticiones al servicio con los datos del ejemplo:

-          Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
-          Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
-          Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
-          Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
-          Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)


Se valorará:

Diseño y construcción del servicio.
Calidad de Código.
Resultados correctos en los test.

## La resolución de la tarea técnica inicial

La tarea fue resuelta cumpliendo cada parte de la descripción tal y como se explica a continuación.

El objetivo fue crear el requerido servicio que a partir de los datos con la organización provista fuese capaz de recibir y responder los datos que la descripción estipula.

### La arquitectura escogida

La idea fue la implementación de un diseño guiado por dominio (Domain Driven Design) y una arquitectura hexagonal (puertos y adaptadores).
Aunque para un escenario pequeño no suele escogerse la mencionada arquitectura la elección se hizo para demostrar la competencia en el tema.
Una vez escogido el diseño y la arquitectura se realizó la implementación de manera tal que se pusiesen de manifiesto los detalles que caracterizan tanto el diseño guiado por dominio como la arquitectura hexagonal.

### La estructura del directorio de aplicación

El directorio de la aplicación cuenta con una organización típica para el diseño y la arquitectura que se han escogido.

El directorio *price* cuenta con una separación explícita de las partes que la integran en elementos de
- *application*
- *domain*
- *infrastructure*

El directorio *domain* contiene los elementos de dominio como su nombre lo indica incluyendo por ejemplo la entidad que hace las veces de Aggregate Root a la cual se ha llamado *Price* y puertos como *GetFinalPrice* (Use Case) y *PriceRepository* que es un puerto para persistencia.

Los elementos de dominio no tienen dependencias externas de ninguna clase y son agnósticas con respecto al framework utilizado para implementar la infraestructura y la aplicación.

El directorio *infrastructure* contiene los elementos de infraestructura incluyendo por ejemplo los adaptadores para la persistencia y porciones de configuración para hacer el *wiring* de elementos de dominio con el framework de manera tal que el dominio permanezca con independencia.

Los elementos de infraestructura dependen únicamente del dominio sin atentar en caso alguno contra la independencia del mismo.

El directorio *application* contiene el controlador *FinalPriceController* que hace las veces de adaptador de aplicación al servirse del caso de uso *GetFinalPrice* y el servicio de dominio que implementa al mismo.

Dicho elemento de aplicación depende a su vez tanto de la capa de infraestructura como de la de dominio.

## Inicializar la aplicación

La aplicación utiliza Maven y puede ser lanzada utilizando el *wrapper* con el comando a continuación

```
./mvnw spring-boot:run
```

## Utilizar el *endpoint* del servicio

Al contar con una inicialización con los datos provistos en la descripción el *endpoint* del servicio puede probarse haciendo un *get* *request* a la siguiente dirección

```
http://localhost:8080/api/v1/prices/final
```

 y pasando los parámetros que se indican a continuación
 - *applicationDate* (una fecha con formato "yyyy-MM-dd-HH.mm.ss")
 - *productId*
 - *brandId*

Ejemplo

```
http://localhost:8080/api/v1/prices/final?applicationDate=2020-06-14-10.00.00&productId=35455&brandId=1
```

## Los *test* del servicio

Fueron implementados los *test* que la descripción de la tarea requería de modo integrado sobre el endpoint lo cual sirvió de guía al desarrollo del mismo.

Dichos *test* son los que se encuentran en *FinalPriceControllerTest* y están denotados como *itShouldReturnPrice* y enumerados del 1 al 5 según su orden en la descripción inicial.
