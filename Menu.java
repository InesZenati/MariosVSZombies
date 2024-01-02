import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public void afficheMenuPrincipal(){
        int choix;
        do {
            afficherMessage("=== Menu Principal ===");
            afficherMessage("1. Lire les règles du jeu");
            afficherMessage("2. Catalogue des personnages");
            afficherMessage("3. Démarrer une nouvelle partie");
            afficherMessage("4. Quitter le jeu");
            afficherMessage("========================");

            choix = demanderChoixUtilisateur(1, 4);

            switch (choix) {
                case 1:
                afficherReglesDuJeu();
                    break;
                case 2:
                    afficherCatalogue(initialiserListeMario());
                    break;
                case 3:
                    afficherMessage("Démarrage d'une nouvelle partie...");
                    break;
                case 4:
                    afficherMessage("Merci d'avoir joué ! Au revoir !");
                    break;
                default:
                    afficherMessage("Choix invalide. Veuillez choisir une option valide.");
                    break;
                

    }
        }
        while (choix != 4);
    }                       

    public void afficherReglesDuJeu(){
        afficherMessage("=== Règles du jeu ===");
        afficherMessage("Le but du jeu est de tuer tous les zombies avant qu'ils n'atteignent le château.");
        afficherMessage("Pour cela, vous disposez de plusieurs Mario qui disposent de capacitée differentes:");
        afficherMessage("BasicMario : Mario de base, qui peut tuer un zombie en lui sautant dessus.");
        afficherMessage("WallBrick : Allié de Mario, c'est un mur de brique qui bloquera le passage aux zombies.");
        afficherMessage("FireMario : Mario qui peut tuer un zombie en lançant des boules de feu.");
        afficherMessage("BigMario : Mario qui peut tuer un zombie en lui sautant dessus.");
        afficherMessage("StarMario : C'est leplus puissant des Mario il dispose de capacitées quasi-maximal et vous rend presue invincible pendant le tour.");
        afficherMessage("Vous pouvez cconsulter les capcitée des Mario dans le catalogue.");
        afficherMessage("Vous pouvez choisir le type de Mario que vous souhaitez utiliser au début de chaque tour.");
        afficherMessage("Vous pouvez placer votre Mario sur une case vide du plateau, cependant vous ne pouvez pas le deplacer.");
        afficherMessage("Vous pouvez quitter la partie en cours.");
        afficherMessage("Bonne chance !");
        afficherMessage("======================");

    }

public void afficherCatalogue(List<Mario> catalogueMario) {
        afficherMessage("=== Catalogue des Tours ===");
        for (int i = 0; i < catalogueMario.size(); i++) {
            Mario m = catalogueMario.get(i);
            afficherMessage((i + 1) + ". " + m.toString());
        }
        afficherMessage("==========================");
    }

        private List<Mario> initialiserListeMario() {
        List<Mario> catalogue = new ArrayList<>();
        catalogue.add(new BasicMario(0,0));
        catalogue.add(new FireMario(0, 0));
        catalogue.add(new WallBrick(0, 0));
        catalogue.add(new BigMario(0, 0));
        catalogue.add(new StarMario(0, 0));
        
        return catalogue;
    }
 public void afficherMessage(String message) {
        System.out.println(message);
    }

    public int demanderChoixUtilisateur(int min, int max) {
        afficherMessage("Choisissez une option : ");
        return scanner.nextInt();
    }

    public int demanderChoixNiveau(int min, int max) {
        afficherMessage("Choisissez le niveau de difficulté (1 facile, 2 moyen, 3 difficile): ");
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        Menu m = new Menu();
        m.afficheMenuPrincipal();
    }
    
}
