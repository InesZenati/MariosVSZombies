import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class ZombieThread extends Thread {
    private Plateau plato;
    private PlateauGUI pGui;
    private int i;


    public ZombieThread(Plateau plato) {
                this.i=0;
                this.plato = plato;    
    }

    public ZombieThread(PlateauGUI p){
                this.i=1;
                pGui=p;
    }

    @Override
    public void run() {
        while(true){  
            spawn();
            update();
            sleep(100);   
            }

           /* 
            plato.moveZombie(zombie);
                sleep(100);
                plato.affiche();
        }
        */
    }

    public void spawn(){
        switch (i) {
            case 0:
                plato.spawnRandomZombies(plato.getVague());
                break;
            case 1:
                pGui.getJeuGUI().getPlateau().spawnRandomZombies(pGui.getJeuGUI().getPlateau().getVague());
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
                break;
            default:
                break;
        }
    }

    public void moveZombie(Zombie z) {
        Plateau plato = this.plato;                          
        int li = z.getInfoActuelle().getPosX();
        int col = z.getInfoActuelle().getPosY();
        while(z.peutDeplacer(plato)){ 
                removeZombie(li, col);
                col=col-1;
                sleep(100);
                placeZombie(z, li, col);
                sleep(1000);
                update();
            }
        }

    public void moveRandomZombies(List<Zombie> listeZombies) {
        for (int i = 0; i < listeZombies.size(); i++) {
            sleep(1000);
            moveZombie(listeZombies.get(i));
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
        
        placeZombie(z, li, col);
        moveZombie(z);
        System.out.println(z.toString());
    } 

    public void spawnRandomZombies(List<Zombie> listeZombies) {
        for (int i = 0; i < listeZombies.size()-1; i++) {
            System.out.println("Dans spawnRandomZombies");
            spawnZombie(listeZombies.get(i));
        }
    }
    public void placeZombie(Zombie z, int li, int col) {
        //(!plato[li][col].contientZombie() && !plato[li][col].contientMario()){    
        z.getInfoActuelle().setPosX(li);
        z.getInfoActuelle().setPosY(col);
        plato.ajouter(z);
        plato.getCase(li, col).setZombie(z);
        //}
    }

    public void removeZombie(int li, int col) {
        plato.retirer(plato.getCase(li, col).getPersonnage());
        plato.getCase(li, col).supprimerPerso();
    }

    private static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
