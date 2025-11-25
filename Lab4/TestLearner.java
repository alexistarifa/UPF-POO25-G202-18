package Lab4;

public class TestLearner {
    public static void main(String[] args) {
        System.out.println("INICIO DEL TEST DE APRENDIZAJE Y ABSTRACCIÓN \n");
        
        RawDataset dataset = new RawDataset(2);
        //Queremos entrenar a nuestro modelo para que sume los componentes del vector, y que ese sea el Record del Vector en cuestión
        dataset.addRecord(new Record(new Vector(new double[]{1, 1}), 2));   
        dataset.addRecord(new Record(new Vector(new double[]{2, 3}), 5));  
        dataset.addRecord(new Record(new Vector(new double[]{4, 1}), 5));   
        dataset.addRecord(new Record(new Vector(new double[]{0, 0}), 0));   
        dataset.addRecord(new Record(new Vector(new double[]{-1, 1}), 0));  
        dataset.addRecord(new Record(new Vector(new double[]{10, 5}), 15)); 

        System.out.println("Datos cargados: " + dataset.getData().size() + " registros.");

        System.out.println("\n Estadísticas del RawDataset ");
        System.out.println("Media Input: " + dataset.meanInput());
        System.out.println("Media Output: " + dataset.meanOutput());

        StandardizedDataset standardizedDataset = dataset.standardize();

        System.out.println("Dataset estandarizado creado correctamente.");

        System.out.println("\n\n PRUEBA 1: Abstracción con Gradient Descent ");
        
        Algorithm algoritmo1 = new GradientDescent(0.01, 0.001);
        
        System.out.println("Variable 'algoritmo1' declarada como tipo: Algorithm");
        
        SupervisedLearner learnerGD = new SupervisedLearner(algoritmo1, standardizedDataset);
        
        learnerGD.solve();
        System.out.println("Modelo entrenado (Pesos): " + learnerGD.toString());

        Vector vector_predict = new Vector(new double[]{10, 10});
        double prediccionGD = learnerGD.predict(vector_predict);
        
        System.out.println("Pregunta: 10 + 10");
        System.out.println("Predicción GD: " + prediccionGD);
        System.out.println("Error: " + Math.abs(20 - prediccionGD));

        System.out.println("\n\n PRUEBA 2: Abstracción con Stochastic Gradient Descent ");

        Algorithm algoritmo2 = new StochasticGradientDescent(0.01, 2, 1000);
        
        System.out.println("Variable 'algoritmo2' declarada como tipo: Algorithm");

        SupervisedLearner learnerSGD = new SupervisedLearner(algoritmo2, standardizedDataset);
        
        learnerSGD.solve();
        System.out.println("Modelo SGD entrenado (Pesos): " + learnerSGD.toString());

        // PREDICCIÓN
        double prediccionSGD = learnerSGD.predict(vector_predict);
        
        System.out.println("Pregunta: 10 + 10");
        System.out.println("Predicción SGD: " + prediccionSGD);
        System.out.println("Error: " + Math.abs(20 - prediccionSGD));

        System.out.println("\n=== FIN DEL TEST ===");
    } 
    
}

