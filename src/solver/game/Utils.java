package solver.game;

public class Utils {

    public static void printStateBoard(GameState state) {
        Integer[][] puzzle = state.getPuzzleLayout();
        for (int i = 0; i < Constants.BOARD_ROWS; i++) {
            for (int j = 0; j < Constants.BOARD_COLS; j++) {
                System.out.print(puzzle[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("============================");
    }
}
