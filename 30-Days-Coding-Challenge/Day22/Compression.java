
// You are working on a data compression project and need to minimize the space required to store a set of characters and their frequencies. One of your colleagues suggests using a tree-based approach to encode the characters efficiently. To evaluate this idea, you decide to implement a system that: 1. Reads a set of characters along with their frequencies. 2. Constructs an optimal binary tree based or tliese frequencies. 3. Generates binary codes for each character. Your task is to write a function that takes a list of characters and their corresponding frequencies, constructs the optimal tree, and returns a dictionary with characters as keys and their binary codes as values.

import java.util.*;

class Node implements Comparable<Node> {
    char ch;
    int freq;
    Node left, right;

    Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
        left = null;
        right = null;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.freq, other.freq);
    }
}

public class Compression {
    public static Map<Character, String> buildCodes(Node root, String currentCode, Map<Character, String> codes) {
        if (root == null) {
            return codes;
        }

        if (root.ch != '\0') {
            codes.put(root.ch, currentCode);
        }

        buildCodes(root.left, currentCode + "0", codes);
        buildCodes(root.right, currentCode + "1", codes);

        return codes;
    }

    public static Node buildHeap(List<Character> chars, List<Integer> freqs) {
        PriorityQueue<Node> heap = new PriorityQueue<>();

        for (int i = 0; i < chars.size(); i++) {
            heap.add(new Node(chars.get(i), freqs.get(i)));
        }

        while (heap.size() > 1) {
            Node node1 = heap.poll();
            Node node2 = heap.poll();

            Node merged = new Node('\0', node1.freq + node2.freq);
            merged.left = node1;
            merged.right = node2;

            heap.add(merged);
        }

        return heap.poll();
    }

    public static Map<Character, String> huffmanCoding(List<Character> chars, List<Integer> freqs) {
        Node root = buildHeap(chars, freqs);
        Map<Character, String> codes = new HashMap<>();

        buildCodes(root, "", codes);

        return codes;
    }

    public static void main(String[] args) {
        List<Character> chars = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f');
        List<Integer> freqs = Arrays.asList(5, 9, 12, 13, 16, 45);

        Map<Character, String> codes = huffmanCoding(chars, freqs);

        for (Map.Entry<Character, String> entry : codes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}