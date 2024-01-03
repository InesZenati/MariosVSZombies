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

    private void placerMario(String tour) {
        switch (tour.charAt(0)) {
            case 'B':
                plato.placeMario(listeMario.get(0), Character.getNumericValue(tour.charAt(1)), Character.getNumericValue(tour.charAt(2)));
                this.joueur.decrementerArgent(listeMario.get(0).getPrix());
                break;
            case 'W':
                plato.placeMario(listeMario.get(1), Character.getNumericValue(tour.charAt(1)), Character.getNumericValue(tour.charAt(2)));
                this.joueur.decrementerArgent(listeMario.get(1).getPrix());
                break;
            case 'F':
                plato.placeMario(listeMario.get(2), Character.getNumericValue(tour.charAt(1)), Character.getNumericValue(tour.charAt(2)));
                this.joueur.decrementerArgent(listeMario.get(2).getPrix());
                break;
            case 'G':
                plato.placeMario(listeMario.get(3), Character.getNumericValue(tour.charAt(1)), Character.getNumericValue(tour.charAt(2)));
                this.joueur.decrementerArgent(listeMario.get(3).getPrix());
                break;
            case 'S':
                plato.placeMario(listeMario.get(4), Character.getNumericValue(tour.charAt(1)), Character.getNumericValue(tour.charAt(2)));
                this.joueur.decrementerArgent(listeMario.get(4).getPrix());
                break;
        }
    }
}


