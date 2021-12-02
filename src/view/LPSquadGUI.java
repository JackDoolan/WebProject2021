package view;

//import controller.LPSquadClient;

import model.LPSquad;
import model.LPSquadInterface;
import model.LPSquadList;
import model.LPSquadListInterface;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class LPSquadGUI extends JFrame implements ActionListener {

    JLabel jLabelAdd = new JLabel("Add");

    JTextArea newPlayerName = new JTextArea("Player Name");
    JTextArea newPlayerNationality = new JTextArea("Player Nationality");
    JTextArea newPlayerKitNumber = new JTextArea("Player Kit Number");
    JTextArea newPlayerGoalsScored = new JTextArea("PLayer Goals Scored");
    JTextArea playerToDelete = new JTextArea("Player to delete");
    JButton playerToDeleteButton = new JButton("Delete");
    JButton addNewPlayer = new JButton("Add Player");
    JButton displayAllPlayers = new JButton("Display");
    JTextArea listOfPlayers = new JTextArea(20, 40);
    JButton save = new JButton("Save");


    public LPSquadGUI() throws RemoteException, MalformedURLException, NotBoundException {
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        getContentPane().setLayout(gridbag);
        //constraints.fill = GridBagConstraints.HORIZONTAL;


        constraints.weightx = 0;
        constraints.weighty = 0;
        gridbag.setConstraints(addNewPlayer, constraints);
        getContentPane().add(addNewPlayer);

        constraints.weightx = 1;
        constraints.weighty = 0;
        gridbag.setConstraints(newPlayerName, constraints);
        getContentPane().add(newPlayerName);

        constraints.weightx = 2;
        constraints.weighty = 0;
        gridbag.setConstraints(newPlayerNationality, constraints);
        getContentPane().add(newPlayerNationality);

        constraints.weightx = 3;
        constraints.weighty = 0;
        gridbag.setConstraints(newPlayerKitNumber, constraints);
        getContentPane().add(newPlayerKitNumber);

        constraints.weightx = 4;
        constraints.weighty = 0;
        gridbag.setConstraints(newPlayerGoalsScored, constraints);
        getContentPane().add(newPlayerGoalsScored);


        constraints.weightx = 0;
        constraints.gridy = 2;
        gridbag.setConstraints(playerToDeleteButton, constraints);
        getContentPane().add(playerToDeleteButton);

        constraints.weightx = 1;
        constraints.gridy = 2;
        gridbag.setConstraints(playerToDelete, constraints);
        getContentPane().add(playerToDelete);


        constraints.weightx = 5;
        constraints.gridy = 3;
        gridbag.setConstraints(listOfPlayers, constraints);
        getContentPane().add(listOfPlayers);

        constraints.weightx = 6;
        constraints.gridy = 4;
        gridbag.setConstraints(displayAllPlayers, constraints);
        getContentPane().add(displayAllPlayers);

        constraints.weightx = 7;
        constraints.gridy = 5;
        gridbag.setConstraints(save, constraints);
        getContentPane().add(save);

        displayAllPlayers.addActionListener(this);
        addNewPlayer.addActionListener(this);
        playerToDeleteButton.addActionListener(this);


        setVisible(true);

        setSize(1000, 800);

    }


    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        new LPSquadGUI();

    }

    LPSquadListInterface players = (LPSquadListInterface) Naming.lookup("listOfPlayers");
    ArrayList<LPSquadInterface> actualLPSquadList = players.getList();

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            //DISPLAY BUTTON---------------------------------------------------------------------------------------------------------------
            if (e.getSource().equals(displayAllPlayers)) {

                if (listOfPlayers.getText().length() != 0) {
                    listOfPlayers.setText("");
                } else if (listOfPlayers.getText().length() == 0) {
                    for (LPSquadInterface h : actualLPSquadList) {
                        listOfPlayers.append(h.getPlayer() + ", " + h.getNationality() + ", " + h.getKitNumber() + ", " + h.getGoalsScored());
                        listOfPlayers.append("\n");
                    }
                }
            } else if (e.getSource().equals(addNewPlayer)) {
                String newName, newNationality;
                int kitnumber, goalsScored;
                newName = newPlayerName.getText();
                newNationality = newPlayerNationality.getText();
                kitnumber = Integer.parseInt(newPlayerKitNumber.getText());
                goalsScored = Integer.parseInt(newPlayerGoalsScored.getText());

//                           LPSquad newPlayer = new LPSquad(newName, newNationality, kitnumber, goalsScored);
//
//                            LPSquadList.add(newPlayer);
                players.addPlayer(newName, newNationality, kitnumber, goalsScored);


                try {
                    seriealize();
                    deserialize();


                    if (listOfPlayers.getText().length() != 0) {
                        listOfPlayers.setText("");
                    } else if (listOfPlayers.getText().length() == 0) {
                        for (LPSquadInterface h : actualLPSquadList) {
                            listOfPlayers.append(h.getPlayer() + ", " + h.getNationality() + ", " + h.getKitNumber() + ", " + h.getGoalsScored());
                            listOfPlayers.append("\n");
                        }
                    }
                } catch (Exception h) {
                    h.printStackTrace();

                }

            }
            else if (e.getSource().equals(playerToDeleteButton))
            {

                try{
                    String playerToSack ="";
                    playerToSack = playerToDelete.getText();
                    players.deletePlayer(playerToSack);
                    seriealize();
                }catch (Exception h){
                    h.printStackTrace();
                }


                seriealize();
                deserialize();
                listOfPlayers.setText("");
                for (LPSquadInterface h : actualLPSquadList) {
                    listOfPlayers.append(h.getPlayer() + ", " + h.getNationality() + ", " + h.getKitNumber() + ", " + h.getGoalsScored());
                    listOfPlayers.append("\n");
                }
            }


        } catch (Exception j) {
            j.printStackTrace();
        }
    }

    public void seriealize() {
        try {
            ArrayList<LPSquadInterface> serializeList = players.getList();
            FileOutputStream fileOutputStream = new FileOutputStream("Players.ser");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOutputStream);

            objectOut.writeObject(serializeList);
            fileOutputStream.close();
//            objectOut.close();

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public void deserialize() {
        try {
            FileInputStream fileIn = new FileInputStream("Players.ser");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            ArrayList<LPSquadInterface> newnewPlayer = (ArrayList<LPSquadInterface>) objectIn.readObject();
            actualLPSquadList = newnewPlayer;
            objectIn.close();
            fileIn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
