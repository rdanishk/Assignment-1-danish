//This strategy is a mix of random and horizontal search.
//First it uses random numbers till it gets a hit and then it
//searches the whole row for a ship.
import java.util.Random;

public class StrategicSearch implements SearchStrategy {
    private int cells;
    private String location;
    private String carrierLocation;
    private String submarineLocation;
    private boolean carrierFound;
    private boolean submarineFound;


    public String strategyName() {
        return "Strategic search";
    }

    public int numberOfCellsSearched() {
        return cells;
    }

    public void search(boolean[][] grid) {
        int hitcounter = 0; //to keep track if we have hit all the ships
        Random rand = new Random();
        Grid checkedGrid = new Grid();
        boolean checked[][] = checkedGrid.getGrid();    //need a checked grid to avoid checking the same cell twice.
        while (!submarineFound && !carrierFound) {
            int randomOne = rand.nextInt(25);   //generating randoms
            int randomTwo = rand.nextInt(25);
            if (!checked[randomOne][randomTwo]) {
                checked[randomOne][randomTwo] = true;
                if (grid[randomOne][randomTwo]) {   //if a hit is found,
                    for(int j = 0; j < 25; j++) {   //the whole row is searched.
                        if (grid[randomOne][j]) {
                            hitcounter++;
                            if(hitcounter == 1)
                                location  = "(" + randomOne + "," + j + ")";    //location is saved,
                        }
                        if (hitcounter == 1 && !carrierFound)
                            carrierLocation = location;
                        if (hitcounter == 5) {              //and checked if its either a submarine or a carrier.
                            submarineFound = false;
                            carrierFound = true;
                            hitcounter = 0;
                        }
                        if (!submarineFound && hitcounter == 3) {
                            submarineLocation = location;
                            submarineFound = true;
                        }
                    }
                }
                cells++;    //counting cells visited.
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
