public class BT2{
	private Node root;

	public static void main(String [] args){
		BT2 bt = new BT2();
		bt.addNode(4);
		bt.addNode(3);
		bt.addNode(8);
		bt.addNode(1);
		bt.inOrderTraversal(bt.root);
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
		inOrderTraversal(n.left);
		System.out.println(n.data);
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

	public Node(int d){
		data=d;
	}
	public String toString(){
		return "Data: "+data+" left: "+ left + " right "+right;
	}
}
