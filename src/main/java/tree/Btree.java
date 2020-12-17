package tree;

public class Btree {
    private BTreeNode treeRoot;
    private int degree;

    Btree(int degree) {
        this.treeRoot = null;
        this.degree = degree;
    }

    Btree(int degree, BTreeNode root) {
        this.treeRoot = root;
        this.degree = degree;
    }

    public BTreeNode search(int key) {
        if (this.treeRoot == null)
            return null;
        else
            return this.treeRoot.search(key);
    }

}
