package common;

import java.io.IOException;
import java.util.logging.*;
import java.util.logging.Logger;

public class Log {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Logger log = Logger.getLogger("Test.log");

        Handler handler = null;

        try {
            handler = new FileHandler("messages.log");
        } catch (IOException e) {
            System.out.println("Could not create file. Using the console handler");
            handler = new ConsoleHandler();
        }

        log.addHandler(handler);

        handler.setFormatter(new XMLFormatter());

        log.info("Our first logging message");
        log.severe("Something terrible happened");
    }
}
