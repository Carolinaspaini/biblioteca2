package biblioteca;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LibroRepository implements Repository<Libro>, Serializable {

    private List<Libro> libros = new ArrayList<>();
    private String filePath;

    public LibroRepository(String filePath) {
        this.filePath = filePath;
        crearArchivoSiNoExiste(); // Crear archivo al inicializar el repositorio
        loadAll(); // Cargar datos existentes del archivo

    }
    
    private void crearArchivoSiNoExiste() {
        File archivo = new File(filePath);
        try {
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado exitosamente: " + archivo.getName());
            } else {
                System.out.println("El archivo ya existe: " + archivo.getName());
            }
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + e.getMessage());
        }
    }

    @Override
public void add(Libro entity) {
    if (entity == null) {
        throw new IllegalArgumentException("El libro no puede ser nulo.");
    }
    if (entity.getTitulo() == null || entity.getTitulo().length() < 3) {
        throw new IllegalArgumentException("El título no puede ser nulo ni tener menos de 3 caracteres.");
    }
    if (entity.getAutor() == null || entity.getAutor().length() < 3) {
        throw new IllegalArgumentException("El autor no puede ser nulo ni tener menos de 3 caracteres.");
    }

    libros.add(entity);
    saveAll(); // Guardar en el archivo después de agregar un libro
    System.out.println("El libro \"" + entity.getTitulo() + "\" se agregó exitosamente.");
}




    @Override
    public Optional<Libro> findById(int IDS) {
        return libros.stream().filter(libro -> libro.getIDS() == IDS).findFirst();
    }

    @Override
    public List<Libro> findAll() {
        return new ArrayList<>(libros);
    }

    @Override
    public List<Libro> findByAuthor(String autor) {
        return libros.stream().filter(libro -> libro.getAutor().equalsIgnoreCase(autor)).toList();
    }

    private void saveAll() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(libros);
        } catch (IOException e) {
            System.err.println("Error al guardar los libros: " + e.getMessage());
        }
    }

    private void loadAll() {
        File archivo = new File(filePath);
        if (archivo.exists() && archivo.length() > 0) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
                List<Libro> cargados = (List<Libro>) ois.readObject();
                libros.addAll(cargados);
                System.out.println("Libros cargados desde el archivo.");
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Error al cargar los libros: " + e.getMessage());
            }
        }
    }
    

}
