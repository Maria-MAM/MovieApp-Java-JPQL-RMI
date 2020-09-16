package client.gui;

import client.controller.ActorController;
import client.controller.RegizorController;
import lib.dto.ActorDto;
import lib.dto.LocNastereDto;
import lib.dto.RegizorDto;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;

public class ActorRegizorFrame extends JFrame {
    public static final String DateFormat = "dd/MM/yyyy";
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JPanel actorPanel;
    private JPanel regizorPanel;
    private JTextField actorNumeTextField;
    private JTextField actorTaraTextField;
    private JTextField actorOrasTextField;
    private JButton adaugaActorButton;
    private JTextField regizorNumeTextField;
    private JTextField regizorDataNastereTextField;
    private JTextField regizorOrasTextField;
    private JTextField regizorTaraTextField;
    private JTextField regizorPetsTextField;
    private JRadioButton daRadioButton;
    private JRadioButton nuRadioButton;
    private JButton adaugaRegizorButton;
    private JTextField actorDataNastereTextField;


    public ActorRegizorFrame(String actorSauRegizor) {
        tabbedPane1.removeAll();

        if (actorSauRegizor.equals("actor")) {
            tabbedPane1.addTab("Actor", null, actorPanel, "Adauga un actor!");
        } else {
            tabbedPane1.addTab("Regizor", null, regizorPanel, "Adauga un regizor!");
        }

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(daRadioButton);
        buttonGroup.add(nuRadioButton);
        daRadioButton.setActionCommand("true");
        nuRadioButton.setActionCommand("false");

        actorDataNastereTextField.setText(now());
        adaugaActorButton.addActionListener(e -> {
            var actorNume = actorNumeTextField.getText();
            var actorDataNastere = actorDataNastereTextField.getText();
            var actorOras = actorOrasTextField.getText();
            var actorTara = actorTaraTextField.getText();

            try {
                if (!actorNume.isBlank() && !actorOras.isBlank() && !actorTara.isBlank() &&
                        (daRadioButton.isSelected() || nuRadioButton.isSelected())) {
                    var actor = new ActorDto(
                            actorNume,
                            LocalDate.parse(actorDataNastere, DateTimeFormatter.ofPattern("d" +
                                    "/MM/yyyy")),
                            new LocNastereDto(actorOras, actorTara),
                            Boolean.parseBoolean(buttonGroup.getSelection().getActionCommand())
                    );
                    ActorController.getInstance().persist(actor);
                    JOptionPane.showMessageDialog(null, "Inregistrarea a fost efectuata!");
                } else {
                    JOptionPane.showMessageDialog(null, "Inregistrarea nu a fost efectuata!");
                }
            } catch (DateTimeParseException ex) {
                JOptionPane.showMessageDialog(null, "Inregistrarea nu a fost efectuata!");
            } finally {
                this.dispose();
            }
        });

        regizorDataNastereTextField.setText(now());
        adaugaRegizorButton.addActionListener(e -> {
            var regizorNume = regizorNumeTextField.getText();
            var regizorDataNastere = regizorDataNastereTextField.getText();
            var regizorOras = regizorOrasTextField.getText();
            var regizorTara = regizorTaraTextField.getText();
            var regizorPets = regizorPetsTextField.getText();
            try {
                if (!regizorNume.isBlank() && !regizorOras.isBlank() && !regizorTara.isBlank() &&
                        !regizorPets.isBlank()) {
                    var regizor = new RegizorDto(
                            regizorNume,
                            LocalDate.parse(regizorDataNastere, DateTimeFormatter.ofPattern("d" +
                                    "/MM/yyyy")),
                            new LocNastereDto(regizorOras, regizorTara),
                            Integer.parseInt(regizorPets)
                    );
                    RegizorController.getInstance().persist(regizor);
                    JOptionPane.showMessageDialog(null, "Inregistrarea a fost efectuata!");
                } else {
                    JOptionPane.showMessageDialog(null, "Inregistrarea nu a fost efectuata!");
                }
            } catch (DateTimeParseException | NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Inregistrarea nu a fost efectuata!");
            } finally {
                this.dispose();
            }
        });

        setContentPane(panel1);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static String now() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat(DateFormat);
        return format.format(cal.getTime());
    }

}
