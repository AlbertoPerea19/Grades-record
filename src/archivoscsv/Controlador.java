
package archivoscsv;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jacobUc
 * @author RafaelPerea
 */
public class Controlador {
    boolean comparacion=true;
    ArchivoCSV archivoNuevo = new ArchivoCSV();
    
    //Creamos el array donde guardaremos los usuarios que se lean
    ArrayList <Usuario> usuarios = new ArrayList();
    
    //Declaramos un scanner
    Scanner scanner = new Scanner(System.in);
    
    //Declaramos los datos que se ingresan para el login
    String usuarioDado;
    String contrasenaDada;
    //Creamos un usuario que sera los datos de entrada del teclado
    Usuario usuarioIngresado;
    
    //Creamos un arraylist donde se recuperaran los alumnos calificados
    ArrayList<Alumno> alumnosCalificados = new ArrayList();
    
    //Creamos nuestra variable para crear el PDF
    ArchivoPDF archivoPDF = new ArchivoPDF();
    
    
    public void mostrarMenu(){
        System.out.println("\tMENU");
        System.out.println("PULSE 1 PARA INGRESAR AL PROGRAMA\nPULSE 0 PARA SALIR");
    }
    
    public void prepararUsuarios(ArrayList usuarios){
        //Leemos los usuarios
        this.archivoNuevo.leerArchivoUsuario("C:\\Users\\betoh\\OneDrive\\Documentos\\Projects java\\actividad1\\usuarios.csv");
        //Guardamos los usuarios
        this.archivoNuevo.getUsuarios(usuarios);
    }
    
    public void crearUsuario(){
        System.out.println("Ingrese el usuario: ");
        usuarioDado = scanner.next();
        System.out.println("Ingrese la contrasena: ");
        contrasenaDada = scanner.next();
        //Creamos un ususario con los parametros dados
        usuarioIngresado = new Usuario(usuarioDado, contrasenaDada);
    }
    
    public boolean validacion(Usuario inputUsuario){
        for(Usuario a: usuarios){
           return this.comparacion=a.compararUsuarios(inputUsuario);
        }
        return this.comparacion;
    }
    
    public void validarOpcion(){
        int opcionIngresada;
        String contrasenaEncriptada;
        
        
        do{
            mostrarMenu();
            opcionIngresada = scanner.nextInt();
            
            if(opcionIngresada == 1){
                prepararUsuarios(usuarios);
                crearUsuario();
            
                contrasenaEncriptada = usuarioIngresado.encriptarContrasena();
                usuarioIngresado.setContrasena(contrasenaEncriptada);
                //System.out.println(usuarioIngresado.getContrasena());
                
                for(Usuario a: usuarios){
                    boolean comparacionUsuarios = a.compararUsuarios(usuarioIngresado);
                    
                    if(comparacionUsuarios){
                        archivoNuevo.leerArchivoAlumno("C:\\Users\\betoh\\OneDrive\\Documentos\\4th semester\\Software design\\Usuarios.csv");
                        archivoNuevo.asignarCalificaciones(alumnosCalificados);
                        archivoNuevo.exportarArchivoCSVAlumno(alumnosCalificados);
                        
                        //Pasamos los alumnosCalificados al array alumnosCalificados
                        archivoNuevo.getAlumnosCalificados(alumnosCalificados);
                        //Imprimimos el reporte PDF
                        archivoPDF.crearArchivo(alumnosCalificados);
                    }
                    
                }
            
                
            }
            
        }while(opcionIngresada != 0);
    }
  
   
}
