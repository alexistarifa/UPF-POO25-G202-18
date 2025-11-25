package Lab4;

import java.util.List;

public class GradientDescent extends Algorithm {
    private double stoppingCriteria;
    public GradientDescent(double lr,double sc){
        super(lr);
        this.stoppingCriteria = sc;
    }
    public Vector gradient(Dataset ds,Model m){
        int tamaño = m.getParams().getDim();
        Vector suma = new Vector(tamaño,0.0);
        List<Record> data = ds.getData();
        int n = data.size();
        if(n == 0){
            System.out.println("Error Crítico: El dataset está vacío. No se puede calcular el gradiente.");
            System.exit(0);
        }
        for(int i = 0;i<n;i++){
            Record r = data.get(i);
            double prediccion = m.predict(r.getInput().augment());
            double real = r.getOutput();
            double resta = prediccion-real;
            Vector input_augmented = r.getInput().augment();
            suma = suma.add(input_augmented.multiply_scalar(resta));
        }
        return suma.divide_scalar(n);
    }
    @Override
    public Model solve(Dataset ds){
        Model modelo = new Model(ds.getDim());
        int maxIterations = 10000;
        int i = 0;
        while(true){
            Vector g = this.gradient(ds, modelo);
            if(g.norm() < this.stoppingCriteria){
                break;
            }
            i++;
            modelo.update(g, this.learningRate);
            if (i >= maxIterations) {
                System.out.println("Error: El algoritmo alcanzó el máximo de iteraciones (" + maxIterations + ") sin converger.");
                System.out.println("Prueba a aumentar el learning rate o revisar tus datos.");
                System.exit(0);
            }
        }
        return modelo;
    }

}
