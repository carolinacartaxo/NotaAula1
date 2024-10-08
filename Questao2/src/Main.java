import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int selecionar = 1;
        String repetir = "r";
        Scanner sc = new Scanner(System.in);
        Produto p = new Produto();

        do {
            System.out.println("== Sistema do Supermercado ==");
            System.out.println("Digite 1 para cadastrar um produto");
            System.out.println("Digite 2 para realizar a venda do produto");
            System.out.println("Digite 3 para ver o estoque");
            System.out.println("Digite 4 para sair");
            selecionar = sc.nextInt();

            switch (selecionar) {
                case 1:
                    System.out.println("Digite o código do produto: ");
                    p.setCodigo(sc.nextInt());

                    System.out.println("Digite o nome do produto: ");
                    p.setNome(sc.next());

                    System.out.println("Digite o peso do produto: ");
                    p.setPeso(sc.nextDouble());

                    System.out.println("Digite a cor do produto: ");
                    p.setCor(sc.next());

                    System.out.println("Digite o valor do produto: ");
                    p.setValor(sc.nextDouble());

                    System.out.println("Digite quantos produtos desse tem em estoque: ");
                    p.setQuantidadeEstoque(sc.nextInt());

                    System.out.println("Produto cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println("Quantos produtos você quer comprar? ");
                    int quantidade = sc.nextInt();

                    if (p.verificarEstoque(quantidade)) {
                        System.out.println("Digite o dígito referente à forma de pagamento escolhida: ");
                        System.out.println("1 - Pix | 2 - Espécie | 3 - Transferência | 4 - Débito | 5 - Crédito ");
                        int formaPagamento = sc.nextInt();

                        double valorFinal = p.getValor() * quantidade;

                        if (formaPagamento >= 1 && formaPagamento <= 4) {
                            valorFinal *= 0.95;
                            System.out.println("Valor com desconto: R$ " + valorFinal);
                        }

                        // Pagamento em espécie, cálculo de troco
                        if (formaPagamento == 2) {
                            System.out.println("Digite o valor pago: ");
                            double valorPago = sc.nextDouble();

                            p.calcularTroco(valorPago, valorFinal);

                            if (valorPago >= valorFinal) {
                                p.atualizarEstoque(quantidade);
                                System.out.println("Pagamento realizado com sucesso!");
                            }
                        } else if (formaPagamento == 5) { 
                            System.out.println("Deseja parcelar em 1, 2 ou 3 vezes?");
                            int parcelas = sc.nextInt();

                            if (parcelas >= 1 && parcelas <= 3) {
                                double valorParcela = valorFinal / parcelas;
                                System.out.println("Valor total: R$" + valorFinal + " em " + parcelas + "x de R$: " + valorParcela);
                                p.atualizarEstoque(quantidade);
                                System.out.println("Pagamento realizado com sucesso!");
                            } else {
                                System.out.println("O número de parcelas digitado é inválido");
                            }
                        } else {
                            p.atualizarEstoque(quantidade);
                            System.out.println("Pagamento realizado com sucesso!");
                        }
                    }
                    break;

                case 3:
                    p.exibirDetalhesProduto();
                    break;

                case 4:
                    System.out.println("Saindo do sistema");
                    repetir = "n";
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }

            System.out.println("Para repetir digite 'r'");
            repetir = sc.next();

        } while (repetir.equalsIgnoreCase("R"));
    }
}
