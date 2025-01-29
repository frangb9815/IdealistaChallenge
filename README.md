# Idealista Android Challenge

_Solución al reto Android Challenge https://idealista.github.io/android-challenge/ implementada por Francisco Gaitán_

### Estructura 📋

_Este proyecto sigue los principios de Clean Architecture, dividiendo la aplicación en capas bien definidas para mejorar la mantenibilidad y escalabilidad del código:_

**Arquitectura y Patrón de Diseño**

_Se implementa **Clean Architecture** con las capas **Data, Domain y Presentation**, asegurando una separación clara de responsabilidades.
Se sigue el **patrón MVVM (Model-View-ViewModel)** para una mejor gestión del estado y del ciclo de vida de la UI._

**Inyección de Dependencias**

_Se utiliza **Hilt** para una inyección de dependencias eficiente y modular._

**Manejo de Datos**

Los datos se obtienen de una API remota usando **Retrofit**.
Para el almacenamiento local y la persistencia de los favoritos marcados, así como la fecha y hora en la que se han marcado, se emplea **Room**.

**Carga de Imágenes**

Se integra **Glide** para la gestión optimizada de imágenes en la aplicación. Tanto en la pantalla de listado como en la de detalle, se cargan un carrousel de imágenes con todas las disponibles.

**Manejo de Concurrencia**

_Se usan **Coroutines** para operaciones asíncronas, mejorando la experiencia de usuario y el rendimiento de la aplicación._

```
Obtención del listado
Obtención del detalle
Añadir a favoritos
Obtención de los previamente marcados como favoritos
```

### Pantallas 🔧

_Contiene 2 pantallas: Por un lado la pantalla de listado, y por otra la pantalla de Detalle. Recalcar que para la pantalla de detalle, se llama al servicio de detalle,
no se envía ningún id ni elemento desde el listado, por lo que da igual el que abras, que el detalle siempre muestra lo mismo, por como funciona la API proporcionada._

**Para acceder al detalle, hay que pulsar en la card por fuera del carrousel de fotos**

#### Listado
![image](https://github.com/user-attachments/assets/2b24419c-bd25-4e00-8850-948848dc7645)







#### Detalle
![image](https://github.com/user-attachments/assets/0c2c075e-bc85-42d2-b7a3-93405c2a3b65)



## Autor ✒️

* **Francisco Gaitán** - *Implementación completa* - [frangb9815](https://github.com/frangb9815)
