package edu.uam.maxcliqueiithpivot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author rasgrass
 */
public final class Graph {

	private final int nodesCount;

	final List<Vertex> verticies = new ArrayList<>();

	public Graph(int nodesCount) {
		this.nodesCount = nodesCount;
		initGraph();
	}

	public int getNodesCount() {
		return nodesCount;
	}

	public List<Vertex> getVerticies() {
		return Collections.unmodifiableList(verticies);
	}
	
	List<Vertex> getNbrs(Vertex v) {
		int i = v.getX();
		return verticies.get(i).getNeighbours();
	}
	public static List<Vertex> removeNbrs(List<Vertex> arlFirst, Vertex v) {
		List<Vertex> result = new ArrayList<>(arlFirst);
		result.removeAll(v.getNeighbours());
		return result;
	}
	

	void initGraph() {
		verticies.clear();
		for (int i = 0; i < nodesCount; i++) {
			Vertex V = new Vertex();
			V.setX(i);
			verticies.add(V);
		}
	}
	
	void Bron_KerboschWithPivot(List<Vertex> R, List<Vertex> P,
			List<Vertex> X, String pre) {

	//	System.out.print(pre + " " + VertexSetUtil.printSet(R) + ", " + VertexSetUtil.printSet(P) + ", "
			//	+ VertexSetUtil.printSet(X));
		if ((P.isEmpty()) && (X.isEmpty())) {
			VertexSetUtil.printClique(R);
			return;
		}
		System.out.println();
		List<Vertex> P1 = new ArrayList<>(P);
		// Find Pivot 
		Vertex pivot = VertexSetUtil.getMaxDegreeVertex(VertexSetUtil.union(P, X));

		System.out.println("" + pre + " Pivot: " + (pivot.getX()));
		// P = P / Nbrs(u) 
		P = removeNbrs(P, pivot);

		for (Vertex v : P) {
			R.add(v);
			Bron_KerboschWithPivot(R, VertexSetUtil.intersect(P1, getNbrs(v)), VertexSetUtil.intersect(X, getNbrs(v)), pre);
			R.remove(v);
			P1.remove(v);
			X.add(v);
		}
	}

}
