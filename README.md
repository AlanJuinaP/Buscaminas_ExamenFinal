# Buscaminas en Java

Este es un proyecto en Java que implementa el clásico juego **Buscaminas** utilizando principios de **Programación Orientada a Objetos (POO)** y el patrón **MVC**. El juego permite a los usuarios interactuar con un tablero de 10x10 casillas, en el que deben descubrir las casillas sin pisar las minas.

## Índice
1. [Requisitos](#requisitos)
2. [Instalación](#instalación)
3. [Uso del Juego](#uso-del-juego)
4. [Estructura del Proyecto](#estructura-del-proyecto)
5. [Ejemplos de Ejecución](#ejemplos-de-ejecución)
6. [Contribuciones](#contribuciones)
7. [Licencia](#licencia)

## Requisitos

- **Java 8** o superior instalado.
- **IDE** como Eclipse o IntelliJ IDEA para ejecutar el proyecto (o cualquier otra herramienta de desarrollo que soporte Java).
- Se utiliza Junit no es necesario maven
## Instalación

1. Clona este repositorio en tu máquina local usando el siguiente comando:
   ```bash
   git clone https://github.com/tuusuario/buscaminas-java.git
Acalarando el Porgrama fue hecho indivual dado a la falta de ayuda por compañeros de grupos espero su compresion
por esa razon el programa fue subido tarde dado a que se paso insistiendo hasta el ultimo dia de entrega 

Impresion
  A B C D E F G H I J
1 - - - - - - - - - -
2 - - - - - - - - - -
3 - - - - - - - - - -
4 - - - - - - - - - -
5 - - - - - - - - - -
6 - - - - - - - - - -
7 - - - - - - - - - -
8 - - - - - - - - - -
9 - - - - - - - - - -
10 - - - - - - - - - -
Introduce una coordenada (ejemplo: A5) o escribe 'marcar A5' para marcar:
A5
  A B C D E F G H I J 
1 - - - - - - - - - - 
2 - - - - - - - - - - 
3 - - - - - - - - - - 
4 - - - - - - - - - - 
5 1 - - - - - - - - - 
6 - - - - - - - - - - 
7 - - - - - - - - - - 
8 - - - - - - - - - - 
9 - - - - - - - - - - 
10 - - - - - - - - - - 
Introduce una coordenada (ejemplo: A5) o escribe 'marcar A5' para marcar:
A7
  A B C D E F G H I J 
1 - 1 0 0 0 0 0 0 1 -
2 - 1 0 0 1 1 1 0 1 1
3 - 1 1 1 2 - 1 0 0 0
4 - - - - 2 1 1 0 0 0
5 1 - - - 2 0 0 0 0 0
6 1 1 2 - 1 0 0 0 1 1
7 0 0 1 1 1 0 0 0 2 -
8 0 0 0 0 0 0 1 1 3 -
9 1 1 1 0 0 0 1 - - -
10 - - 1 0 0 0 1 - - -
Introduce una coordenada (ejemplo: A5) o escribe 'marcar A5' para marcar:
