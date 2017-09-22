# UTJ-Monitor-sync-job

Programa que se ejecutara una o varias veces al día, el cual actualizara 
la información de los tableros.

### Requisitos 

Se debe de contar con un **archivo de configuración .txt** para poder cambiar 
la información de configuración del programa, si no se cuenta el programa 
tomará un **archivo de configuración interno** con información por default.

### Archivo de configuración

El archivo de configuración debe de contar con la siguiente información:
1. Horas de inicio del job.
* `horaInicioJob=06:00;14:00`
Debe de ser en formato de 24 horas, respetando 2 dígitos en horas y 2 dígitos en minutos
separando con ":" las horas de los minutos y separación con ";" sin espacios entre 
diferentes horas.
2. Número de indicadores
* `numIndicadores=1700`
Se puede cambiar el número de indicadores que se van a revisar.
3. Información de correos electrónicos
* `host=smtp.gmail.com`
Nombre de servidor de correo electrónico.
* `puerto=587`
Número de puerto de correo electrónico.
* `asunto=Error en job`
Asunto que llevaran los correos electrónicos.
* `cooreoOrigen=correoOrigen@gmail.com`
Correo de donde se enviarán mensajes de cualquier error cuando se esté ejecutando el programa
* `password=password`
Contraseña del correo de donde se enviarán los mensajes de error.
* `correoDestino=correoDestino@gmail.com;correoDestino2@hotmail.com`
Correos a quienes se enviarán los informes de error, separados con ";" y sin espacios
entre cada correo.
** Solo se deben de modificar los parámetros, la información después del signo "=" ** 

### Ejecución del programa

En la línea de comandos se debe de poner la siguiente instrucción:
`java -jar SyncJob.jar <ruta donde se encuentra archivo configuración>`

* Ejemplo: `java -jar SyncJob.jar C:\Users\pc\Documents\archivoConf.txt`

Si no se contara con archivo de configuración únicamente se da la siguiente instrucción:
`java -jar SyncJob.jar`