package Scripts.Panels;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ClassPanel extends JPanel {
    public JButton knightClassButton, heraldClassButton, sorcererClassButton, clericClassButton;
    private ArrayList<JButton> classesButtons = new ArrayList<JButton>();

    private static String classChosen;

    
    public ClassPanel() {
        super();
        
        this.knightClassButton = new JButton("Knight");
        this.heraldClassButton = new JButton("Herald");
        this.sorcererClassButton = new JButton("Sorcerer");
        this.clericClassButton = new JButton("Cleric");
        
        this.classesButtons.add(knightClassButton);
        this.classesButtons.add(heraldClassButton);
        this.classesButtons.add(sorcererClassButton);
        this.classesButtons.add(clericClassButton);
        
        GridLayout buttonsLayout = new GridLayout();
        buttonsLayout.setColumns(1);
        buttonsLayout.setRows(this.classesButtons.size());
        buttonsLayout.setVgap(30);
        
        this.setBounds(450, 250, 250, 400);
        this.setBackground(Color.BLUE);
        this.setLayout(buttonsLayout);
        
        for (JButton jButton : this.classesButtons) {
            this.add(jButton);
        }
        
        this.setVisible(false);
        
        for (JButton jButton : classesButtons) {
            
            // for (int i = 0; i < this.classesButtons.size(); i++) {
                // this.classesButtons.get(i).setBounds(50, 200 + (i * 60), 200, 50);
                jButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        for (JButton jButton : classesButtons) {
                            if (e.getSource() == jButton) {
                                classChosen = jButton.getText();
                                setVisible(false);
                                ChosenAttPanel.getPanel().setVisible(true);
                                ChosenAttPanel.updatePanel(NamePanel.getNameChosen(), GenderPanel.getGenderChosen(), classChosen);
                                // JOptionPane.showMessageDialog(jButton, classChosen);
                            }
                        }
                    }
                    
                });
                
            }
            
        }
        
        public ArrayList<JButton> getButtonsArray() {
            return classesButtons;
        }
        public static String getClassChosen() {
            return classChosen;
        }
    }
    