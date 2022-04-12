
package archivoscsv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVFormat;

public class ArchivoCSV {
    
    private BufferedReader lector;
    private String linea;
    private String [] partes = null;
    
    private ArrayList<Alumno> alumnos = new ArrayList(); //Es donde guardaran los objetos Alumno de la lista
    private ArrayList<Alumno> alumnosCalificados = new ArrayList();
    
    private ArrayList<Usuario> usuarios = new ArrayList();
    //private ArrayList<Usuario> usuariosEncriptados = new ArrayList();
    
    public void getAlumnosCalificados(ArrayList <Alumno> array){
        for(Alumno a: this.alumnosCalificados){
            array.add(a);
        }
    }
    public void getAlumnos(ArrayList <Alumno> array){
        for(Alumno a: this.alumnos){
            array.add(a);
        }
    }
    
    
    public void getUsuarios(ArrayList <Usuario> array){
        for(Usuario a: this.usuarios){
            array.add(a);
        }
        
    }
    
    public void leerArchivoAlumno(String nombreArchivo){
        
        try{
            lector = new BufferedReader(new FileReader(nombreArchivo));
        
            while((linea = lector.readLine()) != null){
                partes = linea.split(",");
                
                
                //Obtenemos los valores del alumno
                int matricula = Integer.parseInt(partes [0].trim());//trim es un metodo pa quitar espacios en blanco
                String apellidoPaterno = partes[1];
                String apellidoMaterno = partes[2];
                String nombreS = partes[3];
                //Creamos el objeto Alumno con los datos anteriores
                Alumno nuevoAlumno = new Alumno(matricula, apellidoPaterno, apellidoMaterno, nombreS);
                //Anadimos el alumno creado al arraylist 'alumnos'
                this.alumnos.add(nuevoAlumno);
                
                
                System.out.println();//hacemos un salto de linea para el otro alumno
            }
            lector.close();
            linea = null;
            partes = null;
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    public void leerArchivoUsuario(String nombreArchivo){
         try{
            lector = new BufferedReader(new FileReader(nombreArchivo));
        
            while((linea = lector.readLine()) != null){
                partes = linea.split(",");
                
                //Obtenemos los valores del usuario
                String nombreUsuario = partes[0];
                String contrasenaUsuario = partes[1];
                //Creamos el objeto Usuario con los datos anteriores
                Usuario nuevoUsuario = new Usuario(nombreUsuario, contrasenaUsuario);
                //Anadimos el alumno creado al arraylist 'usuarios'
                //Antes era usuarios, ahora a 'usuariosEncriptados'
                this.usuarios.add(nuevoUsuario);
                
                //No necesitamos que se muestren los usuarios y contrasenas
                //imprimirLinea();
            }
            lector.close();
            linea = null;
            partes = null;
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    public void imprimirLinea(){
        for(int i = 0; i < partes.length; i++){
            System.out.print(partes[i] + "  |  ");
        }
    }
    
    
    public void asignarCalificaciones(ArrayList <Alumno> array){
        int calificacion;
        Alumno nuevoAlumno;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println();
        System.out.println();
        System.out.println("INGRESE CALIFICACIONES DE LOS ALUMNOS");
        System.out.println("PARA LA ASIGNATURA DISENO DE SOFTWARE");
        System.out.println("USE SOLAMENTE NUMEROS ENTEROS DEL 1 AL 100");
        
        //HACEMOS UN FOR EACH PARA CAPUTARAR LA CALIFICACION DE CADA ALUMNO DE LA LISTA
       for(Alumno a : array){
           /* System.out.println("Ingrese la calificacion de " + a.getPrimerApellido() + " " + a.getSegundoApellido() + " " + a.getNombres() + " : ");
            calificacion=0;
            do {
                
            
            while (!scanner.hasNextInt()){ //método para validar numeros enteros
                System.out.println("POR FAVOR INGRESE SOLAMENTE NUMEROS ENTEROS DEL 1 AL 100 ");
                scanner.next();
            }
            calificacion = scanner.nextInt();
            if(calificacion<1|| calificacion>100){ //Capturar el rango de la calificación
                System.out.println("POR FAVOR INGRESE SOLAMENTE NUMEROS ENTEROS DEL 1 AL 100 ");
            }*/
            
            nuevoAlumno = new Alumno(a.getMatricula(), a.getPrimerApellido(), a.getSegundoApellido(), a.getNombres(), a.getCalificacion());
            array.add(nuevoAlumno);
            }// while (calificacion<1|| calificacion>100);// validar el rango de la calificación
            
      //  }
        
    }
    
    //FALTA EL METODO PARA VERIFICAR QUE TODOS LOS ALUMNOS TENGAN CALIFICACION
    
    
    public void exportarArchivoCSVAlumno(ArrayList <Alumno> array){
        
        String nombreArchivo = new String();
        nombreArchivo = "listasCalificados.csv";
        try{
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(nombreArchivo));
            CSVPrinter csvPrinter = new CSVPrinter(writer, 
                    CSVFormat.DEFAULT.withHeader("matricula","asignatura","calificacion"));
            
            //Imprimimos a los a
            for(Alumno a : array){
                csvPrinter.printRecord(a.getMatricula(), "Diseño de Software", a.getCalificacion());
            }
            
            //Para liberar recursos
            csvPrinter.flush();
            csvPrinter.close();
            
        }catch(IOException e){
            System.err.println("ERROR: " + e.getMessage());
        }
        
        System.out.println("Se ha generado el archivo con las calificaciones"); 
    }
    
    public void exportarArchivoCSVUsuario(){
        String nombreArchivo = new String();
        nombreArchivo = "usuarios.csv";
        try{
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(nombreArchivo));
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
            
            
            
            //Imprimimos a los a
            for(Usuario a : usuarios){
                //String contrasenaEncriptada = a.encriptarContrasena();
                //Encriptar a cada usuario
                //Guardar en un array usuariosEncriptados
                //Imprimir
                
                csvPrinter.printRecord(a.getNombreUsuario(), a.encriptarContrasena());
            }
            
            //Para liberar recursos
            csvPrinter.flush();
            csvPrinter.close();
            
        }catch(IOException e){
            System.err.println("ERROR: " + e.getMessage());
        }
        
    }
    
}