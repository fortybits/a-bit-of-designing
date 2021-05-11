package edu.bit.designing.parking.command;

// incomplete: pattern for command execution
public interface Executor<Q, R> {

    Q createRequest(String[] args);

    R callService(Q request);

    void writeResponse(R response);

    default void executeCommand(String[] args) {
        Q request = createRequest(args);
        R response = callService(request);
        writeResponse(response);
    }
}