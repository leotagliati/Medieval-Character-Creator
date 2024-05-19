package Scripts.Panels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GenderPanel extends JPanel{
    public JButton maleButton, femaleButton;
    private ArrayList<JButton> gendersButtonArrayList = new ArrayList<>();

    public static String genderChosen;

    public GenderPanel()
    {
        super();
        // Inicializa os Botoes
        this.maleButton = new JButton("Male");
        this.femaleButton = new JButton("Female");
        
        // Add os botoes no arrayList
        this.gendersButtonArrayList.add(femaleButton);
        this.gendersButtonArrayList.add(maleButton);
        
        // Inicializa o painel
        this.setBounds(400, 150, 300, 500);
        this.setBackground(Color.RED);
        this.setLayout(null);
        
        for (JButton jButton : this.gendersButtonArrayList) {
            this.add(jButton);
        }
        this.setVisible(false);
        
        for(int i = 0; i < this.gendersButtonArrayList.size(); i++)
        {
            this.gendersButtonArrayList.get(i).setBounds(50,20 + (i*60),200,50);
            this.gendersButtonArrayList.get(i).addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (JButton jButton : gendersButtonArrayList) {
                        if (e.getSource() == jButton) {
                            genderChosen = jButton.getText();
                            setVisible(false);
                            ChosenAttPanel.getPanel().setVisible(true);
                            ChosenAttPanel.updatePanel(NamePanel.getNameChosen(), GenderPanel.getGenderChosen(), ClassPanel.getClassChosen());
                            // JOptionPane.showMessageDialog(jButton, genderChosen);
                        }
                    }
                }
                
            });
        }
        
    }
    public ArrayList<JButton> getButtonsArray() {
        return gendersButtonArrayList;
    }
    public static String getGenderChosen() {
        return genderChosen;
    }
}
