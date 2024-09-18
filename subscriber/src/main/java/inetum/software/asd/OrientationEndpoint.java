package inetum.software.asd;

import inetum.software.asd.bean.Orientation;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import java.util.*;

@Path("/orientation")
public class OrientationEndpoint {

    public static final Map<UUID, Orientation> listOrientation = new HashMap<>();

    @Channel("orientation-requests")
    Emitter<Orientation> orientationRequestEmitter;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String createOrientation(Orientation orientation) {
        UUID uuid = UUID.randomUUID();
        orientation.setUuid(uuid);
        listOrientation.put(uuid, orientation);
        orientationRequestEmitter.send(orientation);
        return uuid.toString();
    }

    @GET
    @Path("/{uuid}")
    @Produces(MediaType.TEXT_PLAIN)
    public Orientation hello(@PathParam("uuid") String uuid) {
        return listOrientation.getOrDefault(UUID.fromString(uuid), null);
    }
}
