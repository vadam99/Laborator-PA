/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laborator6;

import javax.swing.*;

/**
 *
 * @author vadam
 */
public class ConfigPanel extends JPanel {

    final MainFrame frame;
    JLabel sidesLabel;
    JSpinner sidesField;
    JComboBox colorCombo;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        sidesLabel = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(6);
        String[] valori = new String[10];
        valori[0] = "Random";
        valori[1] = "Black";

        colorCombo = new JComboBox(valori);

        add(sidesLabel);
        add(sidesField);
        add(colorCombo);
    }

    int getValoare() {
        return (int) sidesField.getValue();
    }
}
