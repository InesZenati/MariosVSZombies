import javax.swing.*;
import java.awt.*;
public class Controller extends JPanel{
    private PlateauGUI plateauGUI;
    private Plateau plateau;
    private JeuGUI jeuGUI;
  
    public Controller(PlateauGUI plateauGUI, Plateau plateau, JeuGUI jeuGUI){
        this.plateauGUI = plateauGUI;
        this.plateau = plateau;
        this.jeuGUI = jeuGUI;
       
    }

    public PlateauGUI getPlateauGUI(){
        return plateauGUI;
    }

    public void debut(){
        plateauGUI.spawnZombies(1);
        plateauGUI.partieFinish();

        
    }

}
