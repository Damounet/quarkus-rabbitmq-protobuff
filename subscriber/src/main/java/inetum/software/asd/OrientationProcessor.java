package inetum.software.asd;

import inetum.software.asd.bean.Orientation;
import io.smallrye.common.annotation.Blocking;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class OrientationProcessor {

    @Incoming("orientation-responses")
    @Blocking
    public void process(Orientation orientationResponse) throws InterruptedException {
        // simulate some hard-working task
        Thread.sleep(1000);
        OrientationEndpoint.listOrientation.put(orientationResponse.getUuid(), orientationResponse);
    }
}
