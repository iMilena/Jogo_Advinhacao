/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jogoadivinhacao;

/**
 *
 * @author casal
 */
import java.util.*;

public class JogoAdivinhacao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numeroSecreto = random.nextInt(100) + 1;
        int tentativas = 0;
        int pontuacao = 100;

        System.out.println("Bem-vindo ao jogo Adivinhe o Número!");
        System.out.println("Tente adivinhar o número de 1 a 100.");

        Queue<Integer> filaTentativas = new LinkedList<>();

        while (true) {
            System.out.print("Digite um número: ");
            int palpite = scanner.nextInt();

            filaTentativas.add(palpite);
            tentativas++;
            pontuacao--;

            if (palpite < numeroSecreto) {
                System.out.println("O número secreto é maior!");
            } else if (palpite > numeroSecreto) {
                System.out.println("O número secreto é menor!");
            } else {
                System.out.println("Parabéns! Você acertou o número secreto em " + tentativas + " tentativas.");
                System.out.println("Pontuação: " + pontuacao);
                break;
            }

            if (tentativas == 10) {
                System.out.println("Suas tentativas acabaram. O número secreto era " + numeroSecreto + ".");
                System.out.println("Pontuação: " + pontuacao);
                break;
            }
        }

        System.out.println("Histórico de tentativas:");

        while (!filaTentativas.isEmpty()) {
            System.out.println(filaTentativas.poll());
        }
    }
}

