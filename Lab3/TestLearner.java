package Lab3;

public class TestLearner {
    public static void main(String[] args) {
        System.out.println("--- INICIO DEL TEST ---");

        Vector real = new Vector(new double[]{2.0, 3.0, 4.0});
        
        System.out.println("Fórmula real (pesos ocultos): " + real.toString());

        Dataset ds = new Dataset(2); 

        Vector v1 = new Vector(new double[]{1.0, 1.0});
        Vector v2 = new Vector(new double[]{2.0, 1.0});
        Vector v3 = new Vector(new double[]{1.0, 0.0});
        Vector v4 = new Vector(new double[]{0.0, 2.0});

        ds.addRecord(new Record(v1, real.dotProduct(v1.augment())));
        ds.addRecord(new Record(v2, real.dotProduct(v2.augment())));
        ds.addRecord(new Record(v3, real.dotProduct(v3.augment())));
        ds.addRecord(new Record(v4, real.dotProduct(v4.augment())));

        System.out.println("Dataset generado con " + ds.getData().size() + " registros.");

        System.out.println("\n--- Verificación de Descenso del Gradiente ---");
        Model modelTest = new Model(2);
        Algorithm algoTest = new Algorithm(0.05, 0.0001);
        
        double lastNorm = Double.MAX_VALUE;

        for (int i = 1; i <= 5; i++) {
            Vector g = algoTest.gradient(ds, modelTest);
            double currentNorm = g.norm();
            
            System.out.println("Iteración " + i + " - Norma del gradiente: " + String.format("%.4f", currentNorm));
            
            if (currentNorm > lastNorm) {
                System.out.println("La norma está subiendo. Revisa el learning rate.");
            }
            lastNorm = currentNorm;
            modelTest.update(g, 0.05);
        }

        System.out.println("\n--- Entrenamiento Completo ---");
        Algorithm algo = new Algorithm(0.05, 0.00001);
        SupervisedLearner learner = new SupervisedLearner(algo, ds);
        
        learner.solve();
        
        System.out.println("Pesos aprendidos: " + learner.toString());

        System.out.println("\n--- Predicción Final ---");
        
        Vector input = new Vector(new double[]{2.0, 2.0}); 

        double obtained = learner.predict(input);

        double expected = real.dotProduct(input.augment());

        System.out.println("Entrada:  " + input.toString());
        System.out.println("Esperado: " + String.format("%.4f", expected));
        System.out.println("Obtenido: " + String.format("%.4f", obtained));
        
        double error = obtained - expected;
        if (error < 0){
            error = -error; 
        }
        System.out.println("Error absoluto: " + String.format("%.4f", error));

        if (error < 0.1) {
            System.out.println("TEST SUPERADO: El modelo ha aprendido la fórmula real.");
        } else {
            System.out.println("TEST FALLIDO: El error es demasiado grande.");
        }
    }
}