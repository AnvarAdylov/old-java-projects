
package csci152.adt;

/**
 * Key-value pairs to be used with the Map interface
 * @param <K>
 * @param <V>
 */
public class KeyValuePair<K extends Comparable, V> {
    
    private K key;
    private V value;
    
    public KeyValuePair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * @return the key
     */
    public K getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(K key) {
        this.key = key;
    }

    /**
     * @return the value
     */
    public V getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(V value) {
        this.value = value;
    }
    
    public boolean equals(Object obj) { 
        if (obj instanceof KeyValuePair) {
        KeyValuePair sobj = (KeyValuePair)obj;
        return key == sobj.getKey();
        }
        return false;
    }
    
    public int compareTo(Object obj) {
        if (obj instanceof KeyValuePair) {
        KeyValuePair sobj = (KeyValuePair)obj;
        if (key.compareTo(sobj.getKey()) > 0) {
            return 1;
        } else if (key.compareTo(sobj.getKey()) < 0) {
            return -1;
        }
        }
        return 0;
    }
    
    @Override
    public String toString() {
        return "<" + key + ", " + value + ">";
    }
}
