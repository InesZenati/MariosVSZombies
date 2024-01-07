import java.util.List;
public class AttaqueThread extends Thread {
    private Plateau plato;


    public AttaqueThread(Plateau plato) {
        this.plato = plato;
    }

    @Override
    public void run(){
        while(true){
            plato.affiche();
            attaque(plato);
            plato.affiche();
            sleep(1000);
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
