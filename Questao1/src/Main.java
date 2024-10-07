import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Aluno a = new Aluno();

        System.out.println("Digite o nome do aluno: ");
        a.setNome(sc.next());

        System.out.println("Digite a primeira nota: ");
        a.setNota1(sc.nextDouble());

        System.out.println("Digite a segunda nota: ");
        a.setNota2(sc.nextDouble());

        System.out.println("Digite a terceira nota: ");
        a.setNota3(sc.nextDouble());

        a.calcularMedia();
        a.verificarAprovacao();
        a.exibirDetalhesAluno();

    }
}