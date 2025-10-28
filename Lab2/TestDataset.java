package Lab2;

public class TestDataset {
    public static void main(String[] args){
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
        System.out.println("\nPrueba de los métodos de Estadística (Dataset)\n");
        Vector mi = dataset.meanInput();
        double mo = dataset.meanOutput();
        System.out.println("Mean Input (mi): " + mi);
        System.out.println("\nMean Output (mo): " + mo);
        Vector si = dataset.stdInput();
        double so = dataset.stdOutput();
        System.out.println("\nStd Input (si):  " + si);
        System.out.println("\nStd output (so):  " + so);

        System.out.println("\nPrueba de la clase StandardizedDataset: \n");
        StandardizedDataset standardizeddataset = dataset.standardize();
        System.out.println(standardizeddataset.toString());
        System.out.println("\nMean Input del Standardized (mi): "+ standardizeddataset.meanInput());
        System.out.println("\nMean Output del Standardized (mo): "+ standardizeddataset.meanOutput());
        System.out.println("\nStd Input del Standardized (si) : "+ standardizeddataset.stdInput());
        System.out.println("\nStd Output del Standardized (si) : "+ standardizeddataset.stdOutput());
        
        
        System.out.println("\nPrueba del método transform() por separado:");
        Vector vNuevo = new Vector(new double[]{1.0, 1.0, 1.0});
        Record rNuevo = new Record(vNuevo, 4.0); // Con output 4
        Record rNuevoTransformado = standardizeddataset.transform(rNuevo);
        System.out.println("\nRecord original: " + rNuevo.toString());
        System.out.println("\nRecord transformado: " + rNuevoTransformado.toString());

        System.out.println("\nPrueba dataset vacío :");
        Dataset dsVacio = new Dataset(5); 
        System.out.println("\nMean Input (vacío): " + dsVacio.meanInput());
        System.out.println("\nStd Input (vacío): " + dsVacio.stdInput());
        System.out.println("\nMean Output (vacío): " + dsVacio.meanOutput());
        StandardizedDataset sdsVacio = dsVacio.standardize();
        System.out.println("\nStandardized (vacío) : " + sdsVacio.toString());
        System.out.println("\nMean Input (vacío, std): " + sdsVacio.meanInput());

    }
}
