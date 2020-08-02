import java.util.ArrayList;
import java.util.List;

/**
 * @author Liang Junjie
 * @version 1.0.0
 * @since 2020/6/4 20:21
 */
public class Solution2 {

    public boolean calc(TreeNode root) {
        if (root == null || isLeaf(root)) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }
        return calc(root.left, root.right);
    }

    private boolean calc(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.val == node2.val) {
            return calc(node1.left, node2.right) && calc(node1.right, node2.left);
        }
        return false;
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int count = 0;
        while (true) {
            list.add(String.valueOf(count++));
        }
    }
}
