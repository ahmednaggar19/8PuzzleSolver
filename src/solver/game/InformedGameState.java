package solver.game;

import solver.heuristics.HeuristicEvaluator;

public class InformedGameState extends GameState implements Comparable<InformedGameState>{

    private HeuristicEvaluator heuristicEvaluator;
    private Integer heuristicCost = 0;

    public InformedGameState(Integer[][] puzzleLayout, HeuristicEvaluator heuristicEvaluator) {
        super(puzzleLayout);
        this.heuristicEvaluator = heuristicEvaluator;
    }

    public Integer getHeuristicCost() {
        return heuristicCost;
    }

    public void setHeuristicCost(Integer heuristicCost) {
        this.heuristicCost = heuristicCost + heuristicEvaluator.getHeuristicValue(this);
    }

    public Integer getTotalEstimatedCost() {
        return heuristicEvaluator.getHeuristicValue(this) + this.depth;
    }

    @Override
    public int compareTo(InformedGameState o) {
        return Integer.compare(this.heuristicCost, o.getHeuristicCost());
    }
}
