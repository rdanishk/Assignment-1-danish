//interface that all strategies adhere to.
public interface SearchStrategy {
    public String strategyName();
    public int numberOfCellsSearched();
    public void search(boolean[][] grid);
    public String getCarrierLocation();
    public String getSubmarineLocation();
}
