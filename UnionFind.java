public class UnionFind
{
    private int[] parent;
    private int[] rank;

    public UnionFind(int size)
    {
        parent = new int[size];
        rank = new int[size];

        for (int i = 0; i < size; i++)
        {
            parent[i] = i;
        }
    }

    public void union(int p, int q)
    {
        int pParent = find(p);
        int qParent = find(q);

        if (pParent == qParent)
        {
            return;
        }

        if (rank[p] < rank[q])
        {
            parent[pParent] = qParent;
        }
        else
        {
            parent[qParent] = pParent;

            if (rank[p] == rank[q])
            {
                rank[p]++;
            }
        }
    }

    public int find(int p)
    {
        if (parent[p] != p)
        {
            int root = find(parent[p]);
            parent[p] = root;
        }

        return parent[p];
    }

    public int countTrees()
    {
        for (int i = 0; i < parent.length; i++)
        {
            // To compress path
            find(i);
        }

        HashSet<Integer> hs = new HashSet<Integer>();
        for (int i = 0; i < parent.length; i++)
        {
            hs.add(parent[i]);
        }

        return hs.size();
    }
}