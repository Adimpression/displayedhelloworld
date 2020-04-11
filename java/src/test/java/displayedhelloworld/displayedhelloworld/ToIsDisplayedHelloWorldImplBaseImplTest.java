package displayedhelloworld.displayedhelloworld;

import io.grpc.Server;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class ToIsDisplayedHelloWorldImplBaseImplTest {

    private Server server;

    @BeforeMethod
    public void setUp() throws IOException {
        server = InProcessServerBuilder.forName(ToIsDisplayedHelloWorldGrpc.SERVICE_NAME)
                .addService(new ToIsDisplayedHelloWorldImplBaseImpl())
                .build();
        server.start();
    }

    @AfterMethod
    public void tearDown() {
        server.shutdown();
    }

    @Test
    public void testProduce() {
        final ToIsDisplayedHelloWorldGrpc.ToIsDisplayedHelloWorldBlockingStub toIsDisplayedHelloWorldBlockingStub = ToIsDisplayedHelloWorldGrpc.newBlockingStub(InProcessChannelBuilder.forName(ToIsDisplayedHelloWorldGrpc.SERVICE_NAME)
                .usePlaintext()
                .build())
                .withWaitForReady();

        final IsDisplayedHelloWorld isDisplayedHelloWorld = toIsDisplayedHelloWorldBlockingStub.produce(NotDisplayedHelloWorld.newBuilder()
                .build());

        assert isDisplayedHelloWorld.getIsOutput()
                .getIsDisplayString()
                .equals("Hello World!");
    }
}