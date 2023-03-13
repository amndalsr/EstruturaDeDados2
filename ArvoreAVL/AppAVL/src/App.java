import br.unicap.edii.avl.ArvoreAvl;
import br.unicap.edii.avl.AVLNode;

public class App {
    public static void main(String[] args) {
        
        ArvoreAvl tree = new ArvoreAvl();
        
        int[] values = {5, 2, 9, 1, 3, 7, 10};
    
        for (int value : values) {
            tree.insert(value);
        }
    
        System.out.println("Travessia em ordem na árvore AVL: ");
        tree.inorder();
    }
}
