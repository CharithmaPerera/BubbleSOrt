import java.util.Iterator;


public interface ST<Key extends Comparable<Key>, Value> {
    
    void put(Key key, Value value);
    
    Value get(Key key);
    
    public Iterator<Key> iterator();
    
    public int treeDepth();
    
    
}