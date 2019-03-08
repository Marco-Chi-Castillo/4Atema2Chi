
package pkg4atema2chi;
import javax.swing.*;

import java.util.ArrayList;

public class ctrlBiseccion {
   private double xi, xs, errorDeseado;
   private int iteraciones;

    public ctrlBiseccion(double xi, double xs, double errorDeseado, int iteraciones) {
        this.xi = xi;
        this.xs = xs;
        this.errorDeseado = errorDeseado;
        this.iteraciones = iteraciones;
    }
   
   /**
    * @return validacion si no es negativo.
    */
   public boolean esRangoValido(){
       boolean valido = false;
       if(this.getEvaluacion(this.xi)*this.getEvaluacion(this.xs) < 0)
           valido = true;
       return valido;
   }
   
   /**
    * 
    * @param x los intervalos
    * @return la evaluacion.
    */
   public double getEvaluacion(double x){
     // return Math.pow(x, 3) + 4 * Math.pow(x, 2) - 10;
     //return Math.tan(x) - x + 1; //Ejercicio 1
     // return Math.pow(x,2)-0.9*x-1.52; 
     // return Math.sin(x) - 0.3 * Math.pow(Math.E, x); //ejercicio 2
     // return Math.tan(x) - 3.5 ;
     // return Math.pow(x,2) - 0.9*x - 1.52;
      return x * Math.sin(x) - 0.1;
   }
   
   public double getRaiz(double xi, double xs){
       return (xi + xs) / 2;
   }
   
   private double getError(double xActual, double xAnterior){
       return Math.abs((xActual - xAnterior)/xActual);
   }
   
   public ArrayList<filaBiseccion> Biseccion(){
       int i =1;
       double errorCalculado = 1;
       ArrayList<filaBiseccion> listaSoluciones = new ArrayList<>();
       double xr;
       if(this.esRangoValido()){
           while(i<= this.iteraciones && errorCalculado > this.errorDeseado){
               
               xr = this.getRaiz(this.xi, this.xs);
               
               filaBiseccion fila = new filaBiseccion();
               
               fila.setI(i);
               fila.setXi(this.xi);
               fila.setXs(this.xs);
               fila.setXr(xr);
               fila.setFxi(this.getEvaluacion(fila.getXi()));
               fila.setFxr(this.getEvaluacion(fila.getXr()));
               fila.setFxs(this.getEvaluacion(fila.getXs()));
               
               if(i==1){
                   errorCalculado = 1;
               }else{
                   double xrAnterior = listaSoluciones.get(listaSoluciones.size()-1).getXr();
                   double xrActual = fila.getXr();
                   errorCalculado = this.getError(xrActual, xrAnterior);
               }
               fila.setError(errorCalculado);
               
               if(fila.getFxi() * fila.getFxr() < 0){
                   this.xs = fila.getXr();
               }else{
                   this.xi =  fila.getXr();
               }
               listaSoluciones.add(fila);
               i++;
           }
       }else{
           listaSoluciones = null;
           JOptionPane.showMessageDialog(null, "No hay Solución");
       }
    return listaSoluciones;
   }
   
   public tablaBiseccion getTablaBiseccion(){
       tablaBiseccion modelo = null;
       ArrayList<filaBiseccion> lista = this.Biseccion();
       
       if(lista != null)
            modelo = new tablaBiseccion(lista);
      
       return modelo;
   }
}
