import org.fusesource.jansi.AnsiConsole;

import java.util.*;

import static org.fusesource.jansi.Ansi.*;

public class Main {

    private ArrayList<String> resposta = new ArrayList<>();
    List<String> cores = Arrays.asList("Azul", "Verde", "Vermelho", "Amarelo", "Rosa", "Roxo");
    private static Main main;
    private ArrayList<Tentativa> tentativas;
    public static void main(String[] args) {

        Main.novoJogo().jogar();
    }

    public void jogar() {
        AnsiConsole.systemInstall();
        this.tentativas = new ArrayList<>();

        do {
            main.gerarResposta();

            int nTentativas = 10;
            int nTentativaAtual = 1;
            boolean acertou = false;

            while (!acertou && nTentativaAtual <= nTentativas) {
                System.out.println("Você está na sua tentiva de número " + nTentativaAtual + ". Você tem mais " + (nTentativas - nTentativaAtual) + " tentativas.");
                Tentativa tentativaAtual = main.novaTentativa();
                acertou = tentativaAtual.verificaChute(resposta);
                tentativas.add(tentativaAtual);
                System.out.println(ansi().eraseScreen());
                tentativas.forEach(t -> {
                    //System.out.println(t);
                    System.out.println(ansi().render(t.toString()));
                });
                if (acertou) {
                    System.out.println("Parabéns.");
                } else {
                    System.out.println("Deu ruim. Tente novamente");
                }
                nTentativaAtual++;
            }

            if (acertou) System.out.println("Parabêns.");
            else System.out.println("Deu ruim.");
            main.mostrarResposta();

            System.out.println("Deseja jogar mais uma vez? (S) Sim - (N) Não");
        } while (!new Scanner(System.in).next().equals("S"));
    }

    public static Main novoJogo() {
        if (main == null) {
            main = new Main();
        }

        return main;
    }

    public void gerarResposta() {
        resposta.clear();
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

    private Tentativa novaTentativa() {
        List<String> chute = new ArrayList<>();
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

        return new Tentativa(chute);

    }
}
