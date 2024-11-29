
 
package biblioteca;

import java.util.List;
import java.util.Optional;

class GestorBiblioteca {
    private final Repository<Libro> libroRepository;

    public GestorBiblioteca(Repository<Libro> libroRepository) {
        this.libroRepository = libroRepository;
    }
    
    

   public void agregarLibro(String titulo, String autor){
        libroRepository.add(new Libro(titulo, autor));
        }
   
   public Optional<Libro>buscarLibroPorId(int IDS){
       return libroRepository.findById(IDS);
          
   }
   
   public List<Libro>BuscarLibroPorAutor(String autor){
       return libroRepository.findByAuthor(autor);
   }
   
   public List<Libro>listarLibros(){
       return libroRepository.findAll();
   }
       
       
      
       
       
       
           
   }

    
    
    

    
    
    
    
    
    
    

