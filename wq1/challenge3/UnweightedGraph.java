/*
Write a function that accepts 2 parameters, size and density, between 0 and 1,
which generates a random graph.
For example: genGraph(0.60, 0.35) might generate a graph around 60% of the maximum
possible size (max decided by you), with 35% of possible edges existing.

Now implement BFS on that graph, or Dijkstra’s if you chose to have weighted edges.
*/

/*this is a proof of concept - should implement generics to allow BFS on any object
which implements a comparator. Should also modify such that the actual path is
returned or displayed in some way
*/

import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Random;

class UnweightedGraph {
	private Random r = new Random(1);
	private int max_size = 12;	//a reasonable upper bound on demo graph size
	private double size;
	Map<Integer, ArrayList<Integer>> edges;
	
	UnweightedGraph(double size, double density) {
		
		this.size = max_size * size;
		edges = new HashMap<Integer, ArrayList<Integer>>();
		
		//generate graph edges. verts are indexed by ints and hold no data, so there's no need to store them
		for(int i = 0; i < this.size; i++) {
			for(int j = i+1; j < this.size; j++) {
				if(r.nextDouble() < density) {					
					//straightforward to express undirected graph with pairs of directed edges
					ArrayList<Integer> l1 = edges.get(i);
					ArrayList<Integer> l2 = edges.get(j);
					if(l1 == null) {
						edges.put(i, l1 = new ArrayList<Integer>());
					}
					if(l2 == null) {
						edges.put(j, l2 = new ArrayList<Integer>());
					}
					l1.add(j);
					l2.add(i);
				}
			}
		}
		//display edges
		for(ArrayList e : edges.values()) {
			System.out.println(e);
		}
	}

	boolean BFS(int A, int B) {
		//perform BFS to search for a path from A to B
		//returns true if path A-->B found
		
		try {
			if(A < 0 || B < 0 || A >= size || B >= size) {
				throw new IndexOutOfBoundsException();
			}
		}
		catch(Exception e) {
			System.out.println("passed invalid vertices");
			System.exit(1);
		}

		//track visited and keep queue of vertices to visit
		HashSet<Integer> visited = new HashSet<Integer>();
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		q.add(A);	//seed with first vertex
		
		while(q.size() > 0) {
			//check if destination node found
			if(q.peek() == B) {
				System.out.println("path found!");
				return true;
			}
			//otherwise mark as visited and continue queueing vertices
			visited.add(q.peek());
			ArrayList<Integer> nextVertices = edges.get(q.peek());
			q.remove(q.peek());
			for(int e : nextVertices) {
				if(!visited.contains(e)){
					q.add(e);	
				}
			}
		}
		System.out.println("no path found. :(");
		return false;
	}
	
	public static void main(String[] args) {
		UnweightedGraph g = new UnweightedGraph(0.5, 0.3);
		g.BFS(0,1);
		g.BFS(0,2);
		g.BFS(0,3);
		g.BFS(0,4);
		g.BFS(0,5);
	}
}