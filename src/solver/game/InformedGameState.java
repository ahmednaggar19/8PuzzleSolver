package solver.game;

import com.sun.tools.javac.util.Pair;
import solver.heuristics.HeuristicEvaluator;

import java.util.ArrayList;

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

    public ArrayList<InformedGameState> getAdjacentStates() {
        ArrayList<InformedGameState> adjacentStates = new ArrayList<>();
        Pair<Integer, Integer> emptyTileLocation = getEmptyTileLocation();
        if (emptyTileLocation.fst > 0) { // Up
            adjacentStates.add(createGameState(emptyTileLocation.fst, emptyTileLocation.snd, true, 1));
        }
        if (emptyTileLocation.fst < Constants.BOARD_ROWS - 1) { // Down
            adjacentStates.add(createGameState(emptyTileLocation.fst, emptyTileLocation.snd, true, -1));
        }
        if (emptyTileLocation.snd > 0) {
            adjacentStates.add(createGameState(emptyTileLocation.fst, emptyTileLocation.snd, false, 1));
        }
        if (emptyTileLocation.snd < Constants.BOARD_COLS - 1) {
            adjacentStates.add(createGameState(emptyTileLocation.fst, emptyTileLocation.snd, false, -1));
        }
        return adjacentStates;
    }

    protected InformedGameState createGameState(int i, int j, boolean isVertical, int offset) {
        Integer[][] newPuzzleLayout = copyPuzzleLayout();
        newPuzzleLayout[i][j] =
                newPuzzleLayout[isVertical ? i - offset : i][!isVertical ? j - offset : j];
        newPuzzleLayout[isVertical ? i - offset : i][!isVertical ? j - offset : j] = 0;
        InformedGameState newGameState = new InformedGameState(newPuzzleLayout, this.heuristicEvaluator);
        newGameState.setDepth(this.depth + 1);
        newGameState.setPreviousGameState(this);
        return newGameState;
    }
}
