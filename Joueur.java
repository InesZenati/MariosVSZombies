public class Joueur {
    private final String name;
    private int argent =0;
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

}
