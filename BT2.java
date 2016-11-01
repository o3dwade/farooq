import java.util.*;
public class BT2{
	private Node root;

	public static void main(String [] args){
		BT2 bt = new BT2();
		bt.addNode(5);
		bt.addNode(3);
		bt.addNode(7);
		bt.addNode(2);
		bt.addNode(4);
		bt.addNode(6);
		bt.addNode(8);
		bt.getNeighbor(bt.root);
		System.out.println(bt.root+" : "+bt.root.neighbor);
		System.out.println(bt.root.left+" : "+bt.root.left.neighbor);
		System.out.println(bt.root.left.left+" : "+bt.root.left.left.neighbor);
		System.out.println(bt.root.left.right+" : "+bt.root.left.right.neighbor);
		System.out.println("\n");
		System.out.println(bt.root.right+" : "+bt.root.right.neighbor);
		System.out.println(bt.root.right.left+" : "+bt.root.right.left.neighbor);
		System.out.println(bt.root.right.right+" : "+bt.root.right.right.neighbor);
		//bt.DFS(bt.root);
	}

	public void getNeighbor(Node n){

		if(n==null)
			return;
		Node parent;
		Queue<Node> q = new LinkedList<Node>();
		List<Node> visited = new ArrayList<Node>();
		q.add(n);

		while(!q.isEmpty()){
			Node focusNode = q.remove();
			visited.add(focusNode);	
			parent = focusNode;
			
			if(focusNode.left!=null){
				focusNode = focusNode.left;
				focusNode.neighbor = parent.right;

				if(!visited.contains(parent.left)){
					q.add(parent.left);
				}
			}
			if(parent.right!=null){
				if(!visited.contains(parent.right)){
					q.add(parent.right);
				}
			}


		}



	}

	


	public void DFS(Node root){
		Stack<Node> nodes = new Stack<Node>();
		nodes.push(root);

		while(!nodes.empty()){
			Node n = nodes.pop();
			//System.out.println("Reached leaf "+n.data+" end");	
			if(n.right == null && n.left == null)
				System.out.println("Reached leaf "+n.data+" end");
			else{
				if(n.left != null)
					nodes.push(n.left);
				if(n.right != null){
					nodes.push(n.right);
				}
			}
		}

	}




	public void addNode(int d){
		Node n = new Node(d);

		if(root==null){
			root=n;
			return;
		}
		else{
			Node curr = root;
			Node p;
			while(true){
				if(d<=curr.data){
					p = curr;
					curr = curr.left;
					if ( curr == null){
						p.left = n;
						return;
					}
				}
				else{	
					p = curr;
					curr = curr.right;
					if ( curr == null){
						p.right = n;
						return;
					}
				}
			}

		}
	}


	public void inOrderTraversal(Node n){
	if (n!= null){
		System.out.println(n.data);
		inOrderTraversal(n.left);
		inOrderTraversal(n.right);
	}


	}
	public String toString(){
		String str = "";
		return ""+root;
	}
}

class Node{
	int data;
	Node left;
	Node right;
	Node neighbor;
	public Node(int d){
		data=d;
	}
	public String toString(){
		return "Data: "+data;
	}
}
