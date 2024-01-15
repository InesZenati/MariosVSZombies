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
                if(plato.getMarathonOrNot()==true){
                l= plato.getMarathonMode();
            }
                spawnRandomZombies(l);
                break;
            case 1:
                 List<Zombie> f = pGui.getJeuGUI().getPlateau().getVague();
                if(plato.getMarathonOrNot()==true){
                f= pGui.getJeuGUI().getPlateau().getMarathonMode();
            }
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

    public void move(Zombie z){
        switch (i) {
            case 0:
                z.moveZombie(plato);
                break;
            case 1:
                z.moveZombie(pGui);
                break;
            default:
                break;
        }
    }

    

    public void moveRandomZombies(List<Zombie> listeZombies) {
        for (int i = 0; i < listeZombies.size(); i++) {
            sleep(1000);
            listeZombies.get(i).moveZombie(plato);
            sleep(1000);
        }
        sleep(1000);

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
        sleep(1000);
        move(z);
        update();
    } 

    public void spawnRandomZombies(List<Zombie> listeZombies) {
        for (int i = 0; i < listeZombies.size(); i++) {
            spawnZombie(listeZombies.get(i));
            if(plato.getPartisStatus()!=0){
                break;
            }
        }
        sleep(1000);
        if(plato.getMarathonOrNot()==true && plato.getPartisStatus()!=1){
            spawnRandomZombies(plato.generateEnemieMarathon());
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
