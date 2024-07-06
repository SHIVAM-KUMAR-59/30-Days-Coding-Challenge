
// You are working on a sophisticated GPS navigation system that calculates the fastest route in the city . The city is represented by a graph where intersections are nodes and roads between them are edges with travel times. Develop a function that determines the shortest travel from a given starting intersection to all the other intersections in the city

import java.util.*;

class ShortestPath {
    static class Node implements Comparable<Node> {
        int id;
        int travelTime;

        Node(int id, int travelTime) {
            this.id = id;
            this.travelTime = travelTime;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.travelTime, other.travelTime);
        }
    }

    public static Map<Integer, Integer> shortestTravel(Map<Integer, Map<Integer, Integer>> graph, int start) {
        Map<Integer, Integer> travelTimes = new HashMap<>();
        for (int node : graph.keySet()) {
            travelTimes.put(node, Integer.MAX_VALUE);
        }
        travelTimes.put(start, 0);

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Node(start, 0));

        while (!priorityQueue.isEmpty()) {
            Node currentNode = priorityQueue.poll();
            if (currentNode.travelTime > travelTimes.get(currentNode.id)) {
                continue;
            }

            for (Map.Entry<Integer, Integer> neighbor : graph.get(currentNode.id).entrySet()) {
                int newTravelTime = currentNode.travelTime + neighbor.getValue();
                if (newTravelTime < travelTimes.get(neighbor.getKey())) {
                    travelTimes.put(neighbor.getKey(), newTravelTime);
                    priorityQueue.add(new Node(neighbor.getKey(), newTravelTime));
                }
            }
        }

        return travelTimes;
    }

    public static void main(String[] args) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        graph.put(0, Map.of(1, 4, 2, 2));
        graph.put(1, Map.of(3, 5));
        graph.put(2, Map.of(1, 1, 3, 8));
        graph.put(3, Map.of());

        Map<Integer, Integer> travelTimes = shortestTravel(graph, 0);
        for (Map.Entry<Integer, Integer> entry : travelTimes.entrySet()) {
            System.out.println("Node " + entry.getKey() + ": " + entry.getValue());
        }
    }
}