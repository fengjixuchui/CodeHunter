package org.sec;

import org.apache.log4j.Logger;
import org.sec.start.Application;

import java.io.IOException;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        System.out.println("   _____          _      _    _             _            \n" +
                "  / ____|        | |    | |  | |           | |           \n" +
                " | |     ___   __| | ___| |__| |_   _ _ __ | |_ ___ _ __ \n" +
                " | |    / _ \\ / _` |/ _ \\  __  | | | | '_ \\| __/ _ \\ '__|\n" +
                " | |___| (_) | (_| |  __/ |  | | |_| | | | | ||  __/ |   \n" +
                "  \\_____\\___/ \\__,_|\\___|_|  |_|\\__,_|_| |_|\\__\\___|_|   \n" +
                "                                                         \n" +
                "                                                         ");
        logger.info("start CodeHunter application");
        // 运行主逻辑
        Application.start(args);
        System.out.println("CodeHunter (Version:   1.0.0)  Modify from TonyD0g");
    }
}