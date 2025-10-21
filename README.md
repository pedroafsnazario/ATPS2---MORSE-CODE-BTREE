# ATPS2---MORSE-CODE-BTREE
Trabalho de ATPS - Estruturação de Dados - Arvore Binária com lógica de Código Morse

## Alunos 👥
- Eduardo Zenere
- Pedro Antonio

## O Projeto 📖
O Objetivo é implementar uma Árvore Binária, porém com uma regra de distribuição/armazenamento diferente, e com a capacidade de armazenar valores que possam ser codificados em codigo morse (desde números a caracteres)
A regra de distribuição/armazenamento dessa árvore não é a tradicional  menor -> esquerda/maior -> direita, e sim uma regra que segue o conceito de código morse, ou seja "." -> esquerda / " - " -> direita

## O Código 👨‍💻
 Para representarmos um Código Morse dentro de uma Árvore Binária (onde cada caminho da raiz até um nó representa a sequência de pontos (.) e traços (-) correspondente a um caractere), separamos o projeto em duas classes, a **Main** e a **Btree** 

### Main
- **Implementação**: Implementamos todos os fatores importantes dentro do main para o código realizar a função desejada (no caso, fizemos a implementação da MorseTree e dos seus valores com seus respectivos codigos em morse).
- **Menu (Switch)**: Criamos um menu por meio de um Loop While(true), um Switch case e um Scanner para inputs para executar uma das opções que um User inserir, as opções sendo para inserir um valor dentro da arvore, codificar ou decodificar um valor dentro da árvore, entre outros.

### Btree
- **Classe Principal**: A base para árvore, contendo seu construtor e funções para inserção, codificação, decodificação e exibição da árvore.
- **Classe Nó**: A class nó necessária para a base da Árvore, contendo seus atributos e seu construtor

### Observação 👁️
TBD
