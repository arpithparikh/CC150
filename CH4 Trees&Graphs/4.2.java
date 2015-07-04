//given a directed graph, design an algorithm to find out whether there is a route between two nodes
//using graph traversal to solve this problem, such as DFS/BFS
package CC150;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


class Node {
	public int val;
	public Set<Node> neighbors;
	Node(int v) {
		val = v;
		neighbors = new HashSet<Node>(); 
	}
}



// 时间复杂度: O(n),平均给每个节点入队出队次数为1，因此所有节点的操作平均复杂度为O(n)
// 空间复杂度: O(n), 用到了一个HashSet来存储已经访问过的节点，还有队列queue的空间。
public class Solution {

	public static boolean areConnected(Node src, Node dest) {
		HashSet<Node> visited = new HashSet<Node>();
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(src);
		while( queue.size() != 0 ){
			int size = queue.size();
			for(int i = 0; i < size; i++){
				Node temp = queue.poll();
				visited.add(temp);
				if( temp.neighbors.contains(dest) ){
					return true;
				}
				Iterator<Node> iter = temp.neighbors.iterator();
				while(iter.hasNext()){
					Node child = iter.next();
					if( visited.contains(child) ){
						continue;
					}
					queue.offer(child);
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {	

		Node n1 = new Node(0);
		Node n2 = new Node(1);
		Node n3 = new Node(2);
		Node n4 = new Node(3);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
 
		n1.neighbors.add(n2);
		n1.neighbors.add(n3);
		n2.neighbors.add(n4);
		n4.neighbors.add(n5);
		n4.neighbors.add(n1);
		n3.neighbors.add(n5);
		n3.neighbors.add(n3);
 
		System.out.println(!areConnected(n1, n6));
		System.out.println(areConnected(n1, n5));
		System.out.println(!areConnected(n5, n1));	
		System.out.println(areConnected(n1, n2));
		System.out.println(areConnected(n1, n3));
		System.out.println(areConnected(n1, n4));
		System.out.println(areConnected(n4, n1));
		System.out.println(areConnected(n3, n1));
		System.out.println(!areConnected(n5, n6));
		System.out.println(areConnected(n3, n3));		

		// T T T T T T T F T T 
	
	}		
}