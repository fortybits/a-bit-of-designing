package edu.bit.designing;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Hierarchy {

    class Transport {
    }

    class Cars extends Transport {
    }

    class Airplanes extends Transport {
    }

    class Trucks extends Transport {
    }

    private static Transport filterObjects(List<Transport> listOfTransport, int refNr) {
        Supplier<Optional<Transport>> cars =
                () -> filterObjects(listOfTransport, Cars.class, refNr);
        Supplier<Optional<Transport>> airplanes =
                () -> filterObjects(listOfTransport, Airplanes.class, refNr);

        // future
        Supplier<Optional<Transport>> trucks =
                () -> filterObjects(listOfTransport, Trucks.class, refNr);

        return Stream.of(cars, airplanes, trucks)
                .map(Supplier::get)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst()
                .orElse(null); // even better if you could return Optional<> from here itself
    }

    private static Optional<Transport> filterObjects(List<Transport> listOfTransport,
                                                     Class clazz, int refNr) {
        List<Transport> transports = listOfTransport.stream()
                .filter(clazz::isInstance)
                .collect(Collectors.toList());

        return transports.isEmpty() ? Optional.empty() :
                Optional.of(transports.get(refNr));
    }
}