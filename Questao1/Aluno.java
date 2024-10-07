// Aluno

public class Aluno {

    private String nome, status, exibir;

    private double nota1, nota2, nota3, media;


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    public double calcularMedia() {
        media = (nota1 + nota2 + nota3) / 3;
        return media;
    }

    public void verificarAprovacao() {
        if (media >= 7) {
            status = "Aprovado";
        } else if( media >= 4 & media < 7) {
            status = "Final";
        } else {
            status = "Reprovado";
        }
    }

    public void exibirDetalhesAluno() {
        System.out.println("O aluno é: " + nome);
        System.out.println("Sua primeira nota é: " + nota1);
        System.out.println("Sua segunda nota é: " + nota2);
        System.out.println("Sua terceira nota é: " + nota3);
        System.out.println("Sua média final é: " + media);
        System.out.println("Sua situação final é: " + status);
    }


}