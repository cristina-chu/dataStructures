import static org.junit.Assert.*;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.*;
import java.util.*;


public class SZJunit {
	ArrayList<Edge> wiki;
	Collection<Edge> answer;
	Vertex a,b,c,d,e,f,g;
	HashSet<Vertex> setwiki;
	DisjointSet<Vertex> disjoint1;
	AdjacencyList adjacency1;
	HashMap<Vertex, List<Pair>> mapwiki;
	
	@Before
	public void setUp() throws Exception {
		//WIKI TEST 
		wiki = new ArrayList<Edge>();
		a = new Vertex("A");b=new Vertex("B");c= new Vertex("C");d=new Vertex("D");
		e=new Vertex("E");f=new Vertex("F");g=new Vertex("G");
		wiki.add(new Edge(a,b,7));
		wiki.add(new Edge(a,d,5));
		wiki.add(new Edge(d,b,9));
		wiki.add(new Edge(d,f,6));
		wiki.add(new Edge(d,e,15));
		wiki.add(new Edge(f,e,8));
		wiki.add(new Edge(f,g,11));
		wiki.add(new Edge(g,e,9));
		wiki.add(new Edge(b,e,7));
		wiki.add(new Edge(b,c,8));
		wiki.add(new Edge(e,c,5));
		setwiki= new HashSet<Vertex>();
		for (Edge e:wiki){
			if(!setwiki.contains(e.u)) setwiki.add(e.u);
			if(!setwiki.contains(e.v)) setwiki.add(e.v); 
		}
	}

	@After
	public void tearDown() throws Exception {

	}
	
	@Test
	public void testDisjointSetBaseCase() {
		 
		 // this is when nothing has been added yet
		disjoint1 = new DisjointSet<Vertex>(setwiki);
		System.out.println(disjoint1.find(a));
		System.out.println(disjoint1.find(b));
		assertEquals(a,disjoint1.find(a));
		assertEquals(b,disjoint1.find(b));
		disjoint1.merge(a,b);
		//after merge they should point to the same root
		assertEquals(disjoint1.find(a),disjoint1.find(b));
		disjoint1.merge(c,d);
		assertFalse(disjoint1.find(c).equals(disjoint1.find(b)));
		disjoint1.merge(d,a);
		//after this merge they whould have the same parent
		assertEquals(disjoint1.find(c),disjoint1.find(b));
	}
	
	
	@Test 
	public void testAdjacencylistBaseCase(){
		adjacency1 = new AdjacencyList(wiki);
		mapwiki = (HashMap<Vertex, List<Pair>>) adjacency1.getAdjacencyList();
		assertEquals(7,mapwiki.size());
		System.out.println("===AdjacencyList Base Case===");
		for (Vertex v:mapwiki.keySet()){
			System.out.println(v.name+" : ");
			for(Pair p: mapwiki.get(v)){
				System.out.println("     "+p.vertex.name +", "+p.weight);
			}
			System.out.println();
		}
		System.out.println("\nAnswer:");
		System.out.println("refer to the attached picture");

	}
	
	
	@Test 
	public void testMSTPrimBaseCase(){
		answer = MST.prims(d, new AdjacencyList(wiki));
		System.out.println("size should be 6: "+answer.size());
		assertEquals(6, answer.size());
		System.out.println("===Prim's Base Test===");
		for (Edge e: answer){
			System.out.println(e.v.name+"---"+e.weight+"---"+e.u.name);
		}
		System.out.println("\nAnswer:\n");
		System.out.println("A---5---D\nE---5---C\nD---6---F\nA---7---B\nB---7---E\nG---9---E");
		System.out.println("===end test===\n\n");		
	}
    
	
	
	@Test 
	public void testMSTKrukalBaseCase(){
		answer = MST.kruskals(wiki);
		//should only have 6 connections
		System.out.println(answer);
		System.out.println(answer.size());
		assertEquals(6, answer.size());
		System.out.println("===Kruskal's Base Test===");
		for (Edge e: answer){
			System.out.println(e.v.name+"---"+e.weight+"---"+e.u.name);
		}
		System.out.println("\nAnswer:\n");
		System.out.println("A---5---D\nE---5---C\nD---6---F\nA---7---B\nB---7---E\nG---9---E");
		System.out.println("===end test===\n\n");
	}
	

}
