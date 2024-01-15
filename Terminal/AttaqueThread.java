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
        if(plato.getMarathonOrNot()==false){
        while(plato.getPartieStatus()==0){
            update();
            attaque();
            update();
            sleep(1000);
        }     
        }else{
            while(plato.getPartieStatus()!=1){
                update();
                attaque();
                update();
                sleep(1000);
            
        }
    }
    }

    public void stopThread(){
        running = false;
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
                if(n instanceof Mario){
                    Mario m = (Mario) n;
                    m.attaque(plato);
                }else if(n instanceof Zombie){
                    Zombie z =(Zombie) n;
                    z.attaque(pGui);
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
