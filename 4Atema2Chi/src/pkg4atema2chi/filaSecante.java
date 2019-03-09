/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4atema2chi;

/**
 *
 * @author dell
 */
public class filaSecante {
    private int i;
    private double xi1,xi,fxi1,fxi,formula1,formula2,error;

    
    public void setI(int i) {
        this.i = i;
    }

    public void setXi1(double xi1) {
        this.xi1 = xi1;
    }

    public void setXi(double xi) {
        this.xi = xi;
    }

    public void setFxi1(double fxi1) {
        this.fxi1 = fxi1;
    }

    public void setFxi(double fxi) {
        this.fxi = fxi;
    }

    public void setFormula1(double formula1) {
        this.formula1 = formula1;
    }

    public void setFormula2(double formula2) {
        this.formula2 = formula2;
    }

    public void setError(double error) {
        this.error = error;
    }
    
    public int getI() {
        return i;
    }

    public double getXi1() {
        return xi1;
    }

    public double getXi() {
        return xi;
    }

    public double getFxi1() {
        return fxi1;
    }

    public double getFxi() {
        return fxi;
    }

    public double getFormula1() {
        return formula1;
    }

    public double getFormula2() {
        return formula2;
    }

    public double getError() {
        return error;
    }
}
