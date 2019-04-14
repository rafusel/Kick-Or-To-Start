package tokickortostart;
import java.util.*;

public class Hashing<String, Project> {

    private int n;       // number of key-value pairs
    private int m;       // hash table size
    private ArrayList<Project>[] st;   // array of linked-list symbol tables

    // create separate chaining hash table with m lists
    public Hashing(int m) {
        this.m = m;
        st = new ArrayList[m];
    } 

    // Returns a hash value between 0 and m-1
    private int hash(String key) {
        return (key.hashCode() & 0x7fffffff) % m;
    } 

    //Returns the item at the key location
    public ArrayList<Project> get(String key)
    {
        int i = hash(key);
        return st[i];
    }

    // inserting a value into the hash table
    public void put(String key, Project val) {
        int i = hash(key);
        if(st[i] == null)
        {
        	st[i] = new ArrayList();
        }
        st[i].add(val);
    }

}
