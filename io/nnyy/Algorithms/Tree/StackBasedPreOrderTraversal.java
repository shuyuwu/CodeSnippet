package io.nnyy.Algorithms.Tree;

import java.util.*;

public class StackBasedPreOrderTraversal
{
    public List<Integer> preorderTraversal(TreeNode root)
    {
        List<Integer> l = new ArrayList<>();

        if (root == null) return l;

        TreeNode curr = root;

        Stack<TreeNode> s = new Stack<>();
        while (curr != null)
        {
            l.add(curr.val); // Visit current node

            s.push(curr);
            curr = curr.left;
        }

        // Each of the following while loop iteration
        // is a step to visit the next node
        while (!s.empty())
        {
            curr = s.pop();

            if (curr.right != null)
            {
                curr = curr.right;
                while (curr != null)
                {
                    l.add(curr.val); // Visit current node

                    s.push(curr);
                    curr = curr.left;
                }
            }
        }

        return l;
    }

    class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x)
        {
            val = x;
        }
    }
}