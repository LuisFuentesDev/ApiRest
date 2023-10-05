# ARTIST API

Api creada para almacenar información sobre artistas.

Los datos a registrar son:
- Nombre Artista
- Primer nombre
- Primer Apellido
- Fecha de nacimiento
- Edad actual

# Acceso a la base de datos

Link para acceder a la base de datos:
```
http://localhost:8080/h2-console/
```
<img width="450" alt="Captura de pantalla 2023-10-02 a la(s) 11 33 30" src="https://github.com/LuisFuentesDev/ApiRest/assets/136398930/90224bcb-3507-4ab4-992a-835ba499a43b">

En JBDC URL, ingresar lo siguiente para acceder a la base de datos:
```
jdbc:h2:mem:apidb
```
# Endpoints
Para crear un registro:

```JSON
{
    "artistName": "Tulio Triviño"
    "firstName": "Tulio",
    "lastName": "Triviño",
    "birthdate": "1985-12-16",
    "age": "38"
}

```
Para obtener el listado de artistas registrados:
```
api/artists
```

Para obtener un artista por el id:
```
api/artists/{id}

  Ejemplo: api/artists/13
```

Para eliminar un artista por el id:
```
api/artists/{id}

  Ejemplo: api/artists/13
```


