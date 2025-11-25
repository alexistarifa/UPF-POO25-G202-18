package Lab4;

public abstract class Algorithm {
    protected double learningRate;
    public Algorithm(double lr){
        this.learningRate = lr;
        
    }
    public abstract Model solve(Dataset ds);

}
