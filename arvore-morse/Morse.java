//Implementação da árvore Morse
public class Morse {
    //Atributos iniciais
    private int altura = 0; // Altura da árvore
    private NoMorse root = null; // Nó raiz da árvore

    //Construtor
    Morse() {
        this.root = new NoMorse('\0');
    }

    // Função de adição, recebe o código Morse e o caractere correspondente
    boolean adicionar(String codigo, char valor) {
        
        String seq = ""; // Sequência vazia
        NoMorse atual = this.root; // Começa do nó root

        // Percorre cada caractere do código Morse
        for (int i = 0; i < codigo.length(); i++) {
            // Pega o caractere atual do código
            char val = codigo.charAt(i);
            // Se for '.', vai para a esquerda
            if (val == '.') {
                if(atual.esquerda == null) atual.esquerda = new NoMorse('\0'); // Cria o nó se não existir algo naquele lugar da arvore
                atual = atual.esquerda;
            } else if (val == '-') { // Se for '-', vai para a direita
                if(atual.direita == null) atual.direita = new NoMorse('\0'); // Cria o nó se não existir algo naquele lugar da arvore
                atual = atual.direita;
            } else return false; // Se for algo diferente de '.' ou '-', retorna falso
        }

        if (codigo.length() > altura) altura = codigo.length(); // Atualiza a altura da árvore se necessário

        atual.caracter = valor; // Atribui o caractere ao nó final
        return true; // Retorna verdadeiro indicando sucesso
    }

    // Função de decodificação, recebe uma string em Morse e retorna o texto correspondente
    String decodificar(String morse) {
        // Inicializa a string de retorno e começa do nó root
        String retorno = "";
        NoMorse atual = this.root;

        // Percorre cada caractere da string Morse
        for (int i = 0; i < morse.length(); i++) {
            // Pega o caractere atual
            char valor = morse.charAt(i);

            // Se for '.', vai para a esquerda
            if (valor == '.') {
                if (atual.esquerda != null) atual = atual.esquerda; // Move para a esquerda se possível
                else return null; // Retorna nulo se o caminho não existir
            } else if (valor == '-') { // Se for '-', vai para a direita
                if (atual.direita != null) atual = atual.direita; // Move para a direita se possível
                else return null; // Retorna nulo se o caminho não existir
            } else if (valor == ' ') { // Se for espaço, significa fim de um caractere
                if(atual != this.root) { 
                    // Adiciona o caractere ao retorno, se não for root
                    retorno += atual.caracter; // Adiciona o caractere ao retorno
                    atual = this.root; // Reseta para o nó root
                } else {
                    retorno += ' '; // Adiciona espaço ao retorno, caso esteja em root
                }
            } else return null; // Retorna nulo se o caractere for inválido
        }

        if (atual != this.root) retorno += atual.caracter; // Adiciona o último caractere se necessário

        return retorno; // Retorna a string decodificada
    }

    // Função de codificação, recebe um texto e retorna a string em Morse correspondente
    String codificar(String texto) {
        // Inicializa a string de retorno
        String retorno = "";

        // Percorre cada caractere do texto
        for (int i = 0; i < texto.length(); i++) {
            // Pega o caractere atual
            char caracter_atual = texto.charAt(i);

            // Se for espaço, adiciona espaço ao retorno
            if (caracter_atual == ' ') {
                // Adiciona espaço ao retorno
                retorno += ' ';
                continue; // Pula para o próximo caractere
            }
            // Adiciona um espaço antes do próximo código Morse, se o retorno não estiver vazio
            if (retorno.length() != 0) retorno += ' ';

            // Encontra o código Morse correspondente ao caractere atual
            String codigo = this.encontrar(caracter_atual);
            // Se o código for nulo, retorna nulo
            if(codigo == null) return null;

            retorno += codigo; // Adiciona o código Morse ao retorno
        }

        return retorno; // Retorna a string codificada em Morse
    }

