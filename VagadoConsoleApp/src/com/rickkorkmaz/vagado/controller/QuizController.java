package com.rickkorkmaz.vagado.controller;

import com.rickkorkmaz.vagado.domain.Quiz;
import com.rickkorkmaz.vagado.domain.Vraag;
import com.rickkorkmaz.vagado.frontend.View;

import java.util.Scanner;

public class QuizController {
    private static final String QUIZ_FINISHED = "Quiz is afgelopen. Druk op enter om jouw score te zien.";
    private static final String REPLAY = "Druk op enter om opnieuw te spelen.";
    private static final String STRATEGIE_KEUZE =
            "Huidig puntentelling strategie is nu %s.\n" +
            "Type S voor Standaard, M voor moeilijk. Geen keuze is Standaard.";
    private static final String HUIDIGE_STRATEGIE = "Huidige strategie is nu %s.";
    private static final String QUIZ_STARTEN =
            "Top! Druk op enter om de quiz te starten.\n" +
            "_________________________________________";
    private static final String PROBEER_OPNIEUW = "Verkeerde keuze. Probeer opnieuw.";

    private Quiz quiz;
    private View view;
    private Scanner scanner;

    public QuizController(Quiz quiz, View view) {
        this.quiz = quiz;
        this.view = view;
        this.scanner = new Scanner(System.in);
    }

    public void initialiseerQuiz() {
        String vragenlijstenVanSpeler = quiz.initialiseerQuiz();
        view.render(vragenlijstenVanSpeler);

        setHuidigeVragenlijst(scanner.nextLine());

        String huidigePuntenTelling = quiz.getHuidigePuntenTelling();
        view.render(String.format(STRATEGIE_KEUZE, huidigePuntenTelling));
        setPuntenTelling(scanner.nextLine());

        view.render(QUIZ_STARTEN);
        scanner.nextLine();
        startQuiz();
    }

    public void setPuntenTelling(String puntenTellingKeuze) {
        if (puntenTellingKeuze != null) {
            quiz.setPuntenTelling(puntenTellingKeuze);
            String huidigePuntenTelling = quiz.getHuidigePuntenTelling();
            view.render(String.format(HUIDIGE_STRATEGIE, huidigePuntenTelling));
        }
    }

    public void setHuidigeVragenlijst(String vragenlijst) {
        while (true) {
            try {
                int vragenLijstIndex = Integer.parseInt(vragenlijst);
                if (vragenLijstIndex >= 0 && vragenLijstIndex < quiz.getSpelerVragenlijsten().size()) {
                    quiz.setHuidigeVragenlijst(vragenLijstIndex);
                    break;
                } else {
                    throw new NumberFormatException();
                }
            } catch(NumberFormatException error) {
                view.render(PROBEER_OPNIEUW);
            }
        }
    }

    private void startQuiz() {
        quiz.startQuiz();

        Scanner scanner = new Scanner(System.in);
        boolean heeftVolgendeVraag = quiz.heeftVolgendeVraag();
        if (heeftVolgendeVraag) {
            do {
                quiz.setEerstvolgendeVraag();
                Vraag vraag = quiz.getHuidigeVraag();
                view.render(vraag.toString());
                beantwoordVraag(scanner.nextLine());
            } while (quiz.heeftVolgendeVraag());
        }

        view.render(QUIZ_FINISHED);
        scanner.nextLine();
        toonScore();
        view.render(REPLAY);
        scanner.nextLine();
        initialiseerQuiz();
    }

    public void beantwoordVraag(String antwoord) {
        quiz.beantwoordVraag(antwoord);
    }

    public void toonScore() {
        String score = quiz.getScore();
        view.render(score);
    }
}
