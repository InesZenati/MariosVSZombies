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
        while (plato.getPartieStatus()==0 && running) {
            String choix = c.demanderPersoPosition(plato);
            if(!ZombieMort()&&plato.getPartieStatus()==0){
            update();    
            placerMario(choix);
            }
            
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
        if(m.getPrix()<=this.joueur.getArgent()&&plato.getPartieStatus()==0){
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
        if(tour.length()==3 && MarioCorrect(tour)){
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
        }else{
            if(plato.getPartieStatus()==0){
                System.out.println("Pour placer une tour, il faut écrire sous la forme : Mxy");
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

    public boolean MarioCorrect(String s){
        if(s.charAt(0)=='B'||s.charAt(0)=='W'||s.charAt(0)=='S'||s.charAt(0)=='G'||s.charAt(0)=='F'){
            if(s.charAt(1)=='0'||s.charAt(1)=='1'||s.charAt(1)=='2'||s.charAt(1)=='3'||s.charAt(1)=='4'||s.charAt(1)=='5'){
                if(s.charAt(2)=='0'||s.charAt(2)=='1'||s.charAt(2)=='2'||s.charAt(2)=='3'||s.charAt(2)=='4'||s.charAt(2)=='5'||s.charAt(2)=='6'||s.charAt(2)=='7'||s.charAt(2)=='8'||s.charAt(2)=='9'){
                    return true;
                }
            }
            
        }
        return false;
    }
}


