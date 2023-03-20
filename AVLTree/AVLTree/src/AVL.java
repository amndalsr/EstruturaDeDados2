public class AVL {

    public No raiz;

    public boolean isEmpty() {
        if (this.raiz == null) {
            return true;
        } else {
            return false;
        }
    }

    public void put(Integer chave) {
        this.raiz = put(this.raiz, chave);
    }

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

    public Integer get(Integer chave) {
        No no = get(this.raiz, chave);
        if (no == null) {
            return null;
        }
        return no.chave;
    }

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

    private No rotacaoEsquerda(No y) {
        No x = y.direita;
        No T2 = x.esquerda;

        x.esquerda = y;
        y.direita = T2;

        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;

        return x;
    }

    private No rotacaoDireita(No y) {
        No x = y.esquerda;
        No T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;

        return x;
    }

    public int altura(No no) {
        if (no == null) {
            return -1;
        }
        int alturaEsquerda = altura(no.esquerda);
        int alturaDireita = altura(no.direita);
        return 1 + Math.max(alturaEsquerda, alturaDireita);
    }  

    private No balancear(No no) {
        if (no == null) {
            return no;
        }
        int balance = altura(no.esquerda) - altura(no.direita);

        if (balance > 1 && altura(no.esquerda.esquerda) >= altura(no.esquerda.direita)) {
            return rotacaoDireita(no);
        }
        if (balance > 1 && altura(no.esquerda.esquerda) < altura(no.esquerda.direita)) {
            no.esquerda = rotacaoEsquerda(no.esquerda);
            return rotacaoDireita(no);
        }
        if (balance < -1 && altura(no.direita.direita) >= altura(no.direita.esquerda)) {
            return rotacaoEsquerda(no);
        }
        if (balance < -1 && altura(no.direita.direita) < altura(no.direita.esquerda)) {
            no.direita = rotacaoDireita(no.direita);
            return rotacaoEsquerda(no);
        }

        no.altura = Math.max(altura(no.esquerda), altura(no.direita)) + 1;
        return no;
    }

    public void deletar(Integer chave) {
        this.raiz = deletar(this.raiz, chave);
    }

    private No deletar(No no, Integer chave) {
        if (no == null) {
            return no;
        }
        if (chave < no.chave) {
            no.esquerda = deletar(no.esquerda, chave);
        } else if (chave > no.chave) {
            no.direita = deletar(no.direita, chave);
        } else {
            if (no.esquerda == null && no.direita == null) {
                no = null;
            } else if (no.esquerda == null) {
                no = no.direita;
            } else if (no.direita == null) {
                no = no.esquerda;
            } else {
                No temp = maximoDaEsquerda(no.esquerda);
                no.chave = temp.chave;
                no.esquerda = deletar(no.esquerda, temp.chave);
            }
        }
        if (no != null) {
            no = balancear(no);
        }
        return no;
    }

    private No maximoDaEsquerda(No no) {
        No atual = no;
        while (atual.direita != null) {
            atual = atual.direita;
        }
        return atual;
    }

    public void emOrdem() {
        emOrdemRecursiva(raiz);
    }

    private void emOrdemRecursiva(No no) {
        if (no != null) {
            emOrdemRecursiva(no.esquerda);
            System.out.println(no.chave);
            emOrdemRecursiva(no.direita);
        }
    }
}