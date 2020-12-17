package tree;

import java.util.ArrayList;

public class BTreeNode {
    /// keys of each node
    ArrayList<Integer> keys;
    ArrayList<BTreeNode> childs;
    private int degree;
    private int nbKeys;
    private boolean isLast;

    BTreeNode(int degree, boolean isLast) {
       this.keys = new ArrayList<>( (2 * degree)-1);
       this.childs = new ArrayList<>(2*degree);
       this.degree = degree;
       this.nbKeys = 0;
       this.isLast = isLast;
    }

    BTreeNode search(int keyNumber) {
        int i = 0;
        // On cherche la première clé supérieur ou de même valeur que celle recherchée
        while (i < this.keys.size() && keyNumber > this.keys.get(i)){
            i++;
        }

        if ( i < this.keys.size()) {
            if (this.keys.get(i).equals(keyNumber)) {
                return this;
            }
        }

        if(this.isLast) {
            return null;
        }
        return this.childs.get(i).search(keyNumber);
    }

    public void setKeys(ArrayList<Integer> keys) {
        this.keys = keys;
    }

    public void addChild(BTreeNode child) {
        this.childs.add(child);
    }

    public String toString() {
        return "My floor : " + (degree-1) + " My keys : " + this.keys;
    }

}
