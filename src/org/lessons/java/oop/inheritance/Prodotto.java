package org.lessons.java.oop.inheritance;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Prodotto {

    private int codice;
    private String nome, marca;
    private BigDecimal prezzo, iva;

    public Prodotto(String nome, String marca, BigDecimal prezzo, BigDecimal iva) {
        this.codice = new Random().nextInt(100) + 1;
        this.nome = nome;
        this.marca = marca;
        this.prezzo = prezzo;
        this.iva = iva;
    }

    public int getCodice() {
        return this.codice;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            System.out.println("Il nome del prodotto non può essere nullo o vuoto");
        } else {
            this.nome = nome;
        }

    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        if (marca == null || marca.isBlank()) {
            System.out.println("Il brand del prodotto non può essere nullo o vuoto");
        } else {
            this.marca = marca;
        }

    }

    public BigDecimal getPrezzo() {
        return this.prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        if (prezzo == null || prezzo.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("Il prezzo non può essere inferiore o uguale a 0");
        } else {
            this.prezzo = prezzo;
        }

    }

    public BigDecimal getIva() {
        return this.iva;
    }

    public void setIva(BigDecimal iva) {
        if (iva == null || iva.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("L'IVA non può essere inferiore a 0");
        }
        this.iva = iva;

    }

    public BigDecimal getPrezzoIvato() {
        return this.prezzo.add(this.prezzo.multiply(this.iva)).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getPrezzoScontato() {
        return this.prezzo
                .multiply(new BigDecimal("0.98"))
                .setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getPrezzoScontatoIvato() {
        return getPrezzoScontato()
                .multiply(BigDecimal.ONE.add(this.iva))
                .setScale(2, RoundingMode.HALF_UP);
    }

    public String toString() {
        return String.format("%s - %s", this.codice, this.nome);
    }

}
