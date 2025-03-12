package smarthouse.Sensores.api.services.leituraService;

import smarthouse.Sensores.api.dtos.LeituraRequest;
import smarthouse.Sensores.api.dtos.LeituraResponse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LeituraService {
    List<LeituraResponse>findLeituraList();
    Optional<LeituraResponse>findLeituraId(UUID uuid);
    void createLeitura(LeituraRequest leituraRequest);
    void updateLeitura(UUID uuid,LeituraRequest leituraRequest);
    void deleteLeitura(UUID uuid);

}
