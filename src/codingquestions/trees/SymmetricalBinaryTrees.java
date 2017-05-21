/**
 * 
 */
package codingquestions.trees;

import java.util.LinkedList;
import java.util.Queue;

import codingquestions.trees.TreeTraversal.Node;

/**
 * @author Sanjay
 *
 */
public class SymmetricalBinaryTrees {

	public class Node<T> {
		public T data;
		public Node<T> left;
		public Node<T> right;

		public Node(T num) {
			this.data = num;
			this.left = null;
			this.right = null;
		}

		public Node() {
			this.left = null;
			this.right = null;
		}

	}

	public boolean isMirrorTree(Node<?> tree, Node<?> mirrorTree) {
		if (null == tree && null == mirrorTree)
			return true;

		if (null == tree || null == mirrorTree)
			return false;

		if (tree.data != mirrorTree.data)
			return false;

		if (false == isMirrorTree(tree.left, mirrorTree.right))
			return false;

		if (false == isMirrorTree(tree.right, mirrorTree.left))
			return false;

		return true;
	}

	public void printTree(Node<?> root) {
		if (root == null) {
			System.out.println("Tree is empty");
			return;
		}
		Queue<Node<?>> queue = new LinkedList<Node<?>>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			Node<?>  node = queue.poll();
			System.out.printf("%d ", node.data);
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
		System.out.println("");
		return;
	}

	private void test() {
		// TODO Auto-generated method stub
		// Binary Tree 1:
		// root level 0
		Node<Integer> A = new Node<Integer>(70);
		// Level 1
		Node<Integer> B = new Node<Integer>(50);
		Node<Integer> C = new Node<Integer>(55);

		// Level 2
		Node<Integer> D = new Node<Integer>(25);

		Node<Integer> E = new Node<Integer>(80);
		Node<Integer> F = new Node<Integer>(37);
		Node<Integer> G = new Node<Integer>(45);

		// connect Level 0 and 1
		A.left = B;
		A.right = C;
		// connect level 1 and level 2
		B.left = D;
		B.right = E;
		C.left = F;
		C.right = G;

		// Binary Tree 2:

		// root level 0
		Node<Integer> P = new Node<Integer>(70);
		// Level 1
		Node<Integer> Q = new Node<Integer>(55);
		Node<Integer> R = new Node<Integer>(50);
		// Level 2
		Node<Integer> S = new Node<Integer>(45);
		Node<Integer> T = new Node<Integer>(37);
		Node<Integer> U = new Node<Integer>(80);
		Node<Integer> V = new Node<Integer>(25);

		// connect Level 0 and 1
		P.left = Q;
		P.right = R;
		// connect level 1 and level 2
		Q.left = S;
		Q.right = T;
		R.left = U;
		R.right = V;

		System.out.println("Binary Tree 1 :");
		printTree(A);
		System.out.println("Binary Tree 2 :");
		printTree(P);

		boolean isMirrorBinaryTrees = isMirrorTree(A, P);
		System.out.printf("Check Trees are mirror binary tree : %b", isMirrorBinaryTrees);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SymmetricalBinaryTrees sbt = new SymmetricalBinaryTrees();
		sbt.test();

	}

}
