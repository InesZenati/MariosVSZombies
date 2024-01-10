import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class ZombieThread extends Thread {
    private Plateau plato;

    public ZombieThread(Plateau plato) {
        this.plato = plato;
    }

    @Override
    public void run() {

                plato.spawnRandomZombies(plato.getVague());
                plato.affiche();
                sleep(100);   
           /* 
            plato.moveZombie(zombie);
                sleep(100);
                plato.affiche();
        }
        */
    }
  

    private static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
