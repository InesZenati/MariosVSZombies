import java.util.List;

public class Jeu {
    private Plateau plato;
    private String niveauDeDifficulté;
    private List<Zombie> ennemis;
    private List<Mario> ListeMario;
    public Joueur joueur;

    public Jeu(Plateau plato, String niveauDeDifficulté, List<Zombie> ennemis, List<Mario> ListeMario , Joueur joueur) {
        this.plato = plato;
        this.niveauDeDifficulté = niveauDeDifficulté;
        this.ennemis = ennemis;
        this.ListeMario = ListeMario;
        this.joueur = joueur;
    }

    public Plateau getPlato() {
        return plato;
    }
    public String getNiveauDeDifficulté() {
        return niveauDeDifficulté;
    }
    public List<Zombie> getEnnemis() {
        return ennemis;
    }
    public List<Mario> getListeMario() {
        return ListeMario;
    }

    public void setPlato(Plateau plato) {
        this.plato = plato;
    }

   public void placerMario(Mario m, int li, int col , Joueur joueur) {
        if(joueur.getArgent()>=m.getPrix()){
              plato.placeMario(m, li, col);
        }
        joueur.decrementerArgent(m.getPrix()); 
    }


    public static void main(String[] args) {
        Plateau p = new Plateau(7, 10);
        Zombie zombie = new Zombie("zombie1", 10,5, new Information(2, 0, 0, 0, 10));
        p.affiche();
        zombie.spawn(p);
        p.affiche();
        p.spawnZombie(zombie);
        p.affiche();
       // zombie.deplacerZ(p);
        //p.affiche();

    }
}
