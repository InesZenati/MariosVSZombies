import java.util.Scanner;

public class MarioVSKoopa {
private Jeu jeu;
private JeuGUI jeuGUI;  



public  void demanderInterfaceMarioVSKoopa(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Ou voulez vous jouer ? 1 Terminal, 2 Interface Graphique ");
    int r= sc.nextInt();
  switch(r){ 
     case 1:
    Communication c = new Communication();
    Joueur j = new Joueur(c.demanderString("Comment souhaites-tu te nommer ?"));
    String mode = jeu.modeJeu(c.demanderNiveauDifficulte());
    Plateau p = new Plateau(6,10,mode,j);
    jeu = new Jeu(p);
    jeu.jouer(1);
    break;

    case 2:
    jeuGUI = new JeuGUI();

  }
 
}

public static void main(String[] args) {
    MarioVSKoopa m = new MarioVSKoopa();
    m.demanderInterfaceMarioVSKoopa();
}

}