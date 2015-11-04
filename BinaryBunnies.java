
public class BinaryBunnies { 



	Node root;
	String str = "";

	public static void main(String [] args){
		BinaryBunnies b = new BinaryBunnies();
                BinaryBunnies c = new BinaryBunnies();
                BinaryBunnies d = new BinaryBunnies();
                BinaryBunnies e = new BinaryBunnies();
                c.addNode(5);c.addNode(9);c.addNode(8);c.addNode(2);c.addNode(1);
		b.addNode(5);b.addNode(2);b.addNode(9);b.addNode(1);b.addNode(8);
                d.addNode(1);d.addNode(2);d.addNode(3);d.addNode(4);d.addNode(5);
                e.addNode(3);e.addNode(1);e.addNode(4);e.addNode(5);e.addNode(2);
		b.inOrderTraversal(b.root);
                c.inOrderTraversal(c.root);
                d.inOrderTraversal(d.root);
                e.inOrderTraversal(e.root);
		System.out.println(b.str);
                System.out.println(c.str);
                System.out.println(d.str);
                System.out.println(e.str);
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
                        str = str + curr.data +" ";
			inOrderTraversal(curr.right);
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
