package org.acme.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "T_TP_PERGUNTA")
public class PerguntasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pergunta;

    @Column(name = "enunciado")
    private String enunciado;

    public Integer getId_pergunta() {
        return id_pergunta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }
}
