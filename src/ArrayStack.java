import java.util.Arrays;
//classe para a pilha dinâmica com growth rate (fator de crescimento)
//herda todos os atributos, métodos e comportamentos da pilha abstrata (AbstractStack)
public class ArrayStack extends AbstractStack {
    //variável de fator de crescimento da pilha
    private float growthRate;

    //construtor da pilha dinâmica, recebe como parâmetro a capacidade da pilha e o valor para fator de crescimento
    public ArrayStack(int capacity, float growthRate) {
        //chamada do construtor do pai (AbstractStack)
        super(capacity);
        //guarda o valor do fator de crescimento na variável local growthRate
        this.growthRate = growthRate;
    }

    //Método que adiciona um elemento à pilha, recebe como parâmetro o elemento que será adicionado
    public void push(int element) {
        //se a pilha atingir a capacidade máxima
        if(top >= getCapacity() - 1) {
            //uma nova capacidade é criada
            //o growthRate pode ser qualquer valor entre 0 e 1
            //quando for zero a pilha cresce apenas 1 posição, quando for 1 dobramos o tamanho da pilha
            //qualquer valor entre isso é calculado de acordo com o valor fornecido e o tamanho da pilha
            //ex: caso o valor de growthRate seja 0.5 e o tamanho inicial da pilha seja 6, a pilha cresce 3 posições (50%)
            //veja que a multiplicação é feita por growthRate + 1
            //isso é feito para manter a capacidade atual (1.0 = 100%) e acrescentar a capacidade adicional (0.5 = 50%)
            //no caso de uma pilha de tamanho 6 e um growthRate de 0.5, a nova capacidade fica 9 (6 + 3)
            int newCapacity = (int)(getCapacity() * (growthRate + 1));
            //o método max da biblioteca Math recebe dois valores, e retorna o maior valor entre os dois
            //ex: se os valores forem 4 e 2, o retorno da função max será 4.
            //esse método é utilizado para tratar a condição do growthRate ser 0
            //ex: se o valor de growthRate é 0 e a capacidade da pilha é 6
            //a função max receberia o valor 6+1 (7) e 6 (linha 28: 6 * (0 + 1) = 6)
            //como os valores fornecidos foram 7 e 6, a função max retorna o valor 7, que é o maior entre os dois valores
            //com isso, no caso do growthRate ser 0, nossa nova capacidade vai ser acrescido em 1
            newCapacity = Math.max(getCapacity() + 1, newCapacity);
            //a função copyOf da biblioteca Arrays copia os valores de um array para um novo array
            //ela recebe como parâmetro o array que contém os elementos (original) e o tamanho do novo array que será criado.
            //o retorno da função é um array com os elementos do array original no tamanho fornecido (newCapacity)
            var newArray = Arrays.copyOf(elements, newCapacity);
            //sobrescrita do array local para o novo array criado
            elements = newArray;
        }

        //definição da variável de topo para o índice do último elemento inserido
        // (no caso o que está sendo inserido na chamada deste método)
        top = top + 1;
        //insere o elemento no topo da pilha
        elements[top] = element;
    }

    //método que retorna verdadeiro caso a pilha esteja cheia e falso caso não esteja cheia
    //a pilha dinâmica nunca fica cheia, pois sempre que ela enche, quando um novo elemento é adicionado, acrescentamos mais capacidade à pilha
    //portanto nesse caso, essa função sempre retorna falso
    public boolean isFull() {
        return false;
    }

    //método para remover as posições vazias da pilha
    //ex: no caso de uma pilha com capacidade 9, mas com tamanho 6 (6 elementos)
    //ao chamar o método trimToSize as 3 posições finais são removidas da pilha
    //fazendo com que ela fique com uma capacidade equivalente ao tamanho (quantidade de elementos)
    public void trimToSize() {
        //novamente é utilizado o método copyOf da biblioteca Arrays
        //o array de retorno do método copyOf mantém os elementos do array original, alterando apenas o tamanho
        elements = Arrays.copyOf(elements, getSize());
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
