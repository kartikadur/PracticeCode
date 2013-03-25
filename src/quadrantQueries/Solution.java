package quadrantQueries;

import java.util.Scanner;

public class Solution {

	private static Node[] q = new Node[4];
	
	private static class Node {
		private int idx;
		private int N;
		private Node lt = null;
		private Node rt = null;
		
		public Node (int idx, int N) {
			this.idx = idx;
			this.N = N;
//			this.Quad =  x > 0 ?  y > 0 ? 0 : 3 : y > 0 ? 1 : 2;
		}
		
		public String toString() {
			return "ID: " + idx + ", size: " + N;
		}
	}
	
	private static int size(Node root) {
		if (root == null) return 0;
		else return root.N;
	}
	
	//Put Node into root for quadrant
	private static Node put(Node root, int idx){
		if(root == null) return new Node(idx, 1);
		if      (idx < root.idx) root.lt = put(root.lt, idx);
		else if (idx > root.idx) root.lt = put(root.rt, idx);
		else    root.idx = idx;
		root.N = 1 + size(root.lt) + size(root.rt);
		System.out.println(root.N);
		return root;	
	}
	
	public static void put(int quad, int idx){
//		System.out.println(quad);
		q[quad] = put(q[quad], idx);
	}
	
	private static Node get(Node root, int idx) {
		if(root == null) return null;
		if      (idx < root.idx) return get(root.lt, idx);
		else if (idx > root.idx) return get(root.rt, idx);
		else 	return root;	
	}
	
	public static boolean contains(int quad, int idx) {
		return get(q[quad], idx) != null;
	}
	
	private static Node min(Node root){
		if(root.lt == null) return root;
		else return min(root.lt);
	}
	
	private static Node deleteMin(Node root) {
		if (root.lt == null) return root.rt;
		root.lt = deleteMin(root.lt);
		root.N = size(root.lt) + size(root.rt) + 1;
		return root;
	}
	
	private static Node remove(Node root, int idx) {
		if (root == null) return null;
		if (idx < root.idx)  root.lt = remove(root.lt, idx);
		else if (idx > root.idx) root.rt = remove(root.rt, idx);
		else {
			if (root.rt == null) return root.lt;
			if (root.lt == null) return root.rt;
			Node t = root;
			root = min(t.rt);
			root.rt = deleteMin(t.rt);
			root.lt = t.lt;
			
		}
		return root;
	}
	
	public static void remove(int quad, int idx) {
		q[quad] = remove(q[quad], idx);
	}
	
	public static void transformX(int quad, int idxLo, int idxHi) {
		for (int i = idxLo; i < idxHi; i++) {
			remove(quad, i);
			put((quad^3), i);
		}
	}
	
	public static void transformY(int quad, int idxLo, int idxHi) {
		for (int i = idxLo; i < idxHi; i++) {
			remove(quad, i);
			put((quad^1), i);
		}
	}
	
	public static int size(int quad, int idxLo, int idxHi) {
		if (idxLo > idxHi) return 0;
		if (contains(quad, idxHi)) return rank(quad, idxHi) - rank(quad, idxLo) + 1;
		else                       return rank(quad, idxHi) - rank(quad, idxLo);
		
	}
	
	private static int rank(Node root, int idx) {
		if (root == null) return 0;
		if      (idx < root.idx) return rank(root.lt, idx);
		else if (idx > root.idx) return 1 + size(root.lt) + rank(root.rt, idx);
		else	return size(root.lt);
		
	}
	
	public static int rank(int quad, int idx) {
		return rank(q[quad], idx);
	}
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int N, Q;
		String qry;
		int qryS, qryD;
		
		N = in.nextInt();
		
		for(int i = 0; i < N; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			put( x > 0 ?  y > 0 ? 0 : 3 : y > 0 ? 1 : 2, i);
			System.out.println(contains( x > 0 ?  y > 0 ? 0 : 3 : y > 0 ? 1 : 2, i));
		}
		
		Q = in.nextInt();
		
		for(int i = 0; i < Q; i++) {
			qry = in.next();
			qryS = in.nextInt();
			qryD = in.nextInt();
			switch(qry) {
			case "C":
				for (int j = 0; j < 4; j++) {
					System.out.print(size(i, qryS -1, qryD) + " ");
				}
				System.out.println();
				//search each quadrant root
				break;
			case "X":
				for (int j = 0; j < 4; j++) {

					System.out.println(size(q[i]));
//					transformX(i, qryS - 1, qryD);
				}
//				for(int j = qryS - 1; j < qryD; j++){
//					System.out.println(remove(0, j));
//				}
				//search each quadrant root
				break;
			case "Y":
				for (int j = 0; j < 4; j++) {
					transformY(i, qryS - 1, qryD);
				}
				//search each quadrant root
				break;
			}
		}
	}
	
}