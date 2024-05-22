package Scripts.Panels;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class NamePanel{

    private JTextField nameTextField;
    private JPanel namePanel;
    public NamePanel()
    {
        this.nameTextField = new JTextField();
        this.nameTextField.setBounds(25,10,250,40);
        this.nameTextField.setFont(new Font("Jet Brains Mono", Font.PLAIN, 30));
        this.nameTextField.setHorizontalAlignment(JTextField.CENTER);
        this.nameTextField.setEditable(false);
        this.nameTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                nameTextField.setEditable(true);
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
