package Scripts.Panels;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MainPanel {
    public JButton charNameButton, charGenderButton, charClassButton, charAppearenceButton, charBuildButton;
	private ArrayList<JButton> mainButtons = new ArrayList<JButton>();
    private JPanel buttonsPanel;

    
    public MainPanel()
    {
        // Inicializa os Botoes
        this.charNameButton = new JButton("Name");
        this.charClassButton = new JButton("Class");
        this.charGenderButton = new JButton("Gender");
        this.charAppearenceButton = new JButton("Appearence");
        this.charBuildButton = new JButton("Build");
        
        // Add os botoes no arrayList
        this.mainButtons.add(charNameButton);
        this.mainButtons.add(charGenderButton);
        this.mainButtons.add(charClassButton);
        this.mainButtons.add(charAppearenceButton);
        
        // Set Posicao dos botoes
        for(int i = 0; i < this.mainButtons.size(); i++)
        {
            mainButtons.get(i).setBounds(50,20 + (i*60),200,50);
        }
        
        // Set design dos botoes
        for (JButton jButton : this.mainButtons) {
            jButton.setFont(new Font("Jet Brains Mono", Font.PLAIN, 15));
			jButton.setFocusable(false);
        }
        
        this.buttonsPanel = new JPanel();
		this.buttonsPanel.setBounds(50, 150, 300, 500);
        this.buttonsPanel.setBackground(Color.BLACK);
		this.buttonsPanel.setLayout(null);
        
        
        for(int i = 0; i < mainButtons.size(); i++)
        {
            buttonsPanel.add(mainButtons.get(i));
        }
    }
    public ArrayList<JButton> getMainButtons() {
        return mainButtons;
    }
    public JPanel getButtonsPanel() {
        return buttonsPanel;
    }
}
