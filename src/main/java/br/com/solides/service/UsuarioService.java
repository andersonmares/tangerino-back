package br.com.solides.service;

import br.com.solides.configurations.BusinessException;
import br.com.solides.model.dtos.UsuarioDto;
import br.com.solides.model.dtos.UsuarioFilterDto;
import br.com.solides.model.entity.Usuario;
import br.com.solides.model.mappers.UsuarioFilterMapper;
import br.com.solides.model.mappers.UsuarioMapper;
import br.com.solides.model.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@AllArgsConstructor
public class UsuarioService {
    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;
    private final UsuarioFilterMapper mapperFilter;
    private final PasswordEncoder passwordEncoder;

    public UsuarioDto obterPorId(Long id) {

        try {
            Usuario entity = repository.findById(id).orElseThrow();
            return mapper.toDto(entity);

        } catch (BusinessException e) {
            log.error(e.getMessage());
            throw new BusinessException(e.getMessage());
        }

    }

    @Transactional(propagation = Propagation.REQUIRED)
    public UsuarioDto salvar(UsuarioFilterDto dto) {
        try {
            Usuario entity = mapperFilter.toEntity(dto);
            entity.setPassword(this.passwordEncoder.encode(dto.getPassword()));
            Usuario usuario = repository.save(entity);
            return mapper.toDto(usuario);

        } catch (BusinessException e) {
            log.error(e.getMessage());
            throw new BusinessException(e.getMessage());
        }
    }
}
