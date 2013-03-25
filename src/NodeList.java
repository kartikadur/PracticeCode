import java.math.BigDecimal;


public class NodeList {

	private Node root;
	private int N = 0;
	
	private class Node {
		public int val;
		public Node next;
		public Node prev;
		
		public Node (int val) {
			this.val = val;
		}
	}
	
	public boolean isEmpty(){
		return size() == 0;
	}
	
	public int size() {
		return N;
	}
	
	
	public int add(Node x, int val) {
		Node temp = new Node(val);
		while(val >= x.val) {
			if(x.next == null){
				x.next = temp;
				temp.prev = x;
				N++;
				return val;
			}
			x = x.next;
		}
		if(x.prev == null){
			root = temp;
		}else{
			x.prev.next = temp;
		}
		temp.next = x;
		x.prev = temp;
		
		N++;
		return val;
		
	}
	
	public int add(int val) {
		if(root == null) { root = new Node(val); N++; return val;}
		return add(root, val);
	}
	
	public int rem (Node x, int val) {
		while (val > x.val && x.next != null) {
			x = x.next;
		}
		if(x.val > val && x.next == null) { return -1; }
		if(x.prev != null) x.prev.next = x.next;
		if(x.next != null) x.next.prev = x.prev;
		if(x.prev == null) root = x.next;
		N--;
		return x.val;
	}
	
	
	public int rem (int val) {
		if(root == null) { return -1; }
		return rem(root, val);		
	}
	
	public String median () {
		Node x = root; int lim;
		if (N == 0) {
			return "Wrong!";
		} else if (N == 1) {
			return String.valueOf(x.val).replaceAll("(?<=^\\d+)\\.0*$", "");
		} else if (N == 2) {
			return String.valueOf((x.val + x.next.val)/ 2.0).replaceAll("(?<=^\\d+)\\.0*$", "");
		} else if (N % 2 == 1){
			//odd
			lim = (N + 1) / 2;
		} else {
			//even
			lim = N / 2;
		}
		for(int i = 1; i < lim; i++){
			x = x.next;
		}
		if (N % 2 == 1){
			//odd
			return String.valueOf(x.val).replaceAll("(?<=^\\d+)\\.0*$", "");
		} else {
			//even
			return String.valueOf((x.val + x.next.val) / 2.0).replaceAll("(?<=^\\d+)\\.0*$", "");
		}
		
	}
	
	public String toString() {
		Node x = root;
		StringBuilder s = new StringBuilder();
		s.append(x.val);
		while(x.next != null) {
			x = x.next;
			s.append(" " + x.val);
		}
		return s.toString();
	}
	
}