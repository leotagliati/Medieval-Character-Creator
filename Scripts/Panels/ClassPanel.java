package Scripts.Panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Scripts.ImageCreate;

public class ClassPanel extends JPanel {
    public JButton knightClassButton, heraldClassButton, sorcererClassButton, clericClassButton;
    private ArrayList<JButton> classButtons = new ArrayList<JButton>();
    private ArrayList<JLabel> buttonsImage = new ArrayList<JLabel>();
    private JPanel backgJPanel;


    
    private static String classChosen;
    
    public ClassPanel() {
        super();
        // Inicializa os Botoes
        this.knightClassButton = new JButton("Knight");
        this.heraldClassButton = new JButton("Herald");
        this.sorcererClassButton = new JButton("Sorcerer");
        this.clericClassButton = new JButton("Cleric");
        
        // Add os botoes no arrayList
        this.classButtons.add(knightClassButton);
        this.classButtons.add(heraldClassButton);
        this.classButtons.add(sorcererClassButton);
        this.classButtons.add(clericClassButton);
        
        GridLayout buttonsLayout = new GridLayout();
        buttonsLayout.setColumns(1);
        buttonsLayout.setRows(this.classButtons.size());
        buttonsLayout.setVgap(30);
        
        // Inicializa as molduras dos botoes
        for (int i = 0; i < this.classButtons.size(); i++) {
            ImageCreate backgroundImage = new ImageCreate(0, 0, 350, 100);
            backgroundImage.setAlignment(JLabel.CENTER, JLabel.CENTER);
            backgroundImage.setIconFile("Images\\underName.png");
            backgroundImage.imageSetter();
            buttonsImage.add(backgroundImage);
        }
        for (JButton jButton : this.classButtons) {
            jButton.setFont(new Font("Adobe Garamond Pro", Font.ITALIC, 25));
            jButton.setForeground(Color.WHITE);
            jButton.setOpaque(true);
            jButton.setContentAreaFilled(false);
            jButton.setBorderPainted(false);
            jButton.setFocusable(false);
        }
        
        this.backgJPanel = new JPanel();
        this.backgJPanel.setLayout(buttonsLayout);
        this.backgJPanel.setBounds(500, 200, 350, 400);
        this.backgJPanel.setOpaque(false);
        this.backgJPanel.setBackground(Color.GREEN);
        this.backgJPanel.setVisible(false);
        
        this.setLayout(buttonsLayout);
        this.setBounds(500, 200, 350, 400);
        this.setOpaque(false);
        this.setBackground(Color.BLUE);
        
        for (JButton jButton : this.classButtons) {
            this.add(jButton);
        }
        for (JLabel jLabel : buttonsImage) {
            backgJPanel.add(jLabel);
        }
        
        this.backgJPanel.setVisible(false);
        this.setVisible(false);
        
        for (JButton jButton : classButtons) {
            
            jButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (JButton jButton : classButtons) {
                        if (e.getSource() == jButton) {
                            classChosen = jButton.getText();
                            setVisible(false);
                            ChosenAttPanel.getPanel().setVisible(true);
                            ChosenAttPanel.updatePanel(NamePanel.getNameChosen(), GenderPanel.getGenderChosen(),
                            classChosen);
                            // JOptionPane.showMessageDialog(jButton, classChosen);
                        }
                    }
                }
                
            });
        }
        
    }
    
    public ArrayList<JButton> getButtonsArray() {
        return classButtons;
    }
    
    public static String getClassChosen() {
        return classChosen;
    }
    public JPanel getBackgJPanel() {
        return backgJPanel;
    }
}
