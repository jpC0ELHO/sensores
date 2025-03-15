package smarthouse.Sensores.api.services.configuracaoService;


import smarthouse.Sensores.api.dtos.ConfiguracaoRequest;
import smarthouse.Sensores.api.dtos.ConfiguracaoResponse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ConfiguracaoService {
    List<ConfiguracaoResponse>findConfigList();
    Optional<ConfiguracaoResponse> findConfigId(UUID uuid);
    void createConfig(ConfiguracaoRequest configuracaoRequest);
    void updateConfig(UUID uuid,ConfiguracaoRequest configuracaoRequest);
    void deleteConfig(UUID uuid);
}
