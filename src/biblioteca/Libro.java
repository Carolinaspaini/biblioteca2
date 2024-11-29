
package biblioteca;

import java.io.Serializable;


public class Libro implements Serializable {
    private static int id = 1;
    private int IDS;
    private String titulo;
    private String autor;

    public Libro(String titulo, String autor) {
        
          if(titulo == null || titulo.length() <3){
            throw new Error("No puede tener menos de 3 caracteres");
        }
        
        if(autor == null || autor.length() <3 ){
            throw new Error("El nombre autor no puede contener menos de 3 caracteres ni numeros");
            
        }
        
        this.titulo = titulo.trim();
        this.autor = autor.trim();
        this.IDS = id++;
        
       
 
    }

    public static int getId() {
        return id;
    }

    public int getIDS() {
        return IDS;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }
    
    

    
    
    
    
}
