package org.example.UI;

import org.example.DAO.EntrenadorDAO;
import org.example.DAO.EntrenadorDAOImpl;
import org.example.Excepciones.EmpatePorPeleaException;
import org.example.Model.Entrenador;
import org.example.Model.Poder;

import javax.swing.*;
import java.awt.*;


public class SwingPelea extends JFrame {
    public SwingPelea(Entrenador entrenador1, Entrenador entrenador2){
        Poder poderInfernape ,poderRoserade ,poderGeodude ,poderEmpoleon ,poderElectabuzz ,poderKyogre;
        poderInfernape = new Poder("Giro Fuego", 5, 15);
        poderRoserade = new Poder("Campo de Hierva", 5, 25);
        poderGeodude = new Poder("Placaje", 5, 35);
        poderEmpoleon = new Poder("Aqua Jet", 5, 50);
        poderElectabuzz = new Poder("Impactrueno", 5, 30);
        poderKyogre = new Poder("Hidropulso", 5, 45);
        setTitle("Batalla Pokemon!");
        setSize(400, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        int poderEntrenador1 =(int)(Math.random() * (250 + 1));
        int poderEntrenador2 =(int)(Math.random() * (250 + 1));
        System.out.println();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 3));
        add(panel);
        if(poderEntrenador1 > poderEntrenador2){
            JLabel Label = new JLabel("<html>El entrenador "+ entrenador1.getNombre() + " gano ya que tiene pokemones con " + poderEntrenador1+" de poder<br>Mientras que el entrenador " + entrenador2.getNombre() +" tiene "+poderEntrenador2+ " de poder </html>");

            panel.add(Label);
            JLabel Label2 = new JLabel("<html>Gano utilizando de estrategia los poderes de sus 3 pokemones: <br>Primer Estrategia " + poderInfernape.getNombre() +"<br>Segunda Estrategia "+ poderRoserade.getNombre() +"<br>Tercer Estrategia "+ poderGeodude.getNombre()+"</html>");
            panel.add(Label2);

        }else if(poderEntrenador1 < poderEntrenador2){
            JLabel Label = new JLabel("<html>El entrenador "+ entrenador2.getNombre() + " gano ya que tiene pokemones con " + poderEntrenador2+" de poder<br>Mientras que el entrenador " + entrenador1.getNombre() +" tiene "+poderEntrenador1+ " de poder </html>");

            panel.add(Label);
            JLabel Label2 = new JLabel("<html>Gano utilizando de estrategia los poderes de sus 3 pokemones: <br>Primer Estrategia " + poderElectabuzz.getNombre() +"<br>Segunda Estrategia "+ poderEmpoleon.getNombre() +"<br>Tercer Estrategia "+ poderKyogre.getNombre()+"</html>");
            panel.add(Label2);
        }else{
            throw new EmpatePorPeleaException(entrenador1, entrenador2);
        }
    }

}
