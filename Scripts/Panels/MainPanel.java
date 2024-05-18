package Scripts.Panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;

public class MainPanel {
    public JButton charNameButton, charGenderButton, charClassButton, charAppearenceButton, charBuildButton;
	private ArrayList<JLabel> buttonsImageLabel = new ArrayList<JLabel>();
    private ArrayList<JButton> mainButtons = new ArrayList<JButton>();
    private JPanel buttonsPanel;
    private JPanel backgJPanel;
    
    
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
        
        GridLayout buttonsLayout = new GridLayout();
        buttonsLayout.setColumns(1);
        buttonsLayout.setRows(this.mainButtons.size());
        buttonsLayout.setVgap(20);
        
        for(int i = 0; i < this.mainButtons.size(); i++)
        {
            JLabel backgButtonLabel = new JLabel();
            backgButtonLabel.setLayout(null);
            backgButtonLabel.setBounds(0, 0 + (i*130),300,100);
            backgButtonLabel.setHorizontalAlignment(SwingConstants.CENTER);
            backgButtonLabel.setVerticalAlignment(SwingConstants.CENTER);
            backgButtonLabel.setIcon(new ImageIcon("Images\\button.png"));
            backgButtonLabel.setVisible(true);
            buttonsImageLabel.add(backgButtonLabel);
        }
        
        // Set design dos botoes
        for (JButton jButton : this.mainButtons) {
            jButton.setFont(new Font("Adobe Garamond Pro", Font.PLAIN, 28));
            jButton.setForeground(Color.WHITE);
            jButton.setOpaque(true);
            jButton.setContentAreaFilled(false);
            jButton.setBorderPainted(false);
            jButton.setFocusable(false);
        }
        
        this.backgJPanel = new JPanel();
        this.backgJPanel.setLayout(null);
		this.backgJPanel.setBounds(50, 150, 300, 500);
        this.backgJPanel.setOpaque(false);
        this.backgJPanel.setBackground(Color.GREEN);
        
        this.buttonsPanel = new JPanel();
        this.buttonsPanel.setLayout(buttonsLayout);
		this.buttonsPanel.setBounds(75, 150, 250, 500);
        this.buttonsPanel.setOpaque(false);
        this.buttonsPanel.setBackground(Color.RED);
        
        
        for(int i = 0; i < mainButtons.size(); i++)
        {
            buttonsPanel.add(mainButtons.get(i));
        }
        for (JLabel jLabel : buttonsImageLabel) {
            backgJPanel.add(jLabel);
        }
    }
    public ArrayList<JButton> getMainButtons() {
        return mainButtons;
    }
    public JPanel getButtonsPanel() {
        return buttonsPanel;
    }
    public JPanel getBackgJPanel() {
        return backgJPanel;
    }
    public ArrayList<JLabel> getButtonsImageLabel() {
        return buttonsImageLabel;
    }
}
