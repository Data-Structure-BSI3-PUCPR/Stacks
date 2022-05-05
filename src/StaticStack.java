//classe de implementação da pilha estática (possui capacidade limitada de acordo com o tamanho definido)
//herda todos os atributos, métodos e comportamentos da pilha abstrata (AbstractStack)
public class StaticStack extends AbstractStack {
    //construtor da pilha estática, recebe como parâmetro o valor da capacidade da pilha estática (tamanho do array)
    //inclui apenas a chamada do construtor pai (super(capacity)), que no caso é a pilha abstrata
    public StaticStack(int capacity) {
        super(capacity);
    }

    //Método que adiciona um elemento à pilha estática, recebe como parâmetro o elemento que será adicionado
    public void push(int element) {
        //caso a pilha esteja cheia, é disparada uma exceção
        //na pilha estática não é possível inserir mais elementos uma vez que ela está cheia
        if(isFull()) {
            throw new IllegalStateException("Stack is full");
        }
        //definição da variável de topo para o índice do último elemento inserido
        // (no caso o que está sendo inserido na chamada deste método)
        top = top + 1;
        //insere o elemento no topo da pilha
        elements[top] = element;
    }

    //método que retorna verdadeiro caso a pilha esteja cheia e falso caso não esteja cheia
    public boolean isFull() {
        //se o topo for maior que a capacidade da pilha, a pilha está cheia
        return top >= getCapacity() -1;
    }

    //método de formatação de string para imprimir a pilha no formato: [1, 2, 3]
    @Override
    public String toString() {
        String out = "[";
        if(getSize() > 0) {
            out += this.elements[0];
        }
        for (int i = 1; i < getSize(); i++) {
            out += ", " + this.elements[i];
        }
        out += "]";
        return out;
    }
}
