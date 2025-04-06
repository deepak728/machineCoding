import controller.GameController;
import model.COLOR;
import model.Loc;
import model.Player;


public class Main {
    public static void main(String[] args) {
        GameController game = new GameController();
        Player p1 = new Player("Santa", COLOR.WHITE);
        Player p2 = new Player("Banta", COLOR.BLACK);

        game.start(p1, p2);

        System.out.println("Initial Board:");
        game.gameView();

        // ✅ Turn 1: White pawn e2 to e3
        game.makeMove(p1, new Loc(6, 4), new Loc(5, 4)); // e2 -> e3
        game.gameView();

        // ✅ Turn 2: Black pawn d7 to d6
        game.makeMove(p2, new Loc(1, 3), new Loc(2, 3)); // d7 -> d6
        game.gameView();

        // ❌ Turn 3: White tries to move two steps ahead (invalid)
        game.makeMove(p1, new Loc(5, 4), new Loc(3, 4)); // e3 -> e5 (invalid)
        game.gameView();

        // ✅ Turn 3 retry: White moves pawn one step ahead
        game.makeMove(p1, new Loc(5, 4), new Loc(4, 4)); // e3 -> e4
        game.gameView();

        // ✅ Turn 4: Black pawn c7 to c6
        game.makeMove(p2, new Loc(1, 2), new Loc(2, 2)); // c7 -> c6
        game.gameView();

        // ❌ Turn 5: White tries diagonal capture where no opponent exists (invalid)
        game.makeMove(p1, new Loc(4, 4), new Loc(3, 3)); // e4 -> d5 (invalid, no piece to capture)
        game.gameView();

        // ✅ Turn 5 retry: White moves knight g1 to f3
        game.makeMove(p1, new Loc(7, 6), new Loc(5, 5)); // g1 -> f3
        game.gameView();

        // ✅ Turn 6: Black pawn from d6 to d5
        game.makeMove(p2, new Loc(2, 3), new Loc(3, 3)); // d6 -> d5
        game.gameView();

        // ✅ Turn 7: White pawn at e4 captures pawn at d5 diagonally
        game.makeMove(p1, new Loc(4, 4), new Loc(3, 3)); // e4 -> d5
        game.gameView();

        // ✅ Turn 8: Black captures white pawn
        game.makeMove(p2, new Loc(2, 2), new Loc(3, 3)); // invalid
        game.gameView();

        //  ❌  Turn 9: White move it's night. Invalid
        game.makeMove(p1, new Loc(5, 5), new Loc(4, 4)); // b8 -> c6
        game.gameView();

        System.out.println("\nMove History:");
        game.viewHistory();
    }
}
