package Lab3;
public class Model {
    private Vector params;
    public Model(int dim){
        double[] elementos = new double[dim+1];
        for(int i = 0;i<dim+1;i++){
            elementos[i] =  0;
        }
        params = new Vector(elementos);
    }
    public Vector getParams(){
        return this.params; 
    }
    public double predict(Vector v){
        return this.params.dotProduct(v);
    }
    public void update(Vector v,double rate){
        Vector updated = new Vector(v.getDim(),0.0);
        updated = this.params.subtract(v.multiply_scalar(rate));
        this.params = updated;
    }

}
