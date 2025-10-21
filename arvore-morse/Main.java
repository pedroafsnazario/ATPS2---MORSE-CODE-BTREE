import java.util.Scanner;

// Classe principal para o sistema de codificação e decodificação Morse
public class Main {
    // Scanner para entrada do usuário
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Criação da instância do sistema Morse
        Morse morse = new Morse();

        // Adiciona os caracteres Morse padrão
        morse.adicionar(".-", 'A');
        morse.adicionar("-...", 'B');
        morse.adicionar("-.-.", 'C');
        morse.adicionar("-..", 'D');
        morse.adicionar(".", 'E');
        morse.adicionar("..-.", 'F');
        morse.adicionar("--.", 'G');
        morse.adicionar("....", 'H');
        morse.adicionar("..", 'I');
        morse.adicionar(".---", 'J');
        morse.adicionar("-.-", 'K');
        morse.adicionar(".-..", 'L');
        morse.adicionar("--", 'M');
        morse.adicionar("-.", 'N');
        morse.adicionar("---", 'O');
        morse.adicionar(".--.", 'P');
        morse.adicionar("--.-", 'Q');
        morse.adicionar(".-.", 'R');
        morse.adicionar("...", 'S');
        morse.adicionar("-", 'T');
        morse.adicionar("..-", 'U');
        morse.adicionar("...-", 'V');
        morse.adicionar(".--", 'W');
        morse.adicionar("-..-", 'X');
        morse.adicionar("-.--", 'Y');
        morse.adicionar("--..", 'Z');
        morse.adicionar("-----", '0');
        morse.adicionar(".----", '1');
        morse.adicionar("..---", '2');
        morse.adicionar("...--", '3');
        morse.adicionar("....-", '4');
        morse.adicionar(".....", '5');
        morse.adicionar("-....", '6');
        morse.adicionar("--...", '7');
        morse.adicionar("---..", '8');
        morse.adicionar("----.", '9');

        // Menu interativo
        System.out.println("Sistema MORSE\n\n");
        boolean continuar = true;
        // Loop principal do menu, continua até o usuário escolher sair
        while (continuar) {
            System.out.println("Escolha uma opção para continuar\n");
            System.out.println("(1) Inserir");
            System.out.println("(2) Codificar");
            System.out.println("(3) Decodificar");
            System.out.println("(4) Imprimir");
            System.out.println("(5) Sair\n");

            System.out.print("Opção: ");
            // Lê a opção do usuário
            int opcao = sc.nextInt();
            sc.nextLine();

            // Executa a ação correspondente à opção escolhida
            switch (opcao) {
                case 1:
                    //CASO 1: Inserir novo caractere Morse
                    System.out.print("\n\nDigite o caractere a ser codificado: ");
                    String caracter = sc.nextLine();
                    System.out.print("Digite o morse a ser utilizado (. e -): ");
                    String cCod = sc.nextLine();

                    // Adiciona o novo caractere ao sistema Morse, charAt(0) pega o primeiro caractere da string
                    morse.adicionar(cCod, caracter.charAt(0));
                    break;
                case 2:
                    //CASO 2: Codificar texto para Morse
                    System.out.print("\n\nDigite o texto a ser codificado: ");
                    String text = sc.nextLine();
                    System.out.println("\nTexto codificado: " + morse.codificar(text) + "\n\n");
                    break;
                case 3:
                    //CASO 3: Decodificar Morse para texto
                    System.out.print("\n\nDigite o morse a ser decodificado: ");
                    String codigo = sc.nextLine();
                    System.out.println("\nTexto decodificado: " + morse.decodificar(codigo) + "\n\n");
                    break;
                case 4:
                    //CASO 4: Imprimir a árvore Morse
                    System.out.println("A árvore morse:\n");
                    morse.imprimir();
                    System.out.println("\n");
                    break;
                case 5:
                    //CASO 5: Sair do programa
                    continuar = false;
            }
        }
    }
}