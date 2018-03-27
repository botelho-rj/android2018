package com.example.opet.appmaster;

/**
 * Created by Diego on 19/03/2018.
 */

public class ItemLista {
    private String livro;
    private String autor;

    public ItemLista() {
    }

    public ItemLista(String livro, String autor) {
        this.livro = livro;
        this.autor = autor;
    }

    public String getLivro() {
        return livro;
    }

    public String getAutor() {
        return autor;
    }

    public void setLivro(String livro) {
        this.livro = livro;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
