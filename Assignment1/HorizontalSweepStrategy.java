//The most straightforward strategy, it just goes through every row
//horizontally till it finds the ships.
public class HorizontalSweepStrategy implements SearchStrategy {
    private int cells;
    private boolean carrierFound;
    private boolean submarineFound;
    private String location;
    private String submarineLocation;
    private String carrierLocation;

    HorizontalSweepStrategy() {
        cells = 0;
        carrierFound = false;
        submarineFound = false;
    }

    public String strategyName() {
        return "Horizontal Sweep";
    }

    public int numberOfCellsSearched() {
        return cells;
    }

    public String getSubmarineLocation() {
        return submarineLocation;
    }

    public String getCarrierLocation() {
        return carrierLocation;
    }

    public void search(boolean[][] grid) {
        int hitcounter = 0;
        search: {   //need this to break when both ships are found
            for (int i = 0; i < 25; i++) {
                for (int j = 0; j < 25; j++) {
                    if (grid[i][j]) {   //if a hit is found,
                        hitcounter++;
                        if(hitcounter == 1)
                            location  = "(" + i + "," + j + ")"; //that location is saved,
                    }
                    if (hitcounter == 1 && !carrierFound)   //then its checked if its either a
                        carrierLocation = location; //carrier
                    if (hitcounter == 5) {
                        submarineFound = false;
                        carrierFound = true;
                        hitcounter = 0;
                    }
                    if (!submarineFound && hitcounter == 3) {   //or a submarine
                        submarineLocation = location;
                        submarineFound = true;
                    }
                    if(carrierFound && submarineFound)  //loop is broken when both are found.
                        break search;
                    cells++;        //counting cells checked.
                }
            }
        }
    }
}
