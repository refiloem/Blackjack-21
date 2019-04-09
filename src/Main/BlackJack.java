package Main;

import java.util.Arrays;
import java.util.stream.IntStream;
class BlackJack {

    private static int[] a = {10,4,4};
    private static int[] b = {2,2,2,4,5};
    private static int[] c = {10,6,9};
    private static int[] l = {1,7,1};
    private static int[] dealersHand = {10, 9};
    private static int winningCards = 5;

    public static void main(String[] args) {

        System.out.println((new BlackJack().calcHands()));
    }
    private static int aSum = IntStream.of(a).sum();
    private static int bSum = IntStream.of(b).sum();
    private static int cSum = IntStream.of(c).sum();
    private static int lSum = IntStream.of(l).sum();


    //sum of dealers array of cards
    private static int dealerSum = IntStream.of(dealersHand).sum();

    //condition::if all players hands are greater than the maximum points(21)
    private int calcHands() {
        int maxPts = 21;
        if (!(aSum <= maxPts || bSum <= maxPts || cSum <= maxPts || lSum <= maxPts)) {
            maxPts();
        }
        //condition::PlayerA
        if (!(bSum <= maxPts || cSum <= maxPts || lSum <= maxPts || aSum > maxPts || aSum < dealerSum)) {

            playerA();
        } else {
            checkDeckA();
        }
        if
            //condition::PlayerB
                (!(aSum <= maxPts || cSum <= maxPts || lSum <= maxPts || bSum > maxPts || bSum < dealerSum)) {
            playerB();
        } else {
            checkDeckB();
        }
        //condition::PlayerC
        if (!(aSum <= maxPts || bSum <= maxPts || lSum <= maxPts || cSum > maxPts || cSum < dealerSum)) {
            playerC();
        } else {
            checkDeckC();
        }
        //condition::PlayerL
        if (!(aSum <= maxPts || bSum <= maxPts || cSum <= maxPts || lSum > maxPts || lSum < dealerSum)) {
            playerL();
        } else {
            checkDeckL();
        }
        return 0;
    }

    //if players hands exceed the maximum points to win : if players exceed 21,all players loose
    private void maxPts() {
        System.out.println("No one wins this time : "
                + System.lineSeparator() +
                "Andrew had" + Arrays.toString(a) + " with " + a.length + " cards"
                + System.lineSeparator() +
                "Billy had" + Arrays.toString(b) + " with " + b.length + " cards"
                + System.lineSeparator() +
                "Carla had" + Arrays.toString(c) + " with " + c.length + " cards"
                + System.lineSeparator() +
                "Lemmy had" + Arrays.toString(l) + " with " + l.length + " cards"
                + System.lineSeparator() +
                "The dealer has" + Arrays.toString(dealersHand)
                + System.lineSeparator() + "And " + dealerSum + " points");
    }

    //player A
    private void playerA() {
        System.out.println("Andrew Wins with :"
                + aSum + " points" + "and a hand of :"
                + Arrays.toString(a) + " with " + a.length + " cards" +
                System.lineSeparator() +
                "Billy lost with :" +
                +bSum + " points" + "and a hand of :" +
                Arrays.toString(b) + " with " + b.length + " cards" +
                System.lineSeparator() +
                "Carla lost with :" +
                +cSum + " points" + "and a hand of :" +
                Arrays.toString(c) + " with " + c.length + " cards" +
                "Lemmy lost with :" +
                +lSum + " points" + "and a hand of :" +
                Arrays.toString(l) + " with " + a.length + " cards"
                + System.lineSeparator() +
                System.lineSeparator() +
                "The dealer has" + Arrays.toString(dealersHand) +
                "And " + dealerSum + " points");

    }
    private void playerB() {

        System.out.println("Billy Wins with: "
                + bSum + " points" + " and a hand of:"
                + Arrays.toString(b) + " with " + b.length + " cards" +
                System.lineSeparator() +
                "Andrew lost with :" +
                +aSum + " points" + " and a hand of :" +
                Arrays.toString(a) + " with " + a.length + " cards" +
                System.lineSeparator() +
                "Carla lost with :" +
                +cSum + " points" + " and a hand of :" +
                Arrays.toString(c) + " with " + c.length + " cards" +
                System.lineSeparator() +
                "Lemmy lost with " + +lSum + " points" + " and a hand of :" +
                Arrays.toString(l) + " with " + l.length + " cards" +
                System.lineSeparator() +
                "The dealer has " + Arrays.toString(dealersHand)
                + "And " + dealerSum + " points");
    }
    private void playerC() {
        System.out.println("Carla Wins with : "
                + cSum + " points " + " and a hand of:"
                + Arrays.toString(c) + " with " + c.length + " cards" +
                System.lineSeparator() +
                "Andrew lost with :" +
                +aSum + " points " +
                " and a hand of:" +
                Arrays.toString(a) + " with " + a.length + " cards" +
                System.lineSeparator() +
                "Billy lost with :" +
                +bSum + " points " +
                " and a hand of:" +
                Arrays.toString(b) + " with " + b.length + " cards" +
                System.lineSeparator() +
                "Lemmy lost" + Arrays.toString(l) + " with " + l.length + " cards" +
                "The dealer has " + Arrays.toString(dealersHand)
                + " And " + dealerSum + " points");
    }
    private void playerL() {
        System.out.println("Lemmy Wins with : "
                + lSum + " points " + " and a hand of:"
                + Arrays.toString(l) + " with " + l.length + " cards" +
                System.lineSeparator() +
                "Carla lost with :" +
                +cSum + " points " +
                " and a hand of:" +
                Arrays.toString(c) + " with " + c.length + " cards" +

                System.lineSeparator() +
                "Andrew lost with :" +
                +aSum + " points " +
                " and a hand of:" +
                Arrays.toString(a) + " with " + a.length + " cards" +
                System.lineSeparator() +
                "Billy lost with :" +
                +bSum + " points " +
                " and a hand of:" +
                Arrays.toString(b) + " with " + b.length + " cards" +
                System.lineSeparator() +
                "The dealer has " + Arrays.toString(dealersHand)
                + " And " + dealerSum + " points");
    }
    private void checkDeckA() {
        boolean result = Arrays.stream(a).anyMatch(x -> x == 1);
        if (result) {
            int counter = 0;

            for (int x : a) {
                if (x == 1) {
                    counter++;
                }
            }
            System.out.println("Andrew has " + "" + counter + " Aces");
        }
        if (a.length == winningCards) {
            playerA();
        }
    }
    private void checkDeckB() {
        boolean result = Arrays.stream(b).anyMatch(x -> x == 1);
        if (result) {
            int counter = 0;
            for (int x : b) {
                if (x == 1) {
                    counter++;
                }
            }
            System.out.println("Billy has " + "" + counter + " Aces");
        }
        if (b.length == winningCards) {
            playerB();
        }
    }
    private void checkDeckC() {
        boolean result = Arrays.stream(c).anyMatch(x -> x == 1);
        if (result) {
            int counter = 0;

            for (int x : c) {
                if (x == 1) {
                    counter++;
                }
            }
            System.out.println("Carla has " + "" + counter + " Aces");
        }
        if (c.length == winningCards) {
            playerC();
        }
    }
    private void checkDeckL() {
        boolean result = Arrays.stream(l).anyMatch(x -> x == 1);
        if (result) {
            int counter = 0;
            for (int x : l) {
                if (x == 1) {
                    counter++;
                }
            }
            System.out.println("Lemme has " + "" + counter + " Aces");
        }
        if (l.length == winningCards) {
            playerL();
        }
    }
}












