
package pkg4atema2chi;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class tablaSecante extends AbstractTableModel{
    ublic String[] columnas={
        "i", "Xi-1", "Xi", "F(Xi-1)", "F(xi)" , "F(xi)(xi-1-xi)/F(xi-1)-F(xi)", "xi+1=xi-0", "Error"
    };
    public Class [] tipos ={
        Integer.class, Double.class, Double.class, Double.class,Double.class, Double.class, Double.class 
    };
     
     private ArrayList<filaSecante> filas;
    
    public tablaSecante(ArrayList<filaSecante> filas){
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
        filasecante fila = this.filas.get(i);
        switch(i1){
            case 0: return fila.getI();
            case 1: return fila.getXi1();
            case 2: return fila.getFXi1();
            case 3: return fila.getFxi();
            case 4: return fila.getFxi();
            case 5: return fila.getFxi2();
            case 6: return fila.getxi2();
            case 7: return fila.getError();
            
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
