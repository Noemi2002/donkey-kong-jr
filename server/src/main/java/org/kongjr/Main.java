package org.kongjr;

import org.kongjr.server.Server;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        var gameServer = new Server(1234);
        gameServer.acceptClientConnections();

    }
}