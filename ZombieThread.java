import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class ZombieThread extends Thread {
    private Plateau plato;
    private List<Zombie> ennemis;

    public ZombieThread(Plateau plato, List<Zombie> ennemis) {
        this.plato = plato;
        this.ennemis = ennemis;
    }

    @Override
    public void run() {
        
                plato.spawnRandomZombies(generateEnemies(10));
                plato.affiche();
                sleep(100);   
           /* 
            plato.moveZombie(zombie);
                sleep(100);
                plato.affiche();
        }
        */
    }
   public static List<Zombie> generateEnemies(int n) {
        List<Zombie> ennemis = new ArrayList<>();
        Random random = new Random();

        // Définir la proportion de zombies de type 1 et type 2
        int zombieType1Percentage = 70;
        int zombieType2Percentage = 30;

        for (int i = 0; i < n; i++) {
            int randomNumber = random.nextInt(100) + 1; // Générer un nombre entre 1 et 100 inclus

            // Sélectionner le type de zombie en fonction de la proportion définie
            if (randomNumber <= zombieType1Percentage) {
                ennemis.add(new Zombie1(1000));
            } else {
                ennemis.add(new Zombie2(2000));
            }
        }
        return ennemis;
        }

    private static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
