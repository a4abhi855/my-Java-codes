package dsaPractice.graph;

import java.util.ArrayList;
import java.util.Scanner;

public class GraphIntro {

	int e, v;

	public GraphIntro(int e, int v) {
		this.e = e;
		this.v = v;
	}

	int adjecencyMatrix[][] = new int[v + 1][v + 1];
	ArrayList<ArrayList<Integer>> adjecencyList=new ArrayList<>();

	for(int i = 0;i<=v;i++)
	{
		adjecencyList.add(new ArrayList<Integer>());
	}

	public void addEdges(int source, int dest) {
		adjecencyMatrix[source][dest]=1;
		adjecencyMatrix[dest][source]=1;	
	}

	public void addEdgesInList(int source, int dest) {
		adjecencyList.get(source).add(dest);
		adjecencyList.get(dest).add(source);
		
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter edge and vertices: ");
		int e=sc.nextInt(),v=sc.nextInt();
		int source, dest;
		System.out.println("enter source: ");
		source=sc.nextInt();
		System.out.println("enter dest: ");
		dest=sc.nextInt();
		GraphIntro gr=new GraphIntro(e, v);
		gr.addEdges(source,dest);
		gr.addEdgesInList(source, dest);
		

	}

}
