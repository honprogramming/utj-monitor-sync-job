# UTJ-Monitor-sync-job

Programa que se ejecutara una o varias veces al d�a, el cual actualizara 
la informaci�n de los tableros.

### Requisitos 

Se debe de contar con un **archivo de configuraci�n .txt** para poder cambiar 
la informaci�n de configuraci�n del programa, si no se cuenta el programa 
tomar� un **archivo de configuraci�n interno** con informaci�n por default.

### Archivo de configuraci�n

El archivo de configuraci�n debe de contar con la siguiente informaci�n:
1. Horas de inicio del job.
* `horaInicioJob=06:00;14:00`
Debe de ser en formato de 24 horas, respetando 2 d�gitos en horas y 2 d�gitos en minutos
separando con ":" las horas de los minutos y separaci�n con ";" sin espacios entre 
diferentes horas.
2. N�mero de indicadores
* `numIndicadores=1700`
Se puede cambiar el n�mero de indicadores que se van a revisar.
3. Informaci�n de correos electr�nicos
* `host=smtp.gmail.com`
Nombre de servidor de correo electr�nico.
* `puerto=587`
N�mero de puerto de correo electr�nico.
* `asunto=Error en job`
Asunto que llevaran los correos electr�nicos.
* `cooreoOrigen=correoOrigen@gmail.com`
Correo de donde se enviar�n mensajes de cualquier error cuando se est� ejecutando el programa
* `password=password`
Contrase�a del correo de donde se enviar�n los mensajes de error.
* `correoDestino=correoDestino@gmail.com;correoDestino2@hotmail.com`
Correos a quienes se enviar�n los informes de error, separados con ";" y sin espacios
entre cada correo.
** Solo se deben de modificar los par�metros, la informaci�n despu�s del signo "=" ** 

### Ejecuci�n del programa

En la l�nea de comandos se debe de poner la siguiente instrucci�n:
`java -jar SyncJob.jar <ruta donde se encuentra archivo configuraci�n>`

* Ejemplo: `java -jar SyncJob.jar C:\Users\pc\Documents\archivoConf.txt`

Si no se contara con archivo de configuraci�n �nicamente se da la siguiente instrucci�n:
`java -jar SyncJob.jar`