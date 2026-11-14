package org.lessons.java.oop.inheritance;

import java.math.BigDecimal;

public class Televisori extends Prodotto {

    private String pollici;
    private boolean smartTv;

    public Televisori(String nome, String marca, BigDecimal prezzo, BigDecimal iva, String pollici, boolean smartTv) {
        super(nome, marca, prezzo, iva);
        this.pollici = pollici;
        this.smartTv = smartTv;

    }

    public String getPollici() {
        return this.pollici + " \"";
    }

    public boolean isSmartTv() {
        return this.smartTv;
    }

}
