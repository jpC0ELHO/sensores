package smarthouse.Sensores.api.services.leituraService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import smarthouse.Sensores.api.dtos.LeituraRequest;
import smarthouse.Sensores.api.dtos.LeituraResponse;
import smarthouse.Sensores.domain.exceptions.ModelIntegrityViolationException;
import smarthouse.Sensores.domain.exceptions.ModelNotFoundException;
import smarthouse.Sensores.domain.repositories.LeituraRespository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static smarthouse.Sensores.api.dtos.LeituraRequest.toEntidade;

@Service
@Log4j2
@AllArgsConstructor
public class LeituraServiceImp implements LeituraService{
    private final LeituraRespository leituraRespository;
    @Override
    public List<LeituraResponse> findLeituraList() {
        try {
            var findLeituraList=leituraRespository.findAll();
            if (findLeituraList.isEmpty()){
                throw new ModelNotFoundException("List not found!");
            }
            findLeituraList.stream().map(LeituraResponse::toResponse).toList();
        }catch (RuntimeException e){
            log.error("Error: {} ",e.getMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public Optional<LeituraResponse> findLeituraId(UUID uuid) {
        var findLeituraId=leituraRespository.findById(uuid);
        if (findLeituraId.isEmpty()){
            throw new ModelNotFoundException("ID: "+uuid+" not found!");
        }
        return findLeituraId.map(LeituraResponse::toResponse);
    }

    @Override
    public void createLeitura(LeituraRequest leituraRequest) {
        var findLeituraByTipo=leituraRespository.findLeituraByTipo(leituraRequest.deteccaoTipo());
        var findLeituraByHorario=leituraRespository.findLeituraByHorario(leituraRequest.horarioDetec());
        if (findLeituraByTipo.isPresent()&&findLeituraByHorario.isPresent()){
            log.info("Detection by this sensor is already present!");
            throw new ModelIntegrityViolationException("Error!");
        }
        leituraRespository.save(toEntidade(leituraRequest));
    }

    @Override
    public void updateLeitura(UUID uuid, LeituraRequest leituraRequest) {
        var findLeituraById=leituraRespository.findById(uuid);
        if (findLeituraById.isEmpty()){
            log.info("ID: {} not found!",uuid);
            throw new ModelNotFoundException("ID not found!");
        }
        findLeituraById.map(leitura -> {
            leitura.setDeteccao_sim_nao(leituraRequest.deteccao_sim_nao());
            leitura.setDeteccaoTipo(leituraRequest.deteccaoTipo());
            leitura.setLocalizacao(leituraRequest.localizacao());
            leitura.setSensor(leituraRequest.sensor());
            return leituraRespository.save(leitura);
        });
    }

    @Override
    public void deleteLeitura(UUID uuid) {
        try {
            var findLeituraId=leituraRespository.findById(uuid)
                    .orElseThrow(()-> new ModelNotFoundException("ID not found!"));
            leituraRespository.delete(findLeituraId);
        }catch (RuntimeException e){
            log.info("Error :{} ",e.getMessage());
        }
    }
}
