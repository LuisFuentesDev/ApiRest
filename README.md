# ARTIST API

Api creada para almacenar información sobre artistas.

Los datos a registrar son:
- Primer nombre
- Primer Apellido
- Fecha de nacimiento
- Edad actual

# Endpoints

Link para acceder a la base de datos:
http://localhost:8080/h2-console/

Para crear un registro:

Ejemplo:
{
    "firstName": "Tulio",
    "lastName": "Triviño",
    "birthdate": "1985-12-16",
    "age": "38"
}

Para obtener el listado de artistas registrados:
- api/artists

Para obtener un artista por el id:
- api/artists/{id}
  Ejemplo: api/artists/13

Para eliminar un artista por el id:
- api/artists/{id}
  Ejemplo: api/artists/13


