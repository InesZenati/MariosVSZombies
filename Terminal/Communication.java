import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Communication {
    private Scanner scanner;

    public Communication() {
        this.scanner = new Scanner(System.in);
    }
    public Scanner getScanner(){
        return scanner;
    }

    public void afficherMessage(String message) {
        System.out.println(message);
    }

    public int demanderDeRejouer(){
        afficherMessage("Voulez-vous rejouer ? 1 OUI 2 NON");
        return scanner.nextInt();
    }
    public int demanderNiveauDifficulte() {
        afficherMessage("Choisissez le niveau de difficulté (1 facile, 2 moyen, 3 difficile, 4 marathon): ");
        return scanner.nextInt();
    }

    public int demanderInterfacedeJEU(){
        afficherMessage("Ou voulez vous jouer ? 1 Terminal, 2 Interface Graphique ");
        return scanner.nextInt();
              
    }

    public int demanderTypeMario() {
        afficherMessage("Choisissez le type de Mario (1 BasicMario ");
        return scanner.nextInt();
    }
    public String demanderString(String s){
        afficherMessage(s);
        return scanner.nextLine();
    }
    public String demanderPersoPosition(){
        afficherMessage("Tour: ");
        String position = scanner.nextLine();
        return position;
    }



}