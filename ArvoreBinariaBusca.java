public class ArvoreBinariaBusca {

    class No {
        int dado;
        No esquerda;
        No direita;

        No(int elemento) {
            this.dado = elemento;
        }
    }

    No raiz = null;

    public void insereElemento(int elemento) {
        No novoNo = new No(elemento);
        if (raiz == null) {
            raiz = novoNo;
            return;
        }

        No atual = raiz;
        while (true) {
            if (elemento < atual.dado) {
                if (atual.esquerda == null) {
                    atual.esquerda = novoNo;
                    return;
                }
                atual = atual.esquerda;
            } else {
                // Valores maiores ou iguais ficam a direita.
                if (atual.direita == null) {
                    atual.direita = novoNo;
                    return;
                }
                atual = atual.direita;
            }
        }
    }

    public boolean buscaElemento(int elemento) {
        No atual = raiz;
        while (atual != null) {
            if (elemento == atual.dado) {
                return true;
            }
            atual = elemento < atual.dado ? atual.esquerda : atual.direita;
        }
        return false;
    }

    // Remove uma ocorrencia. Retorna false quando o valor nao existe.
    public boolean removeElemento(int elemento) {
        No pai = null;
        No atual = raiz;

        while (atual != null && atual.dado != elemento) {
            pai = atual;
            atual = elemento < atual.dado ? atual.esquerda : atual.direita;
        }
        if (atual == null) {
            return false;
        }

        if (atual.esquerda != null && atual.direita != null) {
            // Substitui pelo menor valor da subarvore direita.
            No paiSucessor = atual;
            No sucessor = atual.direita;
            while (sucessor.esquerda != null) {
                paiSucessor = sucessor;
                sucessor = sucessor.esquerda;
            }
            atual.dado = sucessor.dado;
            // O sucessor nao tem filho esquerdo; basta remove-lo abaixo.
            pai = paiSucessor;
            atual = sucessor;
        }

        No filho = atual.esquerda != null ? atual.esquerda : atual.direita;
        if (pai == null) {
            raiz = filho;
        } else if (pai.esquerda == atual) {
            pai.esquerda = filho;
        } else {
            pai.direita = filho;
        }
        return true;
    }

    public static void main(String[] args) {
        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();
        arvore.insereElemento(20);
        arvore.insereElemento(10);
        arvore.insereElemento(30);
        arvore.insereElemento(25);
        arvore.insereElemento(30);

        System.out.println("Busca 25: " + arvore.buscaElemento(25)); // true
        System.out.println("Busca 99: " + arvore.buscaElemento(99)); // false
        System.out.println("Remove 20: " + arvore.removeElemento(20)); // true
        System.out.println("Nova raiz: " + arvore.raiz.dado); // 25
        System.out.println("Remove 99: " + arvore.removeElemento(99)); // false
        System.out.println("Remove 30: " + arvore.removeElemento(30)); // true
        System.out.println("Ainda existe 30: " + arvore.buscaElemento(30)); // true
    }
}
