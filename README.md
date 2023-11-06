# Wompi Test

Este proyecto es una automatización para validar los estados de las diferentes transacciones a un sandbox por medio de diferentes medios de pago. https://checkout.co.uat.wompi.dev/l/stagtest_VPOS_bdQraT

## Prerequisitos

Para correr los casos de automatizacion, asegurarse de tener los siguientes prerequisitos instalados:

- Java Vesion 1.8.0
- IntelliJ 2023.1.3
- Gradle
- Cucumber
- Gherkin

## Para iniciar se necesita

1. Clonar el repositorio con la siguiente url:

   ```shell
   git clone 
   ```


2. Correr la automatizacion:

   ```shell
   gradle test aggregate
   ```

## Estructura del Proyecto

La estructura del proyecto está organizada de la siguiente manera:

- src/: Contiene el código fuente de las pruebas de automatización.
- main/: Contiene utilidades y clases comunes para las pruebas.
- test/: Contiene los archivos de prueba y las clases de casos de prueba.
- resources/: Contiene los features y datos de prueba.

## Reportes

Los reportes seran generados luego de correr la automatizacion de pruebas. Estos reportes pueden ser encontrados en la carpeta `Wompi_Test/target`.