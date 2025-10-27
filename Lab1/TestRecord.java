package Lab1;
public class TestRecord {
    public static void main(String[] args){
        double[] double_v1 = {1.0,2.0,3.0};
        double[] double_v2 = {4.0,5.0,6.0};
        double[] double_v3 = {9.0,10.0,11.0};
        Vector v1 = new Vector (double_v1);
        Vector v2 = new Vector(double_v2);
        Vector v3 = new Vector(double_v3);
        System.out.println("v1 = " + v1);
        System.out.println("v2 = " + v2);
        System.out.println("v3 = " + v3 + "\n");
        
        
        System.out.println(" MÉTODES DE LA CLASSE VECTOR \n");
        System.out.println("Dimensión de v1: " + v1.getDim() + "\n");
        System.out.println("Suma (v1 + v2): " + v1.add(v2) + "\n");
        System.out.println("Resta (v1 - v2): " + v1.subtract(v2) + "\n");
        System.out.println("Multiplicación elemento a elemento (v1 * v2): " + v1.multiply(v2) + "\n");
        System.out.println("División elemento a elemento (v2 / v1): " + v2.divide(v1) + "\n");
        System.out.println("Multiplicación por escalar (v1 * 2): " + v1.multiply_scalar(2) + "\n");
        System.out.println("División por escalar (v2 / 2): " + v2.divide_scalar(2) + "\n");
        System.out.println("Raíz cuadrada de v3: " + v3.sqrt() + "\n");
        System.out.println("Producto punto (v1 · v2): " + v1.dotProduct(v2) + "\n");
        System.out.println("Norma de v1: " + v1.norm() + "\n");
        Vector v4 = new Vector(4, 7.5);
        System.out.println("Vector creado con (dim=4, val=7.5): " + v4 + "\n" + "\n" );
        
        System.out.println(" MÉTODES DE LA CLASSE RECORD  \n");
        Record r1 = new Record(v1, 10.5);
        Record r2 = new Record(v2, 25.0);

        System.out.println("Record 1: " + r1 + "\n");
        System.out.println("Record 2: " + r2 + "\n");

        System.out.println("Input de r1: " + r1.getInput() + "\n");
        System.out.println("Output de r1: " + r1.getOutput() + "\n");
        System.out.println("Input de r2: " + r2.getInput() + "\n");
        System.out.println("Output de r2: " + r2.getOutput() + "\n");
    }
}

