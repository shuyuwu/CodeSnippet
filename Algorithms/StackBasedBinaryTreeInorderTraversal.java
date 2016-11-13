/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution
{
    public List<Integer> inorderTraversal(TreeNode root)
    {
        List<Integer> l = new ArrayList<Integer>();

        if (root == null)
        {
            return l;
        }

        Stack<TreeNode> s = new Stack<>();

        TreeNode curr = root;
        while (curr != null)
        {
            s.push(curr);
            curr = curr.left;
        }

        // Each of the following while loop iteration
        // is a step to visit the next node
        while (!s.empty())
        {
            curr = s.pop();

            l.add(curr.val); // Visit current node

            if (curr.right != null)
            {
                curr = curr.right;
                while (curr != null)
                {
                    s.push(curr);
                    curr = curr.left;
                }
            }
        }

        return l;
    }
}