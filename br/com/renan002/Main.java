package br.com.renan002;

import java.io.IOException;
import java.util.*;


public class Main {

    private List<String> resposta;
    List<String> cores = Arrays.asList("Azul", "Verde", "Vermelho", "Amarelo", "Preto", "Branco");
    private List<String> chute = new ArrayList<>();;
    public static void main(String[] args) {
        Main main = new Main();
        main.gerarResposta();
        main.mostrarResposta();

        int tentativas = 10;
        int tentativaAtual = 1;
        boolean acertou = false;

        while (!acertou && tentativaAtual<=tentativas) {
            System.out.println("Você está na sua tentiva de número "+tentativaAtual+". Você tem mais "+(tentativas-tentativaAtual));
            main.tentativa();
            acertou = main.verificarChute();
            tentativaAtual++;
        }

        if (acertou) System.out.println("Parabêns.");
        else System.out.println("Deu ruim.");
    }

    private void gerarResposta() {
        resposta = new ArrayList<>();
        while(resposta.size() < 4) {
            int index = new Random().ints(0,6).findFirst().getAsInt();
            String cor = cores.get(index);
            if (!resposta.contains(cor))
                resposta.add(cores.get(index));
        }
    }

    private void mostrarResposta() {
        System.out.println("INDEX  -  VALOR");
        for(int i = 0;i<resposta.size();i++){
            System.out.println(i+1 + "      - "+resposta.get(i));
        }
    }

    private void tentativa() {
        chute.clear();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o primeiro pino");
        String inputTest1 = scanner.nextLine();
        System.out.println("Digite o segundo pino");
        String inputTest2 = scanner.nextLine();
        System.out.println("Digite o terceiro pino");
        String inputTest3 = scanner.nextLine();
        System.out.println("Digite o quarto pino");
        String inputTest4 = scanner.nextLine();

        chute.add(inputTest1);
        chute.add(inputTest2);
        chute.add(inputTest3);
        chute.add(inputTest4);

    }

    private boolean verificarChute(){
        for(int i=0;i<resposta.size();i++) {
            if (!resposta.get(i).equals(chute.get(i))) {
                System.out.println("Errou.");
                return false;
            }
        }
        System.out.println("Acertou.");
        return true;
    }
}
