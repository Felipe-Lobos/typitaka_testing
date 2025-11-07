# Typitaka Testing

Proyecto de pruebas automatizadas con Java + Selenium (Maven) para el proyecto Typitaka.

## Descripción
Conjunto de tests E2E y de integración que validan la funcionalidad de Typitaka desde la interfaz (navegador). Está pensado para ejecutarse localmente y en CI, usando Selenium WebDriver (Chrome/Firefox) y Maven.

## Requisitos
- JDK 11+ (recomendado 17)
- Maven 3.6+
- Chrome o Firefox instalados
- ChromeDriver/GeckoDriver en PATH o uso de WebDriverManager

## Tecnologías
- Java 11+
- Maven
- Selenium WebDriver
- JUnit 5 (u otra librería de pruebas según configuración)
- WebDriverManager (recomendado para gestionar drivers)

## Instalación y configuración
1. Clonar el repositorio:
    git clone <url-del-repo>
2. Configurar variables (opcional):
    - BASE_URL: URL donde corre Typitaka (por ejemplo http://localhost:3000)
    - BROWSER: chrome | firefox
    - HEADLESS: true | false

Ejemplo export (Linux/macOS):
export BASE_URL=http://localhost:3000
export BROWSER=chrome
export HEADLESS=true

En Windows (PowerShell):
$env:BASE_URL="http://localhost:3000"

## Dependencias útiles (pom.xml)
- selenium-java
- junit-jupiter
- io.github.bonigarcia:webdrivermanager

(Revisar pom.xml en el proyecto para versiones y configuración concreta.)

## Comandos importantes
- Compilar:
  mvn clean compile
- Ejecutar todos los tests:
  mvn test
- Ejecutar un test específico (JUnit 5):
  mvn -Dtest=MiTest#metodoTest test
- Forzar propiedades desde línea de comandos:
  mvn test -Dbase.url=http://localhost:3000 -Dbrowser=chrome -Dheadless=true

## Estructura recomendada
- src/main/java : utilidades, page objects, helpers
- src/test/java : clases de tests (JUnit)
- src/test/resources : datos de prueba, perfiles de configuración

## Buenas prácticas
- Usar Page Object Pattern para separar lógica de tests y selectores.
- Evitar sleeps fijos; preferir ExpectedConditions / WebDriverWait.
- Mantener datos de prueba en resources o fixtures.
- Ejecutar tests en modo headless en CI.

## Integración continua
- En GitHub Actions / GitLab CI:
  - Instalar JDK y Maven
  - Ejecutar Chrome/Firefox (o usar contenedor con navegador)
  - Ejecutar mvn test con variables de entorno para BASE_URL y BROWSER

Ejemplo (GitHub Actions) — pasos:
- actions/checkout
- setup-java
- cache de Maven
- ejecutar mvn -Dbase.url=${{ secrets.BASE_URL }} test

## Contribuir
- Crear rama feature/mi-feature
- Abrir PR con descripción de cambios y comandos para reproducir

## Licencia
Indicar la licencia del proyecto (MIT, Apache, etc.) o dejar según preferencia.

---
GitHub Copilot