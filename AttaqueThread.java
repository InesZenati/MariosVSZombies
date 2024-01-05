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
        for(int i=0 ;i <p.getNumLi();i++ ){
            for(int j=0 ;j <p.getNumCols();j++ ){
                if(p.getCase(i,j).getPersonnage() != null){
                    if(p.getCase(i,j).getPersonnage().peutAttaquer(p)){
                        p.getCase(i,j).getPersonnage().attaque(p);
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
