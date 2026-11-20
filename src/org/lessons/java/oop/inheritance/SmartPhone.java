package org.lessons.java.oop.inheritance;

import java.math.BigDecimal;

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
        return super.toString() + "\nCodiceImei : " + getCodiceImei() + "\nMemoriaGB : " + getMemoria();
    }

}
