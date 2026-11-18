package org.lessons.java.oop.inheritance;

import java.math.BigDecimal;

public class Televisori extends Prodotto {

    private String pollici;
    private boolean isSmartTv;

    public Televisori(String nome, String marca, BigDecimal prezzo, BigDecimal iva, String pollici, boolean isSmartTv) {
        super(nome, marca, prezzo, iva);
        this.pollici = pollici;
        this.isSmartTv = isSmartTv;

    }

    public String getPollici() {
        return this.pollici + " \"";
    }

    public boolean isSmartTv() {
        return this.isSmartTv;
    }

    @Override
    public String getNomeConCodice() {
        return super.getNomeConCodice() + "\nPollici Tv : " + getPollici() + "\nSmart : " + isSmartTv();
    }

}
