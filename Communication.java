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

    public void afficherMArioDisponibles(List<Mario> MArioDisponibles) {
        afficherMessage("Mario disponibles :");

        for (int i = 0; i < MArioDisponibles.size(); i++) {
            Mario mario = MArioDisponibles.get(i);
            afficherMessage((i + 1) + ". " + mario.toString());
        }
    }
/* 
    public int demanderPlacementMario() {
        afficherMessage("Où souhaitez-vous placer votre Mario ? x : \n");
        int ligne = scanner.nextInt();
        afficherMessage("y: \n ");
        int colonne = scanner.nextInt();
        return (ligne << 16) | colonne; 
    }
    */

}