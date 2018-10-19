package solver.game;

import com.sun.tools.internal.jxc.ap.Const;
import com.sun.tools.javac.util.Pair;

import java.util.ArrayList;

/**
 * Class to represent any state during solving the game.
 */
public class GameState {

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

    public ArrayList<GameState> getAdjacentStates() {
        ArrayList<GameState> adjacentStates = new ArrayList<GameState>();
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

    public boolean isGoalState() {
        int currentNumber = 0;
        for (int i = 0; i < Constants.BOARD_ROWS; i++) {
            for (int j = 0; i < Constants.BOARD_COLS; j++) {
                if (puzzleLayout[i][j] != currentNumber++) {
                    return false;
                }
            }
        }
        return true;
    }

    private GameState createGameState(int i, int j, boolean isVertical, int offset) {
        Integer[][] newPuzzleLayout = copyPuzzleLayout();
        newPuzzleLayout[i][j] =
                newPuzzleLayout[isVertical ? i - offset : i][!isVertical ? j - offset : j];
        newPuzzleLayout[isVertical ? i - offset : i][!isVertical ? j - offset : j] = 0;
        GameState newGameState = new GameState(newPuzzleLayout);
        newGameState.setDepth(this.depth + 1);
        newGameState.setPreviousGameState(this);
        return newGameState;
    }

    /**
     *  Searches the puzzle for the empty tile and return its location.
     * @return a pair of integers denoting Empty Tile Location
     */
    private Pair<Integer, Integer> getEmptyTileLocation() {
        for (int i = 0; i < puzzleLayout.length; i++) {
            for (int j = 0; j < puzzleLayout[i].length; j++) {
                if (puzzleLayout[i][j] == 0) {
                    return new Pair<Integer, Integer>(i, j);
                }
            }
        }
        return null;
    }

    private Integer[][] copyPuzzleLayout() {
        Integer[][] newPuzzleLayout = new Integer[Constants.BOARD_ROWS][Constants.BOARD_COLS];
        for (int i = 0; i < puzzleLayout.length; i++) {
            for (int j = 0; j < puzzleLayout[i].length; j++) {
                if (puzzleLayout[i][j] == 0) {
                    newPuzzleLayout[i][j] = puzzleLayout[i][j];
                }
            }
        }
        return newPuzzleLayout;
    }
}
