package inetum.software.asd;

import inetum.software.asd.bean.OrientationDto;
import inetum.software.asd.proto.OrientationMessage;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import java.util.*;

@Path("/orientation")
public class OrientationEndpoint {

    protected static final Map<String, OrientationMessage> listOrientation = new HashMap<>();

    @Channel("orientation-requests")
    Emitter<OrientationMessage> orientationRequestEmitter;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String createOrientation(OrientationDto orientationDto) {
        UUID uuid = UUID.randomUUID();
        OrientationMessage orientation = OrientationMessage.newBuilder()
                .setUuid(uuid.toString())
                .setName(orientationDto.getName())
                .setIdIdentity(orientationDto.getIdIdentity())
                .setType(orientationDto.getType())
                .build();
        listOrientation.put(uuid.toString(), orientation);
        orientationRequestEmitter.send(orientation);
        return uuid.toString();
    }

    @GET
    @Path("/{uuid}")
    @Produces(MediaType.TEXT_PLAIN)
    public OrientationMessage hello(@PathParam("uuid") String uuid) {
        return listOrientation.getOrDefault(uuid, null);
    }
}
