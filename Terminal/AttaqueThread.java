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
            attaque(plato);
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

    public void attaque(Plateau p){
        if(!p.getListPerso().isEmpty()){
            //System.out.println(p.getListPerso().size());
            p.afficheList();
            for(int i=0 ; i<p.getListPerso().size(); i++ ){
                    Personnage n = p.getListPerso().get(i);
                     //   System.out.println("dans le while"); 
                    //System.out.println(n.estDevant(p));
                    if(n.peutAttaquer(p)){
                        System.out.println(n.getName()+"peut attaquer !");
                        System.out.println(n.getName()+"attaque !");
                       n.attaque(p);
                       //n.aGagner(p);
                    }
            }
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
