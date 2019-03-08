
package pkg4atema2chi;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ctrlNewton {
    ////SE hizo un comentario con modificacion 
    private int iteraciones;
    double FunOriginal, FunDerivada,valorInicial, error;
    
    
    public ctrlNewton(double valorInicial, double error ){
this.valorInicial = valorInicial;
this.error = error;

}
    public double getFunOriginal(double x){

    return Math.pow(Math.E, -(x) )- x;
}


public double getFunDerivada(double x){

return Math.pow(-Math.E, -(x) ) -1;
    
}
 
public double getEvaluacion(double xi){

return Math.abs(xi - this.getFunOriginal(xi)/ this.getFunDerivada(xi))   ;

}
    
   public double getError(double error){
   
   return Math.abs(this.getEvaluacion(error) - error/ this.getEvaluacion(error));
   } 
    
   public ArrayList<filaNewton> newton(){
   int i = 1;
   double errorCalculado = 1;
   double fx;
   double dfx;
   double fxi;
   double error;
   /*double xOriginal;
   double xDerivada;
   double error;
*/
ArrayList<filaNewton> listaSoluciones = new ArrayList<>();
   while(i <= this.iteraciones  && errorCalculado < this.error){
       
       //Obtenemos los valores de las funciones
       
       
       
       fx = this.getFunOriginal(this.valorInicial);
       //dfx = this.getFunDerivada(this.valorInicial);
       fxi = this.getEvaluacion(this.valorInicial);
       error = this.getError(this.valorInicial);
       
    
       
       
       //Llamar a las funciones para la tabla
       filaNewton fila = new filaNewton();
       
       fila.setI(i);
       
       fila.setI(i);
       fila.setXi(this.valorInicial);
       fila.setFx(fx);
       fila.setFdx(this.getEvaluacion(this.valorInicial));
       fila.setxEvalucion(this.getEvaluacion(this.valorInicial));
       fila.setxError(error);
       
       listaSoluciones.add(fila);
       
       
       this.valorInicial = fila.getXi();
       
       errorCalculado = fila.getxError();
       i++;
       
       //this.valorInicial = 
   }return listaSoluciones; 
   }
   public tablaNewton getTablaNewt(){
   tablaNewton modelo = null;
    ArrayList<filaNewton> lista = this.newton();
    
    if(lista != null)
   modelo = new tablaNewton(lista);
    return modelo;
   }
}
