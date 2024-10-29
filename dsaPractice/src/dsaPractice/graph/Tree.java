package dsaPractice.graph;

import java.util.*;

public class Tree {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	static class TreeInfo {
		int ht;
		int diam;

		public TreeInfo(int ht, int diam) {
			this.ht = ht;
			this.diam = diam;
		}
	}

	static class BinaryTree {
		static int idx = -1;

		// {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1}
		public static Node buildTree(int nodes[]) {
			idx++;
			if (nodes[idx] == -1) {
				return null;
			}

			Node newNode = new Node(nodes[idx]);
			newNode.left = buildTree(nodes);
			newNode.right = buildTree(nodes);

			return newNode;
		}
	}

	// 1 2 4 5 3 6
	public static void preorder(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preorder(root.left);
		preorder(root.right);
	}

	// 4 2 5 1 3 6
	public static void inorder(Node root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

	// 4 5 2 6 3 1
	public static void postorder(Node root) {
		if (root == null) {
			return;
		}
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data + " ");

	}

	/*
	 * 1 23 456
	 */
	public static void levelOrder(Node root) {
		if (root == null) {
			return;
		}
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		q.offer(null);

		while (!q.isEmpty()) {
			Node currNode = q.poll();
			if (currNode == null) {
				System.out.println();
				if (q.isEmpty()) {
					break;
				} else {
					q.offer(null);
				}
			} else {
				System.out.print(currNode.data);
				if (currNode.left != null) {
					q.offer(currNode.left);
				}
				if (currNode.right != null) {
					q.offer(currNode.right);
				}
			}
		}
	}

	public static int countOfNodes(Node root) {
		if (root == null) {
			return 0;
		}

		int leftNodes = countOfNodes(root.left);
		int rightNodes = countOfNodes(root.right);

		return leftNodes + rightNodes + 1;

	}

	public static int sumOfNodes(Node root) {
		if (root == null) {
			return 0;
		}
		int leftSum = sumOfNodes(root.left);
		int rightSum = sumOfNodes(root.right);

		return leftSum + rightSum + root.data;
	}

	public static int heightOfTree(Node root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = heightOfTree(root.left);
		int rightHeight = heightOfTree(root.right);
		int myHeight = Math.max(leftHeight, rightHeight) + 1;
		return myHeight;
	}

	public static int diameter(Node root) {
		if (root == null) {
			return 0;
		}
		int diam1 = diameter(root.left);
		int diam2 = diameter(root.right);
		int diam3 = heightOfTree(root.left) + heightOfTree(root.right) + 1;

		return Math.max(diam3, Math.max(diam1, diam2));
	}

	public static TreeInfo diameter2(Node root) {
		if (root == null) {
			return new TreeInfo(0, 0);
		}
		TreeInfo left = diameter2(root.left);
		TreeInfo right = diameter2(root.right);
		int myHeight = Math.max(left.ht, right.ht) + 1;
		int Diam1 = left.diam;
		int Diam2 = right.diam;
		int Diam3 = left.ht + right.ht + 1;

		int myDiam = Math.max(Math.max(Diam1, Diam2), Diam3);
		TreeInfo myInfo = new TreeInfo(myHeight, myDiam);
		return myInfo;
	}

	public static boolean isSubtree(Node root, Node subRoot) {

		return false;
	}

	public static void main(String[] args) {
		int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
		int[] subnodes = { 1, 2, -1, -1, 3, -1, -1 };
		Node root = BinaryTree.buildTree(nodes);
		Node subroot = BinaryTree.buildTree(subnodes);

//		System.out.println(root.data);
		System.out.print("Preorder:> ");
		preorder(root);
		System.out.println();
		System.out.print("Inorder:> ");
		inorder(root);
		System.out.println();
		System.out.print("Postorder:> ");
		postorder(root);
		System.out.println();
		System.out.println("Level order:> ");
		levelOrder(root);
		System.out.println("Count of Total Nodes=" + countOfNodes(root));
		System.out.println("Sum of Total Nodes=" + sumOfNodes(root));
		System.out.println("Height of Tree=" + heightOfTree(root));
		System.out.println("Maximum Diameter=" + diameter(root));
		System.out.println("Maximum Diameter by diam2 =" + diameter2(root).diam);
		System.out.println("is Subtree=" + isSubtree(root, root));

	}

}
