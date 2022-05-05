//classe que define uma pilha abstrata (qualquer)
//implementa métodos da interface stack
public abstract class AbstractStack implements Stack {
    //variável que armazena o índice do elemento no topo da pilha
    protected int top;
    //array que representa a pilha
    protected int[] elements;

    //construtor de uma pilha abstrata (qualquer)
    //recebe como parâmetro a capacidade que a pilha deve ter (quantidade de elementos / tamanho do array)
    public AbstractStack(int capacity) {
        //Caso a capacidade informada seja menor ou igual a 0, é disparada uma exceção (erro)
        if(capacity <= 0) {
            throw new IllegalArgumentException("Capacity has to be greater then 1");
        }
        //Inicialização do top com valor de -1, indicando que a pilha está vazia (não há elementos na pilha)
        top = -1;
        //inicialização do array de elementos (pilha) com o tamanho informado no parâmetro capacidade
        elements = new int[capacity];
    }

    //função que desempilha o último elemento inserido na pilha
    @Override
    public int pop() {
        //caso a pilha esteja vazia, uma exceção é disparada (erro)
        //não é possível desempilhar uma pilha vazia, certo?
        if(isEmpty()) {
            throw new IllegalStateException("Stack is Empty");
        }
        //guarda o elemento do topo em uma variável temporária
        int elem = elements[top];
        //define o elemento do topo para 0 (por ser uma pilha do tipo int definimos zero, em caso de objetos seria null)
        elements[top] = 0;
        //definição o topo para o índice anterior do array
        top = top - 1;
        //retorno do elemento do topo
        return elem;
    }

    //função que limpa a pilha (por ser do tipo int basta definir o top para -1, igual no construtor)
    @Override
    public void clear() {
        top = top - 1;
    }

    //função que retorna o tamanho da pilha
    public int getSize() {
        return top + 1;
    }

    //função que retorna a capacidade da pilha
    public int getCapacity() {
        return elements.length;
    }

    //função que retorna verdadeiro caso a pilha esteja vazia e falso se não estiver vazia
    @Override
    public boolean isEmpty() {
        return top < 0;
    }
}
