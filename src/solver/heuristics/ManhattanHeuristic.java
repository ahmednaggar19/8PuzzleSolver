package solver.heuristics;

import solver.game.Constants;
import solver.game.GameState;

public class ManhattanHeuristic implements HeuristicEvaluator {

    public ManhattanHeuristic() {
    }

    @Override
    public Integer getHeuristicValue(GameState state) {
        Integer[][] puzzleLayout = state.getPuzzleLayout();
        Integer heuristicValue = 0;
        for (int i = 0; i < Constants.BOARD_ROWS; i++) {
            for (int j = 0; j < Constants.BOARD_COLS; j++) {
                heuristicValue += getManhattanDistance(puzzleLayout[i][j], i, j);
            }
        }
        return heuristicValue;
    }

    private Integer getManhattanDistance (Integer value, int i, int j) {
        int originalI = value % Constants.BOARD_ROWS;
        int originalJ = value % Constants.BOARD_COLS;

        return (Math.abs(originalI - i) + Math.abs(originalJ - j));
    }
}
