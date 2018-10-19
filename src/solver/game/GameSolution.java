package solver.game;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class to wrap the game solution along with other information.
 */
public class GameSolution {

    /**
     * A list of game states that lead to the game solution.
     */
    private ArrayList<GameState> path;
    /**
     * The maximum depth the search algorithm reached to find the game solution.
     */
    private Integer searchDepth;
    /**
     * The total path cost of the solution.
     */
    private Integer pathCost;

    public GameSolution() {}

    public ArrayList<GameState> getPath() {
        return path;
    }

    public void setPath(ArrayList<GameState> path) {
        this.path = path;
        Collections.reverse(this.path);
    }

    public Integer getSearchDepth() {
        return searchDepth;
    }

    public void setSearchDepth(Integer searchDepth) {
        this.searchDepth = searchDepth;
    }

    public Integer getPathCost() {
        return pathCost;
    }

    public void setPathCost(Integer pathCost) {
        this.pathCost = pathCost;
    }

}
