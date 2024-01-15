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
    private Mario selectedPersonnage=null;
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JeuGUI jeuGUI;

    public JeuGUI getJeuGUI(){
       // this.selectedPersonnage=null;
        return this.jeuGUI;
    }
    Font marioFont = loadMarioFont();

    public PlateauGUI(JeuGUI jeuGUI){
        this.jeuGUI = jeuGUI;

        setLayout(new BorderLayout());//pour que le panel soit divisé en 5 parties

        cardLayout = jeuGUI.getCardLayout();

        cardPanel = jeuGUI.getCardPanel();

          // Création du menuPanel à gauche
        menuPanel = createSideMenu();
        add(menuPanel, BorderLayout.WEST);
         menuPanel.setBackground(new Color(205, 55, 35, 255)); 

        

        InfoPanel = createInfoPanel();
        add(InfoPanel,BorderLayout.NORTH);

        // Création du plateauPanel au centre
        plateauPanel = createPlateau();
        add(plateauPanel, BorderLayout.CENTER);

        // Création du terminerPanel en bas
        JPanel terminerPanel = createTerminerPanel();
        add(terminerPanel, BorderLayout.SOUTH);

       // plateauPanel.setBackground(new Color(205, 55, 35, 255)); 
        plateauPanel.setBorder(BorderFactory.createEmptyBorder(60, 50, 70, 80));
        //add background image
      



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
        infoJoueur.setBackground(new Color(205, 55, 35, 255)); 
        // add border
        infoJoueur.setBorder(BorderFactory.createEmptyBorder(20, 30, 10, 10));
        infoJoueur.setLayout(new BoxLayout(infoJoueur, BoxLayout.Y_AXIS));
        JLabel joueurName = new JLabel("Information de : "+this.getJeuGUI().getJoueur().getName()+" ");
        joueurName.setFont(marioFont.deriveFont(Font.PLAIN, 20));
        joueurName.setForeground(Color.WHITE);
        JLabel joueurArgent = new JLabel("Argent : " + this.getJeuGUI().getJoueur().getArgent()+ " ");
        joueurArgent.setFont(marioFont.deriveFont(Font.PLAIN, 20));
        joueurArgent.setForeground(Color.WHITE);
       
        
        infoJoueur.add(joueurArgent);
        joueurArgent.setFont(marioFont.deriveFont(Font.PLAIN, 20));
        joueurArgent.setForeground(Color.WHITE);
        JLabel joeuurScore = new JLabel("Score : "+this.getJeuGUI().getJoueur().getScore()+" points");
        joeuurScore.setFont(marioFont.deriveFont(Font.PLAIN, 20));
        joeuurScore.setForeground(Color.WHITE);
        infoJoueur.add(joueurName);
        infoJoueur.add(joueurArgent);
        infoJoueur.add(joeuurScore);
        return infoJoueur;
    }

    public void updateJoueurInfo(){
        if(InfoPanel!=null){
            InfoPanel.removeAll();
            InfoPanel.setBackground(new Color(205, 55, 35, 255)); 
        // add border
            InfoPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 10, 10));
            InfoPanel.setLayout(new BoxLayout(InfoPanel, BoxLayout.Y_AXIS));
            JLabel joueurName = new JLabel("Information de : "+this.getJeuGUI().getJoueur().getName()+" ");
            joueurName.setFont(marioFont.deriveFont(Font.PLAIN, 20));
            joueurName.setForeground(Color.WHITE);
            JLabel joueurArgent = new JLabel("Argent : " + this.getJeuGUI().getJoueur().getArgent() + " ");
            joueurArgent.setFont(marioFont.deriveFont(Font.PLAIN, 20));
            joueurArgent.setForeground(Color.WHITE);
        
            InfoPanel.add(joueurArgent);
            joueurArgent.setFont(marioFont.deriveFont(Font.PLAIN, 20));
            joueurArgent.setForeground(Color.WHITE);
            JLabel joeuurScore = new JLabel("Score : "+this.getJeuGUI().getJoueur().getScore()+" points");
            GameOverGUI.getScore().setText("TON SCORE : "+this.getJeuGUI().getJoueur().getScore());
            joeuurScore.setFont(marioFont.deriveFont(Font.PLAIN, 20));
            joeuurScore.setForeground(Color.WHITE);
            InfoPanel.add(joueurName);
            InfoPanel.add(joueurArgent);
            InfoPanel.add(joeuurScore);  
            InfoPanel.revalidate();
            InfoPanel.repaint();
            
        }
    }


        public JPanel createTerminerPanel() {
        JPanel terminerPanel = new JPanel();
        JButton terminerButton = new JButton("Terminer");

        // Ajoutez un ActionListener pour gérer l'action du bouton "Terminer"
        terminerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cardLayout.show(cardPanel, "GameOver");
            }
        });

        terminerPanel.add(terminerButton);
        return terminerPanel;
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
                selectedPersonnage = (Mario)getPersonnageByName(name);
                System.out.println(selectedPersonnage);
            }
        });
        return mario;
        }

    public Personnage getPersonnageByName(String name) {
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
            case "ZombieSimple":
                return new Zombie1(1000);
            case "ZombieAmélioré":
                return new Zombie2(1000);
            case "SuperZombie":
                return new Zombie3(1000);
            case "SuperMegaUltraZombie":
                return new Zombie4(1000);
            default:
                return  new BasicMario();
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
        System.out.println("dans casepanelclic" + selectedPersonnage);
        if (selectedPersonnage != null) {
            System.out.println("dans le if" +selectedPersonnage);
            if (!jeuGUI.getPlateau().getCase(li, col).contientMario()) {
                Personnage mario = getPersonnageByName(selectedPersonnage.getName());
                System.out.println("mario créé");
                Mario m = (Mario) mario;
                int solde = jeuGUI.getJoueur().getArgent();
                System.out.println("solde : " + solde);
                int prix = m.getPrix();
                System.out.println("prix : " + prix);
                if (solde >= prix) {
                    jeuGUI.getPlateau().placeMario(m, li, col);
                    System.out.println(m.toString());
                    System.out.println("mario placé");
                    updatePlateau();
                }
            }
        }
    }
    

    public void updatePlateau() {
        updateJoueurInfo();
        if (plateauPanel != null) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 9; j++) {
                    JPanel casePanel = getCasePanel(i, j);
    
                    // Supprimer tous les composants du panneau
                    casePanel.removeAll();
    
                    // Ajouter un gestionnaire de disposition (FlowLayout)
                    casePanel.setLayout(new FlowLayout());
    
                    if (jeuGUI.getPlateau().getCase(i, j).contientPersonnage()) {
                        try {
                            ImageIcon icon = new ImageIcon(getClass().getResource(getPersonnageByName(jeuGUI.getPlateau().getPersonnageAt(i, j).getName()).getImagePath()));
                            Image image = icon.getImage();
                            int cellSize = 100; // Set the cell size here
                            Image scaledImage = image.getScaledInstance(cellSize, cellSize, Image.SCALE_SMOOTH);
                            JLabel label = new JLabel();
                            label.setIcon(icon);
                            casePanel.add(new JLabel(new ImageIcon(scaledImage)));
                        } catch (NullPointerException e) {
                            e.printStackTrace();
                            System.out.println("pas d'image");
                        }
                    }
    
                    // Revalider le panneau après modification
                    casePanel.revalidate();
                    casePanel.repaint();  // Assurez-vous de redessiner le panneau pour voir les changements
                    jeuGUI.getPlateau().affiche();
                }
            }
        } else {
            System.out.println("error");
        }
    }
    
    

    
    
    private JPanel getCasePanel(int li, int col) {
        return (JPanel) plateauPanel.getComponent(li * 9 + col);
    }

    public void partieFinish(){
        Thread partieOver = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    if(jeuGUI.getPlateau().getPartieStatus()!=0){
                        spawnZombies(2);
                        System.out.println("Partie terminée");
                        if (jeuGUI.getPlateau().getPartieStatus()==1){
                           //call func gamewin
                        }else if(jeuGUI.getPlateau().getPartieStatus()==2){
                            //call func gameover
                        }
                        break;
                    }
                }
            }
        });
        partieOver.start();
        }
    

    public void spawnZombies(int i){
        sleep(1000);
        ZombieThread zombieThread = new ZombieThread(this);
        AttaqueThread attaqueZombies= new AttaqueThread(this);
        MoveThread moveThread = new MoveThread(this);

        if(i ==1){
            zombieThread.start();
            attaqueZombies.start();
            moveThread.start();
        }else if(i==2){
            zombieThread.stopThread();
            attaqueZombies.stopThread();
            moveThread.stopThread();
        
            //cardLayout.show(cardPanel, "GameOver");
           
        }
        
    }

    public void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public Personnage getSelectedPersonnage(){
        return this.selectedPersonnage;
    }

    private Font loadMarioFont() {
        try {
            File fontFile = new File("fonts/SuperMario256.ttf");
            return Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(14f);
        } catch (Exception e) {
            e.printStackTrace();
            // En cas d'erreur, utilisez la police par défaut
            return new Font("SansSerif", Font.PLAIN, 14);
        }
    }
    }




    

