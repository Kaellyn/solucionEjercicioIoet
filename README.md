# Solucion Ejercicio Ioet
Solucion al ejercicio de promacion planteado por Ioet realizado en java

El problema requiere calcular el monto a pagar a cada empleado de una lista de empleados donde constan su nombre, los dias trabajados,
la hora de inicio y la hora de fin de cada dia de trabajo.

Los calculos se deben realizar mediante una tabla dada, donde se especifica cuanto se paga por hora dado un dia y la hora trabajada.

La solucion planteada esta escrita en Java.

Para la solucion los archivos de interes estan dentro de solucionEjercicioIoet/ejercicioIoet/src/

## Descripcion del Diseño
### Los Paquetes
Se crearon 3 paquetes de Java o carpetas que son:
* archivos: donde se encuentra un archivo llamado entrada.txt cuyo contenido es la entrada para el ejercicio de aqui se leen los datos.
* ejecutable: donde se encuentra la clase **Ejecutable** es es la clase "main" del programa.
* modelo: donde se encuentran 3 clases **RolDePago**, **Empleado** y **Horario**.

### Las Clases
Se crearon un total de 4 clases que son:
* **Ejecutable**: la clase "main" del programa esta inicializa un objeto de clase **RolDePago** aqui se indica la direccion de entrada.txt 
                  como tambien se pide la impresion del rol de pagos.
* **RolDePago**: esta clase contiene un solo atributo llamado *listaEmpleados* que es un **ArrayList** de tipo **Empleado**, contiene un contructor 
                que recibe como parametro un String con la direccion del archivo entrada.txt, el constructor lee el archivo, lo "corta" en dos partes y con cada 
                linea del archivo instancia un objeto de la clase Empleado que es agregado finalmente a *listaEmpleados* y finalmente contiene 3 
                metodos que son get, set y el metodo imprimirSueldos donde se imprime el nombre y el sueldo correspondiente de cada 
                empleado tal como se requiere segun el OUTPUT del ejercicio
* **Empleado**: esta clase contiene dos atributos llamados *nombre* de tipo String y *horarios* que es un **ArrayList** de tipo **Horario**,
                contiene dos contructores uno por defecto que recibe el nombre del Empleado y una lista de Horarios y otro constructor (que es el 
                usado desde la clase RolDePago) que recibe como parametro un String con el nombre del Empleado, y otro String con los horarios que
                ha cumplido ese Empleado entonces el contructor tokeniza este ultimo String para obtener cada uno de los horarios
                 por cada token crea un objeto de tipo Horario que es agregado al atributo *horarios*. Finalmente cuenta con metodos 
                 getters and setters y un metodo llamado calcularSueldo que calcula el sueldo del Empleado dado su lista de horarios (solo suma el valor que tiene cada horario en la lista y devuelve el total)
* **Horario**: esta clase contiene tres atributos llamados *dia* de tipo String, *horaInicio* de tipo String y *horaFin* de tipo String.
                Contiene un contructor (que es el utilizado por la clase Empleado) que recibe 3 parametros String dia, String horaInicio y String horaFin que iguala a los atributos de la clase.
                Finalmente cuenta con metodos getters and setters y dos metodos para el calculo del valor de ese Horario 
                de estos dos solamente el ultimo el llamado valorHorarioDos es el usado.
                

## Detalles a tomar en cuenta

### ¿Porque dos metodos para calcular el valor del horario en la clase Horario?

Debemos tomar en cuenta que segun como esta planteado el ejercicio un empleado trabaja en horarios que le son remunerados de acuerdo a 
la tabla de pagos pero ¿que pasa si el empleado, debido a un horario largo, pasa de un valor de remuneracion de la tabla a otro? 
En ese caso se debe tomar en cuenta que trabaja en 2 horarios distintos y cada uno debe ser pagado de diferente forma es por esto la division
de dos metodos. El primer metodo no toma en cuenta este salto de un horario de pago a otro y etiqueta el horario de un empleado en uno 
solo de pago de acuerdo a la tabla de pagos, por el otro lado el segundo metodo (que es el que esta usando actualmente el programa) 
toma en cuenta estos posibles saltos de horarios de pago y divide el horario que trabajo el empleado en 2 o 3 (sea el caso) y calcula 
el pago con 2 o 3 horarios de pago diferentes de acuerdo a la tabla de pagos y si sus horas trabajadas caen en estos horarios de la tabla


## Instrucciones para Ejecutar el Programa
