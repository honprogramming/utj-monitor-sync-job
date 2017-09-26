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
2. Informaci�n de correos electr�nicos
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

**Solo se deben de modificar los par�metros, la informaci�n despu�s del signo "="**
**Los nombres de los par�metros deben de ser iguales a como se mencionan en este archivo, respetando min�sculas y may�sculas** 

### Instalar **Maven**

1. Descargar la �ltima versi�n de Maven en https://maven.apache.org/download.cgi
2. Descomprimir la carpeta en el directorio que sea f�cil identificar (Ejemplo: Documentos o
archivos de programa).
3. Poner el directorio **bin** en el path de b�squeda de ejecutables.
* Panel de control - editar las variables de entorno del sistema
**NOTA: No debemos borrar o modificar la informaci�n ya existente, ya que esto puede generar que otros programas dejen de funcionar.**
* Variables de entorno - Se selecciona path - Apretamos el bot�n editar
* Seleccionamos "Nuevo" - Indicamos la ruta de nuestra carpeta apache-maven-3.5.0
ejemplo: `C:\Users\pc\Documents\apache-maven-3.5.0\bin`
* Le damos aceptar.
4. En linux se toma el fichero .login, .profile, .bashrc o el que sea seg�n el unix/linux que tengamos 
correspondiente del $HOME del usuario y a�adirle al final la l�nea
`PATH=$PATH;/directorio_maven/maven-2.0.4/bin` 
5. Abrimos el s�mbolo de s�stema o cmd para probar que se agreg� correctamente.
Le damos la siguiente instrucci�n `mvn --version`. Nos debe mostrar la versi�n de maven que instalamos.

**Puedes verificar el siguiente sitio: https://maven.apache.org/install.html, para cualquier duda en la instalaci�n**

### Generar archivo .jar

1. Abrir el s�mbolo de sistema o cmd.
2. Moverse al directorio de nuestro programa

* Ejemplo: `C:\Users\pc\Documents\SyncJobPrimero`.

3. Escribimos la siguiente instrucci�n: `mvn package`
4. Para verificar que se generara nuestro archivo **.jar**, entramos a la carpeta del programa, en la carpeta 
**target** y deben de estar 2 archivos: **SyncJob-1.0.jar** y **SyncJob-1.0-jar-with-dependencies.jar**
que este �ltimo es el que vamos ejecutar. 

### Ejecuci�n del programa

1. Abrir s�mbolo de sistema o cmd.
2. Moverse al directorio donde se encuentra guardado el archivo **.jar**
* Ejemplo: `c:\Users\pc\documents\SyncJobPrimero\target>`.

3.En la l�nea de comandos se debe de poner la siguiente instrucci�n:
`java -jar SyncJob-1.0-jar-with-dependencies.jar <ruta donde se encuentra archivo configuraci�n>`

* Ejemplo: `java -jar SyncJob-1.0-jar-with-dependencies.jar C:\Users\pc\Documents\archivoConf.txt`

Si no se contara con archivo de configuraci�n �nicamente se da la siguiente instrucci�n:
`java -jar SyncJob-1.0-jar-with-dependencies.jar`