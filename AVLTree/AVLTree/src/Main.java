public class Main {

    public static void main(String[] args) {
        AVL arvore = new AVL();

        // Adicionando valores à árvore AVL
        arvore.put(10);
        arvore.put(20);
        arvore.put(30);
        arvore.put(40);
        arvore.put(50);
        arvore.put(25);

        // Imprimindo os valores da árvore AVL em ordem
        System.out.println("Valores da árvore AVL em ordem:");
        arvore.emOrdem();

        // Buscando valores na árvore AVL
        System.out.println("Valor buscado na árvore AVL: " + arvore.get(30));

        // Removendo valores da árvore AVL
        arvore.deletar(30);
        arvore.deletar(25);

        // Imprimindo os valores da árvore AVL em ordem após remoção
        System.out.println("Valores da árvore AVL em ordem após remoção:");
        arvore.emOrdem();
    }
}