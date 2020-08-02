import java.util.LinkedList;
import java.util.Queue;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode current;
        while (!queue.isEmpty()) {
            current = queue.poll();
            if (current != null) {
                queue.offer(current.left);
                queue.offer(current.right);
                sb.append(current.val);
            } else {
                sb.append("null");
            }
            sb.append(',');
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || "".equals(data)) {
            return null;
        }
        String[] strs = data.split(",");
        Queue<Pair<TreeNode, TreeNode>> queue = new LinkedList<>();
        TreeNode head = new TreeNode();
        Pair<TreeNode, TreeNode> headPair = new Pair<>(null, head);
        queue.offer(headPair);
        for (String str : strs) {
            Pair<TreeNode, TreeNode> currentPair = queue.poll();
            if (currentPair == null) {
                break;
            }
            TreeNode current = currentPair.value;
            TreeNode currentParent = currentPair.key;
            if ("null".equals(str)) {
                if (current.val == 0) {
                    // 左节点
                    currentParent.left = null;
                } else {
                    currentParent.right = null;
                }
            } else {
                if (currentParent != null) {
                    if (current.val == 0) {
                        currentParent.left = current;
                    } else {
                        currentParent.right = current;
                    }
                }
                // 暂用0和1标识左右节点
                TreeNode left = new TreeNode(0);
                Pair<TreeNode, TreeNode> leftParentPair = new Pair<>(current, left);
                TreeNode right = new TreeNode(1);
                Pair<TreeNode, TreeNode> rightParentPair = new Pair<>(current, right);
                queue.offer(leftParentPair);
                queue.offer(rightParentPair);
                current.val = Integer.parseInt(str);

            }
        }
        return head;
    }

    private static class Pair<K, V> {
        K key;
        V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        String serialize = codec.serialize(TreeNode.generateTreeNode(new Integer[]{1, 2, 3, null, null, 4, 5}));
        codec.deserialize(serialize);
    }

}