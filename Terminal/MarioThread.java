import java.util.List;
    public class MarioThread extends Thread {
    private Plateau plato;
    private PlateauGUI pGui;
    private Joueur joueur;
    private boolean running = true;
    private int i;

    public MarioThread(Plateau plato) {
        this.plato = plato;
        this.joueur = plato.getJoueur();
    }


    @Override
    public void run() {
        Communication c = new Communication();
        while (plato.getPartieStatus() == 0 && running) {
            ZombieMort();
            String choix = c.demanderPersoPosition();
            placerMario(choix);
            plato.affiche();
            pGui.updatePlateau();  
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

    private void placerMarioAux(String tour, Mario m){
        if(m.getPrix()<=this.joueur.getArgent()){
            if(plato.placeMario(m, Character.getNumericValue(tour.charAt(1)), Character.getNumericValue(tour.charAt(2)))){
               
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



