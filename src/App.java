import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        int pot = 100;
        CardsDeck deck = new CardsDeck();
        ArrayList<Player> players = new ArrayList<>();
        ArrayList<CardsDeck.Card> board = new ArrayList<>();
        Player Player1 = new Player("Mike", 100, deck.pullRandom(), deck.pullRandom());
        Player Player2 = new Player("Bob", 100, deck.pullRandom(), deck.pullRandom());
        Player Player3 = new Player("Chad", 100, deck.pullRandom(), deck.pullRandom());
        Player Player4 = new Player("Wonton", 100, deck.pullRandom(), deck.pullRandom());
        players.add(Player1);
        players.add(Player2);
        players.add(Player3);
        players.add(Player4);

        board.add(deck.pullRandom());
        board.add(deck.pullRandom());
        board.add(deck.pullRandom());
        board.add(deck.pullRandom());
        board.add(deck.pullRandom());

        WhoWon.calculate(players, pot, board);
    }
}
