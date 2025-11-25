package Lab4;

public class RawDataset extends Dataset {
    public RawDataset(int d){
        super(d);
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
    public Vector stdInput(){
        if(data.isEmpty()){
            return new Vector(this.dim,0.0);
        }
        Vector result = new Vector(dim,0.0);
        double numRecords = data.size();
        Vector mean = meanInput();
        for(int i = 0;i<numRecords;i++){
            Record r = data.get(i);
            Vector sub = r.getInput().subtract(mean);
            Vector squared = sub.multiply(sub);
            result = result.add(squared);
        }
        Vector solution = result.divide_scalar(numRecords);
        return solution.sqrt();
    }
    public double meanOutput(){
        double sum = 0.0;
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
    public double stdOutput(){
        double result = 0.0;
        int numRecords = data.size();
        double mean = meanOutput();
        if(numRecords == 0){
            return result;
        }
        for(int i = 0;i<numRecords;i++){
            Record r = data.get(i);
            double sub = r.getOutput() - mean;
            result += sub * sub;
        }
    return Math.sqrt(result/numRecords);
    }
    public StandardizedDataset standardize(){
        Vector mi = meanInput();
        Vector si = stdInput();
        double mo = meanOutput();
        double so = stdOutput();
        Dataset dataset = this;
        StandardizedDataset sd = new StandardizedDataset(dataset, mi, si, mo, so);
        int numRecords = data.size();
        for(int i = 0;i<numRecords;i++){
            Record record = data.get(i);
            Record record_sd = sd.transform(record);
            sd.addRecord(record_sd);
        }
        return sd;
    }
    
    @Override
    public Record transform(Record r){
        return r;
    }
    @Override
    public double output(double d){
        return d;
    }

}
