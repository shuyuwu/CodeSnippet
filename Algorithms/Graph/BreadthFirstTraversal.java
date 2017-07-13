package io.nnyy.algorithms.graph;

public class BreadthFirstTraversal
{
    public void traverseEntireGraph(HashMap<String, List<String>> adjList)
    {
        if (adjList == null) return;

        HashSet<String> visited = new HashSet<>();

        for (String node : adjList.keySet())
        {
            if (visited.contains(node)) continue;

            bfs(adjList, visited, node);
        }
    }

    private void bfs(
            HashMap<String, List<String>> adjList,
            HashSet<String> visited,
            String node)
    {
        LinkedList<String> ll = new LinkedList<>();

        ll.addFirst(node);
        visited.add(node);

        while (ll.size() > 0)
        {
            String currNode = ll.pollLast();

            // Logic to visit the currNode

            List<String> neighbors = adjList.get(currNode);
            for (String neighbor : neighbors)
            {
                if (visited.contains(neighbor)) continue;

                ll.addFirst(neighbor);
                visited.add(neighbor);
            }
        }
    }
}