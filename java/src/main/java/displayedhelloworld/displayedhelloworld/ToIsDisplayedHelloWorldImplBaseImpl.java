package displayedhelloworld.displayedhelloworld;

import displayedhelloworld.output.IsOutput;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

/**
 * Displays hello world.
 */
public class ToIsDisplayedHelloWorldImplBaseImpl extends ToIsDisplayedHelloWorldGrpc.ToIsDisplayedHelloWorldImplBase {

    /**
     * Produce a state where "Hello World!" 'is displayed' starting from a state where it is 'not displayed'.
     *
     * @param request          From State: {@link NotDisplayedHelloWorld Not Displayed Hello World}
     * @param responseObserver To State: {@link IsDisplayedHelloWorld Is Displayed Hello World}
     */
    @Override
    public void produce(final NotDisplayedHelloWorld request, final StreamObserver<IsDisplayedHelloWorld> responseObserver) {
        try {
            responseObserver.onNext(IsDisplayedHelloWorld.newBuilder().setIsOutput(IsOutput.newBuilder().setIsDisplayString("Hello World!").build()).build());
            responseObserver.onCompleted();
        } catch (final Exception e) {
            responseObserver.onError(e);
        }
    }

    /**
     *  We have a main method, so that we can build a jar which a Dockerfile can run as a container.
     *  Port should be 8080.
     * @param args Not important
     * @throws IOException _
     * @throws InterruptedException _
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerBuilder.forPort(8080).addService(new ToIsDisplayedHelloWorldImplBaseImpl()).build().start().awaitTermination();
    }
}
