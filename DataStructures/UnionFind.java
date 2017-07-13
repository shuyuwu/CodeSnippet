package io.nnyy.datastructures;

public class UnionFind
{
    private int[] parent;
    private int[] rank;
    private int count;

    public UnionFind(int size)
    {
        parent = new int[size];
        rank = new int[size];
        count = size;

        for (int i = 0; i < size; i++) parent[i] = i;
    }

    public void union(int p, int q)
    {
        int pParent = find(p);
        int qParent = find(q);

        if (pParent == qParent) return;

        if (rank[p] < rank[q]) parent[pParent] = qParent;
        else
        {
            parent[qParent] = pParent;
            if (rank[p] == rank[q]) rank[p]++;
        }

        count--;
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
        return count;
    }
}
