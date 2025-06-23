# App de Volquetas - Android Nativo

Aplicación Android nativa (Java) que consume una API REST para visualizar un listado de vehículos con una interfaz personalizada, basada en la identidad visual de la Alcaldía de Santo Domingo.

## Capturas de Pantalla

| Pantalla de Bienvenida | Listado Principal |
| :---: | :---: |

![copia1](https://github.com/user-attachments/assets/ee7b4d15-884b-4343-a05e-3690c165c314)


![copia 2](https://github.com/user-attachments/assets/e58bde89-e399-4625-bb39-b1e90c90bed0)

## Características

- **Consumo de API REST:** Utiliza **Retrofit** para las peticiones de red y **Gson** para el parseo de JSON a objetos Java.
- **Interfaz de Usuario Moderna:** Muestra los datos en un `RecyclerView` con `CardView` y aplica una identidad visual personalizada (logos, colores y estilos).
- **Flujo de Navegación:** Incluye una pantalla de bienvenida (`SplashActivity`) que dirige al listado principal (`MainActivity`), manejando el ciclo de vida de la app.
- **Manejo de Estados:** Provee feedback visual al usuario durante los estados de carga (con `ProgressBar`) y error.

## Tecnologías

- **Lenguaje:** Java
- **Librerías Clave:** Retrofit, Gson, AndroidX (AppCompat, Material Components).
