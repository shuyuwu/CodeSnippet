package io.nnyy.Algorithms.Graph;

import java.util.*;

public class FindEulerPath
{
    public void findEulerPath(HashMap<String, Queue<String>> adjList)
    {
        if (adjList == null) return;

        LinkedList<String> ll = new LinkedList<>();
        for (String node : adjList.keySet()) dfs(adjList, ll, node);
    }

    private void dfs(
            HashMap<String, Queue<String>> adjList,
            LinkedList<String> ll,
            String currNode)
    {
        Queue<String> neighbors = adjList.get(currNode);

        while (neighbors.size() > 0)
        {
            String neighbor = neighbors.poll();
            dfs(adjList, ll, neighbor);
        }

        ll.addFirst(currNode);
    }
}