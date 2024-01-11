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
        while(running){  
             //   update();
                sleep(100);   
            }

           /* 
            plato.moveZombie(zombie);
                sleep(100);
                plato.affiche();
        }
        */
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
                System.out.println("Dans case 0");
                spawnRandomZombies(l);
                System.out.println("Dans case 0");
                break;
            case 1:
                 List<Zombie> f = pGui.getJeuGUI().getPlateau().getVague();
                if(plato.getMarathonOrNot()==true){
                f= pGui.getJeuGUI().getPlateau().getMarathonMode();
            }
                System.out.println("plato interface" +plato.toString());
                System.out.println("Dans ZombieThread");
                spawnRandomZombies(f);
                    System.out.println("Dans ZombieThread");
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
        System.out.println("Dans moveRandomZombies");
        for (int i = 0; i < listeZombies.size(); i++) {
            sleep(1000);
            listeZombies.get(i).moveZombie(plato);
            sleep(1000);
        }
        sleep(1000);
        System.out.println("Fin moveRandomZombies");
    }


    public void spawnZombie(Zombie z) {
        System.out.println("Dans spawnZombie");
        int li = 1+ (int) (Math.random() * plato.getNumLi()-1);
        int col = plato.getNumCols() - 1;
        System.out.println("colne de spawn " +col);
         System.out.println(z.toString());
        while (plato.getCase(li, col).contientZombie()) {
            li = (int) (Math.random() * plato.getNumLi()-1);
            col = plato.getNumCols() - 1;
        }
        
        z.placeZombie(li, col, plato);
        update();
        sleep(1000);
        move(z);
        update();
        System.out.println(z.toString());
        System.out.println("Fin spawnZombie");
    } 

    public void spawnRandomZombies(List<Zombie> listeZombies) {
        System.out.println("Dans spawnRandomZombies");
        for (int i = 0; i < listeZombies.size(); i++) {
            spawnZombie(listeZombies.get(i));
            if(plato.getPartisStatus()!=0){
                break;
            }
            System.out.println(listeZombies.get(i).toString());
        }
        sleep(1000);
        if(plato.getMarathonOrNot()==true && plato.getPartisStatus()==0){
            spawnRandomZombies(plato.generateEnemieMarathon());
        }
        System.out.println("Fin spawnRandomZombies");
    }
   

    private static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
