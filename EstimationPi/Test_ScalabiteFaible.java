package EstimationPi;
import java.io.FileWriter;
import java.io.PrintWriter; 

public class Test_ScalabiteFaible {

    public static void main(String[] args) throws Exception {
        // Nombre de répétitions pour chaque test
        int repetitions = 1;

        PrintWriter resultatStat = new PrintWriter(new FileWriter("resultatScalabiliteFaible.txt", false));


        // Test 1 : 10 itérations, 1 worker (exécution avec très peu d'itérations)
        System.out.println("Performance Test 1: 100000 itérations, 1 worker");
        runPerformanceTest(1000000, 1, repetitions, resultatStat);

        // Test 2 : 10000 itérations, 5 workers (exécution avec plus d'itérations)
        System.out.println("\nPerformance Test 2: 100000 itérations, 5 workers");
        runPerformanceTest(5000000, 5, repetitions, resultatStat);

        // Test 3 : 100000 itérations, 10 workers (exécution avec encore plus d'itérations et de workers)
        System.out.println("\nPerformance Test 3: 100000 itérations, 10 workers");
        runPerformanceTest(10000000, 10, repetitions, resultatStat);

        // Test 3 : 100000 itérations, 20 workers (exécution avec encore plus d'itérations et de workers)
        System.out.println("\nPerformance Test 3: 100000 itérations, 10 workers");
        runPerformanceTest(20000000, 20, repetitions, resultatStat);

        resultatStat.close();
    }

    /**
     * Méthode pour exécuter un test de performance sous plusieurs répétitions
     * @param totalCount Nombre total d'itérations par worker
     * @param numWorkers Nombre de workers à utiliser
     * @param repetitions Nombre de répétitions pour mesurer le temps
     */
    private static void runPerformanceTest(int totalCount, int numWorkers, int repetitions, PrintWriter resultatStat) throws Exception {
        long totalDuration = 0;
    
        for (int i = 0; i < repetitions; i++) {
            long startTime = System.nanoTime();
            long total = new Master().doRun(totalCount, numWorkers);
            long stopTime = System.nanoTime();
    
            long duration = stopTime - startTime;
            double durationMs = duration / 1_000_000.0;
    
            totalDuration += duration;
    
            // Écriture propre : workers ; durée
            resultatStat.println(numWorkers + ";" + durationMs);
    
            System.out.println("Exécution " + (i + 1) + ": Time Duration (ms): " + durationMs);
            System.out.println("Total from Master = " + total);
        }
    
        double avgDuration = totalDuration / (double) repetitions;
        System.out.println("\nDurée moyenne : " + avgDuration / 1_000_000.0 + " ms");
    }
    

}

