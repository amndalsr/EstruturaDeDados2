public class AVL {

    //variável de instância "raiz" do tipo No, que representa o nó da raiz
    public No raiz;

    //método de verificação se a árvore está vazia
    public boolean isEmpty() {
        if (this.raiz == null) {
            return true;
        } else {
            return false;
        }
    }

    /*insere um novo nó na árvore com a chave informada, chama o método put 
     *passando como parâmetro a raiz e a chave a ser inserida
     */
    public void put(Integer chave) {
        this.raiz = put(this.raiz, chave);
    }

    /*método privado que insere um novo nó na árvore com a chave informada
     * e retorna o nó inserido ou o nó atualizado caso a chave já exista 
     * na árvore. Esse método realiza inserção de forma recursiva, percorrendo
     * da esquerda para a direita, e ainda chama o método privado "balancear" 
     * para garantir qur a árvore vai continuar balanceada após a inserção
     */
    private No put(No no, Integer chave) {
        if (no == null) {
            return new No(chave);
        }
        if (chave < no.chave) {
            no.esquerda = put(no.esquerda, chave);
        } else if (chave > no.chave) {
            no.direita = put(no.direita, chave);
        } else {
            no.chave = chave;
            return no;
        }
        return balancear(no);
    }

    /*busca um nó na árvore pela chave informada, e retorna a chave desse
     * nó ou "null" caso o nó não exista na árvore. Esse método chama o método
     * privado get, que passa como parâmetro a raiz e a chave a ser buscada
     */
    public Integer get(Integer chave) {
        No no = get(this.raiz, chave);
        if (no == null) {
            return null;
        }
        return no.chave;
    }

    /*método privado que busca o nó na árvore e retorna o nó ou "null"
     * esse método realiza a busca de maneira recursiva, percorrendo
     * a árvore da esquerda para a direita até encontrar o nó
     */
    private No get(No no, Integer chave) {
        if (no == null) {
            return null;
        }
        if (chave < no.chave) {
            return get(no.esquerda, chave);
        } else if (chave > no.chave) {
            return get(no.direita, chave);
        } else {
            return no;
        }
    }

    /*realiza a rotação a esquerda do atual nó Y e retornar o novo 
     * nó que ficará no lugar do Y. método utilizado para balancear
     * a arv quando fica desbalanceada a direita.
     */
    private No rotacaoEsquerda(No y) {
        No x = y.direita;
        No T2 = x.esquerda;

        x.esquerda = y;
        y.direita = T2;

        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;

        return x;
    }

    /*realiza a rotação a esquerda do atual nó Y e retornar o novo 
     * nó que ficará no lugar do Y. método utilizado para balancear
     * a arv quando fica desbalanceada a esquerda.
     */
    private No rotacaoDireita(No y) {
        No x = y.esquerda;
        No T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;

        return x;
    }

    /*retorna a altura da nó, que é a distância entre esse 
     * nó e a folha mais distante abaixo dele. Esse método
     * é usado para calcular o fator de balanceamento de um nó
     */
    public int altura(No no) {
        if (no == null) {
            return -1;
        }
        int alturaEsquerda = altura(no.esquerda);
        int alturaDireita = altura(no.direita);
        return 1 + Math.max(alturaEsquerda, alturaDireita);
    }  

    /*verifica se um nó está desbalanceado e, se estiver, realiza as rotações
     * necessárias. Esse método é chamado após uma inserção ou remoção
     */
    private No balancear(No no) {
        if (no == null) {
            return no;
        }
        int balance = altura(no.esquerda) - altura(no.direita);

        //LL
        /*verifica se a altura da subárvore esquerda é maior do que a altura da 
         * subárvore direita em mais de uma unidade, o que significa que esta 
         * desbalanceado para a esquerda
         *
         * verifica se a altura da subárvore esquerda da subárvore esquerda 
         * é maior ou igual à altura da subárvore direita da subárvore esquerda, 
         * o que significa que a desbalanceada está na subárvore esquerda da 
         * subárvore esquerda
         */
        if (balance > 1 && altura(no.esquerda.esquerda) >= altura(no.esquerda.direita)) {
            return rotacaoDireita(no);
        }
        //LR
        if (balance > 1 && altura(no.esquerda.esquerda) < altura(no.esquerda.direita)) {
            /*rotação à esquerda é usada para equilibrar a altura entre a 
             * subárvore direita e a subárvore esquerda de um determinado nó 
             */
            no.esquerda = rotacaoEsquerda(no.esquerda);
            /*rotação à direita é usada para equilibrar a altura entre 
             * a subárvore esquerda e a subárvore direita 
             */
            return rotacaoDireita(no);
        }
        //RR
        /*verifica se a altura da subárvore direita é maior do que a altura da 
         * subárvore esquerda em mais de uma unidade, o que significa que esta 
         * desbalanceado para a direita
         *
         * verifica se a altura da subárvore direita da subárvore direita 
         * é maior ou igual à altura da subárvore esquerda da subárvore direita, 
         * o que significa que a desbalanceada está na subárvore direita da 
         * subárvore direita
         */
        if (balance < -1 && altura(no.direita.direita) >= altura(no.direita.esquerda)) {
            return rotacaoEsquerda(no);
        }
        //RL
        if (balance < -1 && altura(no.direita.direita) < altura(no.direita.esquerda)) {
            /*A rotação à direita é usada para equilibrar a altura entre a subárvore 
             *esquerda e a subárvore direita de um determinado nó 
             */
            no.direita = rotacaoDireita(no.direita);
            /*rotação à esquerda é usada para equilibrar a altura entre 
             *a subárvore direita e a subárvore esquerda 
             */
            return rotacaoEsquerda(no);
        }

        no.altura = Math.max(altura(no.esquerda), altura(no.direita)) + 1;
        return no;
    }

    /*remove um nó na árvore a partir da chave informada e chama o 
     *método privado "deletar" passando como parâmentro a raiz e a 
     *chave a serem removidos
     */
    public void deletar(Integer chave) {
        this.raiz = deletar(this.raiz, chave);
    }

    /*recebe a raiz e a chave a serem removidos, se o nó for
     * nulo significa que a chve nao foi encontra.
     */
    private No deletar(No no, Integer chave) {
        if (no == null) {
            return no;
        }
        if (chave < no.chave) { //se a chave for menor que a chave do nó atual a função é chamada recursivamente para o nó da esquerda
            no.esquerda = deletar(no.esquerda, chave);
        } else if (chave > no.chave) { //se a chave for maior é chamada recursivamente para o nó da direita
            no.direita = deletar(no.direita, chave);
        } else { //caso a chave  seja igual a chave do nó atual:
            if (no.esquerda == null && no.direita == null) { // se o nó não possui filhos
                no = null;
            } else if (no.esquerda == null) { //se possui apenas um filho é substituido pelo filho correspondente
                no = no.direita;
            } else if (no.direita == null) { //se possui apenas um filho é substituido pelo filho correspondente
                no = no.esquerda;
            } else { //se o nó possui dois filhos, o nó é substituído pelo maior nó da subárvore esquerda e o nó correspondente é removido recursivamente
                No temp = maximoDaEsquerda(no.esquerda);
                no.chave = temp.chave;
                no.esquerda = deletar(no.esquerda, temp.chave);
            }
        } //após a remoção ocorre o balancemaneto e retorna o resultado
        if (no != null) {
            no = balancear(no);
        }
        return no;
    }

    // recebe um nó como parâmetro e retorna o nó com a maior chave da subárvore esquerda
    private No maximoDaEsquerda(No no) {
        No atual = no;
        while (atual.direita != null) {
            atual = atual.direita;
        }
        return atual;
    }

    //imprime as chaves da árvore na ordem crescente. Ele chama o método "emOrdemRecursiva" passando a raiz como parâmetro
    public void emOrdem() {
        emOrdemRecursiva(raiz);
    }

    // imprime as chaves da subárvore esquerda, a chave do nó atual e as chaves da subárvore direita de forma recursiva. Ele é usado pelo método "emOrdem"
    private void emOrdemRecursiva(No no) {
        if (no != null) {
            emOrdemRecursiva(no.esquerda);
            System.out.println(no.chave);
            emOrdemRecursiva(no.direita);
        }
    }
}