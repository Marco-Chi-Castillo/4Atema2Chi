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
     * @param x valor inicial
     * @return evaluacion euler
     */
    public double getEvaluar(double x){
        double potencia = Math.pow(x,2);
        return Math.pow(Math.E, -potencia) - x;
    }
    
    /**
     * @param xi valor inicial
     * @param xi1 valor inicial  xi -1
     * @return formula
     */
    public double getFormula(double xi, double xi1){
        return (this.getEvaluar(xi)*(xi1 - xi)) / (this.getEvaluar(xi1)-this.getEvaluar(xi));
    }
    /**
     * @param xi valor inicial
     * @param xi1 valor inicial xi -1
     * @return Error
     */
    
    public double getError(double xi, double xi1){
        return Math.abs((this.getFormulaXi1(xi, xi1) - xi)/this.getFormulaXi1(xi, xi1));
    }
    
    /**
     * @param xi valor inicial 
     * @param xi1 valor inicial x1 - 1
     * @return formula xi - xi+1
     */
    public double getFormulaXi1(double xi, double xi1){
        return xi - this.getFormula(xi, xi1);
    }
    
    public ArrayList<filaSecante> Secante(){
        int i=1;
        double errorcalculado=1;
        
        ArrayList<filaSecante> listaSoluciones = new ArrayList<>();
        
        while(errorcalculado>this.error){
           
         filaSecante fila = new filaSecante();  
         fila.setI(i);
         fila.setXi(this.xi);
         fila.setXi1(this.xi1);
         fila.setFxi(this.getEvaluar(this.xi));
         fila.setFxi1(this.getEvaluar(this.xi1));
         fila.setFormula1(this.getFormula(this.xi, this.xi1));
         fila.setFormula2(this.getFormulaXi1(this.xi, this.xi1));
         fila.setError(this.getError(this.xi, this.xi1));
         
         listaSoluciones.add(fila);
         
         this.xi1 = fila.getXi();
         this.xi = fila.getFormula2();
         
         errorcalculado = fila.getError();
         i++;
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
