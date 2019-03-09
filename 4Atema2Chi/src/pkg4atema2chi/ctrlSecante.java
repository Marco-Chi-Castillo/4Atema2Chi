package pkg4atema2chi;

import java.util.ArrayList;

public class ctrlSecante {
    private double xi,xi1,error;
    
    public ctrlSecante(double Xi,double Xi1,double error){
        this.xi=Xi;
        this.xi1=Xi1;
        this.error=error;
    }
    
    /**
     * @param x 
     * @return 
     */
    public double getEvaluar(double x){
        //return Math.pow(Math.E, -(x));
        return Math.pow(Math.E,Math.pow(-(x),2)) - x;
    }
    /**
     * @param xi valor inicial
     * @param xi1 valor inicial menos 1 xi -1 
     * @return formula
     */
    public double getformula1(double xi, double xi1){
        return (this.getEvaluar(xi)*(xi1 - xi)) / (this.getEvaluar(xi1)-this.getEvaluar(xi));
    }
    
    public double getError(double xi, double xi1){
        return Math.abs(this.getformula2(xi, xi1)/this.getformula1(xi, xi1));
    }
    
    public double getformula2(double xi, double xi1){
        return this.getformula1(xi, xi1) - xi;
    }
    
    public double getFormulaXi1(double xi, double xi1){
        return xi - this.getformula1(xi, xi1);
    }
    
    public ArrayList<filaSecante> Secante(){
        int i=1;
        double errorcalculado=1;
        ArrayList<filaSecante> listaSoluciones = new ArrayList<>();
        
        while(errorcalculado>this.error){
           
         filaSecante fila = new filaSecante();  
         
         fila.setI(i);
         fila.setXi1(this.xi1);
         fila.setXi(this.xi);
         fila.setFxi1(this.getEvaluar(this.xi1));
         fila.setFxi(this.getEvaluar(this.xi));
         fila.setFormula1(this.getformula1(this.xi, this.xi1));
         fila.setFormula2(this.getFormulaXi1(this.xi, this.xi1));
         fila.setErro(this.getError(this.xi, this.xi1));
         
         listaSoluciones.add(fila);
         
         this.xi1 = fila.getXi();
         this.xi = fila.getFormula2();
         
         errorcalculado = fila.getErro();
        }
        
      return listaSoluciones;  
    }
    
    public tablaSecante getTablaSecante(){
    tablaSecante modelo = null;
    ArrayList<filaSecante> lista = this.Secante();
    
    if(lista != null)
        modelo = new tablaSecante(lista);
    return modelo;
   }
    
}
