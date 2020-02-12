package com.rickkorkmaz.vagado;

import com.rickkorkmaz.vagado.controller.QuizController;
import com.rickkorkmaz.vagado.domain.*;
import com.rickkorkmaz.vagado.repository.MockedVragenlijstRepository;
import com.rickkorkmaz.vagado.frontend.ConsoleView;
import com.rickkorkmaz.vagado.frontend.View;

public class VagadoApp {
    public static void main(String[] args) {
        Quiz quiz = new Quiz(2, getMockedSpeler(), new StandaardPuntenTelling());
        View view = new ConsoleView();
        QuizController controller = new QuizController(quiz, view);
        controller.initialiseerQuiz();
    }

    private static Speler getMockedSpeler() {
        return new Speler(10, "Henk", new MockedVragenlijstRepository());
    }
}
