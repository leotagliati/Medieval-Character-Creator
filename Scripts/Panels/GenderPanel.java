package Scripts.Panels;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GenderPanel {
    public JButton maleButton, femaleButton;
    private JPanel genderPanel;
    private ArrayList<JButton> gendersButtonArrayList = new ArrayList<>();

    public GenderPanel()
    {
        // Inicializa os Botoes
        this.maleButton = new JButton("Male");
        this.femaleButton = new JButton("Female");

        // Add os botoes no arrayList
        this.gendersButtonArrayList.add(femaleButton);
        this.gendersButtonArrayList.add(maleButton);

        // Inicializa o painel
        this.genderPanel = new JPanel();
        this.genderPanel.setBounds(400, 150, 300, 500);
        this.genderPanel.setBackground(Color.RED);
        this.genderPanel.setLayout(null);

        for (JButton jButton : this.gendersButtonArrayList) {
            this.genderPanel.add(jButton);
        }
        this.genderPanel.setVisible(false);
        
        for(int i = 0; i < this.gendersButtonArrayList.size(); i++)
        {
            this.gendersButtonArrayList.get(i).setBounds(50,20 + (i*60),200,50);
        }
    }
    public JPanel getPanel() {
        return genderPanel;
    }
    public ArrayList<JButton> getButtonsArray() {
        return gendersButtonArrayList;
    }
}
