package org.lessons.java.oop.inheritance;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SmartPhone extends Prodotto {

    private String codiceImei;
    private int memoria;

    public SmartPhone(String nome, String marca, BigDecimal prezzo, BigDecimal iva, String codiceImei, int memoria) {
        super(nome, marca, prezzo, iva);
        this.codiceImei = codiceImei;
        this.memoria = memoria;
    }

    public String getCodiceImei() {
        return this.codiceImei;
    }

    public int getMemoria() {
        return this.memoria;
    }

    @Override
    public String toString() {
        return super.toString() + "\nMarca : " + getMarca() + "\nCodiceImei : " + getCodiceImei() + "\nMemoriaGB : "
                + getMemoria();
    }

    @Override
    public BigDecimal getPrezzoScontato() {

        BigDecimal sconto;

        if (this.memoria < 32) {
            sconto = new BigDecimal("0.95"); // Sconto 5%
        } else {
            sconto = new BigDecimal("0.98"); // Sconto 2%
        }
        return getPrezzo().multiply(sconto)
                .setScale(2, RoundingMode.HALF_UP);

    }

}
