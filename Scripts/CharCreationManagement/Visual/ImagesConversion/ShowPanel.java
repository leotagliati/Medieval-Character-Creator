package Scripts.CharCreationManagement.Visual.ImagesConversion;

import java.awt.Color;

import javax.swing.JPanel;

public class ShowPanel extends JPanel{

    public ShowPanel()
    {
        this.setBounds(1000, 50, 500, 700);
        this.setBackground(Color.ORANGE);
        this.setLayout(null);
        this.setOpaque(false);
        // this.setOpaque(false);
        this.setVisible(true);
    }
}
