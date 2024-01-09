import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PlateauGUI extends JPanel{
    private JPanel plateauPanel;
    private JPanel menuPanel;
    private JPanel InfoPanel;
    private int Argent = 100;
    private Mario selectedPersonnage;
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JeuGUI jeuGUI;

    public JeuGUI getJeuGUI(){
        this.selectedPersonnage=null;
        return this.jeuGUI;
    }


    public PlateauGUI(JeuGUI jeuGUI){
        this.jeuGUI = jeuGUI;

          // Création du menuPanel à gauche
        menuPanel = createSideMenu();
        add(menuPanel, BorderLayout.WEST);

        // Création du plateauPanel au centre
        plateauPanel = createPlateau();
        add(plateauPanel, BorderLayout.CENTER);

        InfoPanel = createInfoPanel();
        add(InfoPanel,BorderLayout.NORTH);
    }

    private JPanel createSideMenu() {
        JPanel sideMenu = new JPanel();

        sideMenu.setLayout(new BoxLayout(sideMenu, BoxLayout.Y_AXIS));

        sideMenu.add(createTowerButton("BasicMario", "BasicMario.png", 10)); 
        sideMenu.add(createTowerButton("FireMario", "BasicMario.png", 20));
        sideMenu.add(createTowerButton("WallBrick", "BasicMario.png", 25)); 
        sideMenu.add(createTowerButton("BigMario", "BasicMario.png", 50));
        sideMenu.add(createTowerButton("StarMario", "BasicMario.png", 100));

        return sideMenu;
    }

    public JPanel createInfoPanel(){
        JPanel infoJoueur = new JPanel();
        infoJoueur.setLayout(new BoxLayout(infoJoueur, BoxLayout.Y_AXIS));
        JLabel joueurName = new JLabel("Information de : "+this.getJeuGUI().getJoueur().getName()+" ");
        JLabel joueurArgent = new JLabel("Argent : "+this.getJeuGUI().getJoueur().getArgent()+" coin ");
        JLabel joeuurScore = new JLabel("Score : "+this.getJeuGUI().getJoueur().getScore()+" points");
        infoJoueur.add(joueurName);
        infoJoueur.add(joueurArgent);
        infoJoueur.add(joeuurScore);
        return infoJoueur;
    }

    public JButton createTowerButton(String name , String imagePath, int prix){
        JButton mario = new JButton();
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource(imagePath));
            mario.setIcon(icon);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        JLabel titre = new JLabel(name);
        JLabel price = new JLabel("$" +prix);

        mario.setLayout(new FlowLayout(FlowLayout.CENTER));//fait en sorte que les composants soient centrés et pas tt petits

        mario.add(titre);
        mario.add(price);   

        mario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedPersonnage = getPersonnageByName(name);
            }
        });
        return mario;
        }


    private Mario getPersonnageByName(String name) {
        switch (name) {
            case "BasicMario":
                return new BasicMario();
            case "FireMario":
                return new FireMario();
            case "WallBrick":
                return new WallBrick();
            case "BigMario":
                return new BigMario();
            case "StarMario":
                return new StarMario();
            default:
                return null;
        }
    }

    public JPanel createPlateau(){
        int taille = 100;
        JPanel Plateau = new JPanel();
         Plateau.setLayout(new GridLayout(10, 6));
        for (int i = 0; i < 10; i++){
            for (int j =0; j <6 ; j++){
                JPanel casePanel = createCase(i, j);
                casePanel.setPreferredSize(new Dimension(taille, taille));


            }
        }

        return Plateau;
    }


    public JPanel createCase(int col , int li){
        JPanel casePanel = new JPanel();

        casePanel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                casePanelClic(li, col);
            }
        });

        return casePanel;
    }

    public void casePanelClic(int li , int col){
        if(selectedPersonnage != null && this.getJeuGUI().getJoueur().getArgent() >= selectedPersonnage.getPrix()){
          Mario mario = getPersonnageByName(selectedPersonnage.getName());
          jeuGUI.getPlateau().placeMario(mario,li,col);

        }

    }
/* 
    public void updatePlateau(){
        for (int i = 0; i < 10; i++){
            for (int j =0; j <6 ; j++){
                JPanel casePanel = createCase(i, j);
                casePanel.setPreferredSize(new Dimension(100, 100));
        
                if(jeuGUI.getPlateau().getCase(i, j).contientPersonnage()){
                    try {
                        ImageIcon icon = new ImageIcon(getClass().getResource(jeuGUI.getPlateau().getCase(i, j).getPersonnage().getImagePath()));
                        JLabel label = new JLabel();
                        label.setIcon(icon);
                        casePanel.add(label);
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

*/
        


    }




    

