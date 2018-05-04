package edu.princeton.common;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeMap;

public class ST<Key extends Comparable<Key>, Value> implements Iterable<Key> {
	
	private TreeMap<Key, Value> st;
	
	public ST() {
		st = new TreeMap<Key, Value>();
	}
	
	//Returns the value associated with the given key in this symbol table.
	private Value get(Key key) {
		if (key == null)
			throw new IllegalArgumentException("calls get() with null key");
		return st.get(key);
	}
	
	/**
	 * Inserts the specified key-value pair into the symbol table.overwriting the old value
	 * with the new value if the symbol table already contains the specified key.Deletes the 
	 * specified key (and its associated value) from this symbol table if the specified value is null.
	 * @param key
	 * @param val
	 */
	public void put(Key key, Value val) {
		if (key == null)
			throw new IllegalArgumentException("calls put() with null key");
		if (val == null)
			st.remove(key);
		else
			st.put(key, val);
	}
	
	//Removes the specified key and its associated value from this symbol table.
	public void delete(Key key) {
		if (key == null)
			throw new IllegalArgumentException("calls delete() with null key");
		st.remove(key);
	}
	
	//Returns true if this symbol table contain the given key.
	public boolean contains(Key key) {
		if (key == null)
			throw new IllegalArgumentException("calls contains() with null key");
		return st.containsKey(key);
	}
	
	//Returns the number of key-value pairs in this symbol table.
	public int size() {
		return st.size();
	}
	
	//Returns true this symbol table is empty.
	public boolean isEmpty() {
		return size() == 0;
	}
	
	//Returns all keys in this symbol table.
	public Iterable<Key> keys() {
		return st.keySet();
	}
	
	//Returns all of this keys in this symbol table.
	@Override
	public Iterator<Key> iterator() {
		return st.keySet().iterator();
	}
	
	//Returns the smallest key in this symbol table.
	public Key min() {
		if (isEmpty())
			throw new NoSuchElementException("calls min() with emoty symbol table");
		return st.firstKey();
	}
	
	//Returns the largest key in this symbol table.
	public Key max() {
		if (isEmpty())
			throw new NoSuchElementException("calls min() with emoty symbol table");
		return st.lastKey();
	}
	
	//Returns the smallest key in this symbol table greater than or equal to key.
	public Key ceiling(Key key) {
		if (key == null)
			throw new IllegalArgumentException("argument to ceiling() is null");
		Key k = st.ceilingKey(key);
		if(k == null)
			throw new NoSuchElementException("all keys are less than " + key);
		return k;
	}
	
	//Returns the largest key in this symbol table less than or equal to key.
	public Key floor(Key key) {
		if (key == null)
			throw new IllegalArgumentException("argument to ceiling() is null");
		Key k = st.floorKey(key);
		if(k == null)
			throw new NoSuchElementException("all keys are greater than " + key);
		return k;
	}
	
	public static void main(String[] args) {
		ST<String, Integer> st = new ST<String, Integer>();
		for (int i = 0; !StdIn.isEmpty(); i++) {
			String key = StdIn.readString();
			st.put(key, i);
		}
		for (String s : st.keys())
			StdOut.println(s + " " + st.get(s));
	}

}
