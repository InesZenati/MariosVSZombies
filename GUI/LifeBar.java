import javax.swing.*;
import java.awt.*;

public class LifeBar extends JPanel {
    private int maxHealth;
    private int currentHealth;

    public LifeBar(int maxHealth) {
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        setPreferredSize(new Dimension(100, 20)); // Adjust the size as needed
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        // Draw background
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, width, height);

        // Draw life bar
        int barWidth = (int) ((double) currentHealth / maxHealth * width);
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, barWidth, height);

        // Draw border
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, width - 1, height - 1);
    }
}
