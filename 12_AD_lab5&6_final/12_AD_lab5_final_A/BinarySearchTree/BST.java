import java.util.Iterator;
import java.util.Stack;
import java.util.TreeMap;

public class BST<Key extends Comparable<Key>, Value> implements ST<Key,Value> {
    private Node root;
    
    public class Node {
        final Key key;
        Value val;
        Node left, right;
        final int depth; // store node depth
        
        Node(Key key, Value val,int depth) {
            this.key = key;
            this.val = val;
            this.depth = depth; // 0 by default
        }
    }
    
     public int getNodeDepth(Key key) {
        return getNodeDepth(root, key);
    }
    
    private int getNodeDepth(Node x, Key key) {
        if (x == null) {
            return -1;
        }
        
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x.depth;
        } else if (cmp < 0) {
            return getNodeDepth(x.left, key);
        } else {
            return getNodeDepth(x.right, key);
        }
    }
    
    public void put(Key key, Value val) {
        root = put(root, key, val, 0);
    }
    
    private Node put(Node x, Key key, Value val, int depth) {
        if (x == null) {
            Node newNode = new Node(key, val, depth);
            //newNode = depth;
            return newNode;
        }
        
         int cmp = key.compareTo(x.key);
            if (cmp == 0) x.val = val;
            else if (cmp < 0) x.left = put(x.left, key, val,depth + 1);
            else if (cmp > 0) x.right = put(x.right, key, val,depth + 1);
        return x;
    }
    
    public Value get(Key key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp == 0) {
                return x.val;
            } else if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            }
        }
        return null;
    }
    
    public Iterator<Key> iterator() {
        return new BSTIterator();
    }
    
    private class BSTIterator implements Iterator<Key> {
        private Stack<Node> stack = new Stack<>();
        
        private void pushLeft(Node x) {
            while (x != null) {
                stack.push(x);
                x = x.left;
            }
        }
        
        BSTIterator() {
            pushLeft(root);
        }
        
        public boolean hasNext() {
            return !stack.isEmpty();
        }
        
        public Key next() {
            Node x = stack.pop();
            pushLeft(x.right);
            return x.key;
        }
        
    }
    public TreeMap<Integer, Integer> depthHistogram() {
        TreeMap<Integer, Integer> histogram = new TreeMap<>();
        getNodeDepthHistogram(root, histogram);
        return histogram;
    }
    
    private void getNodeDepthHistogram(Node x, TreeMap<Integer, Integer> histogram) {
        if (x == null) return;
        histogram.put(x.depth, histogram.getOrDefault(x.depth, 0) + 1); // Increment node count at current depth

        getNodeDepthHistogram(x.left, histogram);
        getNodeDepthHistogram(x.right, histogram);
    }
    
    public int treeDepth() {
    return treeDepth(root);
    }
    
    private int treeDepth(Node x) {
        if (x == null) {
            return -1; // Empty tree has depth -1
        }
    
        int leftDepth = treeDepth(x.left);
        int rightDepth = treeDepth(x.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

}
