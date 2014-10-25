package br.com.dbs.java.mps.model;

import java.util.List;

public class Cantor {
    
    private String nome;
    private String sobrenome;
    private Byte[] foto;
    private List<Musica> musicas;

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the sobrenome
     */
    public String getSobrenome() {
        return sobrenome;
    }

    /**
     * @param sobrenome the sobrenome to set
     */
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    /**
     * @return the foto
     */
    public Byte[] getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(Byte[] foto) {
        this.foto = foto;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

}
