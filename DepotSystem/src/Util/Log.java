package Util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class implements the Singleton pattern, which ensures that only one instance of the Log class is created.
 * This instance is responsible for logging all events that occur within the depot system.
 */
public class Log {

    // Singleton instance of the Log class
    private static Log instance;

    // StringBuffer to hold the log messages
    private StringBuffer logMessages;

    // Private constructor to prevent external instantiation
    private Log() {
        logMessages = new StringBuffer();
    }

    /**
     * Gets the singleton instance of the Log class.
     * If no instance exists, it creates a new instance.
     *
     * @return The singleton instance of the Log class
     */
    public static Log getInstance() {
        if (instance == null) {
            instance = new Log();
        }
        return instance;
    }

    /**
     * Appends a new log message to the logMessages StringBuffer.
     *
     * @param message The log message to append.
     */
    public void append(String message) {
        logMessages.append(message).append("\n");
    }

    /**
     * Writes the log messages to a text file named "log.txt".
     *
     * @throws IOException If an error occurs while writing to the file.
     */
    public void writeToLog() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt"))) {
            writer.write(logMessages.toString());
        }
    }

	public void logError(String string) {
		// TODO Auto-generated method stub
		
	}

	public static void error(String string) {
		// TODO Auto-generated method stub
		
	}
}


