package Scripts.Panels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GenderPanel {
    public JButton maleButton, femaleButton;
    private JPanel genderPanel;
    private ArrayList<JButton> gendersButtonArrayList = new ArrayList<>();

    private String genderChosen;

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
            this.gendersButtonArrayList.get(i).addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    for (JButton jButton : gendersButtonArrayList) {
                        if (e.getSource() == jButton) {
                            genderChosen = jButton.getText();
                            genderPanel.setVisible(false);
                            ChosenAttPanel.getPanel().setVisible(true);
                            // JOptionPane.showMessageDialog(jButton, genderChosen);
                        }
                    }
                }

            });
        }
        
    }
    public JPanel getPanel() {
        return genderPanel;
    }
    public ArrayList<JButton> getButtonsArray() {
        return gendersButtonArrayList;
    }
}
