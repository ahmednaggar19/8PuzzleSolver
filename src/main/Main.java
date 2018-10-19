package main;

import solver.Solver;
import solver.SolverAlgorithm;
import solver.game.GameSolution;
import solver.game.GameState;
import solver.game.Utils;

public class Main {

    public static void main(String[] args) {
	    Integer[][] puzzle = {{1, 2, 5}, {3, 4, 0}, {6 ,7 ,8}};
        GameSolution solution = new Solver().solvePuzzle(puzzle, SolverAlgorithm.A_STAR);
        System.out.println(solution.getPathCost());
        for (GameState state : solution.getPath()) {
            Utils.printStateBoard(state);
        }
    }
}
