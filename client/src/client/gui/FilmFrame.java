package client.gui;

import client.controller.FilmController;
import lib.dto.FilmDto;
import lib.dto.Gen;
import lib.dto.LimbaVorbita;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class FilmFrame extends JFrame {
    public static final String DateFormat = "dd/MM/yyyy";
    private JTextField titluTextField;
    private JTextField dataAparitieTextField;
    private JTextField durataTextField;
    private JComboBox genComboBox;
    private JCheckBox ENGLEZACheckBox;
    private JCheckBox FRANCEZACheckBox;
    private JCheckBox ITALIANACheckBox;
    private JCheckBox SPANIOLACheckBox;
    private JCheckBox GERMANACheckBox;
    private JButton adaugaButton;
    private JPanel filmPanel;

    public FilmFrame(int idRegizor, Set<Integer> idActori) {

        dataAparitieTextField.setText(now());
        adaugaButton.addActionListener(e -> {

            try {
                var filmTitlu = titluTextField.getText();
                var filmDataAparitie = dataAparitieTextField.getText();
                var filmDurata = durataTextField.getText();

                List<JCheckBox> checkboxes = Arrays.stream(filmPanel.getComponents())
                        .filter(c -> c instanceof JCheckBox)
                        .map(JCheckBox.class::cast)
                        .collect(Collectors.toList());

                Set<LimbaVorbita> limbiVorbite = checkboxes.stream()
                        .filter(JCheckBox::isSelected)
                        .map(JCheckBox::getText)
                        .map(text -> LimbaVorbita.valueOf(text))
                        .collect(Collectors.toSet());
                if (!filmTitlu.isBlank() && !limbiVorbite.isEmpty()) {
                    var film = new FilmDto(
                            filmTitlu,
                            LocalDate.parse(filmDataAparitie, DateTimeFormatter.ofPattern("d" +
                                    "/MM/yyyy")),
                            Integer.parseInt(filmDurata),
                            Gen.valueOf(genComboBox.getSelectedItem().toString()),
                            limbiVorbite,
                            idActori,
                            idRegizor
                    );
                    FilmController.getInstance().persist(film);
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

        setContentPane(filmPanel);
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
