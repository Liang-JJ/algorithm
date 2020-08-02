/**
 * LeetCode 114
 */
class SolutionL114 {
    public void flatten(TreeNode root) {
        flatten0(root);
    }


    private TreeNode flatten0(TreeNode root) {
        TreeNode temp;
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            temp = flatten0(root.left);
            temp.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        temp = root;
        while (temp.right != null) {
            temp = temp.right;
            if (temp.left != null) {
                flatten0(temp);
            }
        }
        return temp;

    }

}