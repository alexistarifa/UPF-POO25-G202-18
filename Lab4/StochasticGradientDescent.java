package Lab4;
import java.util.Random;

public class StochasticGradientDescent extends Algorithm {
    private int batchSize;
    private int iterations;
    private Random random;
    public StochasticGradientDescent(double lr, int bs,int it){
        super(lr);
        this.batchSize = bs;
        this.iterations = it;
        this.random = new Random();
    }
    public Vector stochasticGradient(Dataset ds,Model m){
        int n = ds.getData().size();
        if(n == 0){
        System.out.println("Error: Dataset vacío.");
        System.exit(0);
        }
        int k = this.batchSize;
        if (k > n) {
        k = n; 
        }
        int[] r = random.ints(0,n).distinct().limit(k).toArray();
        if(n == 0){
            System.out.println("Error Crítico: El dataset está vacío. No se puede calcular el gradiente.");
            System.exit(0);
        }
        Vector suma = new Vector(m.getParams().getDim(),0.0);
        for(int i = 0;i<k;i++){
            int idx = r[i];
            Record rec = ds.getData().get(idx);
            double predict = m.predict(rec.getInput().augment());
            double real = rec.getOutput();
            double resta = predict-real;
            Vector inputaugmented = rec.getInput().augment();
            suma = suma.add(inputaugmented.multiply_scalar(resta));

        }
        return suma.divide_scalar(k);
    }
    public Model solve(Dataset ds){
        Model modelo = new Model(ds.getDim());
        int i = 0;
        while(true){
            Vector g = this.stochasticGradient(ds, modelo);
            modelo.update(g, this.learningRate);
            if (i >= iterations) {
                break;
            }
            i++;
        }
        return modelo;
    }


}

