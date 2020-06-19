package Algoritmi;

public class AVLTreePQ implements CoadaDePrioritate {
	private Node root;

	class Node {
		private int priority;
		private int count;
		private int balance;
		private int height;
		private Node left;
		private Node right;
		private Node parent;

		Node(int priority, Node parent) {
			this.priority = priority;
			this.parent = parent;
			this.count = 1;
			this.left = null;
			this.right = null;
		}
	}

	public AVLTreePQ() {
		this.root = null;
	}

	@Override
	public Integer getMax() {
		if(root == null)
			return -1;
		Node max = root;
		while (max.right != null)
			max = max.right;
		return max.priority;
	}

	@Override
	public Integer removeMax() {
		if(root == null)
			return -1;
		Node max = root;
		while (max.right != null)
			max = max.right;
		Integer maximum = max.priority;
		max.count--;
		if (max.count == 0)
			deleteNode(max);
		return maximum;
	}

	@Override
	public void insert(int element) {
		if (this.root == null) {
			root = new Node(element, null);
			return;
		}

		Node n = root;
		while (true) {
			if (n.priority == element) {
				n.count++;
				break;
			}

			Node parent = n;

			if (n.priority > element)
				n = n.left;
			else
				n = n.right;

			if (n == null) {
				if (parent.priority > element)
					parent.left = new Node(element, parent);
				else
					parent.right = new Node(element, parent);
				rebalance(parent);
				break;
			}
		}
	}

	private void rebalance(Node n) {
		setBalance(n);
		if (n.balance == -2) {
			if (height(n.left.left) >= height(n.left.right))
				n = rotateRight(n);
			else
				n = rotateLeftThenRight(n);
		} else if (n.balance == 2) {
			if (height(n.right.right) >= height(n.right.left))
				n = rotateLeft(n);
			else
				n = rotateRightThenLeft(n);
		}
		if (n.parent != null)
			rebalance(n.parent);
		else
			root = n;
	}

	private Node rotateLeft(Node a) {
		Node b = a.right;
		b.parent = a.parent;
		a.right = b.left;
		if (a.right != null)
			a.right.parent = a;
		b.left = a;
		a.parent = b;
		if (b.parent != null) {
			if (b.parent.right == a)
				b.parent.right = b;
			else
				b.parent.left = b;
		}
		setBalance(a, b);
		return b;
	}

	private Node rotateRight(Node a) {
		Node b = a.left;
		b.parent = a.parent;
		a.left = b.right;
		if (a.left != null)
			a.left.parent = a;
		b.right = a;
		a.parent = b;
		if (b.parent != null) {
			if (b.parent.right == a)
				b.parent.right = b;
			else
				b.parent.left = b;
		}
		setBalance(a, b);
		return b;
	}
	
	private Node rotateLeftThenRight(Node n) {
		n.left = rotateLeft(n.left);
		return rotateRight(n);
	}
	
	private Node rotateRightThenLeft(Node n) {
		n.right = rotateRight(n.right);
		return rotateLeft(n);
	}

	private int height(Node n) {
		if (n == null)
			return -1;
		return n.height;
	}

	private void setBalance(Node... nodes) {
		for (Node n : nodes) {
			reheight(n);
			n.balance = height(n.right) - height(n.left);
		}
	}

	private void reheight(Node node) {
		if (node != null)
			node.height = 1 + Math.max(height(node.left), height(node.right));

	}
	
	private void deleteNode(Node n) {
		if(n.left == null && n.right == null) {
			if(n.parent == null)
				root = null;
			else {
				Node parent = n.parent;
				if(parent.left == n)
					parent.left = null;
				else
					parent.right = null;
				rebalance(parent);
			}
			return;
		}
		
		if(n.left != null) {
			Node child = n.left;
			while(child.right != null)
				child = child.right;
			n.priority = child.priority;
			n.count = child.count;
			deleteNode(child);
		} else {
			Node child = n.right;
			while(child.left != null)
				child = child.left;
			n.priority = child.priority;
			n.count = child.count;
			deleteNode(child);
		}
	}
}
