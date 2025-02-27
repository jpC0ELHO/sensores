package smarthouse.Sensores.api.services.eventoService;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import smarthouse.Sensores.api.dtos.EventoRequest;
import smarthouse.Sensores.api.dtos.EventoResponse;
import smarthouse.Sensores.domain.exceptions.ModelIntegrityViolationException;
import smarthouse.Sensores.domain.exceptions.ModelNotFoundException;
import smarthouse.Sensores.domain.repositories.EventoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static smarthouse.Sensores.api.dtos.EventoRequest.toEntidade;

@Service
@Log4j2
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class EventoServiceImp implements EventoService{

    private final EventoRepository eventoRepository;

    @Override
    public List<EventoResponse> findEventoList() {
        try {
            var findEventoList=eventoRepository.findAll();
            if (findEventoList.isEmpty()){
                log.info("List not found!");
                throw new ModelNotFoundException("List not Found!");
            }
            return findEventoList.stream().map(EventoResponse::toResponse).toList();
        }catch (RuntimeException e){
            log.error("Error: ",e.getMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public Optional<EventoResponse> findEventoId(UUID uuid) {
        var findEventoId=eventoRepository.findById(uuid);
        if (findEventoId.isEmpty()){
            log.warn("ID: {} not found!",uuid);
            throw new ModelNotFoundException("ID not found!");
        }
        return findEventoId.map(EventoResponse::toResponse);
    }

    @Override
    public void createEvento(EventoRequest eventoRequest) {
        var findEvent= eventoRepository.findByTipo(eventoRequest.tipoEvento());
        if (findEvent.isPresent()){
            log.warn("Event: {} already exists!",eventoRequest.eventoTipo());
            throw new ModelIntegrityViolationException("Data integrity violation");
        }
        eventoRepository.save(toEntidade(eventoRequest));
    }

    @Override
    public void updateEvento(UUID uuid, EventoRequest eventoRequest) {
    var findEventoId=eventoRepository.findById(uuid);
    if (findEventoId.isEmpty()){
        log.error("ID{} not found!",uuid);
    }
    findEventoId.map(evento -> {
        evento.setTipoEvento(eventoRequest.tipoEvento());
        evento.setLocal(eventoRequest.local());
        evento.setDescricao(eventoRequest.descricao());
        evento.setHorarioEvento(eventoRequest.horarioEvento());
        evento.setEventoTipo(eventoRequest.eventoTipo());
        evento.setSensor(eventoRequest.sensor());
        return eventoRepository.save(evento);
    });
    }

    @Override
    public void deleteEvento(UUID uuid) {
    try {
        var findEventoId=eventoRepository.findById(uuid).orElseThrow(()-> new ModelNotFoundException("Event not found!"));
        eventoRepository.delete(findEventoId);
    }catch (RuntimeException e){
        log.error("Error: {} ",e.getMessage());
    }
    }
}
