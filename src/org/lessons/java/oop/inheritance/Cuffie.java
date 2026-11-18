package org.lessons.java.oop.inheritance;

import java.math.BigDecimal;

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
    public String getNomeConCodice() {
        return super.getNomeConCodice() + "\nColore : " + getColore() + "\nWireless : " + isWireless();
    }

}
