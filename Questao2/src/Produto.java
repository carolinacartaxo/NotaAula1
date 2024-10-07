public class Produto {
    private String nome, cor;
    private int codigo, quantidadeEstoque;
    private double peso, valor;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    // Exibir detalhes do Produto
    public void exibirDetalhesProduto() {
        System.out.println("=== Detalhes do produto ===");
        System.out.println("Código: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Tamanho: " + peso);
        System.out.println("Cor: " + cor);
        System.out.println("Valor: " + valor);
        System.out.println("Quantidade em estoque: " + quantidadeEstoque);
    }

    // Verificar se tem estoque suficiente do produto
    public boolean verificarEstoque(int quantidade) {
        if (quantidade > quantidadeEstoque) {
            System.out.println("Estoque insuficiente. A quantidade do produto em estoque é: " + quantidadeEstoque);
            return false;
        }
        return true;
    }

    // Verificar se o pagamento foi suficiente e, caso pago em dinheiro, calcular o troco
    public boolean calcularTroco(double valorPago, double valorFinal) {
        if (valorPago > valorFinal) {
            double troco = valorPago - valorFinal;
            System.out.println("Troco: R$ " + troco);
            System.out.println("Pagamento realizado com sucesso!");
            return true;
        } else if (valorPago == valorFinal) {
            System.out.println("Pagamento realizado com sucesso!");
            return true;
        } else {
            System.out.println("Valor insuficiente para a compra");
            return false;
        }
    }

    // Atualizar o estoque caso o pagamento seja bem-sucedido
    public void atualizarEstoque(int quantidade) {
        quantidadeEstoque -= quantidade;
        System.out.println("Estoque atualizado! Quantidade restante: " + quantidadeEstoque);
    }
}