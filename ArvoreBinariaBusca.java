import java.util.Scanner;

public class ArvoreBinariaBusca {
    class No {
        char dado;
        No esquerda;
        No direita;

        No(char elemento) {
            this.dado = elemento;
        }
    }

    No raiz = new No(' ');

    public void insereElemento(char elemento, String codigo) {
        No atual = raiz;

        for (int i = 0; i < codigo.length(); i++) {
            if (codigo.charAt(i) == '.') {
                if (atual.esquerda == null) {
                    atual.esquerda = new No(' ');
                }
                atual = atual.esquerda;
            } else if (codigo.charAt(i) == '-') {
                if (atual.direita == null) {
                    atual.direita = new No(' ');
                }
                atual = atual.direita;
            } else {
                System.out.println("Codigo invalido. Use apenas ponto e traco.");
                return;
            }
        }

        if (codigo.length() > 0) {
            atual.dado = elemento;
        }
    }

    public String buscaElemento(char elemento) {
        elemento = Character.toUpperCase(elemento);
        return busca(raiz, elemento, "");
    }

    public String busca(No atual, char elemento, String codigo) {
        if (atual == null) {
            return "";
        }

        if (atual.dado == elemento && atual.dado != ' ') {
            return codigo;
        }

        String resultado = busca(atual.esquerda, elemento, codigo + ".");

        if (!resultado.equals("")) {
            return resultado;
        }

        return busca(atual.direita, elemento, codigo + "-");
    }

    public char buscaCodigo(String codigo) {
        No atual = raiz;

        for (int i = 0; i < codigo.length(); i++) {
            if (codigo.charAt(i) == '.') {
                atual = atual.esquerda;
            } else if (codigo.charAt(i) == '-') {
                atual = atual.direita;
            } else {
                return '?';
            }

            if (atual == null) {
                return '?';
            }
        }

        if (atual.dado == ' ') {
            return '?';
        }

        return atual.dado;
    }

    public void exibeArvore() {
        System.out.println("RAIZ");
        exibe(raiz.esquerda, "    ", ". ");
        exibe(raiz.direita, "    ", "- ");
    }

    public void exibe(No atual, String espacos, String lado) {
        if (atual == null) {
            return;
        }

        if (atual.dado == ' ') {
            System.out.println(espacos + lado + "(vazio)");
        } else {
            System.out.println(espacos + lado + atual.dado);
        }

        exibe(atual.esquerda, espacos + "    ", ". ");
        exibe(atual.direita, espacos + "    ", "- ");
    }

    public String converteMensagem(String mensagem) {
        String resultado = "";

        for (int i = 0; i < mensagem.length(); i++) {
            char letra = mensagem.charAt(i);

            if (letra == ' ') {
                resultado = resultado + "/ ";
            } else {
                String codigo = buscaElemento(letra);

                if (codigo.equals("")) {
                    return "Mensagem invalida. Use letras sem acento, numeros e espacos.";
                }

                resultado = resultado + codigo + " ";
            }
        }

        return resultado.trim();
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();

        arvore.insereElemento('A', ".-");
        arvore.insereElemento('B', "-...");
        arvore.insereElemento('C', "-.-.");
        arvore.insereElemento('D', "-..");
        arvore.insereElemento('E', ".");
        arvore.insereElemento('F', "..-.");
        arvore.insereElemento('G', "--.");
        arvore.insereElemento('H', "....");
        arvore.insereElemento('I', "..");
        arvore.insereElemento('J', ".---");
        arvore.insereElemento('K', "-.-");
        arvore.insereElemento('L', ".-..");
        arvore.insereElemento('M', "--");
        arvore.insereElemento('N', "-.");
        arvore.insereElemento('O', "---");
        arvore.insereElemento('P', ".--.");
        arvore.insereElemento('Q', "--.-");
        arvore.insereElemento('R', ".-.");
        arvore.insereElemento('S', "...");
        arvore.insereElemento('T', "-");
        arvore.insereElemento('U', "..-");
        arvore.insereElemento('V', "...-");
        arvore.insereElemento('W', ".--");
        arvore.insereElemento('X', "-..-");
        arvore.insereElemento('Y', "-.--");
        arvore.insereElemento('Z', "--..");

        arvore.insereElemento('0', "-----");
        arvore.insereElemento('1', ".----");
        arvore.insereElemento('2', "..---");
        arvore.insereElemento('3', "...--");
        arvore.insereElemento('4', "....-");
        arvore.insereElemento('5', ".....");
        arvore.insereElemento('6', "-....");
        arvore.insereElemento('7', "--...");
        arvore.insereElemento('8', "---..");
        arvore.insereElemento('9', "----.");

        System.out.println("Alunos: Gabriel Naumann Jerônimo de Moura e Gabriel Pacheco Benin");
        System.out.println("Arvore Morse: ponto = esquerda, traco = direita.");
        arvore.exibeArvore();

        System.out.println("\nCodigo de S: " + arvore.buscaElemento('S'));
        System.out.println("Letra de ---: " + arvore.buscaCodigo("---"));

        System.out.println("\nDigite uma mensagem com letras sem acento e numeros:");
        String mensagem = entrada.nextLine();

        System.out.println("Resultado: " + arvore.converteMensagem(mensagem));
        System.out.println("Espacos separam letras. A barra / separa palavras.");

        entrada.close();
    }
}