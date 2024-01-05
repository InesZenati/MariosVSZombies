import java.util.List;
    public class MarioThread extends Thread {
    private Plateau plato;
    private Joueur joueur;
    private List<Mario> listeMario;

    public MarioThread(Plateau plato, Joueur joueur, List<Mario> listeMario) {
        this.plato = plato;
        this.joueur = joueur;
        this.listeMario = listeMario;
    }

    @Override
    public void run() {
        while (true) {
            String choix = joueur.demanderPersoPosition();
            placerMario(choix);
            plato.affiche();
        }
    }
// ajoue try catch
    private void placerMario(String tour) {
        switch (tour.charAt(0)) {
            case 'B':
             if (listeMario.get(0).getPrix() <= this.joueur.getArgent()){ 
                System.out.println(0);
                BasicMario mario = new BasicMario();
                plato.placeMario(mario, Character.getNumericValue(tour.charAt(1)), Character.getNumericValue(tour.charAt(2)));
                System.out.println(mario.toString());
                this.joueur.decrementerArgent(mario.getPrix());
                System.out.println(2); 
               while(mario.estVivant()){
             //   System.out.println(3);
                if(mario.peutAttaquer(plato)){
                   System.out.println(4);
                    System.out.println(5);
                    System.out.println("BasicMario attaque !");
                    mario.attaque(plato);
                    mario.aGagner(plato);
                }
                //sleep(1000);
                }
                break;   
                }
                System.out.println("Solde insuffisant");
                break;
            case 'W':
                plato.placeMario(listeMario.get(0), Character.getNumericValue(tour.charAt(1)), Character.getNumericValue(tour.charAt(2)));
                this.joueur.decrementerArgent(listeMario.get(0).getPrix());
                break;
            case 'F':
             if (listeMario.get(0).getPrix() <= this.joueur.getArgent()){ 
                plato.placeMario(listeMario.get(0), Character.getNumericValue(tour.charAt(1)), Character.getNumericValue(tour.charAt(2)));
                this.joueur.decrementerArgent(listeMario.get(0).getPrix());
                if(listeMario.get(0).peutAttaquer(plato)){
                    FireMario mario = (FireMario) listeMario.get(0);
                    mario.attaque(plato);
                }
            }
            System.out.println("Solde insuffisant");
                break;
            case 'G':
                 if (listeMario.get(0).getPrix() <= this.joueur.getArgent()){ 
                plato.placeMario(listeMario.get(0), Character.getNumericValue(tour.charAt(1)), Character.getNumericValue(tour.charAt(2)));
                this.joueur.decrementerArgent(listeMario.get(0).getPrix());
                if(listeMario.get(0).peutAttaquer(plato)){
                    BigMario mario = (BigMario) listeMario.get(0);
                    mario.attaque(plato);
                }
            }
            System.out.println("Solde insuffisant");
                break;
            case 'S':
                if (listeMario.get(0).getPrix() <= this.joueur.getArgent()){ 
                plato.placeMario(listeMario.get(0), Character.getNumericValue(tour.charAt(1)), Character.getNumericValue(tour.charAt(2)));
                this.joueur.decrementerArgent(listeMario.get(0).getPrix());
                if(listeMario.get(0).peutAttaquer(plato)){
                    StarMario mario = (StarMario) listeMario.get(0);
                    mario.attaque(plato);
                }
            }
            System.out.println("Solde insuffisant");
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



