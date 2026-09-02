/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Set;

/**
 *
 * @author Anvar Adylov
 * @param <T>
 */
public class BSTSet<T extends Comparable> implements Set<T> {
    
    private TreeNode root;
    private int size;
    
    public BSTSet() {
    root = null;
    size = 0;
    }
            
    @Override
    public void add(T value) {
        if (!contains(value)) {
            if (root == null) {
                TreeNode n = new TreeNode(value);
                root = n;
            } else {
                addHelper(root, value); 
            }
            size++;
        }
    }
    
    private void addHelper(TreeNode<T> node, T value) {
        if (node.getValue().compareTo(value) < 0) {
            if (node.getRight() == null) {
                TreeNode n = new TreeNode(value);
                node.setRight(n);
            } else {
                addHelper(node.getRight(), value);
            }
        } else {
            if (node.getLeft() == null) {
                TreeNode n = new TreeNode(value);
                node.setLeft(n);
            } else {
                addHelper(node.getLeft(), value);
            }
        }
    }
    
    @Override
    public boolean contains(T value) {
        boolean con = false;
        if (size == 0) {
            return con;
        } else {
            con = containHelper(root ,value);
        }
        return con;
    }
    
    private boolean containHelper(TreeNode<T> node, T value) {
        if (node.getValue().compareTo(value) < 0) {
            if (node.getRight() == null) {
                return false;
            } else {
                return containHelper(node.getRight(), value);
            }
        } else if (node.getValue().compareTo(value) > 0) {
            if (node.getLeft() == null) {
                return false;
            } else {
                return containHelper(node.getLeft(), value);
            }
        } else if (node.getValue().compareTo(value) == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public boolean remove(T value) {
        boolean x = false;
        if (size == 0) {
            return x;
        } else {
            x = removeHelper(root, value);
            if (x) {
                size--;
            }
            return x;
        }
    }
   
    private boolean removeHelper(TreeNode<T> node, T value) {
        if (node.getValue().compareTo(value) < 0) {
            if (node.getRight() == null) {
                return false;
            } else if (node.getRight().getValue().compareTo(value) == 0) {
                if (node.getRight().getRight() == null && node.getRight().getLeft() == null) {
                    node.setRight(null);
                } else if (node.getRight().getRight() != null && node.getRight().getLeft() != null) {
                    T temp;
                    TreeNode<T> cur;
                    cur = node.getRight().getRight();
                    while (cur.getLeft() != null) {
                        cur = cur.getLeft();
                    }
                    temp = cur.getValue();
                    node.getRight().setValue(temp);
                    removeHelper(node.getRight().getRight(), temp);
                } else {
                    if (node.getRight().getRight() != null) {
                        node.setRight(node.getRight().getRight());
                    } else {
                        node.setRight(node.getRight().getLeft());
                    }
                }
                
                return true;
            } else {
                return removeHelper(node.getRight(), value);
            }
        } else if (node.getValue().compareTo(value) > 0) {
            if (node.getLeft() == null) {
                return false;
            } else if (node.getLeft().getValue().compareTo(value) == 0) {
                if (node.getLeft().getRight() == null && node.getLeft().getLeft() == null) {
                    node.setLeft(null);
                } else if (node.getLeft().getRight() != null && node.getLeft().getLeft() != null) {
                    T temp;
                    TreeNode<T> cur;
                    cur = node.getLeft().getRight();
                    while (cur.getLeft() != null) {
                        cur = cur.getLeft();
                    }
                    temp = cur.getValue();
                    node.getLeft().setValue(temp);
                    removeHelper(node.getLeft().getRight(), temp);
                } else {
                    if (node.getLeft().getRight() != null) {
                        node.setLeft(node.getLeft().getRight());
                    } else {
                        node.setLeft(node.getLeft().getLeft());
                    }
                }
                
                return true;
            } else {
                return removeHelper(node.getLeft(), value);
            }
        } else if (node.getValue().compareTo(value) == 0) {
                    if (node.getRight() == null && node.getLeft() == null) {
                        root = null;
                    } else {
                    T temp;
                    TreeNode<T> cur;
                    if (node.getRight()!=null) {
                    cur = node.getRight();
                    while (cur.getLeft() != null) {
                        cur = cur.getLeft();
                    }
                    temp = cur.getValue();
                    removeHelper(node, temp);
                    node.setValue(temp);
                    } else {    
                    root = node.getLeft();
                        }        
                    }
                    
                    return true;
        }
        return false;
    }
    
    @Override
    public T removeAny() throws Exception {
        if (size == 0) {
         throw new Exception("The Set is empty!");
        }
        T res;
        res = (T)root.getValue();
        removeHelper(root, res);
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
    
    private String toStringHelper(TreeNode<T> node) {
        if (node == null) {
            return "";
        } 
        return toStringHelper(node.getLeft()) + " " +
        node.getValue() + " " + 
        toStringHelper(node.getRight());    
    }
    
}
