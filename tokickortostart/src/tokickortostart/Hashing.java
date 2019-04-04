package tokickortostart;
import java.util.*;

public class Hashing<Key, Value> {

    private int n;       // number of key-value pairs
    private int m;       // hash table size
    private ArrayList<Project>[] st;   // array of linked-list symbol tables

    // create separate chaining hash table with m lists
    public Hashing(int m) {
        this.m = m;
        st = new ArrayList[m];
    } 


    // hash value between 0 and m-1
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    } 

    // return number of key-value pairs in symbol table
    public int size() {
        return n;
    } 

    // is the symbol table empty?
    public boolean isEmpty() {
        return size() == 0;
    }

    // is the key in the symbol table?
    public boolean contains(Key key) {
        return get(key) != null;
    } 
    // return value associated with key, null if no such key
    public Value get(Key key) {
        int i = hash(key);
        for (Node x = st[i]; x != null; x = x.next) {
            if (key.equals(x.key)) return (Value) x.val;
        }
        return null;
    }

    // insert key-value pair into the table
    public void put(Key key, Value val) {
        int i = hash(key);
        for (Node x = st[i]; x != null; x = x.next) {
            if (key.equals(x.)) {
                x.val = val;
                return;
            }
        }
        n++;
        st[i] = new ArrayList<Product>(key, val, st[i]);
    }

}
