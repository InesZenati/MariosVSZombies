import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;


public class PlateauGUI extends JPanel{
    private JPanel plateauPanel;
    private JPanel menuPanel;
    private JPanel InfoPanel;
    private JPanel terminerPanel;
    private Mario selectedPersonnage=null;
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JeuGUI jeuGUI;

    public JeuGUI getJeuGUI(){
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

        

        InfoPanel = createInfoPanel();
        add(InfoPanel,BorderLayout.NORTH);

        // Création du plateauPanel au centre
        plateauPanel = createPlateau();
        add(plateauPanel, BorderLayout.CENTER);

        // Création du terminerPanel en bas
       terminerPanel = createTerminerPanel();
        add(terminerPanel, BorderLayout.SOUTH);

       // plateauPanel.setBackground(new Color(205, 55, 35, 255)); 
        plateauPanel.setBorder(BorderFactory.createEmptyBorder(60, 50, 70, 80));
        //add background image
      



    }

    private JPanel createSideMenu() {
        JPanel sideMenu = new JPanel();
        Plateau p = new Plateau();
        List<Mario> l = p.listeMario();
        
        sideMenu.setLayout(new BoxLayout(sideMenu, BoxLayout.Y_AXIS));

        sideMenu.add(createTowerButton("BasicMario", "BasicMario.png", l.get(0).getPrix())); 
        sideMenu.add(createTowerButton("FireMario", "FireMario.png", l.get(2).getPrix()));
        sideMenu.add(createTowerButton("WallBrick", "WallBrick.png", l.get(1).getPrix())); 
        sideMenu.add(createTowerButton("BigMario", "BigMario.png", l.get(3).getPrix()));
        sideMenu.add(createTowerButton("StarMario", "StarMario.png", l.get(4).getPrix()));

        return sideMenu;
    }

    public void updateterminerPanel(){
        if(setJeu.getSelectedDecor().equals("Basic")){
            terminerPanel.setBackground(new Color(205, 55, 35, 255));
        }else if(setJeu.getSelectedDecor().equals("Nouveau")){
            terminerPanel.setBackground(Color.PINK);
        }
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
            if(setJeu.getSelectedDecor().equals("Basic")){
                InfoPanel.setBackground(new Color(205, 55, 35, 255)); 
            }else if(setJeu.getSelectedDecor().equals("Nouveau")){
                InfoPanel.setBackground(Color.PINK);
            }
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
            GameWinGUI.getScore().setText("TON SCORE : "+this.getJeuGUI().getJoueur().getScore());
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
        JButtonStyled terminerButton = new JButtonStyled("Terminer");

        // Ajoutez un ActionListener pour gérer l'action du bouton "Terminer"
        terminerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jeuGUI.getPlateau().getPartieStatus()==2){
                   cardLayout.show(cardPanel, "GameWin");
                   System.out.println(jeuGUI.getPlateau().getPartieStatus());
                }else if(jeuGUI.getPlateau().getPartieStatus()==1){ 
                cardLayout.show(cardPanel, "GameOver");
                System.out.println(jeuGUI.getPlateau().getPartieStatus());
            }
            System.out.println(jeuGUI.getPlateau().getPartieStatus());
        }
        });
    


        terminerPanel.add(terminerButton);
        return terminerPanel;
    }

    public void updateSideMenu(){
        if(setJeu.getSelectedDecor().equals("Basic")){
            menuPanel.setBackground(new Color(205, 55, 35, 255));
        }else if(setJeu.getSelectedDecor().equals("Nouveau")){
            menuPanel.setBackground(Color.PINK);
        }
    }

    public JButton createTowerButton(String name , String imagePath, int prix){
        JButton mario = new JButton();
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource(imagePath));
            Image originalImage = icon.getImage();
            int newSize = 70; 
            Image resizedImage = originalImage.getScaledInstance(newSize, newSize, Image.SCALE_SMOOTH);
    
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            mario.setIcon(resizedIcon);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        JLabel titre = new JLabel(name);
        JLabel price = new JLabel("$" +prix);

        mario.setLayout(new FlowLayout(FlowLayout.CENTER));

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
            case "ZombieAmeliore":
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
        int taille = 200;
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
        updateSideMenu();
        updateterminerPanel();
        if (setJeu.getSelectedDecor().equals("Basic")) {
            plateauPanel.setBackground(new Color(205, 55, 35, 255));
        } else if (setJeu.getSelectedDecor().equals("Nouveau")) {
            plateauPanel.setBackground(Color.PINK);
        } else {
            plateauPanel.setBackground(Color.GREEN);
        }
        if (plateauPanel != null) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 9; j++) {
                    JPanel casePanel = getCasePanel(i, j);
                    if (setJeu.getSelectedDecor().equals("Basic")) {
                        if ((i + j) % 2 == 0) {
                            casePanel.setBackground(new Color(205, 55, 35, 255));
                        } else {
                            casePanel.setBackground(Color.WHITE);
                        }
                    } else if (setJeu.getSelectedDecor().equals("Nouveau")) {
                        if ((i + j) % 2 == 0) {
                            casePanel.setBackground(Color.PINK);
                        } else {
                            casePanel.setBackground(Color.WHITE);
                        }
                    }
    
                    // Supprimer tous les composants du panneau
                    casePanel.removeAll();
    
                    // Ajouter un gestionnaire de disposition (FlowLayout)
                    casePanel.setLayout(new FlowLayout());
    
                    if (jeuGUI.getPlateau().getCase(i, j).contientPersonnage()) {
                        try {
                            ImageIcon icon = new ImageIcon(getClass().getResource(getPersonnageByName(jeuGUI.getPlateau().getPersonnageAt(i, j).getName()).getImagePath()));
                            Image image = icon.getImage();
                            int cellSize = 86; // Set the cell size here
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
                    casePanel.repaint();
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
                        if (jeuGUI.getPlateau().getPartieStatus()==1){//1 =On a perdu
                            cardLayout.show(cardPanel, "GameOver");
                        }else if(jeuGUI.getPlateau().getPartieStatus()==2){//2=On a gagner
                            cardLayout.show(cardPanel, "GameWin");
                        }
                        cardLayout.show(cardPanel, "GameOver");
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
    private class JButtonStyled extends JButton {
        public JButtonStyled(String text) {
            super(text);
            setFocusPainted(false);
            setContentAreaFilled(false);
            setOpaque(true);
            setForeground(Color.WHITE);
            setBackground(new Color(255, 138, 119)); // Couleur orange
            setFont(getFont().deriveFont(Font.BOLD, 16));
            setBorderPainted(false);
            setCursor(new Cursor(Cursor.HAND_CURSOR));
            setPreferredSize(new Dimension(200, 50));
            addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    setBackground(new Color(109, 7, 26));
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    setBackground(new Color(255, 138, 119));
                }
            });
        }
    }
    
    }




    
