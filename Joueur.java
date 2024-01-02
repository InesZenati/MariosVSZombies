import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Joueur {
    private final String name;
    private int argent =30;
    private int score;

    public Joueur(String name, int argent, int score) {
        this.name = name;
        this.argent = argent;
        this.score = score;
    }

    public String getName() {
        return this.name;
    }
    public int getArgent() {
        return this.argent;
    }
    public int getScore() {
        return this.score;
    }
    public void setArgent(int argent) {
        this.argent = argent;
    }
    public void setScore(int score) {
        this.score = score;
    }

    public void incrementerArgent(int montant) {
        this.argent += montant;
    }

    public void decrementerArgent(int montant) {
        this.argent -= montant;
    }

    public void incrementerScore(int montant) {
        this.score += montant;
    }

    public void afficherMessage(String message) {
        System.out.println(message);
    }

        public void afficherMArioDisponibles(List<Mario> MArioDisponibles) {
        afficherMessage("Mario disponibles :");
        for (int i = 0; i < MArioDisponibles.size(); i++) {
            Mario mario = MArioDisponibles.get(i);
            if(mario.getPrix()<=this.argent){
                afficherMessage((i + 1) + ". " + mario.toString());
            }
        }
    }
    public String demanderPersoPosition(){
        Scanner scanner = new Scanner(System.in);
        afficherMessage("Tour: ");
        String position = scanner.nextLine();
        return position;
    }

    public static void main(String[] args) {
         List<Mario> MArioDisponibles =new ArrayList<>();
        MArioDisponibles.add(new BasicMario( 0, 0));
        MArioDisponibles.add(new WallBrick( 0, 0));
        MArioDisponibles.add(new FireMario(0, 0));
        MArioDisponibles.add(new BigMario(0, 0));
        MArioDisponibles.add(new StarMario(0, 0));
        Joueur joueur = new Joueur("joueur", 30, 0);
        joueur.afficherMArioDisponibles(MArioDisponibles);
        

    }
}
