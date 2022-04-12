
package archivoscsv;


public class Alumno {
    
    //Atributos a recuperar
    private int matricula;
    private String primerApellido;
    private String segundoApellido;
    private String nombres;
    private String calificacion;

    public Alumno(int matricula, String primerApellido, String segundoApellido, String nombres) {
        this.matricula = matricula;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.nombres = nombres;
    }
    
    //Ahora creamos el metodo constructor para el Alumno con calificacion
    public Alumno(int matricula, String primerApellido, String segundoApellido, String nombres, String calificacion){
        this.matricula = matricula;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.nombres = nombres;
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "Alumno{" + "matricula=" + matricula + ", primerApellido=" + primerApellido + ", segundoApellido=" + segundoApellido + ", nombres=" + nombres + '}';
    }
    
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    
    public String getPrimerApellido() {
        return primerApellido;
    }
    
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    
    public String getSegundoApellido() {
        return segundoApellido;
    }
    
    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    
    public String getNombres() {
        return nombres;
    }
    
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    
    
    public String getCalificacion() {
        return calificacion;
    }

    
    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }
}
