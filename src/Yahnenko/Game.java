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
        System.out.println("Ваша цель - потопить три сайта");
        System.out.println("Pets.com, eToys.com, Go2.com");
        System.out.println("Попытайтесь потопить их за минимальное количество ходов");

        for (DotCom dotComTest : dotComsList) {
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComTest.setLocationCeels(newLocation);
        }
    }

    private void startPlaying() {
        while (!dotComsList.isEmpty()) {
            String userGuess = helper.getUserInput("Сделайте ход");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "Мимо";
        for (DotCom dotComTest : dotComsList) {
            result = dotComTest.checkYourself(userGuess);
            if (result.equals("Попал")) {
                break;
            }
            if (result.equals("Потопил")) {
                dotComsList.remove(dotComTest);
                break;
            }
        }
        System.out.println(result);
    }

    private void finishGame() {
        System.out.println();
        if (numOfGuesses <= 18) {
            System.out.println("Это заняло у вас всего" + numOfGuesses + " попыток.");
        } else {
            System.out.println("Это заняло у вас довольно много времени" + numOfGuesses + " попыток");
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.setUpGame();
        game.startPlaying();
    }
}