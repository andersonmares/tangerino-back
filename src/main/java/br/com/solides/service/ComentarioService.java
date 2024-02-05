package br.com.solides.service;

import br.com.solides.configurations.BusinessException;
import br.com.solides.model.dtos.ComentarioFilterDto;
import br.com.solides.model.dtos.ComentarioDto;
import br.com.solides.model.entity.Comentario;
import br.com.solides.model.mappers.ComentarioFilterMapper;
import br.com.solides.model.mappers.ComentarioMapper;
import br.com.solides.model.repository.ComentariosRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class ComentarioService extends AppService {
    private final ComentariosRepository repository;
    private final ComentarioMapper mapper;
    private final ComentarioFilterMapper mapperFilter;

    public List<ComentarioDto> obterComentariosUsuario() {

        try {
            List<Comentario> entity = repository.findByUsuarioOrderByDtCriacaoDesc(getUsuarioToken());
            return mapper.toDto(entity);

        } catch (BusinessException e) {
            log.error(e.getMessage());
            throw new BusinessException(e.getMessage());
        }

    }

    @Transactional(propagation = Propagation.REQUIRED)
    public ComentarioDto salvar(ComentarioFilterDto dto) {
        try {
            Comentario entity = mapperFilter.toEntity(dto);
            entity.setUsuario(getUsuarioToken());

            Comentario comentario = repository.save(entity);
            return mapper.toDto(comentario);

        } catch (BusinessException e) {
            log.error(e.getMessage());
            throw new BusinessException(e.getMessage());
        }
    }

    public List<ComentarioDto> obterComentariosPublicacoes(Long idPublicacao) {

        try {
            List<Comentario> entity = repository.obterPorPublicacao(idPublicacao);
            return mapper.toDto(entity);

        } catch (BusinessException e) {
            log.error(e.getMessage());
            throw new BusinessException(e.getMessage());
        }
    }

    @Transactional
    public void deletar(Long id) {
        try {
            Comentario entity = repository.findById(id).orElseThrow();

            if(!entity.getUsuario().getId().equals(getUsuarioToken().getId())) {
                throw new BusinessException("Exclusão não permitida, o usuário só pode excluir seus comentários");
            }
            repository.delete(entity);

        } catch (BusinessException e) {
            log.error(e.getMessage());
            throw new BusinessException(e.getMessage());
        }
    }
}
