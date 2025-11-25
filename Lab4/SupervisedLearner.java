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
        Record record_temp = new Record(v,0.0);
        Record record_trans = this.dataset.transform(record_temp);
        Vector vector_transf = record_trans.getInput();
        Vector vector_trans_aug = vector_transf.augment();
        double prediccion = this.model.predict(vector_trans_aug);
        double prediccion_real = this.dataset.output(prediccion);
        return prediccion_real;

    }
    public String toString(){
        if (this.model == null) {
            return "Modelo no entrenado aún.";
        }
        return this.model.getParams().toString();
    }
}
