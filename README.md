# 🔖Estrutura de Dados 
Estruturas de dados abordadas no curso de Ciência da Computação - UNICAP (Universidade Católica de Pernambuco).

## 🌳1- Árvore AVL:
Uma árvore AVL (Adelson-Velskii e Landis) é uma estrutura de dados em árvore binária balanceada. Essa estrutura é utilizada para armazenar e pesquisar elementos em uma coleção de dados de forma eficiente.
A árvore AVL é balanceada de maneira que a diferença entre as alturas das subárvores esquerda e direita de cada nó não pode exceder um determinado valor (geralmente 1). Isso garante que a altura da árvore seja mantida em logaritmo na base 2 do número de elementos na árvore, o que garante uma eficiência na busca, inserção e remoção de elementos.
O processo de manutenção do balanceamento da árvore AVL ocorre automaticamente durante as operações de inserção e remoção de elementos, fazendo com que a árvore permaneça balanceada e eficiente em todos os momentos.

## 🐞2- Árvore Red-black:
É uma estrutura de dados em árvore binária que é utilizada em muitas aplicações, incluindo sistemas de banco de dados, sistemas de arquivos, compiladores e algoritmos de ordenação. É uma árvore de busca binária que garante que o comprimento do caminho mais longo da raiz para qualquer folha não é maior do que duas vezes o comprimento do caminho mais curto da raiz para outra folha.
As árvores rubro-negras são construídas com base em um conjunto de regras simples que governam a coloração dos nós da árvore. Cada nó é colorido de preto ou vermelho, e as seguintes regras devem ser seguidas:
- A raiz da árvore é sempre preta.
- Todos os nós filhos de um nó vermelho devem ser pretos.
- Qualquer caminho da raiz a uma folha deve ter o mesmo número de nós pretos.
- Um nó pode ser vermelho ou preto.

Essas regras garantem que a árvore esteja sempre balanceada, o que significa que o caminho mais longo da raiz para qualquer folha é no máximo duas vezes mais longo do que o caminho mais curto da raiz para outra folha. Como resultado, as operações de inserção, remoção e busca em uma árvore rubro-negra são muito eficientes e têm complexidade de tempo O(log n).

## 🎋3- Árvore B:
Árvore B é uma estrutura de dados em árvore que é usada para armazenar e pesquisar informações de forma eficiente. Essa estrutura é semelhante a uma árvore de pesquisa binária, mas com algumas diferenças importantes.
A principal diferença entre uma árvore B e uma árvore de pesquisa binária é que cada nó em uma árvore B pode ter mais de duas subárvores. Isso significa que cada nó pode armazenar mais informações do que em uma árvore de pesquisa binária.
Além disso, as árvores B são projetadas para manter uma altura baixa, o que significa que o tempo de busca é reduzido. Isso é alcançado por meio de um processo de divisão e fusão de nós para manter um número mínimo e máximo de chaves em cada nó.
As árvores B são frequentemente usadas em bancos de dados e sistemas de arquivos, pois são capazes de lidar com grandes quantidades de dados e pesquisas em tempo constante. No entanto, sua implementação é mais complexa do que a árvore de pesquisa binária e requer mais espaço de armazenamento devido ao número maior de subárvores em cada nó.

## 🍂4- Árvore B+:
Uma árvore B+ é uma variação da árvore B, que é utilizada para armazenar dados em um banco de dados ou sistema de arquivos. A principal diferença entre a árvore B+ e a árvore B é que a árvore B+ mantém todos os dados em folhas, enquanto a árvore B mantém dados em nós internos e folhas.
As folhas da árvore B+ são ligadas em uma lista duplamente ligada, o que permite realizar buscas sequenciais mais eficientes. Cada nó interno contém apenas chaves de busca e ponteiros para as subárvores, enquanto as folhas contêm as chaves de busca e os dados correspondentes. Isso significa que a árvore B+ é mais eficiente para buscar dados específicos do que a árvore B.
Outra característica importante da árvore B+ é que ela possui um fator de preenchimento mínimo para cada nó, o que significa que os nós não ficam vazios. Isso reduz a quantidade de espaço em disco necessário para armazenar a árvore, tornando-a ideal para aplicações em que a eficiência de armazenamento é importante.

## 🪄5- Hash:
O Hash é uma estrutura de dados que permite armazenar e recuperar informações de forma rápida e eficiente. É baseado em um algoritmo de função hash, que converte as chaves de busca em um valor numérico conhecido como "hash".
Esse valor hash é usado para indexar a tabela hash, que é uma estrutura de dados que armazena as informações. A tabela hash é composta por um conjunto de "buckets", que são contêineres que armazenam as informações com o mesmo valor hash.
Uma das principais vantagens da estrutura de dados hash é sua velocidade de acesso. Ao contrário das estruturas de árvore, que exigem a pesquisa de vários nós para encontrar um valor, a estrutura de hash permite acessar diretamente a posição do valor desejado na tabela, desde que a função hash seja bem projetada.
No entanto, a estrutura de hash tem algumas limitações. Uma delas é que as chaves de busca precisam ser únicas, pois a tabela hash usa a chave como índice. Além disso, o desempenho da estrutura de hash pode ser afetado pela qualidade da função hash, que pode resultar em colisões de hash e causar uma diminuição no desempenho.

## 🧮6- Ordenação:
Ordenação é o processo de reorganizar um conjunto de dados em uma determinada ordem. A ordenação pode ser feita em vários tipos de dados, como números, strings e objetos.
Existem diversos algoritmos de ordenação, cada um com diferentes características de desempenho, complexidade e estabilidade. Entre os algoritmos de ordenação mais comuns estão:

- Bubble Sort: É um algoritmo simples e fácil de implementar, mas possui baixo desempenho em grandes conjuntos de dados.

- Insertion Sort: É um algoritmo que funciona bem em pequenos conjuntos de dados, mas pode ser lento para conjuntos maiores.

- Selection Sort: É um algoritmo simples e fácil de entender, mas possui desempenho lento em grandes conjuntos de dados.

- Quick Sort: É um algoritmo eficiente que funciona bem em grandes conjuntos de dados, mas pode ser instável em alguns casos.

- Merge Sort: É um algoritmo eficiente que funciona bem em grandes conjuntos de dados e é estável, mas pode exigir mais espaço de memória.

A escolha do algoritmo de ordenação apropriado depende do tamanho do conjunto de dados, da disponibilidade de memória, da necessidade de estabilidade e do desempenho desejado.
