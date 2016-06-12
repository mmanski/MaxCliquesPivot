package edu.uam.maxcliqueiithpivot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class MaximalCliquesWithPivot {

	private Graph graph;

	int readTotalGraphCount(BufferedReader bufReader) throws Exception {

		return Integer.parseInt(bufReader.readLine());
	}

	void Bron_KerboschPivotExecute() {

		List<Vertex> X = new ArrayList<>();
		List<Vertex> R = new ArrayList<>();
		List<Vertex> P = new ArrayList<>(graph.getVerticies());
		graph.Bron_KerboschWithPivot(R, P, X, "");
	}

	public static void main(String[] args) {
		BufferedReader bufReader = null;
		if (args.length > 0) {
			// Unit Test Mode 
			bufReader = new BufferedReader(new StringReader(
					"1\n"
					+ "4\n"
					+ "4\n"
					+ "0 1\n"
					+ "0 2\n"
					+ "1 2\n"
					+ "1 3"));
		} else {
			File file = new File("C:\\graphAlgos\\mc1.txt");
			try {
				bufReader = new BufferedReader(new FileReader(file));
			} catch (Exception e) {
				return;
			}
		}
		MaximalCliquesWithPivot ff = new MaximalCliquesWithPivot();
		try {
			int totalGraphs = ff.readTotalGraphCount(bufReader);
			System.out.println("Max Cliques with Pivot");
			for (int i = 0; i < totalGraphs; i++) {
				System.out.println("************** Start Graph " + (i + 1)
						+ "******************************");
				ff.readNextGraph(bufReader);
				ff.Bron_KerboschPivotExecute();

			}
		} catch (Exception e) {
			System.err.println("Exiting : " + e);
		} finally {
			try {
				bufReader.close();
			} catch (Exception f) {

			}
		}
	}

	void readNextGraph(BufferedReader bufReader) throws Exception {
		try {
			graph = new Graph(Integer.parseInt(bufReader.readLine()));
			int edgesCount = Integer.parseInt(bufReader.readLine());

			for (int k = 0; k < edgesCount; k++) {
				String[] strArr = bufReader.readLine().split(" ");
				int u = Integer.parseInt(strArr[0]);
				int v = Integer.parseInt(strArr[1]);
				Vertex vertU = graph.getVerticies().get(u);
				Vertex vertV = graph.getVerticies().get(v);
				vertU.addNbr(vertV);

			}

		} catch (IOException | NumberFormatException e) {
			System.err.println(e);
		}
	}
}
