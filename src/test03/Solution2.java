package test03;

public class Solution2 {
    static int count = 0;
    static int root;

    public int solution(Tree T) {
        root = T.x;
        inOrder(T);
        return count;
    }

    public void inOrder(Tree tree) {
        if (tree.x >= root) {
            count++;
        }
        if (tree.l != null) inOrder(tree.l);
        if (tree.r != null) inOrder(tree.r);
    }

    private static class Tree {
        int x;
        Tree l;
        Tree r;
    }
}
