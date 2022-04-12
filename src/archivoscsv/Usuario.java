
package archivoscsv;


public class Usuario {
    private String nombreUsuario;
    private String contrasena;
    private String claveEncriptacion = "DisenoDeSoftware";
    
    public Usuario(String nombreUsuario, String contrasena){
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }
    
    public boolean compararUsuarios(Usuario usuario){
        boolean retorno = false;
        
        if(this.nombreUsuario.equals(usuario.getNombreUsuario()) && this.contrasena.equals(usuario.getContrasena())){
            retorno = true;
        }
        
        return retorno;
    }
    
    public String encriptarContrasena(){
        String retorno;
        
        try{
            EncriptadorAES encriptador = new EncriptadorAES();
        
            String contrasenaEncriptada = encriptador.encriptar(contrasena, this.claveEncriptacion);
            
            retorno =  contrasenaEncriptada;
            
        }catch(Exception e){
            retorno = null;
        }
        return retorno;
    }
    
    public String desencriptarContrasena(String contrasenaEncriptada){
        String retorno;
        
        try{
            EncriptadorAES encriptador = new EncriptadorAES();
        
            String contrasenaDesencriptada = encriptador.desencriptar(contrasenaEncriptada, claveEncriptacion);
            
            retorno =  contrasenaDesencriptada;
            
        }catch(Exception e){
            retorno = null;
        }
        return retorno;
    }
    
    
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }
    
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
