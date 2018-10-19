package solver.game;

import com.sun.tools.internal.jxc.ap.Const;
import com.sun.tools.javac.util.Pair;

import java.util.ArrayList;

/**
 * Class to represent any state during solving the game.
 */
public abstract class GameState {

    /** Puzzle board layout.*/
    protected Integer[][] puzzleLayout;
    /** The depth of this state from the root state.*/
    protected Integer depth;
    /** The parent state of this state. Null if no parent.*/
    protected GameState previousGameState;

    /**  The value of the used heuristic for the given state.*/
    private Integer heuristicValue;

    public GameState(Integer[][] puzzleLayout) {
        setPuzzleLayout(puzzleLayout);
    }

    public Integer[][] getPuzzleLayout() {
        return puzzleLayout;
    }

    public void setPuzzleLayout(Integer[][] puzzleLayout) {
        this.puzzleLayout = puzzleLayout;
    }

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    public GameState getPreviousGameState() {
        return previousGameState;
    }

    public void setPreviousGameState(GameState previousGameState) {
        this.previousGameState = previousGameState;
    }

    public boolean isGoalState() {
        int currentNumber = 0;
        for (int i = 0; i < Constants.BOARD_ROWS; i++) {
            for (int j = 0; j < Constants.BOARD_COLS; j++) {
                if (puzzleLayout[i][j] != currentNumber++) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     *  Searches the puzzle for the empty tile and return its location.
     * @return a pair of integers denoting Empty Tile Location
     */
    protected Pair<Integer, Integer> getEmptyTileLocation() {
        for (int i = 0; i < puzzleLayout.length; i++) {
            for (int j = 0; j < puzzleLayout[i].length; j++) {
                if (puzzleLayout[i][j] == 0) {
                    return new Pair<Integer, Integer>(i, j);
                }
            }
        }
        return null;
    }

    protected Integer[][] copyPuzzleLayout() {
        Integer[][] newPuzzleLayout = new Integer[Constants.BOARD_ROWS][Constants.BOARD_COLS];
        for (int i = 0; i < puzzleLayout.length; i++) {
            for (int j = 0; j < puzzleLayout[i].length; j++) {
                newPuzzleLayout[i][j] = new Integer(puzzleLayout[i][j]);
            }
        }
        return newPuzzleLayout;
    }
}
