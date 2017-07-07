package io.nnyy.algorithms.graph;

public class GraphDepthFirstTraversal {
    public void traverseEntireGraph(HashMap<String, List<String>> adjList) {
        HashSet<String> visited = new HashSet<>();

        for (String node : adjList.keySet()) {
            dfs(adjList, visited, node);
        }
    }

    public void dfs(
            HashMap<String, List<String>> adjList,
            HashSet<String> visited,
            String currNode) {
        if (visited.contains(currNode)) {
            return;
        }

        visited.add(currNode);

        for (String neighborNode : adjList.get(currNode)) {
            dfs(adjList, visited, neighborNode);
        }
    }
}