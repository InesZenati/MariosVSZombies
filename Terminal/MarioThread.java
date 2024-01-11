import java.util.List;
    public class MarioThread extends Thread {
    private Plateau plato;
    private Joueur joueur;
    private List<Mario> listeMario;
    private boolean running = true;

    public MarioThread(Plateau plato, Joueur joueur, List<Mario> listeMario) {
        this.plato = plato;
        this.joueur = joueur;
        this.listeMario = listeMario;
    }


    @Override
    public void run() {
        while (plato.getPartisStatus() == 0) {
            ZombieMort();
            String choix = joueur.demanderPersoPosition();
            placerMario(choix);
            plato.affiche();
        }
    }

    private void placerMarioAux(String tour, Mario m){
        if(m.getPrix()<=this.joueur.getArgent()){
            if(plato.placeMario(m, Character.getNumericValue(tour.charAt(1)), Character.getNumericValue(tour.charAt(2)))){
                this.joueur.decrementerArgent(m.getPrix());
            }
        }else{
            System.out.println("Solde insuffisant");
        }
    }

    public void stopThread(){
        running = false;
    }

// ajoue try catch
    private void placerMario(String tour) {
        switch (tour.charAt(0)) {
            case 'B':
                BasicMario mario = new BasicMario();
                placerMarioAux(tour, mario);
                break;
            case 'W':
                WallBrick W = new WallBrick();
                placerMarioAux(tour, W);
                break;
            case 'F':
                FireMario F = new FireMario();
                placerMarioAux(tour, F);
                break;
            case 'G':
                BigMario G = new BigMario();
                placerMarioAux(tour, G);
                break;
            case 'S':
                StarMario S = new StarMario();
                placerMarioAux(tour, S);
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

    public boolean ZombieMort(){
        if(plato.getMarathonOrNot()==false){
            for(int i =0;i<plato.getVague().size()-1;i++){
                if(plato.getVague().get(i).estVivant()){
                    return false;
                }
            }
            plato.MarioGagne();
            return true;
        }
        return false;
    }
}



