
package archivoscsv;

import view.InicioSesion;


public class Main {
    
    public static void main (String [] args){
       
        /*Controlador programa = new Controlador();
        programa.validarOpcion();
        */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicioSesion().setVisible(true);
            }
        });
    }
}
