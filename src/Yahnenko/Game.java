package Yahnenko;

import java.util.ArrayList;

/**
 * Created by dront on 11.03.17.
 */
public class Game {
    private GameHelper helper = new GameHelper();
    int numOfGuesses = 0;
    private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();

    private void setUpGame() {
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("eToys.com");
        DotCom three = new DotCom();
        three.setName("Go2.com");
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);
        System.out.println("Âàøà öåëü - ïîòîïèòü òðè ñàéòà");
        System.out.println("Pets.com, eToys.com, Go2.com");
        System.out.println("Ïîïûòàéòèñü ïîòîïèòü èõ çà ìèíèàëüíîå êîëè÷åñòâî õîäîâ");

        for (DotCom dotComTest : dotComsList) {
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComTest.setLocationCeels(newLocation);
        }
    }

    private void startPlaying() {
        while (!dotComsList.isEmpty()) {
            String userGuess = helper.getUserInput("Ñäåëàéòå õîä");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "Ìèìî";
        for (DotCom dotComTest : dotComsList) {
            result = dotComTest.checkYourself(userGuess);
            if (result.equals("Ïîïàë")) {
                break;
            }
            if (result.equals("Ïîòîïèë")) {
                dotComsList.remove(dotComTest);
                break;
            }
        }
        System.out.println(result);
    }

    private void finishGame() {
        System.out.println();
        if (numOfGuesses <= 18) {
            System.out.println("Ýòî çàíÿëî ó âàñ âñåãî" + numOfGuesses + " ïîïûòîê.");
            System.out.println("Âû óñïåëè âûáðàòüñÿ äî òîãî êàê âàøè âëîæåíèÿ óòîíóëè.");
        } else {
            System.out.println("Ýòî çàíÿëî ó âàñ äîâîëüíî ìíîãî âðåìåíè" + numOfGuesses + " ïîïûòîê");
            System.out.println("Ðûáû âîäÿò õîðîâîäû âîêðóã âàøèõ âëîæåíèé");
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.setUpGame();
        game.startPlaying();
    }
}