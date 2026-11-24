package org.lessons.java.oop.inheritance;

import java.math.BigDecimal;
import java.util.Scanner;

public class Carrello {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        Prodotto[] carrello = new Prodotto[0];

        boolean continua = true;

        while (continua) {

            System.out.println("Quale prodotto vuoi inserire?");
            System.out.println("1 - Smartphone");
            System.out.println("2 - Televisore");
            System.out.println("3 - Cuffie");

            int scelta = Integer.parseInt(userInput.nextLine());

            if (scelta < 1 || scelta > 3) {
                System.out.println("Scelta non valida!");
                continue;
            }

            System.out.println("Inserisci il nome del prodotto:");
            String nome = userInput.nextLine();

            System.out.println("Inserisci la marca:");
            String marca = userInput.nextLine();

            BigDecimal prezzo = null;

            while (prezzo == null) {

                System.out.println("Inserisci il prezzo:");
                String inputPrezzo = userInput.nextLine();

                if (inputPrezzo.matches("\\d+(\\.\\d+)?")) {

                    prezzo = new BigDecimal(inputPrezzo);

                } else {

                    System.out.println("Prezzo non valido! Inserisci un numero.");
                }
            }

            BigDecimal iva = new BigDecimal("0.22");

            Prodotto nuovoProdotto = null;

            switch (scelta) {

                case 1:

                    System.out.println("Inserisci il codice IMEI:");
                    String codiceImei = userInput.nextLine();

                    System.out.println("Inserisci la memoria in GB:");
                    int memoria = -1;

                    while (memoria == -1) {
                        String inputMemoria = userInput.nextLine();
                        if (inputMemoria.matches("\\d+") && Integer.parseInt(inputMemoria) > 0) {

                            memoria = Integer.parseInt(inputMemoria);

                        } else {

                            System.out.println("Memoria non valida! Inserisci un numero.");

                        }
                    }

                    nuovoProdotto = new SmartPhone(
                            nome, marca, prezzo, iva, codiceImei, memoria);

                    break;

                case 2:

                    System.out.println("Inserisci i pollici del televisore:");
                    String dimensione = userInput.nextLine();

                    System.out.println("È una Smart TV? (si/no)");
                    boolean smartTv = userInput.nextLine().equalsIgnoreCase("si");

                    nuovoProdotto = new Televisori(
                            nome, marca, prezzo, iva, dimensione, smartTv);

                    break;

                case 3:

                    System.out.println("Inserisci il colore delle cuffie:");
                    String colore = userInput.nextLine();

                    System.out.println("Le cuffie sono wireless? (si/no)");
                    boolean wireless = userInput.nextLine().equalsIgnoreCase("si");

                    nuovoProdotto = new Cuffie(
                            nome, marca, prezzo, iva, colore, wireless);

                    break;

            }

            // Creo un nuovo array con una posizione in più
            Prodotto[] nuovoCarrello = new Prodotto[carrello.length + 1];

            // Copio i prodotti già presenti nel nuovo array
            for (int i = 0; i < carrello.length; i++) {
                nuovoCarrello[i] = carrello[i];
            }

            // Inserisco il nuovo prodotto nell'ultima posizione
            nuovoCarrello[carrello.length] = nuovoProdotto;

            // Aggiorno il riferimento al carrello
            carrello = nuovoCarrello;

            System.out.println("Prodotto aggiunto al carrello!");

            System.out.println("Vuoi inserire un altro prodotto? (si/no)");
            String risposta = userInput.nextLine();

            if (risposta.equalsIgnoreCase("no")) {
                continua = false;
            }
        }

        // Stampa del carrello
        System.out.println("\n--- CONTENUTO DEL CARRELLO ---");

        for (int i = 0; i < carrello.length; i++) {

            System.out.println(carrello[i]);

            System.out.println("Prezzo con IVA : "
                    + carrello[i].getPrezzoIvato() + " Euro");

            System.out.println("-------------------------");
        }

        userInput.close();

    }

}
