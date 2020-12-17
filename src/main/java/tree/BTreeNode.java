package tree;

import java.util.ArrayList;

public class BTreeNode {
    /// keys of each node
    ArrayList<Integer> keys;
    ArrayList<BTreeNode> childs;
    private int degree;
    private int nbKeys;
    private boolean isLast;
    private boolean explored = false;

    BTreeNode(int degree, boolean isLast) {
       this.keys = new ArrayList<>( (2 * degree)-1);
       this.childs = new ArrayList<>(2*degree);
       this.degree = degree;
       this.nbKeys = 0;
       this.isLast = isLast;
    }

    BTreeNode search(int keyNumber) {
        this.explored = true;
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

    public boolean isExplored() {
        return explored;
    }

    public void traverse() {

        // There are n keys and n+1 children, travers through n keys
        // and first n children
        int i = 0;
        for (i = 0; i < this.nbKeys; i++) {

            // If this is not leaf, then before printing key[i],
            // traverse the subtree rooted with child C[i].
            if (!this.isLast) {
                this.childs.get(i).traverse();
            }
            System.out.print(this.keys.get(i) + " ");
        }

        // Print the subtree rooted with last child
        if (!isLast)
            this.childs.get(i).traverse();
    }

}
