package com.kodilla.testing.tictactoe;

import java.util.logging.*;

public class LoggerHandler {

    private static final Logger LOGGER = Logger.getLogger(LoggerHandler.class.getName());

    public static void main(String[] args) {
        Handler consoleHandler = null;
        Handler fileHandler = null;

        try{
            //Creating consoleHandler and fileHandler
            consoleHandler = new ConsoleHandler();
            //fileHandler = new FileHandler("./loggerTicTacToe.log");

            //Assigning handlers to LOGGER object
            LOGGER.addHandler(consoleHandler);
            //LOGGER.addHandler(fileHandler);

            //Setting levels to handlers and LOGGER
            consoleHandler.setLevel(Level.ALL);
            //fileHandler.setLevel(Level.ALL);
            LOGGER.setLevel(Level.ALL);

            LOGGER.config("Configuration done.");
            LOGGER.info("Logger info.");
            //Console handler removed
            //LOGGER.removeHandler(consoleHandler);

            LOGGER.log(Level.FINE, "Finer logged");
        }catch (Exception exception) {
            LOGGER.log(Level.SEVERE, "Error occur in FileHandler.", exception);
        }
    }
}
