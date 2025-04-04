Tragamoneda - Java Swing

Descripción

Este es un proyecto simple de una máquina tragamonedas desarrollada en Java utilizando la biblioteca Swing para la interfaz gráfica de usuario (GUI). El juego permite al usuario girar tres rodillos y, si obtiene tres símbolos iguales, gana.

Requisitos

Para ejecutar este proyecto, necesitas:

Tener instalado Java Development Kit (JDK) 8 o superior.

Un entorno de desarrollo compatible con Java, como IntelliJ IDEA, Eclipse o NetBeans.

Estructura del Código

El código principal se encuentra en el archivo Tragamoneda.java y tiene la siguiente estructura:

Importaciones: Se importan las bibliotecas necesarias (javax.swing, java.awt, etc.).

Clase Tragamoneda: Hereda de JFrame y maneja la ventana principal del juego.

Atributos:

JLabel rodillo1, rodillo2, rodillo3: Representan los rodillos del tragamonedas.

JButton botonGirar: Botón para iniciar el giro.

Random random: Generador de números aleatorios para seleccionar imágenes.

String[] imagenes: Lista de archivos de imagen utilizados en los rodillos.

Métodos:

Tragamoneda(): Constructor donde se inicializan los componentes gráficos.

girarRodillos(): Método que simula el giro de los rodillos y determina si el jugador gana.

Método main: Inicia la aplicación ejecutando la interfaz gráfica en el hilo de eventos de Swing.

Ejecución del Proyecto

Clona o descarga el repositorio en tu máquina.

Asegúrate de colocar las imágenes necesarias en el mismo directorio del código fuente.

Compila el código desde la terminal con:


javac Tragamoneda.java

Ejecuta el programa con:

java Tragamoneda
