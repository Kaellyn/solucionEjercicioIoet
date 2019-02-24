# Solución Ejercicio Ioet
Solución al ejercicio de programación planteado por Ioet realizado en java

El problema requiere calcular el monto a pagar a cada empleado de una lista de empleados donde constan su nombre, los días trabajados,
la hora de inicio y la hora de fin de cada día de trabajo.

Los cálculos se deben realizar mediante una tabla dada, donde se especifica cuanto se paga por hora dado un día y la hora trabajada.

La solución planteada está escrita en Java.

Para la solución los archivos de interés están dentro de solucionEjercicioIoet/ejercicioIoet/src/

## Descripción del Diseño
### Los Paquetes
Se crearon 3 paquetes de Java o carpetas que son:
* archivos: donde se encuentra un archivo llamado entrada.txt cuyo contenido es la entrada para el ejercicio de aquí se leen los datos.
* ejecutable: donde se encuentra la clase **Ejecutable** es la clase "main" del programa.
* modelo: donde se encuentran 3 clases **RolDePago**, **Empleado** y **Horario**.

### Las Clases
Se crearon un total de 4 clases que son:
* **Ejecutable**: la clase "main" del programa esta inicializa un objeto de clase **RolDePago** aquí se indica la dirección de entrada.txt 
                  como también se pide la impresión del rol de pagos.
* **RolDePago**: esta clase contiene un solo atributo llamado *listaEmpleados* que es un **ArrayList** de tipo **Empleado**, contiene un constructor 
                que recibe como parámetro un String con la dirección del archivo entrada.txt, el constructor lee el archivo, lo "corta" en dos partes y con cada 
                línea del archivo instancia un objeto de la clase Empleado que es agregado finalmente a *listaEmpleados* y finalmente contiene 3 
                métodos que son get, set y el método imprimirSueldos donde se imprime el nombre y el sueldo correspondiente de cada 
                empleado tal como se requiere según el OUTPUT del ejercicio
* **Empleado**: esta clase contiene dos atributos llamados *nombre* de tipo String y *horarios* que es un **ArrayList** de tipo **Horario**,
                contiene dos constructores uno por defecto que recibe el nombre del Empleado y una lista de Horarios y otro constructor (que es el 
                usado desde la clase RolDePago) que recibe como parámetro un String con el nombre del Empleado, y otro String con los horarios que
                ha cumplido ese Empleado entonces el constructor tokeniza este último String para obtener cada uno de los horarios
                 por cada token crea un objeto de tipo Horario que es agregado al atributo *horarios*. Finalmente cuenta con métodos 
                 getters and setters y un método llamado calcularSueldo que calcula el sueldo del Empleado dado su lista de horarios (solo suma el valor que tiene cada horario en la lista y devuelve el total)
* **Horario**: esta clase contiene tres atributos llamados *día* de tipo String, *horaInicio* de tipo String y *horaFin* de tipo String.
                Contiene un constructor (que es el utilizado por la clase Empleado) que recibe 3 parámetros String día, String horaInicio y String horaFin que iguala a los atributos de la clase.
                Finalmente cuenta con métodos getters and setters y dos métodos para el cálculo del valor de ese Horario 
                de estos dos solamente el ultimo el llamado valorHorarioDos es el usado.
                

## Detalles a tomar en cuenta

### ¿Porque dos métodos para calcular el valor del horario en la clase Horario?

Debemos tomar en cuenta que según como está planteado el ejercicio un empleado trabaja en horarios que le son remunerados de acuerdo con 
la tabla de pagos, pero ¿qué pasa si el empleado, debido a un horario largo, pasa de un valor de remuneración de la tabla a otro? 
En ese caso se debe tomar en cuenta que trabaja en 2 horarios distintos y cada uno debe ser pagado de diferente forma es por esto la división
de dos métodos. El primer método no toma en cuenta este salto de un horario de pago a otro y etiqueta el horario de un empleado en uno 
solo de pago de acuerdo con la tabla de pagos, por el otro lado el segundo método (que es el que está usando actualmente el programa) 
toma en cuenta estos posibles saltos de horarios de pago y divide el horario que trabajo el empleado en 2 o 3 (sea el caso) y calcula 
el pago con 2 o 3 horarios de pago diferentes de acuerdo con la tabla de pagos y si sus horas trabajadas caen en estos horarios de la tabla


## Instrucciones para la Ejecución del Programa

Para ejecutar el programa podemos descargar o clonar el proyecto después de esto desde netbeans o eclipse elegimos la opción de abrir proyecto luego dentro de la dirección C:\..\solucionEjercicioIoet-master\solucionEjercicioIoet-master se identificará como proyecto la 
carpeta ejercicioIoet lo seleccionamos y podremos abrirlo y ejecutar la clase Ejecutable de la carpeta ejecutable.

Otra forma es crear un proyecto java desde 0 en netbeans o eclipse y luego remplazar todo el contenido de la carpeta src del proyecto recién creado por el contenido de la carpeta src de nuestro proyecto descargado luego solo resta ejecutar la clase Ejecutable de la carpeta ejecutable.
