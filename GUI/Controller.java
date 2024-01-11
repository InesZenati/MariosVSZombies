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
    private PlateauGUI plateauGUI;
    private Plateau plateau;
    private JeuGUI jeuGUI;
  
    public Controller(PlateauGUI plateauGUI, Plateau plateau, JeuGUI jeuGUI){
        this.plateauGUI = plateauGUI;
        this.plateau = plateau;
        this.jeuGUI = jeuGUI;
       
    }

    public void debut(){
        plateauGUI.spawnZombies(1);
        
    }

}
