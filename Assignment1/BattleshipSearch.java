//This class controls the flow of one game,
//it calls all the different strategies and goes through them.
public class BattleshipSearch {
    BattleshipSearch(Grid grid) {
        search(grid);
    }

    private void search(Grid grid) {
        boolean gridArr[][] = grid.getGrid();   //new grid set up
        SearchStrategy strategy = new HorizontalSweepStrategy();    //first strategy started.
        strategy.search(gridArr);
        System.out.println("Strategy: " + strategy.strategyName());
        System.out.println("Number of cells searched: " + strategy.numberOfCellsSearched());
        System.out.println("Carrier found: " + strategy.getCarrierLocation() + " Submarine found: " + strategy.getSubmarineLocation());

        strategy = new RandomSearchStrategy();
        strategy.search(gridArr);
        System.out.println("Strategy: " + strategy.strategyName());
        System.out.println("Number of cells searched: " + strategy.numberOfCellsSearched());
        System.out.println("Carrier found: " + strategy.getCarrierLocation() + " Submarine found: " + strategy.getSubmarineLocation());

        strategy = new StrategicSearch();
        strategy.search(gridArr);
        System.out.println("Strategy: " + strategy.strategyName());
        System.out.println("Number of cells searched: " + strategy.numberOfCellsSearched());
        System.out.println("Carrier found: " + strategy.getCarrierLocation() + " Submarine found: " + strategy.getSubmarineLocation());
    }
}
