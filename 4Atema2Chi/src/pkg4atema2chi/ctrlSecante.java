package pkg4atema2chi;

import java.util.ArrayList;

public class ctrlSecante {
    private int interaciones;
    private double xi,xi1,fxi,fxi1,error,formula1;
    
    public ctrlSecante(int i,double Xi,double Xi1,double error,double Fxi1,double Fxi,double formula){
        this.interaciones = i;
        this.xi=Xi;
        this.xi1=Xi1;
        this.error=error;
        this.fxi1=Fxi1;
        this.fxi=Fxi;
        this.formula1 = formula;
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
        double error; 
        double f1,f2;
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
         
         this.xi1 = fila.getXi();
         this.xi = fila.getFormula2();
        }
        
      return listaSoluciones;  
    }
    
}
