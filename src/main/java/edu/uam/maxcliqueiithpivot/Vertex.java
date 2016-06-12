package edu.uam.maxcliqueiithpivot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author rasgrass
 */
public class Vertex implements Comparable<Vertex> {

	private int x;

	private int degree;

	private List<Vertex> neighbours = new ArrayList<>();

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getDegree() {
		return degree;
	}

	public List<Vertex> getNeighbours() {
		return Collections.unmodifiableList(neighbours);
	}

	public void addNeighbour(Vertex vertex) {
		this.neighbours.add(vertex);
		this.degree++;
	}

	public void setNbrs(List<Vertex> nbrs) {
		this.neighbours = new ArrayList<>(nbrs);
	}

	public void addNbr(Vertex y) {
		this.neighbours.add(y);
		if (!y.getNeighbours().contains(y)) {
			y.addNeighbour(this);
		}
		this.degree++;

	}

	public void removeNbr(Vertex y) {
		this.neighbours.remove(y);
		if (y.getNeighbours().contains(y)) {
			y.removeNbr(this);
		}
		this.degree--;

	}

	@Override
	public int compareTo(Vertex o) {
		if (this.degree < o.getDegree()) {
			return -1;
		}
		if (this.degree > o.getDegree()) {
			return 1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "" + x;
	}
}
