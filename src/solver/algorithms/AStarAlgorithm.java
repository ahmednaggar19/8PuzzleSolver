package solver.algorithms;

import solver.game.GameSolution;
import solver.game.GameState;
import solver.game.InformedGameState;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class AStarAlgorithm implements InformedAlgorithmInterface{

    @Override
    public GameSolution solvePuzzle(InformedGameState initialGameState) {
        PriorityQueue<InformedGameState> statesQueue = new PriorityQueue<>();
        statesQueue.add(initialGameState);
        Integer maxSearchDepth = 0;
        while (!statesQueue.isEmpty()) {
            InformedGameState current = statesQueue.poll();
            if (current.isGoalState()) {
                return buildGameSolution(current, maxSearchDepth);
            }
            ArrayList<InformedGameState> adjacentStates = current.getAdjacentStates();
            for (InformedGameState adjacentState : adjacentStates) {
                (adjacentState).setHeuristicCost(current.getDepth());
                statesQueue.add(adjacentState);
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
        gameSolution.setPathCost(path.size() - 1);
        gameSolution.setSearchDepth(searchDepth);
        return gameSolution;
    }

}
