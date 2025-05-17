package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entity.RespostasEntity;
import org.acme.repository.RespostasRepository;
import java.util.List;
import java.util.NoSuchElementException;

@ApplicationScoped
public class RespostasService {

    private final RespostasRepository respostasRepository;

    public RespostasService(RespostasRepository respostasRepository) {this.respostasRepository = respostasRepository;}

    public List<RespostasEntity> findAll(Integer page, Integer pageSize) {
        return respostasRepository.findAll()
                .page(page, pageSize)
                .list();
    }

    public RespostasEntity findById(Integer respostaId) {
        return (RespostasEntity) respostasRepository.findByIdOptional(respostaId)
                .orElseThrow(() -> new NoSuchElementException("Resposta não encontrada pelo id: " + respostaId));
    }

    public RespostasEntity createResposta(RespostasEntity resposta){
        respostasRepository.persist(resposta);
        return resposta;
    }

    public RespostasEntity updateResposta(Integer respostaId, RespostasEntity respostasEntity){
        var resposta = findById(respostaId);

        resposta.setTexto(respostasEntity.getTexto());
        resposta.setLetra(respostasEntity.getLetra());
        resposta.setCorreta(respostasEntity.getCorreta());
        resposta.setPerguntas(respostasEntity.getPerguntas());

       respostasRepository.persist(resposta);

        return resposta;
    }

    public void deleteResposta(Integer respostaId) {
        var resposta = findById(respostaId);
        respostasRepository.deleteById(resposta.getId_resposta());
    }

}
