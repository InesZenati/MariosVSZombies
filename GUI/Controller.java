import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
public class Controller extends JPanel{
     private JeuGUI jeuGUI;
    public Controller(){
       
        PlateauGUI plateau = new PlateauGUI(jeuGUI);
        plateau.setVisible(true);
        plateau.spawnZombies();
    }
}
