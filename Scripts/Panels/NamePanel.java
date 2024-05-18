package Scripts.Panels;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class NamePanel{

    private JTextField nameTextField;
    private JPanel namePanel;
    public NamePanel()
    {
        this.nameTextField = new JTextField("Entry incomplete");
        this.nameTextField.setBounds(25,20,250,40);
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
                if(nameTextField.getText().equals("Entry incomplete"))
                {
                    nameTextField.setText("");
                }
                nameTextField.setForeground(Color.WHITE);
            }
        });
        this.nameTextField.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e){
            if(e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_ESCAPE)
            {
                if(nameTextField.getText().equals(""))
                {
                    nameTextField.setForeground(Color.RED);
                    nameTextField.setText("Entry incomplete");
                }
                nameTextField.setEditable(false);
            }
        }
            
        });
        this.nameTextField.setVisible(true);
        
        
        this.namePanel = new JPanel();
		this.namePanel.setBounds(400, 150, 300, 500);
        this.namePanel.setBackground(Color.ORANGE);
        this.namePanel.setLayout(null);
        this.namePanel.add(this.nameTextField);
        this.namePanel.setVisible(false);
    }
    public JTextField getNameTextField() {
        return nameTextField;
    }
    public void setNameTextField(JTextField nameTextField) {
        this.nameTextField = nameTextField;
    }
    public JPanel getPanel() {
        return namePanel;
    }
    public void setNamePanel(JPanel namePanel) {
        this.namePanel = namePanel;
    }
    
}
