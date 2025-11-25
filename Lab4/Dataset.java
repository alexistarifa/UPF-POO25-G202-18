package Lab4;

import java.util.ArrayList;
import java.util.List;

public abstract class Dataset {
    protected int dim;
    protected List<Record> data;
    public Dataset(int d){
        this.dim = d;
        this.data = new ArrayList<>();
    }
    public int getDim(){
        return this.dim;
    }
    public List<Record> getData(){
        return this.data;
    }
    public void addRecord(Record r){
        if(this.dim == 0){
            this.dim = r.getInput().getDim();
        }
        if(r.getInput().getDim() != this.dim){
            System.out.println("Las dimensiones del vector en cuestión no son correctas, tienen que ser igual a la del resto de vectores, es decir: "+ this.dim);
            System.exit(0);
        }
        this.data.add(r);
    }
    public abstract Record transform(Record r);
    public abstract double output(double d);
    public String toString(){
        return data.toString();
    }
    
}
