import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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


    public PlateauGUI(CardLayout cardLayout , JPanel cardPanel){
        this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;

          // Création du menuPanel à gauche
      menuPanel = createSideMenu();
      add(menuPanel, BorderLayout.WEST);

        // Création du plateauPanel au centre
    plateauPanel = createPlateau();
    add(plateauPanel, BorderLayout.CENTER);

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
        JPanel Plateau = new JPanel();
        for (int i = 0; i < 10; i++){
            for (int j =0; j <6 ; j++){
                

            }
        }
        bacJPanel.setLayout(new GridLayout(10, 6));

    }

    public JPanel creatCase(){
        JPanel case = new JPanel();

    }


        


    }




    

