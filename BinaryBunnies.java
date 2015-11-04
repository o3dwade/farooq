
public class BinaryBunnies { 



	Node root;
	String str = "";

	public static void main(String [] args){
		BinaryBunnies b = new BinaryBunnies();
		b.addNode(5);b.addNode(2);b.addNode(9);b.addNode(1);b.addNode(8);
		b.inOrderTraversal(b.root);
		System.out.println(b.str);
	}

	public void addNode(int data){
		Node n = new Node(data);

		if (root == null){
			root = n;
			return;
		}

		else{
			Node curr = root;
			Node parent;
			while (true){
				if ( data < curr.data){
					parent = curr;
					curr = curr.right;
					if (curr == null){
						parent.right = n;
						return;
					}
				}
				else{
					parent = curr;
					curr = curr.left;
					if ( curr == null){
						parent.left = n;
						return;
					}
				}
			}
		}
	}

	public void inOrderTraversal (Node curr){
		if (curr!=null){
			inOrderTraversal(curr.right);
			str = str + curr.data +" ";
			inOrderTraversal(curr.left);
		}
	}

    public static String answer(int[] seq) { 
    	String str="";
        // Your code goes here.

        return str;

    } 


    class Node{

    	int data;
    	Node left;
    	Node right;

    	public Node(int d){
    		data = d;
    	}

    }
}