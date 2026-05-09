# Taller 3 - POO: Treyo

##  Integrantes
- **Axel Alcayaga** - Ingeniería Civil en Computación e Informática - 20.832.945-6
- **Vicente Rojas** - Ingeniería Civil en Computación e Informática - 22.141.463-2

##  Resumen
La empresa TaskForge Ltda. ha solicitado el desarrollo de una herramienta de gestión de proyectos para su equipo de desarrollo de software.

## Guía rápida para Eclipse

1. Importar el proyecto: `File → Import → Git → Projects from Git (with smart import) → Clone URL` e ingresar la URL del repositorio.  
2. Abrir la clase: `src/logica/Main.java`.  
3. Ejecutar `Run Main`.



## Compilar en consola
mkdir -p bin
javac -encoding UTF-8 -d bin $(find src -name "*.java")

## Ejecutar en consola
java -cp bin logica.Main


```mermaid
classDiagram
    class Cancion {
        +int id
        +string nombre
        +string artista
        +string album
        +int year
        +int duracion
        +string ubicacion
    }

    class NodoDoble {
        -Cancion cancion
        -NodoDoble* siguiente
        -NodoDoble* anterior
        +Cancion getCancion()
        +void setCancion(Cancion c)
        +NodoDoble* getSiguiente()
        +NodoDoble* getAnterior()
        +void setSiguiente(NodoDoble* n)
        +void setAnterior(NodoDoble* n)
    }

    class ListaDoble {
        -NodoDoble* cabeza
        -NodoDoble* cola
        -NodoDoble* actual
        +ListaDoble()
        +~ListaDoble()
        +void Agregaralfinal(Cancion c)
        +bool Eliminarnodo(int id)
        +void siguientePista(int r, bool a)
        +void pistaAnterior(int r, bool a)
        +void Mezclarrestantes()
        +Cancion* Buscarporid(int id)
        +void Mostrarlistadocompleto()
        +void Mostrarpendientes()
        +void Saltarpistas(int saltos)
        +int Obtenerultimoid()
        +bool tieneActual()
        +Cancion* obtenerActual()
        +void Fijarporid(int id)
    }

    ListaDoble "1" *-- "*" NodoDoble : Compone y gestiona
    NodoDoble "1" --> "1" Cancion : Contiene la información


