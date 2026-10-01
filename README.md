# prueba-practica-logica-Grupo6
# EcoEnergy – Consumo Eléctrico
Integrantes
Castro Sanchez Joseph Andres


## Ejercicio asignado

Grupo 6 – EcoEnergy: Consumo eléctrico.

## Descripción

El programa permite registrar el consumo eléctrico de N usuarios. Para cada usuario se solicita el número de medidor, el estrato y el consumo en kWh.

El programa determina una tarifa según el estrato, calcula el valor de la factura y al finalizar muestra el consumo total, el total facturado y el medidor con mayor consumo.

## Estructuras utilizadas

* Scanner para la entrada de datos.
* do-while para validar los datos.
* for para procesar los N usuarios.
* switch para determinar la tarifa según el estrato.
* if para determinar el mayor consumo.
* Contadores y acumuladores para obtener los resultados finales.

## Instrucciones para ejecutar

1. Descargar o clonar el repositorio.
2. Abrir el proyecto en Visual Studio Code.
3. Abrir el archivo `EcoEnergy.java`.
4. Ejecutar el programa.
5. Ingresar los datos solicitados por consola.

## Casos de prueba

### Caso normal

3 usuarios:

* M001, estrato 1, 100 kWh
* M002, estrato 4, 200 kWh
* M003, estrato 2, 150 kWh

Resultado:

* Total kWh: 450
* Total facturado: $64
* Mayor consumo: M002 con 200 kWh

### Caso límite

1 usuario:

* M010, estrato 6, 0 kWh

El programa acepta el consumo de 0 kWh.

### Caso inválido

Ingresar un estrato fuera del rango 1–6 o un consumo negativo.

El programa muestra un mensaje de error y vuelve a solicitar el dato.
