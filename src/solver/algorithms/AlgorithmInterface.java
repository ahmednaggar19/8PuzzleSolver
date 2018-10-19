package solver.algorithms;

import solver.game.GameSolution;
import solver.game.GameState;

public interface AlgorithmInterface {

    /**
     * Solves the puzzle and internally keep some info to be retrieved later.
     * @param initialGameState the initial game state
     */
    public GameSolution solvePuzzle(GameState initialGameState);

}
