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
    private int Argent = 10000;
    private static Mario selectedPersonnage;
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JeuGUI jeuGUI;

    public JeuGUI getJeuGUI(){
        this.selectedPersonnage=null;
        return this.jeuGUI;
    }


    public PlateauGUI(JeuGUI jeuGUI){
        this.jeuGUI = jeuGUI;

        setLayout(new BorderLayout());//pour que le panel soit divisé en 5 parties

          // Création du menuPanel à gauche
        menuPanel = createSideMenu();
        add(menuPanel, BorderLayout.WEST);


        InfoPanel = createInfoPanel();
        add(InfoPanel,BorderLayout.NORTH);

        // Création du plateauPanel au centre
        plateauPanel = createPlateau();
        add(plateauPanel, BorderLayout.CENTER);
        plateauPanel.setBorder(BorderFactory.createEmptyBorder(50, 30, 50, 60));


    }

    private JPanel createSideMenu() {
        JPanel sideMenu = new JPanel();

        sideMenu.setLayout(new BoxLayout(sideMenu, BoxLayout.Y_AXIS));

        sideMenu.add(createTowerButton("BasicMario", "BasicMario.png", 10)); 
        sideMenu.add(createTowerButton("FireMario", "FireMario.png", 20));
        sideMenu.add(createTowerButton("WallBrick", "BasicMario.png", 25)); 
        sideMenu.add(createTowerButton("BigMario", "BigMario.png", 50));
        sideMenu.add(createTowerButton("StarMario", "SuperMario.png", 100));

        return sideMenu;
    }

    public JPanel createInfoPanel(){
        JPanel infoJoueur = new JPanel();
        infoJoueur.setLayout(new BoxLayout(infoJoueur, BoxLayout.Y_AXIS));
        JLabel joueurName = new JLabel("Information de : "+this.getJeuGUI().getJoueur().getName()+" ");
        JLabel joueurArgent = new JLabel("Argent : "+this.Argent+" coin ");
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
                System.out.println(selectedPersonnage.getName());
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

    public JPanel createPlateau() {
        int taille = 100;
        JPanel Plateau = new JPanel();
        Plateau.setLayout(new GridLayout(5, 9));
    
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                JPanel casePanel = createCase(i, j);
                casePanel.setPreferredSize(new Dimension(taille, taille));
                Plateau.add(casePanel);
            }
        }
    
        return Plateau;
    }
    

    public JPanel createCase(int li , int col){
        JPanel casePanel = new JPanel();
        casePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        casePanel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                casePanelClic(li, col);
            }
        });

        return casePanel;
    }

    public void casePanelClic(int li, int col) {
        if (selectedPersonnage != null) {
            if (!jeuGUI.getPlateau().getCase(li, col).contientPersonnage()) {
                Mario mario = getPersonnageByName(selectedPersonnage.getName());
                System.out.println("mario creer");
                if (this.getJeuGUI().getJoueur().getArgent() >= mario.getPrix()) {
                    jeuGUI.getPlateau().placeMario(mario, li, col);
                    System.out.println("mario place");
                    updatePlateau();
                } else {
                    System.out.println("Argent insuffisant pour acheter ce Mario.");
                }
            } else {
                System.out.println("La case est déjà occupée par un Mario.");
            }
        }
    }

    public void updatePlateau() {
        if (plateauPanel != null) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 9; j++) {
                    JPanel casePanel = getCasePanel(i, j);
                    casePanel.removeAll();
    
                    if (jeuGUI.getPlateau().getCase(i, j).contientPersonnage()) {
                        try {
                            ImageIcon icon = new ImageIcon(getClass().getResource(getPersonnageByName(jeuGUI.getPlateau().getPersonnageAt(i, j).getName()).getImagePath()));
                            Image image = icon.getImage();
                            JLabel label = new JLabel();
                            label.setIcon(icon);
                            casePanel.add(new JLabel(new ImageIcon(image)));
                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }
                    }
                    casePanel.revalidate();
                }
            }
        } else {
            System.out.println("error");
        }
    }

    
    
    private JPanel getCasePanel(int li, int col) {
        return (JPanel) plateauPanel.getComponent(li * 9 + col);
    }



    public void spawnZombies(){
     //   System.out.println("spawnZombies");
        ZombieThread zombieThread = new ZombieThread(this);
      //  System.out.println("spawnZombies");
        zombieThread.start();
        
    }
    

    }




    

