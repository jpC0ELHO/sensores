package smarthouse.Sensores.api.services.configuracaoService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import smarthouse.Sensores.api.dtos.ConfiguracaoRequest;
import smarthouse.Sensores.api.dtos.ConfiguracaoResponse;
import smarthouse.Sensores.domain.exceptions.ModelIntegrityViolationException;
import smarthouse.Sensores.domain.exceptions.ModelNotFoundException;
import smarthouse.Sensores.domain.repositories.ConfiguracaoRespository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static smarthouse.Sensores.api.dtos.ConfiguracaoRequest.toEntidade;

@Service
@AllArgsConstructor
@Log4j2
public class ConfiguracaoServiceImp implements ConfiguracaoService{

    private final ConfiguracaoRespository configuracaoRespository;

    @Override
    public List<ConfiguracaoResponse> findConfigList() {
        try {
            var findConfigList=configuracaoRespository.findAll();
            if (findConfigList.isEmpty()){
                throw new ModelNotFoundException("List not found!");
            }
            return findConfigList.stream().map(ConfiguracaoResponse::toResponse).toList();
        }catch (RuntimeException e){
            log.error("Error:{}",e.getMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public Optional<ConfiguracaoResponse> findConfigId(UUID uuid) {
        var findConfigId=configuracaoRespository.findById(uuid);
        if (findConfigId.isEmpty()){
            log.error("ID: {} not found!",uuid);
            throw new ModelNotFoundException("Not found!");
        }
        return findConfigId.map(ConfiguracaoResponse::toResponse);
    }

    @Override
    public void createConfig(ConfiguracaoRequest configuracaoRequest) {
        var findConfigBySensor=configuracaoRespository.findBySensor(configuracaoRequest.sensor());
        if (findConfigBySensor.isPresent()){
            log.info("Config already exists for this Sensor: {} ",configuracaoRequest.sensor());
            throw new ModelIntegrityViolationException("Integrity Violation");
        }
        configuracaoRespository.save(toEntidade(configuracaoRequest));
    }

    @Override
    public void updateConfig(UUID uuid, ConfiguracaoRequest configuracaoRequest) {
        var findConfigById=configuracaoRespository.findById(uuid);
        if (findConfigById.isEmpty()){
            log.info("ID:{} not found!",uuid);
            throw new ModelNotFoundException("ID not found!");
        }
        findConfigById.map(configuracao -> {
            configuracao.setLimiteMax(configuracaoRequest.limiteMax());
            configuracao.setLimiteMin(configuracaoRequest.limiteMin());
            configuracao.setSensor(configuracaoRequest.sensor());
            return configuracaoRespository.save(configuracao);
        });
    }

    @Override
    public void deleteConfig(UUID uuid) {
    try {
        var findConfigById=configuracaoRespository.findById(uuid)
                .orElseThrow(()-> new ModelNotFoundException("ID "+uuid+" not found!"));
        configuracaoRespository.delete(findConfigById);
    }catch (RuntimeException e){
        log.error("Error: {} ",e.getMessage());
    }

    }
}
