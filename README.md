# Tarea: Robot
## Profesor: José Ramón Jiménez Reyes
## Alumno: Rubén Lozano Sánchez

La tarea va a consistir en modelar el movimiento de un robot por una zona de nuestra habitación.

La zona será rectangular y debe estar dentro de los límites de la habitación (100 de ancho y 100 de alto). La zona debe tener al menos 10 de anchura y 10 de altura para que así nuestro robot pueda moverse. La zona se divide en baldosas para facilitar el movimiento.

La orientación serán los puntos cardinales: norte, noreste, este, sureste, sur, suroeste, oeste, noroeste.

La posición del robot vendrá expresa por sus coordenadas dentro de la zona, es decir su componente en X y su componente en Y.


<div align="center">
<p>
<img alt="Zona por defecto" src="src/main/resources/imagenes/Robot.png" />
</p>
</div>

En esta imagen puedes observar cuál es la coordenada inicial y su orientación, al crear el robot por defecto.

Además, a la hora de crear nuestro robot, podremos hacerlo de las siguientes formas:
- Robot por defecto: Sería la situación de la imagen mostrada, es decir, una zona por defecto (la zona mínima permitida), el robot posicionado en el centro y orientado al norte.
- Robot indicando su zona: Se situaría el robot en el centro de dicha zona y orientado al norte.
- Robot indicando su zona y orientación: Se situaría el robot en el centro de dicha zona y con la orientación indicada.
- Robot indicando su zona, orientación y coordenada inicial: Se situaría el robot en la coordenada indicada y con la orientación indicada.
- Copiar un robot: Copiará la zona, orientación y la coordenada del robot.


Para mover nuestro robot por la zona designada, utilizaremos un controlador del mismo al que le iremos introduciendo comandos tales como:
- 'A' o 'a' que avanzará un paso nuestro robot dependiendo de su orientación. Por ejemplo, en la imagen anterior avanzaría a la corrdenada (5, 6). Nunca podremos salirnos de los límites de la zona.
- 'D' o 'd' que girará a la derecha nuestro robot (las orientaciones de nuestro robot son los puntos cardinales). Por ejemplo, en la imagen anterior, la orientación resultante sería **noreste**.
- 'I' o 'i' que girará a la iquierda nuestro robot. Por ejemplo, en la imagen anterior, la orientación resultante sería **noroeste**.

El programa deberá permitir crear un controlador con los posibles robots y a los que podremos ir introduciendo comandos y nos irá mostrando el estado del robot después de la ejecución de cada uno de ellos.

En este repositorio GitHub hay un esqueleto de proyecto gradle que ya lleva incluidos todos los test necesarios que el programa debe pasar y las dependencias, entre ellas la de la librería `Entrada`. 

Para ello te pongo un diagrama de clases para el mismo y poco a poco te iré explicando los diferentes pasos a seguir:

<div align="center"><img alt="Diagrama de clases para robot" src="src/main/resources/uml/Robot.png" />
</div>

#### Primeros Pasos

1. Lo primero que debes hacer es un fork de este repositorio.
2. Clona tu repositorio remoto recién copiado en **GitHub** a un repositorio local que será donde irás realizando lo que a continuación se te pide. Modifica el archivo `README.md` para que incluya tu nombre en el apartado "Alumno". 
3. Realiza tu primer commit.

#### Enumerado `Orientacion`

1. Crea un enumerado llamado `Orientacion` que contenga los literales: `NORTE`, `NORESTE`, `ESTE`, `SURESTE`, `SUR`, `SUROESTE`, `OESTE`, `NOROESTE` y que a la hora de mostrarlos los muestre con el nombre en minúscula pero la inicial en mayúsculas. 
2. Comprueba que pasa los tests y realiza un commit.

#### Registro `Coordenada`

1. Crea el registro `Coordenada` tal y como se indica en el diagrama. 
2. Comprueba que pasa los tests y realiza un commit.

#### Registro `Zona`

1. Crea el registro `Zona`. 
2. Debes añadirle las constantes que se muestran y en el **constructor canónico** debes validar el ancho y el alto, utilizando los métodos expuestos en el diagrama.
3. Debes añadir un **constructor por defecto** que cree la zona mínima.
4. Debes añadir un método para comprobar si una coordenada pertenece a la zona o no, que se apoyará en los métodos mostrados en el diagrama.
5. Comrpueba que pasa los tests y realiza un commit.

#### Clase `Robot`

