/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.KeyValuePair;
import csci152.adt.Map;
import csci152.impl.TreeNode;

/**
 *
 * @author Anvar Adylov
 * @param <K>
 * @param <V>
 */
public class BSTMap<K extends Comparable, V> implements Map<K, V>  {
    	private TreeNode<KeyValuePair<K,V>> root;
	private int size;
	
	public BSTMap() {
		root = null;
		size = 0;
	}
	
	@Override
	public void define(K key, V value) {
                if (getValue(key) == null) {
                    if (root == null) {
                    root = new TreeNode(new KeyValuePair(key, value));
                    } else {
                        defineHelper(root, key, value);
                    }
                    size++;
                } else {
                    defineHelper(root, key, value);
                }
	}
    private void defineHelper(TreeNode<KeyValuePair<K,V>> node, K key, V value) {
        if (node.getValue().equals(new KeyValuePair(key, null))) {
            node.getValue().setValue(value);
        } else {
            if (node.getValue().compareTo(new KeyValuePair(key, value)) < 0) {
                if (node.getRight() == null) {
                    node.setRight(new TreeNode(new KeyValuePair(key, value)));
                } else {
                    defineHelper(node.getRight(), key, value);
                }
            } else {
                if (node.getLeft() == null) {
                    node.setLeft(new TreeNode(new KeyValuePair(key, value)));
                } else {
                    defineHelper(node.getLeft(), key, value);
                }
            }
        }
    }
	@Override
	public V getValue(K key) {
		if (size == 0) {
		return null;
                }
                return getHelper(root, key);
	}
        
    private V getHelper(TreeNode<KeyValuePair<K,V>> node, K key) {
        if (node.getValue().compareTo(new KeyValuePair(key, null)) < 0) {
            if (node.getRight() == null) {
                return null;
            } else {
                return getHelper(node.getRight(), key);
            }
        } else if (node.getValue().compareTo(new KeyValuePair(key, null)) > 0) {
            if (node.getLeft() == null) {
                return null;
            } else {
                return getHelper(node.getLeft(), key);
            }
        } else if (node.getValue().equals(new KeyValuePair(key, null))) {
            return node.getValue().getValue();
        } else {
            return null;
        }
    }
        
 
	@Override
	public V remove(K key) {
            if (getValue(key) != null) {
                size--;
            }
            V result = removeHelper(root, key);
		return null;
	}
    private V removeHelper(TreeNode<KeyValuePair<K,V>> node, K key) {
        if (node.getValue().compareTo(new KeyValuePair(key, null)) < 0) {
            if (node.getRight() == null) {
                return null;
            } else if (node.getRight().getValue().compareTo(new KeyValuePair(key, null)) == 0) {
                if (node.getRight().getRight() == null && node.getRight().getLeft() == null) {
                    node.setRight(null);
                } else if (node.getRight().getRight() != null && node.getRight().getLeft() != null) {
                    KeyValuePair<K,V> temp;
                    TreeNode<KeyValuePair<K,V>> cur;
                    cur = node.getRight().getRight();
                    while (cur.getLeft() != null) {
                        cur = cur.getLeft();
                    }
                    temp = cur.getValue();
                    node.getRight().setValue(temp);
                    removeHelper(node.getRight().getRight(), temp.getKey());
                } else {
                    if (node.getRight().getRight() != null) {
                        node.setRight(node.getRight().getRight());
                    } else {
                        node.setRight(node.getRight().getLeft());
                    }
                }
                return node.getValue().getValue();
            } else {
                return removeHelper(node.getRight(), key);
            }
        } else if (node.getValue().compareTo(new KeyValuePair(key, null)) > 0) {
            if (node.getLeft() == null) {
                return null;
            } else if (node.getLeft().getValue().compareTo(new KeyValuePair(key, null)) == 0) {
                if (node.getLeft().getRight() == null && node.getLeft().getLeft() == null) {
                    node.setLeft(null);
                } else if (node.getLeft().getRight() != null && node.getLeft().getLeft() != null) {
                    KeyValuePair<K,V> temp;
                    TreeNode<KeyValuePair<K,V>> cur;
                    cur = node.getLeft().getRight();
                    while (cur.getLeft() != null) {
                        cur = cur.getLeft();
                    }
                    temp = cur.getValue();
                    node.getLeft().setValue(temp);
                    removeHelper(node.getLeft().getRight(), temp.getKey());
                } else {
                    if (node.getLeft().getRight() != null) {
                        node.setLeft(node.getLeft().getRight());
                    } else {
                        node.setLeft(node.getLeft().getLeft());
                    }
                }
                return node.getValue().getValue();
            } else {
                return removeHelper(node.getLeft(), key);
            }
        } else if (node.getValue().compareTo(new KeyValuePair(key, null)) == 0) {
                    if (node.getRight() == null && node.getLeft() == null) {
                        root = null;
                    } else {
                    KeyValuePair<K,V> temp;
                    TreeNode<KeyValuePair<K,V>> cur;
                    if (node.getRight()!=null) {
                    cur = node.getRight();
                    while (cur.getLeft() != null) {
                        cur = cur.getLeft();
                    }
                    temp = cur.getValue();
                    removeHelper(node, temp.getKey());
                    node.setValue(temp);
                    } else {    
                    root = node.getLeft();
                        }        
                    }
                    return node.getValue().getValue();
        }
        return null;
    }
	
        @Override
	public KeyValuePair<K, V> removeAny() throws Exception {
		        if (size == 0) {
                            throw new Exception("The Set is empty!");
                        }
                        KeyValuePair<K,V> res;
                        res = (KeyValuePair<K,V>)root.getValue();
                        removeHelper(root, res.getKey());
                        size--;
        return res;
	}
 
	@Override
	public int getSize() {
		return size;
	}
 
	@Override
	public void clear() {
		root = null;
		size = 0;
	}
        
    @Override
    public String toString() {
    	return toStringHelper(root);
    }
    private String toStringHelper(TreeNode<KeyValuePair<K,V>> node) {
        if (node == null) {
            return "";
        } 
        return toStringHelper(node.getLeft()) + " " +
        node.getValue() + " " + 
        toStringHelper(node.getRight());    
    }
}

