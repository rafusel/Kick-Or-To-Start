package tokickortostart;
import java.util.*;
/**
 * 
 * Module for performing the hashing required to store projects
 * with their respective categories in hash table. 
 */
public class Hashing<String, Project> {

	/**
	 * Hash table size
	 */
    private int m;   
    
    /**
     * Array of linked-list symbol tables
     */
    private ArrayList<Project>[] st;   
    
    /**
     * Creates a separate chaining hash table with m lists
     * 
     * @param m Number of lists for the hash table
     */
    public Hashing(int m) {
        this.m = m;
        st = new ArrayList[m];
    } 

    /**
     * This function determines where a value needs to be hashed to
     * the hash value will be between 0 and m-1
     * 
     * @param key The key of the value to hash
     * @return An integer indicating hash location
     */
    private int hash(String key) {
        return (key.hashCode() & 0x7fffffff) % m;
    } 

    /**
     * Returning the value in the hash table with the given key
     * @param key to return the value of
     * @return The value with the given key
     */
    public ArrayList<Project> get(String key)
    {
        int i = hash(key);
        return st[i];
    }

    /**
     * Inserting a key-value pair into the hash table
     * 
     * @param key The key of the item to insert
     * @param val The value with the given key
     */
    public void put(String key, Project val) {
        int i = hash(key);
        if(st[i] == null)
        {
        	st[i] = new ArrayList();
        }
        st[i].add(val);
    }

}
