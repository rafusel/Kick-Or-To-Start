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


    // hash value between 0 and m-1
    private int hash(String key) {
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
    
    public ArrayList<Project> get(String key)
    {
        int i = hash(key);
        return st[i];
    }

    // insert key-value pair into the table
    public void put(String key, Project val) {
        int i = hash(key);
        if(st[i] == null)
        {
        	st[i] = new ArrayList();
        }
        st[i].add(val);
    }

}
