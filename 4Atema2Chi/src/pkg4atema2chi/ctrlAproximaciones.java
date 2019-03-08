
package pkg4atema2chi;

import java.util.ArrayList;

public class ctrlAproximaciones {
   private double valorInicial;
   private double error;
   
    public ctrlAproximaciones(double valorInicial, double error) {
        this.valorInicial = valorInicial;
        this.error = error;
    }
   
    /**
     * @param x es el valor inicial
     * @return la evaluacion a trabajar.
     */
    public double getEvaluacion(double x){
       return Math.pow(Math.E, -(x));
   }
    /**
     * @param xInicial valor inicial
     * @return returna el error en positivo
     */
    public double getError(double xInicial){
        return Math.abs((this.getEvaluacion(xInicial) - xInicial)/this.getEvaluacion(xInicial));
    }
    /**
     * @return la lista de soluciones que contiene todos los datos para
     * la tabla.
     */
    public ArrayList<filaAproximaciones> aproximacion(){
        int i = 1;
        double errorCalculado = 1;
        double error;
        ArrayList<filaAproximaciones> listaSoluciones = new ArrayList<>();
        
        while(errorCalculado > this.error){
            error = this.getError(this.valorInicial);
            
            filaAproximaciones fila = new filaAproximaciones();
            
            fila.setI(i);
            fila.setXi(this.valorInicial);
            fila.setGxi(this.getEvaluacion(this.valorInicial));
            fila.setError(error);
            
            listaSoluciones.add(fila);
           
            this.valorInicial = fila.getGxi();
            
            errorCalculado = fila.getError();
            i++;
        }
        return listaSoluciones;
    }
    /**
     * @return el modelo de la tabla de aproximaciones.
     */
     public tablaAproximaciones getTablaAprox(){
       tablaAproximaciones modelo = null;
       ArrayList<filaAproximaciones> lista = this.aproximacion();
       
       if(lista != null)
            modelo = new tablaAproximaciones(lista);
       return modelo;
   }
    
   

    
    
    
   
}
