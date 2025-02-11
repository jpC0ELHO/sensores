package smarthouse.Sensores.domain.entities.enums;

import lombok.Getter;

@Getter
public enum ProtocoloComunicacao {

        WI_FI("WI_FI"),
        LORA("LORA"),
        BLUETOOTH("BLUETOOTH"),
        MODBUS("MODBUS"),
        RS485("RS485"),
        MQTT("MQTT"),
        ZIGBEE("ZIGBEE"),
        NB_IOT("NB_IOT");

        private final String descicao;

        ProtocoloComunicacao(String descicao){
            this.descicao=descicao;
        }
}
