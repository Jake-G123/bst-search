
import java.util.LinkedList;
import java.util.Queue;

public class BstSearch {
    /**
     * Returns whether a binary search tree contains a given value.
     * 
     * As a precondition, the input root is assumed to be the root of a binary
     * search tree; this is not validated by the method. Passing in an invalid
     * tree causes undefined behavior.
     * 
     * A null value for the root is considered to represent a valid but empty
     * binary search tree. A null root will cause this method to always return
     * false if a valid target is given.
     * 
     * @param <T> The type of the values held in the nodes
     * @param root the root of the binary search tree (assumed to be valid)
     * @param target the value to search for
     * @return true if the target is contained in the tree, false otherwise
     * @throws NullPointerException if target is null
     */
    public static <T extends Comparable<T>> boolean contains(BinaryTreeNode<T> root, T target) {
        if (target == null) throw new NullPointerException("Invalid target value.");
        if (root == null) return false;
        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode<T> current = queue.poll();
            if (current == null) continue;
            if (current.data.compareTo(target) == 0) return true;
            queue.add(current.left);
            queue.add(current.right);
        }
        return false;
    }
}
