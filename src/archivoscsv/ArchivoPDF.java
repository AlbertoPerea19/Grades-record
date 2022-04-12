
package archivoscsv;


import com.itextpdf.text.BaseColor;
import java.io.File;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import java.util.ArrayList;


public class ArchivoPDF {
    
    //private static String FILE = "Es la ruta"; Se reemplaza por el file de abajo
    
    //Declaramos el nombre del archivo
    File file = new File("Reporte_Calificaciones.pdf");
    
    public void crearArchivo(ArrayList <Alumno> alumnosCalificados){
        
        Document documento = new Document();
        //Indicamos el numero de columnas que tendra la tabla
        int numColumnas = 3;
        PdfPTable tabla = new PdfPTable(numColumnas);
        
        try{
            PdfWriter.getInstance(documento, new FileOutputStream(file));
            documento.open();
            
            //Creamos la tabla
            crearTabla(tabla, numColumnas, alumnosCalificados);
            
            documento.add(tabla);
            
            //Cerramos nuestro documento
            documento.close();
            
            System.out.println("El reporte PDF ha sido creado exitosamente");
            
        }catch(DocumentException | FileNotFoundException e){
            
        }
    }
    
    public void crearTabla(PdfPTable tabla, int numColumnas, ArrayList <Alumno> alumnosCalificados){
        
        //Las columnas son : Matricula | NombreCompleto | Calf 
        //PdfPTable tabla = new PdfPTable(numColumnas);
        
        PdfPCell matricula = new PdfPCell(new Phrase("Matricula"));
        matricula.setBackgroundColor(BaseColor.YELLOW);
        
        PdfPCell nombreAlumno = new PdfPCell(new Phrase("Nombre del Alumno"));
        nombreAlumno.setBackgroundColor(BaseColor.YELLOW);
        
        PdfPCell calificacion = new PdfPCell(new Phrase("Calificacion"));
        calificacion.setBackgroundColor(BaseColor.YELLOW);
        
        
        tabla.addCell(matricula);
        tabla.addCell(nombreAlumno);
        tabla.addCell(calificacion);
        
        for(Alumno a: alumnosCalificados){
            tabla.addCell(String.valueOf(a.getMatricula()));
            tabla.addCell(a.getPrimerApellido() + " " + a.getSegundoApellido() + " " + a.getNombres());
            tabla.addCell(String.valueOf(a.getCalificacion())); 
        }
        
        //return tabla;
    }
    
    
}
