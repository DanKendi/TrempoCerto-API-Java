package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entity.PerguntasEntity;
import org.acme.repository.PerguntasRepository;
import java.util.List;
import java.util.NoSuchElementException;

@ApplicationScoped
public class PerguntasService {

    private final PerguntasRepository perguntasRepository;

    public PerguntasService(PerguntasRepository perguntasRepository) {
        this.perguntasRepository = perguntasRepository;
    }

    public List<PerguntasEntity> findAll(Integer page, Integer pageSize) {
        return perguntasRepository.findAll()
                .page(page, pageSize)
                .list();
    }

    public PerguntasEntity findById(Integer perguntaId) {
        return (PerguntasEntity) perguntasRepository.findByIdOptional(perguntaId)
                .orElseThrow(() -> new NoSuchElementException("Pergunta não encontrada com id: " + perguntaId));
    }

    public PerguntasEntity createPergunta(PerguntasEntity pergunta){
        perguntasRepository.persist(pergunta);
        return pergunta;
    }

    public PerguntasEntity updatePergunta(Integer perguntaId, PerguntasEntity perguntasEntity){
        var pergunta = findById(perguntaId);

        pergunta.setEnunciado(perguntasEntity.getEnunciado());

        perguntasRepository.persist(pergunta);

        return pergunta;
    }

    public  void deletePergunta(Integer perguntaId){
        var pergunta = findById(perguntaId);
        perguntasRepository.deleteById(pergunta.getId_pergunta());
    }

}