1. Crea la clase `Robot` con los atributos indicados en el diagrama.
2. Crea los diferentes **constructores** indicados en el diagrama y explicados en el enunciado.
3. Crea los métodos `get` y `set` con la visibilidad indicada.
4. Crea el método `avanzar` que avanzará un paso en la orientación actual o lanzará una excepción indicando que se sale de los límites.
5. Crea el método `girarALaDerecha` que girará a la derecha la orientación actual.
6. Crea el método `girarALaIzquierda` que hará lo propio.
7. Crea los métodos `equals`, `hasCode` y `toString` teniendo en cuenta todos los atributos.
8. Comrpueba que pasa los tests y realiza un commit.

#### Clase `ControladorRobot`

1. Crea la clase `ControladorRobot` con el atributo que se muestra.
2. Crea el **constructor** y el método `get`. Se debe evitar el problema del **aliasing**.
3. Crea el método `ejecutar` que ejecutará el comando pasado por parámetro sobre el robot o lanzará una excepción si el comando es desconocido.
4. Comrpueba que pasa los tests y realiza un commit.

#### Clase `Consola`

1. Crea la clase de utilidades `Consola`.
2. Crea el **constructor** para esta clase con su visibilidad adecuada, teniendo en cuenta que será una clase de utilidades que solo contendrá métodos estáticos
3. Crea el método `mostrarMenuPrincipal` que mostrará un menú con las opciones de nuestra aplicación: controlar un robot por defecto, indicando su zona, indicando su zona y orientación, indicando su zona, orientación y coordenada inicial, ejecutar comando y salir.
4. Crea el método `elegirOpcion` que mostrará el menú anterior y un mensaje para que elijamos una opción del menú y nos pedirá que introduzcamos por teclado la opción hasta que esta sea válida. Devolverá la opción elegida.
5. Crea el método `elegirZona` que nos pedirá el ancho y el alto de la zona mientras no sea posible crear la zona y finalmente devolverá la zona creada.
6. Crea el método `mostrarMenuOrientacion` que mostrará por consola un menú con las diferentes orientaciones que podemos elegir.
7. Crea el método `elegirOrientacion` que mostrará el menú anterior y un mensaje indicando que elijamos una orientación de dicho menú y nos pedirá que introduzcamos por teclado la orientación hasta que esta sea válida. Devolverá la orientación elegida.
8. Crea el método `elegirCoordenada` que nos pedirá por teclado la componente X y la Y, y devolverá una coordenada con dichas componentes. 
9. Crea el método `elegirComando` que mostrará un mensaje indicando que elijamos el comando a ejecutar y devolverá dicho comando.
10. Crea el método `mostrarRobot` que mostrará el robot pasado por parámetro o un mensaje indicando que este es nulo. 
11. Crea el método `despedirse` que mostrará un mensaje de despedida de nuestra aplicación. 
12. Realiza un commit.

#### Clase `Main`

1. Crea el atributo de clase `controladorRobot`.
2. Crea el método `ejecutarOpcion` que dependiendo de la opción pasada como parámetro, actuará en consecuencia.
3. Crea el método `controlarRobotDefecto` que asignará al atributo de clase `controladorRobot` una nueva instancia de un controlador al que le pasamos un robot creado con el constructor por defecto.
4. Crea el método `controlarRobotZona` que asignará al atributo de clase `controladorRobot` una nueva instancia de un controlador al que le pasamos un robot creado con el constructor al que le pasamos la zona.
5. Crea el método `controlarRobotZonaOrientacion` que asignarña al atributo de clase `controladorRobot` una nueva instancia de un controlador al que le pasamos un robot creado con el constructor al que le pasamos la zona y la orientación.
6. Crea el método `controlarRobotZonaOrientacionCoordenada` que asignará al atributo de clase `controladorRobot` una nueva instancia de un controlador al que le pasamos un robot creado con el constructor al que le pasamos la zona, la orientación y la coordenada inicial.
7. Crea el método `ejecutarComando` que ejecutará el comando leído por teclado sobre el contralador actual.
8. Crea el método `main` que será el método principal de nuestra aplicación y deberá iterar pidendo la opción y ejecutándola mientras no elijamos salir, en cuyo caso mostrará un mensaje de despedida y nuestra aplicación finalizará. 
9. Realiza un commit y realiza el push a tu repositorio remoto en GitHub.

#### Se valorará:

- La indentación debe ser correcta en cada uno de los apartados.
- Los identificadores utilizados deben ser adecuados y descriptivos.
- Se debe utilizar la clase `Entrada` para realizar la entrada por teclado que se encuentra como dependencia de nuestro proyecto en la librería `entrada`.
- El programa debe pasar todas las pruebas que van en el esqueleto del proyecto y toda entrada del programa será validada, para evitar que el programa termine abruptamente debido a una excepción.
- La corrección ortográfica tanto en los comentarios como en los mensajes que se muestren al usuario.
