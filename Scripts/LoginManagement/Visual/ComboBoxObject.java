package Scripts.LoginManagement.Visual;

import java.awt.FlowLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.Icon;
import javax.swing.ImageIcon;

@SuppressWarnings("rawtypes")
public class ComboBoxObject extends JComboBox {
    private static String names[] = { "1.gif", "2.gif" };

    @SuppressWarnings("unchecked")
    public ComboBoxObject() {
        super(names);
        this.setMaximumRowCount(2); // Mostra 3 linhas
    }
}
