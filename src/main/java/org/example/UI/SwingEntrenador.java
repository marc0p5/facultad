package org.example.UI;

import org.example.DAO.EntrenadorDAO;
import org.example.DAO.EntrenadorDAOImpl;
import org.example.Excepciones.EmpatePorPeleaException;
import org.example.Model.Entrenador;
import org.example.Model.Pokemon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SwingEntrenador extends JFrame {
    private JTextField ent1Field;
    private JTextField ent2Field;
    public SwingEntrenador() {
        setTitle("Batalla Pokemon!");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 3));

        JLabel ent1Label = new JLabel("Ingrese el id del primer entrenador!");
        ent1Field = new JTextField();

        panel.add(ent1Label);
        panel.add(ent1Field);
        JLabel ent2Label = new JLabel("Ingrese el id del segundo entrenador");
        ent2Field = new JTextField();

        panel.add(ent2Label);
        panel.add(ent2Field);


        JButton sendButton = new JButton("Empezar la batalla pokemon!");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                swingPelea();
                dispose();
            }
        });

        panel.add(sendButton);

        add(panel);
    }
    private void swingPelea() {
        EntrenadorDAO entrenadorDAO = new EntrenadorDAOImpl();
        Entrenador entrenador1= entrenadorDAO.retornarEntrenadorPorID(Integer.parseInt(ent1Field.getText()));
        Entrenador entrenador2= entrenadorDAO.retornarEntrenadorPorID(Integer.parseInt(ent2Field.getText()));
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SwingPelea Pelea = new SwingPelea(entrenador1, entrenador2);
                Pelea.setVisible(true);
            }
        });
    }
    public static void main(String[] args) {
        SwingEntrenador form = new SwingEntrenador();
        form.setVisible(true);
    }
    }

