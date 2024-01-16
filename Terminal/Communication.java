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
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Répondez par 1 ou 2");
            return demanderDeRejouer();
        }
        
    }
    public int demanderNiveauDifficulte() {
        afficherMessage("Choisissez le niveau de difficulté (1 facile, 2 moyen, 3 difficile, 4 marathon): ");
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Répondez par 1, 2, 3 ou 4");
            return demanderDeRejouer();
        }
    }

    public int demanderInterfacedeJEU(){
        afficherMessage("Ou voulez vous jouer ? 1 Terminal, 2 Interface Graphique ");
        try {
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
    public String demanderPersoPosition(){
        afficherMessage("Tour: ");
        String position = scanner.nextLine();
        if(position.length()==3 && MarioCorrect(position)){
            return position;
        }
        afficherMessage("La réponse doit être de forme : Bxy ");
        return demanderPersoPosition();
    }

    public boolean MarioCorrect(String s){
        if(s.charAt(0)=='B'||s.charAt(0)=='W'||s.charAt(0)=='S'||s.charAt(0)=='G'||s.charAt(0)=='F'){
            if(s.charAt(1)=='0'||s.charAt(1)=='1'||s.charAt(1)=='2'||s.charAt(1)=='3'||s.charAt(1)=='4'||s.charAt(1)=='5'){
                if(s.charAt(2)=='0'||s.charAt(2)=='1'||s.charAt(2)=='2'||s.charAt(2)=='3'||s.charAt(2)=='4'||s.charAt(2)=='5'||s.charAt(2)=='6'||s.charAt(2)=='7'||s.charAt(2)=='8'||s.charAt(2)=='9'){
                    return true;
                }
            }
            
        }
        return false;
    }
    



}