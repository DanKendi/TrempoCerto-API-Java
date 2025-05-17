package org.acme.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "T_TP_RESPOSTA")
public class RespostasEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_resposta;

    @Column(name = "texto")
    private String texto;

    @Column(name = "letra")
    private char letra;

    @Column(name = "correta")
    private char correta;

    @ManyToOne
    @JoinColumn(name = "pergunta_id")
    private PerguntasEntity perguntas;

    public Integer getId_resposta() {
        return id_resposta;
    }

    public String getTexto() {
        return texto;
    }

    public char getLetra() {
        return letra;
    }

    public char getCorreta() {
        return correta;
    }

    public PerguntasEntity getPerguntas() {
        return perguntas;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public void setCorreta(char correta) {
        this.correta = correta;
    }

    public void setPerguntas(PerguntasEntity perguntas) {
        this.perguntas = perguntas;
    }
}
