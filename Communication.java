import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Communication {
    private Scanner scanner;

    public Communication() {
        this.scanner = new Scanner(System.in);
    }

    public void afficherMessage(String message) {
        System.out.println(message);
    }

    public int demanderNiveauDifficulte() {
        afficherMessage("Choisissez le niveau de difficulté (1 facile, 2 moyen, 3 difficile): ");
        return scanner.nextInt();
    }

    public int demanderTypeMario() {
        afficherMessage("Choisissez le type de Mario (1 BasicMario , 2 WallBrick , 3 FireMario , 4 BigMario ,5 StarMario): ");
        return scanner.nextInt();
    }

    public String demanderPersoPosition(){
        afficherMessage("Tour: ");
        String position = scanner.nextLine();
        return position;
    }

    public static void main(String[] args) {
        Communication communication = new Communication();
        int niveauDifficulte = communication.demanderNiveauDifficulte();
        int typeMario = communication.demanderTypeMario();
        System.out.println("niveauDifficulte = " + niveauDifficulte);
        System.out.println("typeMario = " + typeMario);
    }

}