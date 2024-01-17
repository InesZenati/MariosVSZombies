import java.util.List;
public class AttaqueThread extends Thread {
    private Plateau plato;
    private PlateauGUI pGui;
    private int i;
    private boolean running = true;


    public AttaqueThread(Plateau plato) {
        i=0;
        this.plato = plato;
    }
    public AttaqueThread(PlateauGUI p){
        i=1;
        pGui=p;
        plato=p.getJeuGUI().getPlateau();
    }

    @Override
    public void run(){
        while(plato.getPartieStatus()==0){
            if (ZombieMort()==false) {
                attaque();
            }
            sleep(1000);    
        }
    }

    public boolean ZombieMort() {
        if (plato.getMarathonOrNot() == false) {
            for (int i = 0; i < plato.getVague().size() - 1; i++) {
                if (plato.getVague().get(i).estVivant()) {
                    return false;
                }
            }
            plato.MarioGagne();
            return true;
        }
        return false;
    }

    public void stopThread(){
        running = false;
    }


    public void attaque(){
        if(!plato.getListPerso().isEmpty()){
            for(int i=0 ; i<plato.getListPerso().size(); i++ ){
                    Personnage n = plato.getListPerso().get(i);
                    if(n.peutAttaquer(plato)){
                        attaquerZombie(n);
                    }
            }
        }
    }

    public void attaquerZombie(Personnage n){
        switch (i) {
            case 0:
                n.attaque(plato);
                break;
            case 1:
                n.attaque(pGui);
                }
                break;
            default:
                break;
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
