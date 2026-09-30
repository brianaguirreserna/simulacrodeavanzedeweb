# StreamSub — Avance 2 (versión simplificada)

Sistema de Suscripción a un Servicio de Streaming y Servicio de Pago.
Proyecto académico (curso Marco de Desarrollo Web) construido con **Spring Boot 3 + Thymeleaf + Bootstrap 5 + Spring Security**.

## Alcance de este avance

- Implementa **CRUD completo** (28 funcionalidades) sobre 6 entidades: Categoría, Contenido, Plan, Usuario, Método de Pago y Suscripción.
- Usa **datos de prueba (dummy) en memoria** — no hay conexión a base de datos.
- **No incluye métricas** (se agregarán en el Avance 3, junto con JPA/base de datos real).
- Control de acceso simple con **Spring Security** (login dummy).
- Páginas estáticas de **Publicidad** y **Contacto**.
- Código deliberadamente simple: cada entidad tiene un modelo, un servicio con operaciones CRUD básicas
  (sin validaciones cruzadas entre entidades) y un controlador con las rutas típicas (listar, nuevo, guardar,
  editar, eliminar). Las relaciones entre entidades (por ejemplo, a qué usuario pertenece una suscripción)
  se muestran como el ID numérico, sin lógica adicional de búsqueda en las vistas.

> Nota: las 5 reglas de negocio siguen documentadas y explicadas en el informe (punto 5.8), pero en esta
> versión simplificada del código no todas están validadas programáticamente — se dejó solo la más simple
> (RN02: al "eliminar" una categoría, el servicio solo cambia `activo` a `false` en vez de borrarla).
> Si tu profesor exige que las 5 reglas estén implementadas en el código (criterio de 7 pts de la rúbrica),
> dilo y te ayudo a agregarlas de vuelta de forma puntual.

## Cómo ejecutar

Requisitos: JDK 17+ y Maven.

```bash
mvn spring-boot:run
```

La aplicación arranca en `http://localhost:8080`.

## Credenciales de acceso (dummy)

- Usuario: `admin`
- Contraseña: `admin123`

## Rutas principales

| Módulo | Ruta |
|---|---|
| Login | `/login` |
| Panel principal | `/` |
| Categorías | `/categorias` |
| Contenido | `/contenidos` |
| Planes | `/planes` |
| Usuarios | `/usuarios` |
| Métodos de Pago | `/metodos-pago` |
| Suscripciones | `/suscripciones` |
| Publicidad (pública) | `/publicidad` |
| Contacto (pública) | `/contacto` |

## Estructura del proyecto

```
src/main/java/com/streamsub/
  model/        Entidades (POJOs, sin JPA en este avance)
  service/      Repositorios dummy en memoria, CRUD simple
  controller/   Controladores MVC (uno por entidad + páginas generales)
  config/       Configuración de Spring Security
src/main/resources/
  templates/    Vistas Thymeleaf (fragments/nav.html reutilizado en todas las páginas)
  static/css/   Hoja de estilos compartida
```

## Próximos avances

- **Avance 3**: incorporar JPA + base de datos relacional real, y las 5 métricas basadas en series de tiempo.
- **Entrega final**: JWT + Spring Security completo, evidencia en base de datos y evaluación oral.
