//This strategy just goes through the grid randomly until it has
//found all the ships.
import java.util.Random;

public class RandomSearchStrategy implements SearchStrategy {
    private int cells;
    private String carrierLocation = "";
    private String submarineLocation = "";

    RandomSearchStrategy() {
        cells = 0;
    }

    public String strategyName() {
        return "Random Search";
    }

    public int numberOfCellsSearched() {
        return cells;
    }
    public void search(boolean[][] grid) {
        int hitcounter = 0;
        Random rand = new Random();
        Grid checkedGrid = new Grid();
        boolean checked[][] = checkedGrid.getGrid();    //this just makes sure that no cell is revisited
        while (hitcounter < 8) {    //loop runs till 8 hits are done
            int randomOne = rand.nextInt(25);
            int randomTwo = rand.nextInt(25);
            if (!checked[randomOne][randomTwo]) {
                checked[randomOne][randomTwo] = true; //our checked grid is updated as we go
                if (grid[randomOne][randomTwo])     //if hit
                    hitcounter++;       //update the counter
                cells++;    //counting checked cells.
            }
        }
    }


    public String getCarrierLocation() {
        return carrierLocation;
    }
    public String getSubmarineLocation() {
        return submarineLocation;
    }
}
