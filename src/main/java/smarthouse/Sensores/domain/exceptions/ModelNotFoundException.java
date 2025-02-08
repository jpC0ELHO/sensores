package smarthouse.Sensores.domain.exceptions;

import lombok.Data;

@Data
public class ModelNotFoundException extends RuntimeException{
    public ModelNotFoundException(String message){
        super(message);
    }
}
