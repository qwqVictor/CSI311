/**
 * @author Huang Kaisheng (2020215138@stu.cqupt.edu.cn)
 * @version 1.0
 */
public class TreeNode<T> {

	public T value;
	public TreeNode<T> left, right;

	/**
	 * Constructs an empty node.
	 */
	public TreeNode() {
		this(null, null, null);
	}

	/**
	 * Constructs a node with value.
	 * 
	 * @param value the value of the node
	 */
	public TreeNode(T value) {
		this(value, null, null);
	}

	/**
	 * Constructs a node with value and two childs.
	 * 
	 * @param value the value of the node
	 * @param left  the left child
	 * @param right the right child
	 */
	public TreeNode(T value, TreeNode<T> left, TreeNode<T> right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

	/**
	 * Returns the value of this node.
	 * 
	 * @return A reference to the value of this node
	 */
	public T getValue() {
		return this.value;
	}

	/**
	 * Returns the string representation
	 * 
	 * @return the string representation
	 */
	public String toString() {
		return this.toString(0);
	}

	public String toString(int indent) {
		String initialIndent = indent == 0 ? "" : String.format("%"+indent*2+"s","");
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("{ value: %s, ", this.value.toString()));
		String left = this.left == null ? "null" : this.left.toString(indent+1);
		String right = this.right == null ? "null" : this.right.toString(indent+1);
		if (left.length() < 20) {
			sb.append(String.format("\n%s  left: %s, ", initialIndent, left));
		}
		else {
			sb.append(String.format("\n%s  left:\n  %s%s, ", initialIndent, initialIndent, left));
		}
		if (right.length() < 20) {
			sb.append(String.format("\n%s  right: %s", initialIndent, right));
		} else {
			sb.append(String.format("\n%s  right:\n  %s%s", initialIndent, initialIndent, right));
		}
		if (left.length() >= 20 || right.length() >= 20) {
			sb.append("\n" + initialIndent + "}");
		}
		else {
			sb.append(" }");
		}
		return sb.toString();
	}
}
