package com.rickkorkmaz.vagado.frontend;

public class ConsoleView implements View {

    @Override
    public void render(String input) {
        System.out.println(input);
    }
}
