package inetum.software.asd.bean;

import lombok.Data;

import java.util.UUID;

@Data
public class OrientationDto {
    UUID uuid;
    String idIdentity;
    String name;
    String type;
}
