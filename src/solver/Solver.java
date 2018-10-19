package solver;

import solver.algorithms.AStarAlgorithm;
import solver.game.GameSolution;
import solver.game.GameState;
import solver.game.InformedGameState;
import solver.heuristics.HeuristicEvaluator;
import solver.heuristics.ManhattanHeuristic;

/**
 * Solver class to delegate the solving process to the perferred algorithm.
 */
public class Solver implements  SolverInterface{

    @Override
    public GameSolution solvePuzzle(Integer[][] initialPuzzleLayout, SolverAlgorithm algorithm) {
        InformedGameState initialState = new InformedGameState(initialPuzzleLayout, new ManhattanHeuristic());
        initialState.setDepth(0);
        initialState.setPreviousGameState(null);
        /// TODO : Return game solution by appropriate algorithm
        return new AStarAlgorithm().solvePuzzle(initialState);
    }
}
