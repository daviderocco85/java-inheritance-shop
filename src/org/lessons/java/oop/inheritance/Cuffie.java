package org.lessons.java.oop.inheritance;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Cuffie extends Prodotto {

    private String colore;
    private boolean isWireless;

    public Cuffie(String nome, String marca, BigDecimal prezzo, BigDecimal iva, String colore, boolean isWireless) {
        super(nome, marca, prezzo, iva);
        this.colore = colore;
        this.isWireless = isWireless;
    }

    public String getColore() {
        return this.colore;
    }

    public boolean isWireless() {
        return this.isWireless;
    }

    @Override
    public String toString() {
        return super.toString() + "\nMarca : " + getMarca() + "\nColore : " + getColore() + "\nWireless : "
                + isWireless();
    }

    @Override
    public BigDecimal getPrezzoScontato() {

        BigDecimal sconto;

        if (!this.isWireless) {
            sconto = new BigDecimal("0.93"); // Sconto 7%
        } else {
            sconto = new BigDecimal("0.98"); // Sconto 2%
        }

        return getPrezzo()
                .multiply(sconto)
                .setScale(2, RoundingMode.HALF_UP);
    }

}
