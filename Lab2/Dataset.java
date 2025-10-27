package Lab2;
import java.util.List;
import java.util.ArrayList;
public class Dataset {
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
    public Vector meanInput(){
        if(data.isEmpty()){
            return new Vector(this.dim,0.0);
        }
        Vector sum = new Vector(dim,0.0);
        double numRecords = data.size();
        for(int i = 0;i<numRecords;i++){
            Record r = data.get(i);
            sum = sum.add(r.getInput());
        }
        return sum.divide_scalar(numRecords);
    }
    public double meanOutput(){
        double sum = 0;
        double numRecords = data.size();
        if(numRecords == 0.0){
            return sum;
        }
        for(int i = 0;i<numRecords;i++){
            Record r = data.get(i);
            sum += r.getOutput();
        }
        return sum/numRecords;
    }
}
