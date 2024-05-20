package Scripts.Panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NamePanel extends JPanel {

    private JTextField nameTextField;
    public static String nameChosen;

    
    public NamePanel() {
        
        super();
        this.nameTextField = new JTextField("Entry incomplete");
        this.nameTextField.setBounds(50, 20, 250, 40);
        this.nameTextField.setFont(new Font("Adobe Garamond Pro", Font.PLAIN, 25));
        this.nameTextField.setHorizontalAlignment(JTextField.CENTER);
        this.nameTextField.setOpaque(false);
        this.nameTextField.setBorder(null);
        this.nameTextField.setForeground(Color.RED);
        this.nameTextField.setEditable(false);
        this.nameTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                nameTextField.setEditable(true);
                if (nameTextField.getText().equals("Entry incomplete")) {
                    nameTextField.setText("");
                }
                System.out.println("aaa");
                nameTextField.setForeground(Color.WHITE);
            }
        });
        this.nameTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    if (nameTextField.getText().equals("")) {
                        nameTextField.setForeground(Color.RED);
                        nameTextField.setText("Entry incomplete");
                    }
                    else
                    {
                        nameTextField.setEditable(false);
                        nameChosen = nameTextField.getText();
                        ChosenAttPanel.updatePanel(NamePanel.getNameChosen(), GenderPanel.getGenderChosen(), ClassPanel.getClassChosen());
                    }
                    setVisible(false);
                    ChosenAttPanel.getPanel().setVisible(true);
                }
            }
            
        });
        this.nameTextField.setVisible(true);
        
        this.setBounds(500, 150, 350, 500);
        this.setBackground(Color.ORANGE);
        this.setLayout(null);
        this.add(this.nameTextField);
        this.setVisible(false);
    }

    public JTextField getNameTextField() {
        return nameTextField;
    }
    public void setNameTextField(JTextField nameTextField) {
        this.nameTextField = nameTextField;
    }
    public static String getNameChosen() {
        return nameChosen;
    }
    
}
