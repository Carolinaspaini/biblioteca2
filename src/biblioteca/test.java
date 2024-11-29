package biblioteca;

import java.util.List;
import java.util.Optional;

public class test {

    public static void main(String[] args) {
        LibroRepository repo = new LibroRepository("libro.dat");
        GestorBiblioteca gestor = new GestorBiblioteca(repo);

        // Agregar libros
        try {
            gestor.agregarLibro("Quijote", "Cervantes");

        } catch (IllegalArgumentException e) {
            System.err.println("Error al agregar libro: " + e.getMessage());
        }

        try {
            gestor.agregarLibro("Cien Años de Soledad", "García Márquez");

        } catch (IllegalArgumentException e) {
            System.err.println("Error al agregar libro: " + e.getMessage());
        }

        try {
            gestor.agregarLibro("Dnn", "Zss");  // Provocará un error

        } catch (IllegalArgumentException e) {
            System.err.println("Error al agregar libro: " + e.getMessage());
        }

        System.out.println("Prueba completada.");

        Optional<Libro> libro = gestor.buscarLibroPorId(1);
        libro.ifPresentOrElse(
                l -> System.out.println("Libro encontrado: " + l.getTitulo()),
                () -> System.err.println("No existe un libro con ese ID")
        );
        
        System.out.println("-----------------------------------------------------------------------------------------------");

        List<Libro> librosPorAutor = gestor.BuscarLibroPorAutor("Cervantes");

        if (librosPorAutor.isEmpty()) {
            System.err.println("No hay libros de ese autor.");
        } else {
            System.out.println("Libros de Cervantes:");
            librosPorAutor.forEach(l -> System.out.println(l.getTitulo()));
        }
        System.out.println("-----------------------------------------------------------------------------------------------");
        
      List<Libro>todosLosLibros = gestor.listarLibros();
      System.out.println("Todos los libros");
      todosLosLibros.forEach(l -> System.out.println(l.getTitulo()));

    }
}
