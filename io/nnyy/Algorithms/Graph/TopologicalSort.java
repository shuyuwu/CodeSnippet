package io.nnyy.Algorithms.Graph;

import java.util.*;

public class TopologicalSort
{
    public void topologicalSort(HashMap<String, List<String>> adjList)
    {
        if (adjList == null) return;

        LinkedList<String> ll = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();

        for (String node : adjList.keySet()) dfs(adjList, ll, visited, node);
    }

    private void dfs(
            HashMap<String, List<String>> adjList,
            LinkedList<String> ll,
            HashSet<String> visited,
            String currNode)
    {
        if (visited.contains(currNode)) return;

        visited.add(currNode);

        for (String neighborNode : adjList.get(currNode)) dfs(adjList, ll, visited, neighborNode);

        ll.addFirst(currNode);
    }
}