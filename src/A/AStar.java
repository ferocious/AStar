package A;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class AStar {

	private Node startNode;
	private Node endNode;
	private int [][] area;
	private Set<Node> openSet = new HashSet<>();
	private Set<Node> closedSet = new HashSet<>();
	
	//w konstruktorze przekazywana jest mapa
	public AStar(int[][] area) {
		this.area = area;
	}
	//metoda uruchamiaj¹ca algorytm
	public List<Node> findShortestPath() {
		List<Node> result = new LinkedList<>();
		
		initialize(); // znajduje wêze³ pocz¹tkowy i koñcowy na mapie
		
		this.closedSet.add(this.startNode); //dodaje start nide do closed setu
		addNodesToOpenSet(this.startNode); //metoda dodaje do open setu wszystkie pola, ktore s¹ wokó³ danego wêz³a
		
		Node closestNode = getClosestNodeFromOpenSet(); //z listy open set pobieramy wêze³, który ma najmniejsz¹ F value - jest najbli¿ej
		while (closestNode != null) {
			this.openSet.remove(closestNode);
			this.closedSet.add(closestNode);
			
			if (this.endNode.equals(closestNode)) {
				result.addAll(createPathFromNode(closestNode));
				break;
			} else {
				addNodesToOpenSet(closestNode);
			}
			
			closestNode = getClosestNodeFromOpenSet();
		}
		
		return result;
	}
	
	/*
	 * Find start and end nodes
	 */
	private void initialize() {
		for (int rowIndex = 0; rowIndex < area.length; rowIndex++) {
			for (int columnIndex = 0; columnIndex < area[0].length;columnIndex++) {
				int areaField = area[rowIndex][columnIndex];
				
				if (areaField == -2) {
					this.startNode = new Node(new Coordinates(columnIndex, rowIndex));
				} else if (areaField == -3) {
					this.endNode = new Node(new Coordinates(columnIndex, rowIndex));
				}
			}
		}
	}
	
	private int calculateDistanceToEndNode(Coordinates from) {
		return Math.abs(from.getX() - endNode.getCoordinates().getX()) + Math.abs(from.getY() - endNode.getCoordinates().getY());
	}
	
	private void addNodesToOpenSet (Node from) {
		addNewNodeToOpenSet(from, from.getCoordinates().createNorth());
		addNewNodeToOpenSet(from, from.getCoordinates().createEast());
		addNewNodeToOpenSet(from, from.getCoordinates().createSouth());
		addNewNodeToOpenSet(from, from.getCoordinates().createWest());
		addNewNodeToOpenSet(from, from.getCoordinates().createNorthEast());
		addNewNodeToOpenSet(from, from.getCoordinates().createNorthWest());
		addNewNodeToOpenSet(from, from.getCoordinates().createSouthEast());
		addNewNodeToOpenSet(from, from.getCoordinates().createSouthWest());
	}
	
	private void addNewNodeToOpenSet(Node parent, Coordinates coordinates) {
		int areaField = this.area[coordinates.getY()][coordinates.getX()];
		
		if (areaField != -2 && areaField != -1) {
			Node node = new Node(coordinates);
			
			if (!this.closedSet.contains(node) && !this.openSet.contains(node)) {
				node.setHValue(calculateDistanceToEndNode(coordinates));
				node.setGValue(this.area[coordinates.getY()][coordinates.getX()]);
				node.setParent(parent);
				this.openSet.add(node);
			}
		}
	}
	
	private Node getClosestNodeFromOpenSet() {
		Node result;
		
		if(this.openSet.isEmpty()) {
			result = null;
		} else {
			Iterator<Node> openSetIterator = this.openSet.iterator();
			Node closestNode = openSetIterator.next();
			
			while (openSetIterator.hasNext()) {
				Node node = openSetIterator.next();
				
				if (closestNode.getFValue() > node.getFValue()) {
					closestNode = node;
				}
			}
			
			result = closestNode;
		}
		
		return result;
	}
	
	private List<Node> createPathFromNode(Node node) {
		LinkedList<Node> path = new LinkedList<>();
		path.add(node);
		
		Node parentNode = node.getParent();
		while(parentNode != null) {
			path.addFirst(parentNode);
			parentNode = parentNode.getParent();
		}
		
		return path;
	}
	
	
}
