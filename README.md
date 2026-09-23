# Árvore binária de código Morse

Gabriel Naumann Jerônimo de Moura e Gabriel Pacheco Benin

## Objetivo

O programa guarda as 26 letras do alfabeto e os números de 0 a 9 em uma árvore binária de código Morse. A raiz é um nó vazio. Cada ponto (`.`) leva ao filho esquerdo e cada traço (`-`) leva ao filho direito. O caminho da raiz até um caractere forma seu código Morse. Por exemplo, esquerda e depois direita levam à letra A, cujo código é `.-`.

## Como executar

É necessário ter o JDK instalado. Abra um terminal na pasta dos arquivos e execute:

```text
javac -encoding UTF-8 ArvoreBinariaBusca.java
java ArvoreBinariaBusca
```

Para modificar o código ou depurar sua execução passo a passo, recomendamos abrir esta pasta no VS Code com suporte a Java e executar `ArvoreBinariaBusca.java` por lá.

O programa exibe a árvore e pede uma mensagem. Digite letras sem acento, números e espaços. Letras minúsculas também são aceitas. Cada código Morse é separado por um espaço; `/` separa as palavras.

Exemplo:

```text
Mensagem: SOS 123
Resultado: ... --- ... / .---- ..--- ...--
```

Se a mensagem tiver um caractere que não está na árvore, o programa informa que a entrada é inválida.

## Como a árvore funciona

A classe `No` guarda um caractere e as referências para os filhos `esquerda` e `direita`. A árvore começa com a raiz vazia. `insereElemento` lê o código Morse sinal por sinal, cria os nós necessários e coloca a letra ou o número no nó final. As 26 letras e os 10 números são inseridos no `main`.

`buscaElemento` recebe uma letra ou um número e devolve seu código Morse. O método `busca` examina os nós e guarda o caminho percorrido. Se não encontrar o caractere, devolve uma String vazia. `buscaCodigo` faz o caminho inverso: recebe o código de um único caractere e devolve a letra ou o número encontrado. Quando o código é inválido, devolve `?`.

`exibeArvore` e `exibe` mostram os nós em níveis. A quantidade de espaços mostra a profundidade, e o ponto ou traço antes de cada nó indica se ele é filho esquerdo ou direito. Um nó que existe apenas para completar um caminho aparece como `(vazio)`.

`converteMensagem` percorre o texto digitado, busca o Morse de cada caractere e junta os códigos. `main` monta a árvore, mostra sua estrutura, apresenta exemplos de busca e lê a mensagem usando `Scanner`.

## Exemplos de busca

| Chamada | Resultado |
| --- | --- |
| `buscaElemento('S')` | `...` |
| `buscaElemento('O')` | `---` |
| `buscaCodigo("...")` | `S` |
| `buscaCodigo("---")` | `O` |

`buscaCodigo` recebe o Morse de apenas um caractere. Para representar SOS, os códigos precisam estar separados: `... --- ...`. A sequência `...---...` não representa um único caminho da árvore.
