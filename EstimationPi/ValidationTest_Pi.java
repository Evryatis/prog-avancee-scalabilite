package EstimationPi;


/*
    *  Test d'acceptation pour la classe master, on vérifie la marge d'erreur entre un faible nombre d'itération et un grand nombre d'itération.
    *  On sait que le premier test aura probablement une marge d'erreur forte à cause du faible nombre d'itération.
    *  Le deuxième test aura cependant une marge d'erreur plus faible et approximera Pi avec plus de précision.
 */

public class Test_Pi {
    public static void main(String[] args) throws Exception {
        // Test 1 : 10 itérations, 1 worker, peu d'itération donc erreur trop grande pour approximer pi
        System.out.println("Test 1: 10 itérations, 1 worker");
        long total1 = new Master().doRun(10, 1);  
        System.out.println("Total from Master = " + total1);
        
        // Test 2 : 10000 itérations, 5 workers, plus d'itération, la loi des grands nombre marche et l'approximation de pi est meilleure.
        System.out.println("\nTest 3: 10000 itérations, 5 workers");
        long total3 = new Master().doRun(10000, 5);  
        System.out.println("Total from Master = " + total3);
    }
}