    // Função auxiliar para encontrar o código Morse de um caractere, inicia a busca recursiva
    String encontrar(char valor) {
        // Chama a função recursiva começando do nó root
        return this.encontrar(valor, "", this.root);
    }
    // Função base recursiva para encontrar o código Morse de um caractere, recebe o caractere, a string de retorno atual e o nó atual
    String encontrar(char valor, String retorno, NoMorse atual) {
        // Se o nó atual for nulo, retorna nulo
        if (atual == null) return null;
        // Se o caractere do nó atual for o valor procurado, retorna a string de retorno
        if (atual.caracter == valor) return retorno;

        // Busca recursivamente na subárvore esquerda e direita
        String esq = encontrar(valor, retorno + '.', atual.esquerda);
        if (esq != null) return esq; // Se encontrado na esquerda, retorna o código

        // Se não encontrado na esquerda, busca na direita
        String dir = encontrar(valor, retorno + '-', atual.direita);
        if (dir != null) return dir; // Se encontrado na direita, retorna o código

        return null; // Retorna nulo se não encontrado em nenhum dos lados
    }




    // Funções de print

    // Faz 2^v
    int two(int v) {
        int val = 2;
        for(int i = 1; i < v; i++) val *= 2;
        return v == 0 ? 0 : val;
    }
    // Simplesmente printa n espaços.
    void printSpaces(int n) {
        for (int c = 0; c < n; c++) System.out.print(" ");
    }
    // Aqui o bagulho é maneiro
    // Isso pega um caractere baseado em sua posição em altura/indice
    char getAt(int h, int i) {
        // Inicia uma variável total com a quantidade total de itens na altura que o item está
        int total = two(h);
        // Cria uma variável auxiliar que contem o valor original de i
        int val = i;

        // Começa pelo nó root.
        NoMorse atual = this.root;

        // Enquanto o total for maior que 1, ou seja, enquanto existirem mais de 2 elementos pra buscar o nosso item
        while(total >= 2) {
            // divida o total de itens por 2
            int half = total / 2;
            // Se o valor que estamos procurando está em um índice mais a esquerda, simplesmente continue percorrendo pra esquerda
            if (val < half) atual = atual.esquerda;
            else {
                // Se for pra direita, percorremos para a direita
                atual = atual.direita;
                // e tiramos a metade de índices que percorremos, então supondo que está em 5 e a metade é 4 o proximo val será 1
                val -= half;
            }
            // Se o atual não existir, então o valor procurado não existe
            if(atual == null) return ' ';

            // O total é dividido por 2, pois na proxima iteração, já estamos um nível abaixo, então são a metade dos itens acessiveis anteriormente
            total /= 2;
        }

        // Se o caractere for nulo, substitua-o por um ?
        return atual.caracter == '\0' ? '?' : atual.caracter;
    }
    void imprimir() {
        // Pra imprimir pegamos a quantidade de nós da ultima linha (2^altura)
        int max = two(altura);

        //E para cada uma das alturas, printamos seus itens
        for (int alt = 0; alt <= this.altura; alt++) {
            // Se a altura for 0, é root, então é uma tratativa especial pra deixar bonito
            if (alt == 0) {
                printSpaces(max - 4);
                System.out.println("ROOT");
            } else {
                // Aqui ele só printa as / \, então a lógica é praticamente igual ali em baixo, com a diferença de que ele verifica se o indice é par e printa / e se for impar \
                printSpaces((max / two(alt)) - 1);
                for (int i = 0; i < two(alt); i++) {
                    System.out.print(getAt(alt, i) != ' ' ? (i % 2 == 0 ? '/' : '\\') : ' ');
                    printSpaces(max / two(alt) * 2 - 1);
                }
                System.out.println();

                // Se for > 0, printamos a quantidade máxima de nós / pela quantidade de nós da linha - 1 (-1 pois tem o caractere do nó que seria um espaço)
                printSpaces((max / two(alt)) - 1);
                // Aí pegamos a quantidade de itens na linha e printamos um a um
                for (int i = 0; i < two(alt); i++) {
                    // Printamos o caractere em si
                    System.out.print(getAt(alt, i));
                    // E printamos a quantidade de espaços de cada uma das linhas menos o proprio caractere (-1).
                    printSpaces(max / two(alt) * 2 - 1);
                }
                // Finalmente pulamos a linha
                System.out.println();
            }
        }
    }
}

// Nó da árvore Morse
class NoMorse {
    // Atributos do nó
    char caracter;
    NoMorse direita;
    NoMorse esquerda;

    // Construtor
    NoMorse(char caracter) {
        this.caracter = caracter;
    }
}