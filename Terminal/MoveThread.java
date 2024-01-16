public class MoveThread extends Thread {
    private Plateau plato;
    private PlateauGUI pGui;
    private int i;
    private boolean running = true;

    public MoveThread(Plateau p){
        i=0;
        plato = p;
    }
    public MoveThread(PlateauGUI p){
        i=1;
        pGui = p;
        plato = p.getJeuGUI().getPlateau();
    }
    @Override
    public void run(){
        while(running && plato.getPartieStatus()==0){
            deplacer();
            sleep(800);
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
    
    public void deplacer(){
        boolean changement = true;
        if(!plato.getListPerso().isEmpty()){
            for(int i=0 ; changement&& i<plato.getListPerso().size(); i++ ){
                if(plato.getPartieStatus()!=0){
                    changement=false;
                }else{
                    if(plato.getListPerso().get(i) instanceof Zombie){
                    Zombie z =(Zombie)plato.getListPerso().get(i);
                    move(z);
                }}
                
            }
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
    public void stopThread(){
        running = false;
    }
    private static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
