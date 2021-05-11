package edu.bit.designing.parking;

import edu.bit.designing.parking.command.CommandHandler;
import edu.bit.designing.parking.data.MultiStoreParking;
import edu.bit.designing.parking.exception.BaseParkingException;
import edu.bit.designing.parking.provider.InquiryProvider;
import edu.bit.designing.parking.provider.ParkingProvider;
import edu.bit.designing.parking.service.Inquiry;
import edu.bit.designing.parking.service.Parking;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This is the driver class to start the application. It launched CLI or executes through a file based on the arguments.
 */
public class ParkIt {

    public static void main(String[] args) {
        final MultiStoreParking multiStoreParking = new MultiStoreParking();
        final Parking parkingProvider = new ParkingProvider(multiStoreParking);
        final Inquiry inquiry = new InquiryProvider(multiStoreParking);

        final CommandHandler commandHandler = new CommandHandler(parkingProvider, inquiry);

        if (args.length == 0) {
            System.out.println("Started ParkIt at CLI!");
            Scanner in = new Scanner(System.in, StandardCharsets.UTF_8.name());
            while (true) {
                handleCommand(commandHandler, in.nextLine());
            }
        }
        if (args.length == 1) {
            String workingDir = System.getProperty("user.dir");
            Path filePath = Paths.get(workingDir + File.separator + args[0]); // assumption: relative path for file
            try (Stream<String> lines = Files.lines(filePath, StandardCharsets.UTF_8)) {
                List<String> commands = lines.collect(Collectors.toList());
                for (String lineInput : commands) {
                    handleCommand(commandHandler, lineInput);
                }
            } catch (IOException e) {
                System.out.println("Could not read the specified file input.");
            }
        } else {
            System.out.println("Invalid input. Usage Style: java -jar <jar_file_path> <|input_file_path>");
        }
    }

    private static void handleCommand(CommandHandler commandHandler, String lineInput) {
        try {
            commandHandler.processCommand(lineInput);
        } catch (BaseParkingException e) {
            // improvement: replace such behaviour with exception mappers
            System.out.println(e.getMessage());
        }
    }
}