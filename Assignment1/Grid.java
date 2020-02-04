//This class sets up and populates the grid according to the input given
import java.util.StringTokenizer;

public class Grid {
    private boolean[][] grid;

    public Grid() {
        grid = new boolean[25][25]; //java by default sets a boolean var to false, so no need to initialize manually
    }

    public Grid(String[] input) {
        grid = new boolean[25][25];
        populateGrid(input);
    }

    private void populateGrid(String[] input) {
        int x = 0;
        int y = 0;
        for(int i = 0; i < input.length; i++) {
            StringTokenizer coordTokenizer = new StringTokenizer(input[i], ","); //the input here is seperated by a comma
            x = Integer.parseInt(coordTokenizer.nextToken());   //the first number is the x coordinate
            y = Integer.parseInt(coordTokenizer.nextToken());   //and the second is the y coordinate
            grid[x][y] = true;  //which is then used to set up the grid
        }
    }

    public boolean[][] getGrid() {
        return grid;
    }
}