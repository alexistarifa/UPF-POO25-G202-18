package Lab3;

public class StandardizedDataset extends Dataset{
    private Vector mi;
    private Vector si;
    private double mo;
    private double so;
    public StandardizedDataset(Dataset d,Vector mi,Vector si,double mo,double so){
        super(d.dim);
        this.si = si;
        this.mi = mi;
        this.mo = mo;
        this.so = so;
    }
    public Record transform(Record r){
        Vector vectorx = r.getInput();
        Vector restax = vectorx.subtract(this.mi);
        Vector xi = restax.divide(this.si);
        double vary = r.getOutput();
        double restay = vary - mo;
        if(this.so == 0){
            System.out.println("so no puede ser 0");
            System.exit(0);
        }
        double yi = restay / so;
        Record record_standardized = new Record(xi,yi);
        return record_standardized;
    }
}
