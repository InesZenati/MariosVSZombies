import java.util.List;
public class AttaqueThread extends Thread {
    private Plateau plato;


    public AttaqueThread(Plateau plato) {
        this.plato = plato;
    }

    @Override
    public void run(){
        while(true){
            attaque(plato);
            plato.affiche();
            sleep(1000);
        }
    }

    public void attaque(Plateau p){
        
        for(int i=0 ;i <p.getNumLi()-1;i++ ){
            for(int j=0 ;j <p.getNumCols()-1;j++ ){
                if((p.getCase(i,j).getPersonnage()!= null) && (p.getCase(i,j).getPersonnage().estVivant())){
                    Personnage n = this.plato.getCase(i,j).getPersonnage();
                     //   System.out.println("dans le while"); 
                    if(n.peutAttaquer(p)){
                        System.out.println("dans le if");
                        System.out.println(n.getName()+"attaque !");
                       n.attaque(p);
                       n.aGagner(p);
                    }
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
