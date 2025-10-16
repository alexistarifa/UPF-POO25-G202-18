public class Vector {
    private double[] elems;
    public Vector(double[] e){
       this.elems=e;
    }
    public int getDim(){
        return elems.length;
    }
    public Vector(int dim,double val){
        this.elems = new double[dim];
    for (int i = 0; i < dim; i++) {
        this.elems[i] = val;
    }
    }
    public Vector add(Vector v){
        if(this.getDim() != v.getDim()){
            System.out.println("Los vectores son de diferentes dimensiones");
            System.exit(0);
        }
        double[] result = new double[elems.length];
        for(int i = 0;i<elems.length;i++){
            result[i] = this.elems[i]+v.elems[i];
        }
        return new Vector(result);
    }
    public Vector subtract(Vector v){
        if(this.getDim() != v.getDim()){
            System.out.println("Los vectores son de diferentes dimensiones");
            System.exit(0);
        }
        double[] result = new double[elems.length];
        for(int i = 0;i<elems.length;i++){
            result[i] = this.elems[i]-v.elems[i];
        }
        return new Vector(result);
    }
    public Vector multiply(Vector v){
        if(this.getDim() != v.getDim()){
            System.out.println("Los vectores son de diferentes dimensiones");
            System.exit(0);
        }
        double[] result = new double[elems.length];
        for(int i = 0;i<elems.length;i++){
            result[i] = this.elems[i]*v.elems[i];
        }
        return new Vector(result);
    }
    public Vector divide(Vector v){
        if(this.getDim() != v.getDim()){
            System.out.println("Los vectores son de diferentes dimensiones");
            System.exit(0);
        }
        double[] result = new double[elems.length];
        for(int i = 0;i<elems.length;i++){
            if(v.elems[i] == 0){
                result[i] = 0;
            }
            else{
                result[i] = this.elems[i] / v.elems[i];
            }
        }
        return new Vector(result);
    }
    public Vector multiply_scalar(double scalar){
        double[] result = new double[elems.length];
        for(int i = 0;i<elems.length;i++){
            result[i] = elems[i]*scalar;
        }
        return new Vector(result);
    }
    public Vector divide_scalar(double scalar){
        double[] result = new double[elems.length];
        for(int i = 0;i<elems.length;i++){
            if(scalar == 0){
                result[i] = 0;
            }
            else{
                result[i] = elems[i]/scalar;
            }
        }
        return new Vector(result);
    }
    public Vector sqrt(){
        double[] result = new double[elems.length];
        for(int i = 0;i<elems.length;i++){
            if(elems[i] < 0){
                System.out.println("No es pot fer l'arrel quadrada d'un número negatiu");
                System.exit(0);
            }
            else{
                result[i] = Math.sqrt(this.elems[i]);
            }
        }
        return new Vector(result);
    }
    public double dotProduct(Vector v){
        double result = 0.0;
        if(this.getDim() != v.getDim()){
            System.out.println("Los vectores son de diferentes dimensiones");
            System.exit(0);
        }
        for(int i = 0;i<elems.length;i++){
            result += this.elems[i]*v.elems[i];
        }
        return result;
    }
    public double norm(){
        return Math.sqrt(this.dotProduct(this));
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < elems.length; i++) {
            sb.append(elems[i]);
            if (i < elems.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }  

}
