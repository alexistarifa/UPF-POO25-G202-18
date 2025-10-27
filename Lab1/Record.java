package Lab1;
public class Record {
    private Vector input;
    private double output;
    public Record(Vector i,double o){
        this.output = o;
        this.input = i;
    }
    public Vector getInput(){
        return this.input;
    }
    public double getOutput(){
        return this.output;
    }
    public String toString(){
        return "Record [input = " + input.toString() +", output = "+output+"]";
    }
}

