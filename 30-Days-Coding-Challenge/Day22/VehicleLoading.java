
// You are working on a logistics optimization system for a large-scale transportation company. The company needs to maximize the value of items transported in its fleet of vehicles, each with a different weight capacity. Each item has a specific weight and value, and some items may have-dependencies, meaning certain items must be included if another item is selected. Write a function that determines the optimal selection of items to maximize their total value while staying within the given weight capacities of multiple vehicles and respecting the dependencies between items.

import java.util.*;

class Item {
    int value;
    int weight;
    List<Integer> dependencies;

    Item(int value, int weight, List<Integer> dependencies) {
        this.value = value;
        this.weight = weight;
        this.dependencies = dependencies;
    }
}

public class VehicleLoading {
    public static int[][] dp;
    public static boolean[][] included;

    public static int knapSack(int W, int n, List<Item> items, int vehicle) {
        if (n == 0 || W == 0) {
            return 0;
        }

        if (dp[vehicle][W] != -1) {
            return dp[vehicle][W];
        }

        int notIncluded = knapSack(W, n - 1, items, vehicle);

        int includedValue = 0;
        if (W >= items.get(n - 1).weight) {
            includedValue = items.get(n - 1).value + knapSack(W - items.get(n - 1).weight, n - 1, items, vehicle);
        }

        int maxValue = Math.max(notIncluded, includedValue);

        dp[vehicle][W] = maxValue;
        included[vehicle][W] = maxValue == includedValue;

        return maxValue;
    }

    public static void constructSolution(List<Item> items, int W, int n, int vehicle, List<List<Item>> solution) {
        if (n == 0 || W == 0) {
            return;
        }

        if (included[vehicle][W]) {
            solution.get(vehicle).add(items.get(n - 1));
            constructSolution(items, W - items.get(n - 1).weight, n - 1, vehicle, solution);
        } else {
            constructSolution(items, W, n - 1, vehicle, solution);
        }
    }

    public static List<List<Item>> loadVehicles(List<Item> items, List<Integer> vehicleWeights) {
        int n = items.size();
        int m = vehicleWeights.size();

        dp = new int[m][1001];
        included = new boolean[m][1001];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= 1000; j++) {
                dp[i][j] = -1;
            }
        }

        List<List<Item>> solution = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            solution.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            knapSack(vehicleWeights.get(i), n, items, i);
            constructSolution(items, vehicleWeights.get(i), n, i, solution);
        }

        return solution;
    }

    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item(60, 10, new ArrayList<>()));
        items.add(new Item(100, 20, new ArrayList<>()));
        items.add(new Item(120, 30, new ArrayList<>()));
        items.get(1).dependencies.add(0);
        items.get(2).dependencies.add(1);

        List<Integer> vehicleWeights = Arrays.asList(50, 50);

        List<List<Item>> solution = loadVehicles(items, vehicleWeights);

        for (int i = 0; i < solution.size(); i++) {
            System.out.println("Vehicle " + (i + 1) + ":");
            for (Item item : solution.get(i)) {
                System.out.println("Value: " + item.value + ", Weight: " + item.weight);
            }
            System.out.println();
        }
    }
}