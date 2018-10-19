package solver;

import solver.game.GameSolution;

public interface SolverInterface {

    /**
     * Solv
     * @param initialPuzzleLayout
     * @return
     */
    public GameSolution solvePuzzle(Integer[][] initialPuzzleLayout, SolverAlgorithm algorithm);
}
