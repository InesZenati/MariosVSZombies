import java.util.List;
public class AttaqueThread extends Thread {
    private Plateau plato;
    private PlateauGUI pGui;
    private int i;


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
        while(true){
            update();
            attaque();
            update();
            sleep(1000);
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

    public void attaque(){
        if(!plato.getListPerso().isEmpty()){
            //System.out.println(p.getListPerso().size());
            plato.afficheList();
            for(int i=0 ; i<plato.getListPerso().size(); i++ ){
                    Personnage n = plato.getListPerso().get(i);
                     //   System.out.println("dans le while"); 
                    //System.out.println(n.estDevant(p));
                    if(n.peutAttaquer(plato)){
                        System.out.println(n.getName()+"peut attaquer !");
                        System.out.println(n.getName()+"attaque !");
                        attaquerZombie(n);
                    }
            }
        }
    }

    public void attaquerZombie(Personnage n){
        switch (i) {
            case 0:
                n.attaque(plato);
                n.aGagner(plato, n);
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
