El objetibo de este proyecto es el siguiente:

Desarrolla una app de productos utilizando Java y una base de datos en memoria. La app debe permitir crear, actualizar, consultar y eliminar productos a través de endpoints.
Requisitos técnicos:
Utilizar Java 8 o superior.
Utilizar Spring Framework.
Utilizar una base de datos en memoria(por ejemplo, HSQLDB, H2 Database, etc).
La aplicación debe estar lista para ejecutar y hacer peticiones desde postman.
Funcionalidades requeridas:
Crear un producto con los siguientes campos: nombre, descripción, precio, cantidad.
Actualizar un producto existente.
Consultar un producto por ID o por nombre.
Eliminar un producto existente.
Funcionales adicionales: 
Consultar todos los productos ordenados por precio.
La solución debe incluir el código fuente completo, documentación detallada sobre cómo ejecutar y probar el sistema, y cualquier otra información adicional que el candidato considere relevante.

La Api acepta peticiones GET, POST, PUT y DELETE.
el server corre en el puerto 8080 y los enpoint son los siguientes:

get: /products => Devuelve todos los productos ordenados por precio de menor a mayor

get: /products/:id => Devuelve el producto del id correspondiente

get: /products/name/:nombre =>Devuelve todos los producto por su nombre con coincidencia exacta

post: /products => Crea un nuevo producto

put:  /products/:id =>Actualiza un producto segun su ID
    el json que recive tiene el siguiente formato:
    {
        "nombre": <String>,
        "descripcion": <String>,
        "cantidad": <Integer>,
        "precio": <Float>
    }

delete: /products/:id =>Elimina un producto segun su ID