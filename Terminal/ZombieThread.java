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
                plato = p.getJeuGUI().getPlateau();
    }

    @Override
    public void run() {
        while(true){  
                switch (i) {
                    case 0:
                        System.out.println("Dans case 0");
                        spawnRandomZombies(plato.getVague());
                        System.out.println("Dans case 0");
                        update();
                        break;
                    case 1:
                    System.out.println("Dans ZombieThread");
                    spawnRandomZombies(pGui.getJeuGUI().getPlateau().getVague());
                    System.out.println("Dans ZombieThread");
                    pGui.getJeuGUI().getPlateau().affiche();
                    update();    
                        break;
                    default:
                        break;
                }
                sleep(100);   
            }

           /* 
            plato.moveZombie(zombie);
                sleep(100);
                plato.affiche();
        }
        */
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
        System.out.println("Dans moveZombie");
        Plateau plato = this.plato;                          
        int li = z.getInfoActuelle().getPosX();
        int col = z.getInfoActuelle().getPosY();
        while(z.peutDeplacer(plato)){ 
                removeZombie(li, col);
                col=col-1;
                sleep(100);
                placeZombie(z, li, col);
                sleep(1000);
                System.out.println("update");
                update();
                System.out.println("update");
            }
            System.out.println("Fin moveZombie");
        }

    public void moveRandomZombies(List<Zombie> listeZombies) {
        System.out.println("Dans moveRandomZombies");
        for (int i = 0; i < listeZombies.size(); i++) {
            sleep(1000);
            moveZombie(listeZombies.get(i));
            sleep(1000);
        }
        sleep(1000);
        System.out.println("Fin moveRandomZombies");
    }

    public void spawnZombie(Zombie z) {
        System.out.println("Dans spawnZombie");
        int li = 1+ (int) (Math.random() * plato.getNumLi()-1);
        int col = plato.getNumCols() - 1;
        while (plato.getCase(li, col).contientZombie()) {
            li = (int) (Math.random() * plato.getNumLi()-1);
            col = plato.getNumCols() - 1;
        }
        
        placeZombie(z, li, col);
        moveZombie(z);
        System.out.println(z.toString());
        System.out.println("Fin spawnZombie");
    } 

    public void spawnRandomZombies(List<Zombie> listeZombies) {
        System.out.println("Dans spawnRandomZombies");
        for (int i = 0; i < listeZombies.size()-1; i++) {
            System.out.println("fin spawnRandomZombies");
            spawnZombie(listeZombies.get(i));
        }
        System.out.println("Fin spawnRandomZombies");
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
