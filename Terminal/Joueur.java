import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Joueur {
    private final String name;
    private int argent =24;
    private int score=0;

    public Joueur(String name) {
        this.name = name;
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

    public void afficheArgent(){
        System.out.println(this.argent);
    }

        
    }
    
}
