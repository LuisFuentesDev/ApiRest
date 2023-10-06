# ARTIST API

Api creada para almacenar información sobre artistas y álbumes.

La entidad principal registra lo siguiente:
- Nombre Artista
- Primer nombre
- Primer Apellido
- Fecha de nacimiento
- Edad actual

La entidad secundaria registra lo siguiente:
- Nombre del álbum
- Total de canciones
- Duración del álbum 

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
Para crear un registro de artista y albumes:

```JSON
{
    "artistName": "Shakira",
    "firstName": "Shakira",
    "lastName": "Mebarak",
    "birthDate": "1997-02-02",
    "age": 46,
    "albums": [
        {
            "nameAlbum": " Pies descalzos",
            "totalSongs":11,
            "albumDuration": 41
        },
        {
            "nameAlbum": "Grandes éxitos",
            "totalSongs": 15,
            "albumDuration": 52
        }
    ]
}

```
Para obtener el listado de artistas:
```
api/artist
```

Para obtener el listado de albumes:
```
api/album
```

Para obtener un artista por el id:
```
api/artist/{id}

  Ejemplo: api/artist/13
```
Para obtener un álbum por el id:
```
api/album/{id}

  Ejemplo: api/album/13
```

Para eliminar un artista por el id:
```
api/artist/{id}

  Ejemplo: api/album/13
```

Para eliminar un álbum por el id:
```
api/album/{id}

  Ejemplo: api/album/13
```

