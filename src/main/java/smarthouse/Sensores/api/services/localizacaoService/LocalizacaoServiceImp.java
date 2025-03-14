package smarthouse.Sensores.api.services.localizacaoService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import smarthouse.Sensores.api.dtos.LocalizacaoRequest;
import smarthouse.Sensores.api.dtos.LocalizacaoResponse;
import smarthouse.Sensores.domain.exceptions.ModelIntegrityViolationException;
import smarthouse.Sensores.domain.exceptions.ModelNotFoundException;
import smarthouse.Sensores.domain.repositories.LocalizacaoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static smarthouse.Sensores.api.dtos.LocalizacaoRequest.toEntidade;

@Service
@AllArgsConstructor
@Log4j2
public class LocalizacaoServiceImp implements LocalizacaoService{
    private final LocalizacaoRepository localizacaoRepository;
    @Override
    public List<LocalizacaoResponse> findList() {
        try {
            var findLocalizacaoList=localizacaoRepository.findAll();
            if (findLocalizacaoList.isEmpty()){
                log.info("List not found!");
                throw new ModelNotFoundException("Not found !!");
            }
           return findLocalizacaoList.stream().map(LocalizacaoResponse::toResponse).toList();
        }catch (RuntimeException e){
            log.error("Error: {} ",e.getMessage());
        }

        return new ArrayList<>();
    }

    @Override
    public Optional<LocalizacaoResponse> findById(UUID uuid) {
        var findLocalizacaoId=localizacaoRepository.findById(uuid);
        if (findLocalizacaoId.isEmpty()){
            log.info("ID:{} not found!",uuid);
            throw new ModelNotFoundException("ID not found!");
        }
        return findLocalizacaoId.map(LocalizacaoResponse::toResponse);
    }

    @Override
    public void createLocalizacao(LocalizacaoRequest localizacaoRequest) {
        var findByLatitude=localizacaoRepository.findByLatitude(localizacaoRequest.latitude());
        var findByLongitude=localizacaoRepository.findByLongitude(localizacaoRequest.longitude());
        if (findByLatitude.isPresent()&&findByLongitude.isPresent()){
            log.info("Latitude :{} already exists!",localizacaoRequest.latitude());
            log.info("Longitude :{} already exists!",localizacaoRequest.longitude());
            throw new ModelIntegrityViolationException("Integrity violation!");
        }
        localizacaoRepository.save(toEntidade(localizacaoRequest));
    }

    @Override
    public void updateLocalizacao(UUID uuid, LocalizacaoRequest localizacaoRequest) {
        var findLocalizacaoId=localizacaoRepository.findById(uuid);
        if (findLocalizacaoId.isEmpty()){
            log.info("ID:{} not found!",uuid);
            throw new ModelNotFoundException("Not found!!");
        }

        findLocalizacaoId.map(localizacao -> {
            localizacao.setSensor(localizacaoRequest.sensor());
            localizacao.setLatitude(localizacaoRequest.latitude());
            localizacao.setLongitude(localizacaoRequest.longitude());
            localizacao.setRegiao(localizacaoRequest.regiao());
            localizacao.setProtocoloComunicacao(localizacaoRequest.protocoloComunicacao());
            return localizacaoRepository.save(localizacao);
        });
    }

    @Override
    public void deleteLocalizacao(UUID uuid) {
    try {
        var findLocalizacaoId=localizacaoRepository
                .findById(uuid).orElseThrow(()-> new ModelNotFoundException("Id not found!"));
        localizacaoRepository.delete(findLocalizacaoId);
    }catch (RuntimeException e){
        log.error("Error: {}",e.getMessage());
    }
    }
}
