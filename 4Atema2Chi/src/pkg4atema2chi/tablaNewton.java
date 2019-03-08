
package pkg4atema2chi;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class tablaNewton extends AbstractTableModel {
     public String[] columnas={
        "i", "Xi", "F(xi)","F´(xi)","xi + 1" ,"Error"
    };
    
     
    public Class [] tipos ={
        Integer.class, Double.class, Double.class, Double.class
                       ,Double.class, Double.class
    };
    
    private ArrayList<filaNewton> filas;
    
    public tablaNewton(ArrayList<filaNewton> filas){
        this.filas = filas;
    }
    
    
     @Override
    public int getRowCount() {
        return this.filas.size();
    }

     @Override
    public int getColumnCount() {
        return this.columnas.length;
    }

     @Override
    public Object getValueAt(int i, int i1) {
        filaNewton fila = this.filas.get(i);
        switch(i1){
            case 0: return fila.getI();
            case 1: return fila.getXi();
            case 2: return fila.getFx();
            case 3: return fila.getFdx();
            case 4: return fila.getxEvalucion();
            case 5: return fila.getxError();
           
            
        }
        return null;
    }

    
     @Override
     public boolean isCellEditable(int i, int i1) {   
         return false;
    }

     @Override
    public Class<?> getColumnClass(int i) {
        return this.tipos[i];
    }

     @Override
    public String getColumnName(int i) {
       return this.columnas[i];
    }
    
}
