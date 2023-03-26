package com.raquel.projetointegrador;

public class LivroLista {
    private int imagem;
    private String titulo;
    private String autor;

    public LivroLista(int imagem, String titulo, String autor) {
        this.imagem = imagem;
        this.titulo = titulo;
        this.autor = autor;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
