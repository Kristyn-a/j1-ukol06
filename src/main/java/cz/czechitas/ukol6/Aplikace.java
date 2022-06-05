package cz.czechitas.ukol6;


import com.formdev.flatlaf.FlatLightLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Aplikace extends JFrame {
    private JLabel husyLabel;

    private JLabel kraliciLabel;

    private JLabel pocetHlavLabel;

    private JLabel pocetNohouLabel;

    private JTextField husyField;
    private JTextField kraliciField;

    private JTextField pocetHlavField;

    private JTextField pocetNohouField;

    private JButton vypocitatButton;


    public static void main(String[] args) {
        FlatLightLaf.setup();
        new Aplikace().start();
    }

    public Aplikace() throws HeadlessException {
        super("Farmářka 1.0");
        this.init();
    }

    public void start() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(Aplikace.class.getResource("czechitas-icon.png")).getImage());
        setLayout(new MigLayout("wrap 2", "[right]rel[50:120:150,grow,fill]"));
        setMinimumSize(new Dimension(250, 200));

        //TODO implementovat formulář podle zadání
        husyField = new JTextField();
        husyLabel = new JLabel("Husy");
        husyLabel.setDisplayedMnemonic('H');
        husyLabel.setLabelFor(husyField);
        add(husyLabel);
        add(husyField);
        husyField.setHorizontalAlignment(JTextField.TRAILING);

        kraliciField = new JTextField();
        kraliciLabel = new JLabel("Králíci");
        kraliciLabel.setDisplayedMnemonic('K');
        kraliciLabel.setLabelFor(kraliciField);
        add(kraliciLabel);
        add(kraliciField);
        kraliciField.setHorizontalAlignment(JTextField.TRAILING);

       vypocitatButton = new JButton("Vypočítat");
       add(vypocitatButton, "center, span");

       pocetHlavField = new JTextField();
       pocetHlavLabel = new JLabel("Počet hlav");
       pocetHlavField.setEnabled(false);
       add(pocetHlavLabel);
       add(pocetHlavField);
       pocetHlavField.setHorizontalAlignment(JTextField.TRAILING);

       pocetNohouField = new JTextField();
       pocetNohouLabel = new JLabel("Počet nohou");
       pocetNohouField.setEnabled(false);
       add(pocetNohouLabel);
       add(pocetNohouField);
       pocetNohouField.setHorizontalAlignment(JTextField.TRAILING);

       vypocitatButton.addActionListener(this::handleVypocitat);

        pack();
    }

    private void handleVypocitat (ActionEvent actionEvent) {

        String husyText = husyField.getText();
        String kraliciText = kraliciField.getText();

        int husyCislo = Integer.parseInt(husyText);
        int kraliciCislo = Integer.parseInt(kraliciText);

        int pocetHlavCislo = (husyCislo + kraliciCislo);
        int pocetNohouCislo = (2 * husyCislo) + (4 * kraliciCislo);

        String pocetHlav = Integer.toString(pocetHlavCislo);
        String pocetNohou = Integer.toString(pocetNohouCislo);

        pocetHlavField.setText(Integer.toString(pocetHlavCislo));
        pocetNohouField.setText(Integer.toString(pocetNohouCislo));







    }


}
