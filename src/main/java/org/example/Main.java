package org.example;

import org.example.controller.YutGameController;
import org.example.view.impl.ConsoleImpl;
import org.example.view.impl.ViewInterface;

public class Main {
    public static void main(String[] args) {
        ViewInterface viewInterface = new ConsoleImpl();
        YutGameController controller = new YutGameController(viewInterface);
        controller.playGame();
    }
}
