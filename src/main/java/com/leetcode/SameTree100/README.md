# Explain

1. This is a classical item about the recursion
2. I found a better way from the internet it is

        public boolean isSameTree(TreeNode p, TreeNode q) 
        {
            if (p == null && q == null) return true;
            return p != null && q != null && p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
3. Just do it.