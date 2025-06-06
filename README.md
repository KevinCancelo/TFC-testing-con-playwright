# TFC-testing-con-playwright
En este trabajo se realizan una serie de tests sobre la página web de luckia. Se hace sobre esta dirección porque aquí realicé las practicas.

## 🎯 Demostración de funciones y aplicaciones

Este proyecto automatiza pruebas funcionales utilizando **Playwright para Java**, con una arquitectura organizada según el patrón **Page Object Model (POM)**. Está desarrollado sobre la web pública [the-internet.herokuapp.com](https://the-internet.herokuapp.com), pensada para prácticas con herramientas como Selenium o Playwright.

Aunque la plataforma es didáctica, el proyecto ha sido diseñado con una estructura escalable y un enfoque realista, ideal para entornos de desarrollo profesional, formación técnica o testing QA en equipos de software.

### 🔍 Funcionalidades implementadas

Se han desarrollado distintos escenarios de prueba que simulan interacciones comunes en aplicaciones web reales:

- ✅ **Smoke Test Básico:** Comprueba que la aplicación carga correctamente y que los elementos esenciales están disponibles.
- 🔐 **Autenticación/Login:**
  - Validación de credenciales correctas e incorrectas.
  - Verificación de mensajes de error o éxito.
- ⚠️ **Alertas del navegador:**
  - Detección y gestión de alertas JavaScript (`prompt`, `confirm`, `alert`).
- 📁 **Descarga de archivos:**
  - Descarga automatizada de archivos `.txt` y verificación de su presencia en disco.
- 🪟 **Navegación entre ventanas:**
  - Validación de comportamiento al interactuar con enlaces que abren nuevas pestañas o ventanas.
- 🖼️ **Manejo de iframes:**
  - Acceso e interacción con contenido embebido en marcos (iframes), incluyendo escritura y lectura.

Cada prueba incluye validaciones específicas (`asserts`) para garantizar que el comportamiento observado es el esperado, y se ejecuta de forma secuencial para asegurar estabilidad.

### ⚙️ Aplicaciones prácticas

Este proyecto tiene múltiples aplicaciones reales y formativas:

- 🧪 **Automatización funcional** de flujos básicos y críticos en una aplicación web.
- 📈 **Generación de reportes automáticos** mediante herramientas como Allure, con evidencias visuales (CSS, JS, fuentes, imágenes) para cada ejecución.
- 🎓 **Formación técnica en QA Automation**, incluyendo estructura de proyecto basada en POM, gestión de dependencias con Maven y buenas prácticas de codificación.
- 🧱 **Base reutilizable** para equipos de testing que trabajen con Java y Playwright, adaptable a otras plataformas reales.
- 🚀 **Simulación de escenarios reales** como descargas, navegación avanzada y uso de componentes embebidos, replicando desafíos típicos de automatización en producción.

La ejecución está diseñada para lanzarse fácilmente desde la terminal del IDE (como Visual Studio Code) utilizando Maven, en el archivo [TUTORIAL MAVEN](./TUTORIAL_MAVEN.md).

## 🚀 Acceso al proyecto

Para comenzar a trabajar con este proyecto de automatización en Playwright (Java) desarrollado en Visual Studio Code, sigue los pasos que se indican a continuación.

### 🔧 Requisitos previos

Antes de empezar, asegúrate de contar con:

- **Sistema operativo:** Windows 10, macOS 10.13+ o una distribución moderna de Linux.
- **Java JDK:** Versión 1.8 o superior (se recomienda JDK 1.8 para garantizar compatibilidad).
- **Maven:** Versión 3.6.0 o superior para gestionar las dependencias y compilación.
- **Navegador:** Chrome o WebKit (Safari) para ejecutar las pruebas automatizadas.
- **IDE:** Visual Studio Code (recomendado), aunque se puede usar cualquier IDE compatible con Java.
- **Hardware:** Al menos 4 GB de RAM y resolución mínima de pantalla de 1280x720.

### 📦 Clonación del repositorio

Clona el repositorio a tu máquina local usando Git:

git clone https://github.com/KevinCancelo/TFC-testing-con-playwright.git

cd TFC-testing-con-playwright

## 🛠️ Tecnologías utilizadas

Este proyecto ha sido desarrollado empleando un conjunto de tecnologías modernas que facilitan la automatización de pruebas y la gestión eficiente del código. A continuación, se detallan las principales herramientas y dependencias utilizadas:

### 📚 Principales tecnologías

- **Playwright**  
  Herramienta de automatización de pruebas end-to-end desarrollada por Microsoft. Permite simular la interacción de un usuario con una aplicación web a través de distintos navegadores (Chromium, Firefox, WebKit). Soporta múltiples lenguajes, como Java, Python y JavaScript. En este proyecto se ha utilizado la implementación para **Java**.

- **Java**  
  Lenguaje de programación orientado a objetos ampliamente utilizado en el desarrollo de aplicaciones empresariales, servicios web y automatización de pruebas.

- **Maven**  
  Sistema de gestión y construcción de proyectos Java. Automatiza tareas como la compilación, empaquetado y gestión de dependencias a través del archivo de configuración `pom.xml`.

- **JUnit**  
  Framework de pruebas unitarias para Java. Permite verificar el comportamiento de métodos y clases, facilitando la automatización de tests y contribuyendo a la calidad del software mediante la detección temprana de errores.

### 📦 Dependencias adicionales

- **Allure**  
  Herramienta de generación de reportes visuales y detallados sobre resultados de pruebas. Se integra mediante dependencias y plugins de Maven, y ofrece informes interactivos que facilitan el análisis de resultados.

- **Apache Commons Lang (`commons-lang3`)**  
  Biblioteca que extiende las funcionalidades básicas del lenguaje Java, proporcionando utilidades para el manejo de cadenas, números, fechas, objetos y más.

- **Jackson (`core` y `databind`)**  
  Conjunto de librerías para el procesamiento de datos en formato JSON. Se utiliza principalmente en pruebas que implican intercambio o validación de datos estructurados.

- **Spring Context y Spring Test**  
  Módulos del ecosistema Spring utilizados para aplicar principios de inyección de dependencias durante las pruebas. Aportan escalabilidad, limpieza estructural y mejor organización del código de testing.

### 💻 Entorno de desarrollo

- **Visual Studio Code**  
  Se ha utilizado como entorno de desarrollo (IDE) principal por su flexibilidad, extensiones y compatibilidad con múltiples lenguajes. Sin embargo, puede ser sustituido por cualquier otro IDE compatible con Java, como IntelliJ IDEA o Eclipse.

## Licencia

Este proyecto está licenciado bajo la Licencia MIT. Esto significa que puedes usar, copiar, modificar, fusionar, publicar, distribuir, sublicenciar y/o vender copias del software, siempre que incluyas el aviso de copyright original.

Para más detalles, consulta el archivo [LICENSE](./LICENSE).

Este proyecto también hace uso del sitio [The Internet](https://the-internet.herokuapp.com), el cual está licenciado bajo las licencias **MIT** y **Apache 2.0**.

## Autor

Este proyecto fue desarrollado por Kevin Cancelo.

Si deseas contribuir o tienes sugerencias, ¡las pull requests son bienvenidas!

## Créditos

Este proyecto utiliza como entorno de pruebas automatizadas el sitio web [The Internet](https://the-internet.herokuapp.com), creado originalmente por [Dave Haeffner](https://github.com/tourdedave) y actualmente mantenido por [Sauce Labs](https://github.com/saucelabs/the-internet).

Todo el contenido del sitio de pruebas pertenece a sus respectivos autores y se utiliza únicamente con fines educativos y de automatización de pruebas.
