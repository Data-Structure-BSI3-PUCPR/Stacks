//Interface para a pilha
//Definição apenas de uma "assinatura" dos métodos
//A implementação de cada método é feita pelas classes que implementam a interface Stack
public interface Stack {
    void push(int element);
    int pop();
    void clear();
    boolean isEmpty();
    boolean isFull();
}