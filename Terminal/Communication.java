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
        int r =scanner.nextInt();
        
        try {
            if(r>2||r<1){
                System.out.println("Répondez par 1 ou 2");
                return demanderDeRejouer();
            }
            return r;
        } catch (Exception e) {
            System.out.println("Répondez par 1 ou 2");
            return demanderDeRejouer();
        }
        
    }
    public int demanderNiveauDifficulte() {
        afficherMessage("Choisissez le niveau de difficulté (1 facile, 2 moyen, 3 difficile, 4 marathon): ");
        int r = scanner.nextInt();
        try {
            if(r>4||r<1){
                System.out.println("Répondez par 1, 2, 3 ou 4");
                return demanderNiveauDifficulte();
            }
            return r;
        } catch (Exception e) {
            System.out.println("Répondez par 1, 2, 3 ou 4");
            return demanderNiveauDifficulte();
        }
    }

    public int demanderInterfacedeJEU(){
        afficherMessage("Ou voulez vous jouer ? 1 Terminal, 2 Interface Graphique ");
        try {
            int r = scanner.nextInt();
            if(r>2||r<1){
                System.out.println("Répondez par 1 ou 2");
                return demanderInterfacedeJEU();
            }
            return scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Répondez par 1 ou 2");
            return demanderInterfacedeJEU();
        }
              
    }
    public String demanderString(String s){
        afficherMessage(s);
        return scanner.nextLine();
    }
    public String demanderPersoPosition(Plateau p){
        afficherMessage("Tour: ");
        while(p.getPartieStatus()==0){
        String position = scanner.nextLine();
            return position;
        }
        return ("");
    }

    
    



}