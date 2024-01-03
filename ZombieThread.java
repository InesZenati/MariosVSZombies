import java.util.List;
public class ZombieThread extends Thread {
    private Plateau plato;
    private List<Zombie> ennemis;

    public ZombieThread(Plateau plato, List<Zombie> ennemis) {
        this.plato = plato;
        this.ennemis = ennemis;
    }

    @Override
    public void run() {
        while (true) {
            for (Zombie zombie : ennemis) {
                plato.spawnZombie(zombie);
                plato.affiche();
                sleep(100);
                plato.moveZombie(zombie);
                sleep(100);
                plato.affiche();
            }
        }
    }

    private static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
