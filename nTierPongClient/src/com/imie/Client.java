package com.imie;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by Blackwaxx on 13/06/2018.
 */
public class Client {

    private Socket connexion = null;
    private String IP = "172.17.0.72";
    private int port = 4200;
    private PrintWriter writer = null;
    private BufferedInputStream reader = null;
    private String name;
    private Scanner scan;

    private void createSocket(){
        try {
            connexion = new Socket(IP, port);
            System.out.println("Connecté !");
        } catch (UnknownHostException e) {
            System.err.println("Impossible de joindre l'hôte ! ");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Impossible de se connecter au socket ! ");
            e.printStackTrace();
        }
    }

    public void startGame() {
        System.out.println("Bienvenue dans n-Tiers Pong !");
        System.out.println("---------------------------------------");
        System.out.println("Connexion au serveur...");

        this.createSocket();

        scan = new Scanner(System.in);
        System.out.println("Entrez votre pseudo : ");
        String username = scan.nextLine();

        while(!connexion.isClosed()) try {

            writer = new PrintWriter(connexion.getOutputStream(), true);
            reader = new BufferedInputStream(connexion.getInputStream());
            writer.write("PSEUDO " + username);
            writer.flush();
            writer.close();

        } catch (SocketException e) {
            System.err.println("LA CONNEXION A ETE INTERROMPUE ! ");
            break;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
