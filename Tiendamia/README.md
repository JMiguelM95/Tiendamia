# Tiendamia

_El proyecto se basa en la automatización de 1 sitio web en el que se espera finalizar una compra._

## Comenzando 🚀

_Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos personales._

### Documentacion del Proyecto 📋

```
Ingresar a la ruta /YOUR-REPOSITORY/resources/docs/
```

### Pre-requisitos 📋

_Que cosas necesitas para instalar el software y como instalarlas_

```
Java 8+
IDE Eclipse o el de tu preferencia.
Tener instalado TestNG en el IDE
Tener ingresada las variables de entorno como JAVA_HOME

```

### Instalación 🔧

_Para este caso solo se necesitara hacer los pasos comunes de clonacion de proyecto con Git_

_1. Abre la Git Bash_

_2. Cambia el directorio de trabajo actual a la ubicación en donde quieres clonar el directorio._

_3. Escribe git clone, y luego pega la URL que copiaste antes._

```
$ git clone https://github.com/YOUR-USERNAME/YOUR-REPOSITORY
```
_4. Presiona Enter para crear tu clon local._

```
$ git clone https://github.com/YOUR-USERNAME/YOUR-REPOSITORY
> Cloning into `Spoon-Knife`...
> remote: Counting objects: 10, done.
> remote: Compressing objects: 100% (8/8), done.
> remove: Total 10 (delta 1), reused 10 (delta 1)
> Unpacking objects: 100% (10/10), done.
```

## Ejecutando las pruebas ⚙️

_Para ejecutar las casos automatizados, debemos de primero ir a la ruta: /YOUR-REPOSITORY/resources/env/test.properties e ingresar la data que queramos utilizar_

_Luego solo ejecutaremos el testng.xml para los TestCase de Tiendamia (Con TestNG)_

### Analice los resultados 🔩

_Estas pruebas automatizadas validan que el flujo de compras funcione correctamente_

```
Para visualizar el reporte de ExtentReport ir a la siguiente ruta: /YOUR-REPOSITORY/test-output/env/STMExtentReport.html
```
## Construido con 🛠️

_Menciona las herramientas que utilizaste para crear tu proyecto_

* [Maven](https://maven.apache.org/) - Manejador de dependencias
* [POM](https://www.guru99.com/page-object-model-pom-page-factory-in-selenium-ultimate-guide.html) - El framework para patron de diseño
* [ExtentReport](https://www.extentreports.com/) - Manejador de reporteria
* [TestNG](https://testng.org/doc/) - Framework para el mejor manejo de la ejecucion de pruebas

## Autores ✒️

* **Miguel Miranda** - *QA Automator* - [Miguel Miranda](https://github.com/JMiguelM95)
