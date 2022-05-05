//classe de implementação da pilha encadeada
//não herda de Abstract Stack pois possui comportamentos diferentes das pilhas anteriores
//Implementa a interface Stack
public class LinkedStack implements Stack{
    //classe privada que representa um nó
    //um nó nada mais é do que um espaço na memória heap onde serão armazenados os nossos elementos
    private static class Node {
        //Referência para o nó anterior
        //lembrando que na memória heap os elementos ficam dispersos na memória
        //é preciso "criar uma ordenação fictícia" desses elementos
        //por esse motivo armazenamos uma referência para o nó anterior
        public Node previous;
        //variável que armazena o dado que será inserido (elemento da pilha)
        public int data;
    }

    //Armazenamento local do nó do topo da pilha
    //Veja que agora nosso top não inicia em -1, pois agora ele é um Objeto Java
    //por isso iniciamos ele como nulo, ou seja, ainda não possui referência para nada (está vazio)
    private Node top = null;

    //método que adiciona um elemento à pilha
    @Override
    public void push(int element) {
        //Criação de um novo nó onde será feita a inserção do novo elemento
        var newData = new Node();
        //atribuição do dado do nó para o elemento que queremos inserir
        newData.data = element;
        //atribuição da referência do nó anterior para o topo
        //perceba que o topo ainda não foi atribuído ao novo valor (newData)
        //portanto o topo ainda está guardando a referência para o último elemento inserido
        //no caso de estar inserindo o primeiro elemento da pilha, a referência para o nó anterior será nula (vazia)
        //afinal de contas, se é o primeiro elemento da pilha, não tem como existir um elemento anterior, certo?
        newData.previous = top;
        //aqui sim é feita a atribuição do topo para o novo elemento que está sendo inserido (newData)
        top = newData;
    }

    //função que desempilha o elemento do topo da pilha (remove da pilha)
    @Override
    public int pop() {
        //caso a pilha esteja vazia, uma exceção é disparada (erro)
        //não é possível desempilhar uma pilha vazia, certo?
        if(isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        //guardamos o valor do elemento do topo em uma variável temporária
        var data = top.data;
        //atribuímmos o valor anterior como novo topo
        //(desempilhei o item de cima da minha pilha, agora meu novo item de cima é o que estava embaixo desse certo?)
        top = top.previous;
        //retorno o valor do elemento do topo
        return data;
    }

    //função para limpar a pilha (apaga todos os elementos)
    @Override
    public void clear() {
        //atribuição do topo para nulo (vazio)
        //uma vez que o topo não está referenciando nada, todas a cadeia de referências será removida pelo Garbage Collector do Java
        top = null;
    }

    //função que retorna verdadeiro caso a pilha esteja vazia e falso se não estiver vazia
    @Override
    public boolean isEmpty() {
        return top == null;
    }

    //método que retorna verdadeiro caso a pilha esteja cheia e falso caso não esteja cheia
    //a pilha encadeada nunca fica cheia pois criamos os nós conforme os elementos são adicionados à pilha
    //portanto nesse caso, essa função sempre retorna falso
    @Override
    public boolean isFull() {
        return false;
    }
}
