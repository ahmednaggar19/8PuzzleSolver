package solver.algorithms;

import solver.game.GameSolution;
import solver.game.GameState;
import solver.game.InformedGameState;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class AStarAlgorithm implements AlgorithmInterface {

    @Override
    public GameSolution solvePuzzle(GameState initialGameState) {
        PriorityQueue<InformedGameState> statesQueue = new PriorityQueue<>();
        statesQueue.add((InformedGameState) initialGameState);
        Integer maxSearchDepth = 0;
        while (!statesQueue.isEmpty()) {
            GameState current = statesQueue.poll();
            if (current.isGoalState()) {
                return buildGameSolution(current, maxSearchDepth);
            }
            ArrayList<GameState> adjacentStates = current.getAdjacentStates();
            for (GameState adjacentState : adjacentStates) {
                ((InformedGameState) adjacentState).setHeuristicCost(current.getDepth());
                statesQueue.add((InformedGameState) adjacentState);
                maxSearchDepth = Math.max(maxSearchDepth, adjacentState.getDepth());
            }
        }
        return null;
    }

    private GameSolution buildGameSolution(GameState goalState, Integer searchDepth) {
        GameSolution gameSolution = new GameSolution();
        ArrayList<GameState> path = new ArrayList<>();
        GameState state = goalState;
        while (state != null) {
            path.add(state);
            state = state.getPreviousGameState();
        }
        gameSolution.setPath(path);
        gameSolution.setPathCost(path.size());
        gameSolution.setSearchDepth(searchDepth);
        return gameSolution;
    }

}
