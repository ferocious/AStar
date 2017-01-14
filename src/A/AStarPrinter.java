package A;

import java.util.List;

public class AStarPrinter {

	public void printAreaWithPath(final int[][] area, final List<Node> path, final String title) {
		System.out.println(title);
		for (int rowIndex = 0; rowIndex < area.length; rowIndex++) {
			for (int columnIndex = 0; columnIndex < area[0].length; columnIndex++) {
				int areaField = area[rowIndex][columnIndex];
			
				switch(areaField) {
					case -1: {
						System.out.print("# ");
						break;
					}
					case -2: {
						System.out.print("> ");
						break;
					}
					case -3: {
						System.out.print("X ");
						break;
					}
					default: {
						if (path.contains(new Node(new Coordinates(columnIndex, rowIndex)))) {
							System.out.print("- ");
						} else {
							System.out.print("  ");
						}
						break;
					}
				}
			}
			
			System.out.println("");	
		}
	
		System.out.println("");	
	}
		
}
