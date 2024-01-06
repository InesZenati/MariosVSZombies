import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NiveauDeDifficulte extends JFrame {

        public NiveauDeDifficulte() {
            setTitle("Sélection de Niveau");
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fermer seulement cette fenêtre
            setSize(300, 200);
          //  setLocationRelativeTo(MenuGUI.this); // Centrer par rapport à la fenêtre principale

            // Créer un panneau pour la sélection de niveau
            JPanel difficultyPanel = new JPanel();
            difficultyPanel.setLayout(new BoxLayout(difficultyPanel, BoxLayout.Y_AXIS));// aligné horizontalement au centre
            JLabel difficultyLabel = new JLabel("Sélectionnez le Niveau de Difficulté");
            difficultyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            difficultyPanel.add(difficultyLabel);

            // Ajouter des boutons pour les différents niveaux de difficulté
            String[] difficultyOptions = {"Facile", "Moyen", "Difficile"};
            for (String difficulty : difficultyOptions) {
                JButton difficultyButton = new JButton(difficulty);
                difficultyButton.setAlignmentX(Component.CENTER_ALIGNMENT);
                difficultyButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Ajoutez ici le code pour traiter la sélection du niveau de difficulté
                        JOptionPane.showMessageDialog(NiveauDeDifficulte.this, "Niveau sélectionné : " + difficulty);
                        dispose(); // Ferme la fenêtre après la sélection
                    }
                });
                difficultyPanel.add(difficultyButton);
            }

            // Ajouter le panneau de sélection de niveau à la fenêtre
            add(difficultyPanel);

            // Rend la fenêtre visible
            setVisible(true);
        }
    }

    // ... (méthode main inchangée)
