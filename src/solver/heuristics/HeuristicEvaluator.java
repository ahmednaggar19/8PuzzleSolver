package solver.heuristics;

import solver.game.GameState;

public interface HeuristicEvaluator {

    public Integer getHeuristicValue(GameState state);
}
