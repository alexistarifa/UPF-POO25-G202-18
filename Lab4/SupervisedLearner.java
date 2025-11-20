package Lab4;

public class SupervisedLearner {
    private Algorithm algorithm;
    private Dataset dataset;
    private Model model;
    public SupervisedLearner(Algorithm a,Dataset ds){
        this.dataset = ds;
        this.algorithm = a;
        this.model = null;
    }
    public void solve(){
        this.model = this.algorithm.solve(this.dataset);
    }
    public double predict(Vector v){
        if (this.model == null) {
            System.out.println("Error: No puedes hacer predicciones sin entrenar el modelo primero.");
            System.exit(0);
        }
        Vector augmented = v.augment();
        return this.model.predict(augmented);
    }
    public String toString(){
        if (this.model == null) {
            return "Modelo no entrenado aún.";
        }
        return this.model.getParams().toString();
    }
}
