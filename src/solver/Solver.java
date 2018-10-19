package solver;

import solver.game.GameSolution;
import solver.game.GameState;

/**
 * Solver class to delegate the solving process to the perferred algorithm.
 */
public class Solver implements  SolverInterface{

    @Override
    public GameSolution solvePuzzle(Integer[][] initialPuzzleLayout, SolverAlgorithm algorithm) {
        GameState initialState = new GameState(initialPuzzleLayout);
        initialState.setDepth(0);
        initialState.setPreviousGameState(null);
        /// TODO : Return game solution by appropriate algorithm
        return null;
    }
}
