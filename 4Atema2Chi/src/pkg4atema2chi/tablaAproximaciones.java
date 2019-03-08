
package pkg4atema2chi;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class tablaAproximaciones extends AbstractTableModel{
     public String[] columnas={
        "i", "Xi", "G(xi)", "Error"
    };
    
    public Class [] tipos ={
        Integer.class, Double.class, Double.class, Double.class
    };
    
    private ArrayList<filaAproximaciones> filas;
    
    public tablaAproximaciones(ArrayList<filaAproximaciones> filas){
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
        filaAproximaciones fila = this.filas.get(i);
        switch(i1){
            case 0: return fila.getI();
            case 1: return fila.getXi();
            case 2: return fila.getGxi();
            case 3: return fila.getError();
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
