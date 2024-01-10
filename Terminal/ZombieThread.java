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
                switch (i) {
                    case 0:
                        plato.spawnRandomZombies(plato.getVague());
                        plato.affiche();
                        break;
                    case 1:
                      //  pGui.getJeuGUI().getPlateau().spawnRandomZombies(pGui.getJeuGUI().getPlateau().getVague());
                    pGui.testPlateau();
                    pGui.getJeuGUI().getPlateau().affiche();    
                   // pGui.updatePlateau();
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
  

    private static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
