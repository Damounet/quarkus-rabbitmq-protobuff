package inetum.software.asd.bean;

import lombok.Data;

import java.util.UUID;

@Data
public class Orientation {
    UUID uuid;
    String idIdentity;
    String name;
    String type;

}
