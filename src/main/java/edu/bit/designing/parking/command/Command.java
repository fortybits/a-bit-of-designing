package edu.bit.designing.parking.command;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Command {

    CREATE_PARKING_LOT("create_parking_lot"),
    PARK_VEHICLE("park"),
    LEAVE_PARKING("leave"),
    SHOW_PARKING_STATUS("status"),
    GET_REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOR("registration_numbers_for_cars_with_colour"),
    GET_SLOT_NUMBERS_FOR_CARS_WITH_COLOR("slot_numbers_for_cars_with_colour"),
    GET_SLOT_NUMBER_FROM_REGISTRATION_NUMBER("slot_number_for_registration_number"),
    DISPATCH_RULE("dispatch_rule"),
    EXIT("exit"),
    UNKNOWN_COMMAND("void");

    private static final Map<String, Command> COMMAND_LOOK_UP;

    static {
        COMMAND_LOOK_UP = Arrays.stream(Command.values())
                .collect(Collectors.toMap(Command::getCommandName, Function.identity()));
    }

    String commandName;

    Command(String commandName) {
        this.commandName = commandName;
    }

    public static Command getCommand(String name) {
        return COMMAND_LOOK_UP.getOrDefault(name, UNKNOWN_COMMAND);
    }

    String getCommandName() {
        return commandName;
    }
}