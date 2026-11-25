package org.lessons.java.oop.inheritance;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Televisori extends Prodotto {

    private int pollici;
    private boolean isSmartTv;

    public Televisori(String nome, String marca, BigDecimal prezzo, BigDecimal iva, int pollici, boolean isSmartTv) {
        super(nome, marca, prezzo, iva);
        this.pollici = pollici;
        this.isSmartTv = isSmartTv;

    }

    public int getPollici() {
        return this.pollici;
    }

    public boolean isSmartTv() {
        return this.isSmartTv;
    }

    @Override
    public String toString() {
        return super.toString() + "\nMarca : " + getMarca() + "\nDimensioni Tv : " + getPollici() + " \""
                + "\nSmartTV : " + isSmartTv();
    }

    @Override
    public BigDecimal getPrezzoScontato() {

        BigDecimal sconto;

        if (!this.isSmartTv) {
            sconto = new BigDecimal("0.90"); // Sconto 10%
        } else {
            sconto = new BigDecimal("0.98"); // Sconto 2%
        }

        return getPrezzo()
                .multiply(sconto)
                .setScale(2, RoundingMode.HALF_UP);
    }

}
