package A;

import java.util.List;

public class Main {
	
	private static final String EXAMPLE_AREA_FILE_PATH = "resources/example_area.txt";
	private static final String SIMPLE_AREA_FILE_PATH = "resources/simple_area.txt";
	private static final String COMPLEX_AREA_FILE_PATH = "resources/complex_area.txt";
	private static final String LABYRINTH_AREA_FILE_PATH = "resources/labyrinth_area.txt";
	private static final String TWO_PATHS_AREA_1_FILE_PATH = "resources/two_paths_area_1.txt";
	
	public static void main(String[] args) throws Exception {
		findPath(EXAMPLE_AREA_FILE_PATH, "Prosta sciezka 1:");
		findPath(SIMPLE_AREA_FILE_PATH, "Prosta sciezka 2:");
		findPath(COMPLEX_AREA_FILE_PATH, "Skomplikowana sciezka:");
		findPath(LABYRINTH_AREA_FILE_PATH, "Labirynt:");
		findPath(TWO_PATHS_AREA_1_FILE_PATH, "Dwie sciezki - krotsza droga jest bardziej optymalna:");
	}		
	
	private static void findPath(String filePath, String label) throws Exception {
		final int[][] area = new AreaLoader().loadAreaFromFile(filePath);
		final AStar aStar = new AStar(area);
		final List<Node> result = aStar.findShortestPath();
        new AStarPrinter().printAreaWithPath(area, result, label);
	}
}
