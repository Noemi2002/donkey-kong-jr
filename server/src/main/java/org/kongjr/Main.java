package org.kongjr;

import org.kongjr.server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;

import static java.lang.System.*;


public class Main {
    public static void main(String[] args) throws IOException {
        var gameServer = new Server(1234);
        gameServer.acceptClientConnections();

    }
}