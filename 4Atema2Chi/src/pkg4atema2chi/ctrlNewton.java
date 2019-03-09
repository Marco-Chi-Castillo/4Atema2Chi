
package pkg4atema2chi;

import java.util.ArrayList;

/**
 * @author Admin
 */
public class ctrlNewton {
    private double valorInicial, error;
    
    public ctrlNewton(double valorInicial, double error ){
        this.valorInicial = valorInicial;
        this.error = error;
    }
    /**
     * @param x valor inicial
     * @return funcion
     */
    public double getFunOriginal(double x){  
        return Math.pow(Math.E, -(x)) - x;
    }
    /**
     * 
     * @param x valor inicial
     * @return funcion derivada
     */
    
    public double getFunDerivada(double x){
        double e = Math.pow(Math.E, -(x));
        return -(e) - 1;
    }
    /**
     * @param xi valor inicial
     * @return xi + 1
     */
    public double getEvaluacion(double xi){
        return Math.abs(xi - (this.getFunOriginal(xi)/this.getFunDerivada(xi)));
    }
    /**
     * @param xInicial valor inicial
     * @return error
     */
    public double getError(double xInicial){
        return Math.abs((this.getEvaluacion(xInicial) - xInicial)/ this.getEvaluacion(xInicial));
    }
    /**
     * @return lista de soluciones
     */
   public ArrayList<filaNewton> newton(){
   int i = 1;
   double errorCalculado = 1;
 
    ArrayList<filaNewton> listaSoluciones = new ArrayList<>();
      while(errorCalculado > this.error){
       
       filaNewton fila = new filaNewton();
   
       fila.setI(i);
       fila.setXi(this.valorInicial);
       fila.setFx(this.getFunOriginal(this.valorInicial)); //f(x)
       fila.setFdx(this.getFunDerivada(this.valorInicial)); //f'(xi)
       fila.setxEvalucion(this.getEvaluacion(this.valorInicial)); //x1+ 1
       fila.setxError(this.getError(this.valorInicial));
       
       listaSoluciones.add(fila);
       
       this.valorInicial = fila.getxEvalucion();
       errorCalculado = fila.getxError();
       i++;
      }
      return listaSoluciones; 
   }
   
   public tablaNewton getTablaNewt(){
    tablaNewton modelo = null;
    ArrayList<filaNewton> lista = this.newton();
    
    if(lista != null)
        modelo = new tablaNewton(lista);
    return modelo;
   }
}
