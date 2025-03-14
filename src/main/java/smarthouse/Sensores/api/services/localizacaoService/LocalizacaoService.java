package smarthouse.Sensores.api.services.localizacaoService;

import smarthouse.Sensores.api.dtos.LocalizacaoRequest;
import smarthouse.Sensores.api.dtos.LocalizacaoResponse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LocalizacaoService {
    List<LocalizacaoResponse>findList();
    Optional<LocalizacaoResponse>findById(UUID uuid);
    void createLocalizacao(LocalizacaoRequest localizacaoRequest);
    void updateLocalizacao(UUID uuid,LocalizacaoRequest localizacaoRequest);
    void deleteLocalizacao(UUID uuid);
}
