package solver.game;

import java.util.ArrayList;

/**
 * Class to represent any state during solving the game.
 */
public class GameState implements Comparable<GameState>  {

    /** Puzzle board layout.*/
    private Integer[][] puzzleLayout;
    /** The depth of this state from the root state.*/
    private Integer depth;
    /** The parent state of this state. Null if no parent.*/
    private GameState previousGameState;

    public GameState(Integer[][] puzzleLayout) {
        this.puzzleLayout = puzzleLayout;
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

        return null;
    }

    @Override
    public int compareTo(GameState o) {
        return 0;
    }

    /**
     *  Searches the puzzle for the empty tile and return its location.
     * @return an integer denoting its location in an unrolled puzzle string
     */
    private Integer getEmptyTileLocation() {
        return null;
    }
}
