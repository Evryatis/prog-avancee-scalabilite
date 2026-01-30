package EstimationPi;

public class PerformanceTest_Pi {

    public static void main(String[] args) throws Exception {
        // Nombre de répétitions pour chaque test
        int repetitions = 10;

        // Test 1 : 10 itérations, 1 worker (exécution avec très peu d'itérations)
        System.out.println("Performance Test 1: 10 itérations, 1 worker");
        runPerformanceTest(10, 1, repetitions);

        // Test 2 : 10000 itérations, 5 workers (exécution avec plus d'itérations)
        System.out.println("\nPerformance Test 2: 10000 itérations, 5 workers");
        runPerformanceTest(10000, 5, repetitions);

        // Test 3 : 100000 itérations, 10 workers (exécution avec encore plus d'itérations et de workers)
        System.out.println("\nPerformance Test 3: 100000 itérations, 10 workers");
        runPerformanceTest(100000, 10, repetitions);
    }

    /**
     * Méthode pour exécuter un test de performance sous plusieurs répétitions
     * @param totalCount Nombre total d'itérations par worker
     * @param numWorkers Nombre de workers à utiliser
     * @param repetitions Nombre de répétitions pour mesurer le temps
     */
    private static void runPerformanceTest(int totalCount, int numWorkers, int repetitions) throws Exception {
        long totalDuration = 0;

        // Effectuer plusieurs répétitions du même test
        for (int i = 0; i < repetitions; i++) {
            long startTime = System.nanoTime(); // Démarre le chronomètre
            long total = new Master().doRun(totalCount, numWorkers);
            long stopTime = System.nanoTime(); // Arrête le chronomètre

            long duration = stopTime - startTime;
            totalDuration += duration;

            System.out.println("Exécution " + (i + 1) + ": Time Duration (ms): " + duration / 1000000.0);
            System.out.println("Total from Master = " + total);
        }

        // Calculer la durée moyenne
        double avgDuration = totalDuration / (double) repetitions;
        System.out.println("\nDurée moyenne des " + repetitions + " répétitions : " + avgDuration / 1000000.0 + " ms");
    }
}
