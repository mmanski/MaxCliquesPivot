package edu.uam.maxcliqueiithpivot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author rasgrass
 */
public class VertexSetUtil {

	public static List<Vertex> intersect(List<Vertex> arlFirst, List<Vertex> arlSecond) {
		List<Vertex> result = new ArrayList<>(arlFirst);
		result.retainAll(arlSecond);
		return result;
	}

	public static List<Vertex> union(List<Vertex> arlFirst, List<Vertex> arlSecond) {
		List<Vertex> result = new ArrayList<>(arlFirst);
		result.addAll(arlSecond);
		return result;
	}

	public static Vertex getMaxDegreeVertex(List<Vertex> g) {
		Collections.sort(g);
		return g.get(g.size() - 1);
	}

	public static String printSet(List<Vertex> Y) {
		StringBuilder strBuild = new StringBuilder();

		strBuild.append("{");
		for (Vertex v : Y) {
			strBuild.append("").append(v.getX()).append(",");
		}
		if (strBuild.length() != 1) {
			strBuild.setLength(strBuild.length() - 1);
		}
		strBuild.append("}");
		return strBuild.toString();
	}

	public static void printClique(List<Vertex> R) {
		System.out.print("  --- Kilka maksymalna: ");
		for (Vertex v : R) {
			System.out.print(" " + (v.getX()));
		}
		System.out.println();
	}

}
