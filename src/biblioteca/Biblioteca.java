
package biblioteca;


public class Biblioteca {
    private String nombre;
    private GestorBiblioteca gestor;

    public Biblioteca(String nombre, GestorBiblioteca gestor) {
        if(nombre.length() <3 || nombre == null){
            throw new Error("El nombre no puede estar vacio ni contener menos de 3 caracteres");
        }
        this.gestor = gestor;
    }
    
    
    
}
