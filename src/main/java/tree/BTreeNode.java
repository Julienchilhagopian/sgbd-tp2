package tree;

import java.util.ArrayList;

public class BTreeNode {
    ArrayList<Integer> keys;
    ArrayList<BTreeNode> childs;
    private int degree;
    private int nbKeys;
    private boolean isLeaf;

    BTreeNode(int degree, boolean isLeaf) {
       this.keys = new ArrayList<>( (2 * degree)-1);
       this.childs = new ArrayList<>(2*degree);
       this.degree = degree;
       this.nbKeys = 0;
       this.isLeaf = isLeaf;
    }

    BTreeNode search(int keyNumber) {
        int i = 0;
        while (i < nbKeys && keyNumber > this.keys.get(i)){
            i++;
        }
        if (this.keys.get(i).equals(keyNumber)) {
            return this;
        }

        if(this.isLeaf) {
            return null;
        }
        return this.childs.get(i).search(keyNumber);
    }

}
