package EstimationPi;
import java.io.FileWriter;
import java.io.PrintWriter; 

public class Test_ScalabiteForte {

    public static void main(String[] args) throws Exception {

        int repetitions = 1;
    
        PrintWriter resultatStat = new PrintWriter(
                new FileWriter("resultatScalabiliteForte.txt", false));
    
        // Différentes tailles de problème à tester
        int[] iterationsList = {1000000, 8000000, 14000000, 18000000};
    
        // Même workers que d’habitude
        int[] workersList = {1, 5, 10, 20};
    
        // Ne plus faire comme ça, charger les expériences dans une seule même boucle surcharge la JVM. Elle n'a pas le temps de finir le thread, qu'elle reçoit de nouveaux processus.
        // Il faut "réinitialiser" à chaque fois.
        for (int iterations : iterationsList) {
            System.out.println("\n===== TEST POUR " + iterations + " ITERATIONS =====\n");
    
            for (int workers : workersList) {
                System.out.println("Test : " + iterations + " itérations, " + workers + " workers");
                runPerformanceTest(iterations, workers, repetitions, resultatStat);
            }
        }
    
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
            resultatStat.println(numWorkers + ";" + totalCount + ";" + durationMs);
                
            System.out.println("Exécution " + (i + 1) + ": Time Duration (ms): " + durationMs);
            System.out.println("Total from Master = " + total);
        }
    
        double avgDuration = totalDuration / (double) repetitions;
        System.out.println("\nDurée moyenne : " + avgDuration / 1_000_000.0 + " ms");
    }
    
}

