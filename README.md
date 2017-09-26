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
2. Información de correos electrónicos
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

**Solo se deben de modificar los parámetros, la información después del signo "="**
**Los nombres de los parámetros deben de ser iguales a como se mencionan en este archivo, respetando minúsculas y mayúsculas** 

### Instalar **Maven**

1. Descargar la última versión de Maven en https://maven.apache.org/download.cgi
2. Descomprimir la carpeta en el directorio que sea fácil identificar (Ejemplo: Documentos o
archivos de programa).
3. Poner el directorio **bin** en el path de búsqueda de ejecutables.
* Panel de control - editar las variables de entorno del sistema
**NOTA: No debemos borrar o modificar la información ya existente, ya que esto puede generar que otros programas dejen de funcionar.**
* Variables de entorno - Se selecciona path - Apretamos el botón editar
* Seleccionamos "Nuevo" - Indicamos la ruta de nuestra carpeta apache-maven-3.5.0
ejemplo: `C:\Users\pc\Documents\apache-maven-3.5.0\bin`
* Le damos aceptar.
4. En linux se toma el fichero .login, .profile, .bashrc o el que sea según el unix/linux que tengamos 
correspondiente del $HOME del usuario y añadirle al final la línea
`PATH=$PATH;/directorio_maven/maven-2.0.4/bin` 
5. Abrimos el símbolo de sístema o cmd para probar que se agregó correctamente.
Le damos la siguiente instrucción `mvn --version`. Nos debe mostrar la versión de maven que instalamos.

**Puedes verificar el siguiente sitio: https://maven.apache.org/install.html, para cualquier duda en la instalación**

### Generar archivo .jar

1. Abrir el símbolo de sistema o cmd.
2. Moverse al directorio de nuestro programa

* Ejemplo: `C:\Users\pc\Documents\SyncJobPrimero`.

3. Escribimos la siguiente instrucción: `mvn package`
4. Para verificar que se generara nuestro archivo **.jar**, entramos a la carpeta del programa, en la carpeta 
**target** y deben de estar 2 archivos: **SyncJob-1.0.jar** y **SyncJob-1.0-jar-with-dependencies.jar**
que este último es el que vamos ejecutar. 

### Ejecución del programa

1. Abrir símbolo de sistema o cmd.
2. Moverse al directorio donde se encuentra guardado el archivo **.jar**
* Ejemplo: `c:\Users\pc\documents\SyncJobPrimero\target>`.

3.En la línea de comandos se debe de poner la siguiente instrucción:
`java -jar SyncJob-1.0-jar-with-dependencies.jar <ruta donde se encuentra archivo configuración>`

* Ejemplo: `java -jar SyncJob-1.0-jar-with-dependencies.jar C:\Users\pc\Documents\archivoConf.txt`

Si no se contara con archivo de configuración únicamente se da la siguiente instrucción:
`java -jar SyncJob-1.0-jar-with-dependencies.jar`