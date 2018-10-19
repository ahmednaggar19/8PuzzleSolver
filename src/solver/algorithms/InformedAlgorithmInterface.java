package solver.algorithms;

import solver.game.GameSolution;
import solver.game.GameState;
import solver.game.InformedGameState;

import javax.sound.sampled.Line;

public interface InformedAlgorithmInterface {


    /**
     * Solves the puzzle and internally keep some info to be retrieved later.
     * @param initialGameState the initial game state
     */
    public GameSolution solvePuzzle(InformedGameState initialGameState);
}
