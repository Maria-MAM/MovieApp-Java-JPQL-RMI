package client.gui;

import client.controller.ActorController;
import client.controller.FilmController;
import client.controller.RegizorController;
import lib.dto.ActorDto;
import lib.dto.FilmDto;
import lib.dto.RegizorDto;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MainFrame extends JFrame {
    private static String actorSauRegizor;
    private JPanel mainPanel;
    private JList filmeList;
    private JList actoriList;
    private JList regizoriList;
    private JButton adaugaFilmButton;
    private JButton adaugaActorButton;
    private JButton adaugaRegizorButton;
    private JLabel birthdayLabel;
    private JLabel infoLabel;
    private JButton refreshButton;
    private JLabel requestedInfoLabel;
    private DefaultListModel<ActorDto> model1 = new DefaultListModel<>();
    private DefaultListModel<RegizorDto> model2 = new DefaultListModel<>();
    private DefaultListModel<FilmDto> model3 = new DefaultListModel<>();


    public MainFrame() {

        infoLabel.setText("*pentru a adauga un film trebuie sa selectati un regizor si cel putin " +
                "un actor");
        actoriList.setModel(model1);
        regizoriList.setModel(model2);
        filmeList.setModel(model3);
        actoriList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        regizoriList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        refreshAll();

        refreshButton.addActionListener(e -> refreshAll());

        adaugaFilmButton.addActionListener(e -> {
            var actori = (List<ActorDto>) actoriList.getSelectedValuesList();
            var regizor = Optional.ofNullable((RegizorDto) regizoriList.getSelectedValue());

            if (!actori.isEmpty() && regizor.isPresent()) {

                var idRegizor = regizor.stream()
                        .mapToInt(RegizorDto::getId)
                        .findFirst()
                        .getAsInt();


                var idActori = actori.stream()
                        .map(ActorDto::getId).collect(Collectors.toSet());

                new FilmFrame(idRegizor, idActori);

                actoriList.clearSelection();
                regizoriList.clearSelection();
            }
        });

        adaugaActorButton.addActionListener(e -> {
            actorSauRegizor = "actor";
            new ActorRegizorFrame(actorSauRegizor);
        });

        adaugaRegizorButton.addActionListener(e -> {
            actorSauRegizor = "regizor";
            new ActorRegizorFrame(actorSauRegizor);
        });

        actoriList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                var selected = (ActorDto) actoriList.getSelectedValue();

                if (selected != null && e.getClickCount() == 2) {
                    var filme = FilmController.getInstance()
                            .findByActorId(selected.getId());
                    if (filme.isEmpty()) {
                        requestedInfoLabel.setText(selected.getNume() + " nu a jucat in niciun " +
                                "film! ");
                    } else {
                        requestedInfoLabel.setText(selected.getNume() + " a jucat in: " + filme.toString());
                    }
                }
            }
        });

        regizoriList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                var selected = (RegizorDto) regizoriList.getSelectedValue();
                if (selected != null && e.getClickCount() == 2) {
                    var filme = FilmController.getInstance()
                            .findByRegizorId(selected.getId());
                    if (filme.isEmpty()) {
                        requestedInfoLabel.setText(selected.getNume() + " nu a regizat niciun " +
                                "film!");
                    } else {
                        requestedInfoLabel.setText(selected.getNume() + " a regizat: " + filme.toString());
                    }
                }
            }
        });

        filmeList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                var selected = (FilmDto) filmeList.getSelectedValue();
                if (selected != null && e.getClickCount() == 2) {
                    var actori = ActorController.getInstance()
                            .findByFilmId(selected.getId());
                    var regizor = RegizorController.getInstance()
                            .findByFilmId(selected.getId());
                    requestedInfoLabel.setText("In " + selected.getTitlu() + " au jucat: " +
                            actori.toString() + " si a fost regizat de" +
                            " " + regizor);
                }
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        setSize(900, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void refreshAll() {
        birthdayLabel.setText("");
        var ziuaCurenta = LocalDate.now().getDayOfMonth();
        var lunaCurenta = LocalDate.now().getMonth();
        var anulCurent = LocalDate.now().getYear();
        var totiActorii = ActorController.getInstance().findAll();
        for (ActorDto actor : totiActorii) {
            if (actor.getDataNastere().getDayOfMonth() == ziuaCurenta &&
                    actor.getDataNastere().getMonth() == lunaCurenta) {
                birthdayLabel.setText(birthdayLabel.getText() + " Astazi este ziua de " +
                        "nastere a lui " + actor.getNume() +
                        " si implineste " + (anulCurent - actor.getDataNastere().getYear()) + " " +
                        "ani ");
            }
        }

        var actori = ActorController.getInstance().findAll();
        model1.clear();
        actori.forEach(model1::addElement);

        var regizori = RegizorController.getInstance().findAll();
        model2.clear();
        regizori.forEach(model2::addElement);

        var filme = FilmController.getInstance().findAll();
        model3.clear();
        filme.forEach(model3::addElement);
    }

}
