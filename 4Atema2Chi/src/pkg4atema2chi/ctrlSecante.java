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

    public double getEvaluar(double x){
        //return Math.pow(Math.E, -(x));
        return Math.pow(Math.E,Math.pow(-x,2) )-x;
    }
    
    public double getformula1(double x){
        
        return (fxi*(xi1-xi))/(fxi1-fxi);
    }

    public double getError(double xi1, double xi){
        return Math.abs((xi1-xi))/xi1;
        
    }
    
    public double getformula2(){
        return xi-formula1;
        
    }
    
    public ArrayList<filaSecante> Secante(){
        int i=1;
        double errorcalculado=1;
        double error; 
        double f1,f2;
        ArrayList<filaSecante> listaSoluciones = new ArrayList<>();
        
        while(errorcalculado>this.error){
            
            error = this.getError(this.xi1, this.xi);
            
         filaSecante fila = new filaSecante();  
         
         fila.setI(i);
         fila.setXi1(this.xi1);
         fila.setXi(this.xi);
         fila.setFxi1(this.getEvaluar(fila.getFxi1()));
         fila.setFxi(this.getEvaluar(fila.getFxi()));;
         fila.setFormula1(formula1);
         fila.setFormula2(formula1);
         
         
            
            
        }
        
      return listaSoluciones;  
    }
    
}
