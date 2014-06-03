package metodopassovariavel;

import com.panayotis.gnuplot.dataset.DataSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Alessandro Campello Silva,<p>
 * Carlos Filipe M. Teixeira Jr.,<p>
 * Thadeu José Caldas Neves,<p>
 * Tomas M.G. de Siqueira.
 */
public class ResultSet implements DataSet{

    private List<Ponto> list = new LinkedList<>();

    public ResultSet(List<Ponto> l) {
        this.list = l;
    }
    
    @Override
    public int size() {
        return list.size();
    }

    @Override
    public int getDimensions() {
        return 2;
    }

    @Override
    public String getPointValue(int point, int dimension) {
        Ponto p = list.get(point);
        switch(dimension){
            case 0: return p.getT().toString();
            case 1: return p.getW().toString();
            default: return "";
        }  
    }
    
}
