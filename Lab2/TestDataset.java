package Lab2;

public class TestDataset {
    public static void main(){
        Dataset dataset = new Dataset(3);
        double[] datav1 = {1.0,2.0,3.0};
        double[] datav2 = {3.0,6.0,9.0};
        double[] datav3 = {2.0,4.0,6.0};
        Vector v1 = new Vector(datav1);
        Vector v2 = new Vector(datav2);
        Vector v3 = new Vector(datav3);
        Record r1 = new Record(v1,1);
        Record r2 = new Record(v2,2);
        Record r3 = new Record(v3,3);
        dataset.addRecord(r1);
        dataset.addRecord(r2);
        dataset.addRecord(r3);
        System.out.println(dataset.toString());
    }
}
