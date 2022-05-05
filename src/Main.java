public class Main {
    public static void main(String[] args) {
        //Criando uma pilha estática
        StaticStack staticStack = new StaticStack(4);
        //Criando uma pilha dinâmica (growth rate)
        ArrayStack arrayStack = new ArrayStack(4, 1);
        //Criando uma pilha encadeada
        LinkedStack linkedStack = new LinkedStack();

        //Adicionando elementos na pilha estática
        staticStack.push(1);
        staticStack.push(5);
        staticStack.push(6);
        staticStack.push(8);

        //Imprime pilha estática
        System.out.println("Static Stack Content: " + staticStack.toString());
        //Imprime tamanho da pilha estática
        System.out.println("Static Stack Size: " + staticStack.getSize());
        //Imprime capacidade da pilha estática
        System.out.println("Static Stack Capacity: " + staticStack.getCapacity());
        //Desempilha o último elemento e imprime
        System.out.println("Static Stack Top Item: " + staticStack.pop());
        //Imprime tamanho da pilha estática novamente
        System.out.println("Static Stack Size: " + staticStack.getSize() + "\n");

        //Adicionando elementos da pilha dinâmica (growth rate)
        arrayStack.push(22);
        arrayStack.push(19);
        arrayStack.push(29);
        arrayStack.push(7);

        //Imprime pilha dinâmica (growth rate)
        System.out.println("Array Stack Content: " + arrayStack.toString());
        //Imprime tamanho da pilha dinâmica (growth rate)
        System.out.println("Array Stack Size: " + arrayStack.getSize());
        //Imprime capacidade da pilha dinâmica (growth rate)
        System.out.println("Array Stack Capacity: " + arrayStack.getCapacity());

        //Adiciona um elemento na pilha dinâmica (growth rate)
        arrayStack.push(44);
        System.out.println("\n44 Added!");
        //Imprime pilha dinâmica (growth rate)
        System.out.println("Array Stack Content: " + arrayStack.toString());
        //Imprime tamanho da pilha dinâmica (growth rate)
        System.out.println("Array Stack Size: " + arrayStack.getSize());
        //Imprime capacidade da pilha dinâmica (growth rate)
        System.out.println("Array Stack Capacity: " + arrayStack.getCapacity());

        //Reduz a capacidade da pilha dinâmica (growth rate) para a quantidade de elementos
        arrayStack.trimToSize();
        System.out.println("Trim to Size Applied");
        //Imprime tamanho da pilha dinâmica (growth rate)
        System.out.println("\nArray Stack Size: " + arrayStack.getSize());
        //Imprime capacidade da pilha dinâmica (growth rate)
        System.out.println("Array Stack Capacity: " + arrayStack.getCapacity());

        //Adiciona elementos na pilha encadeada
        linkedStack.push(99);
        linkedStack.push(98);
        linkedStack.push(97);
        linkedStack.push(96);
        //Desempilha último elemento da pilha encadeada e imprime
        System.out.println("Linked Stack Top Item: " + linkedStack.pop());
        //Desempilha último elemento da pilha encadeada e imprime
        System.out.println("Linked Stack Top Item: " + linkedStack.pop());
        //Desempilha último elemento da pilha encadeada e imprime
        System.out.println("Linked Stack Top Item: " + linkedStack.pop());
        //Desempilha último elemento da pilha encadeada e imprime
        System.out.println("Linked Stack Top Item: " + linkedStack.pop());
        //Adiciona um elemento na pilha
        linkedStack.push(55);
        //Desempilha último elemento da pilha encadeada e imprime
        System.out.println("Linked Stack Top Item: " + linkedStack.pop());
    }
}
