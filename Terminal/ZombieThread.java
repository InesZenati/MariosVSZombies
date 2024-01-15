import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ZombieThread extends Thread {
    private Plateau plato;
    private PlateauGUI pGui;
    private int i;
    private boolean running = true;


    public ZombieThread(Plateau plato) {
                this.i=0;
                this.plato = plato;    
    }

    public ZombieThread(PlateauGUI p){
                this.i=1;
                pGui=p;
                plato = p.getJeuGUI().getPlateau();
    }

    @Override
    public void run() { 
        spawn();

        }

    public void stopThread(){
        running = false;
    }

    public void spawn(){
       
        switch (i) {
            case 0:
             List<Zombie> l= plato.getVague();
                spawnRandomZombies(l);
                break;
            case 1:
                 List<Zombie> f = pGui.getJeuGUI().getPlateau().getVague();
                spawnRandomZombies(f);
                break;
            default:
                break;
        }
    }

    public void update(){
        switch (i) {
            case 0:
                plato.affiche();
                break;
            case 1:
                pGui.updatePlateau();
                plato.affiche();
                break;
            default:
                break;
        }
    }

    


    public void spawnZombie(Zombie z) {
        int li = 1+ (int) (Math.random() * plato.getNumLi()-1);
        int col = plato.getNumCols() - 1;
        while (plato.getCase(li, col).contientZombie()) {
            li = (int) (Math.random() * plato.getNumLi()-1);
            col = plato.getNumCols() - 1;
        }
        z.placeZombie(li, col, plato);
        update();
    } 

    public void spawnRandomZombies(List<Zombie> listeZombies) {
        for (int i = 0; i < listeZombies.size(); i++) {
            spawnZombie(listeZombies.get(i));
            sleep(2000);
            if(plato.getPartieStatus()!=0){
                break;
            }
        }
        sleep(1000);
        if(plato.getMarathonOrNot()==true && plato.getPartieStatus()!=1 && running){
            spawnRandomZombies(plato.generateZombies("Marathon"));
        };
    }
   

    private static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
