import java.util.ArrayList;
import java.util.List;

public class Tentativa {
    private ArrayList<String> chute;
    private int pinosBrancos;
    private int pinosPretos;

    public Tentativa(List<String> chute) {
        this.chute = new ArrayList<>();
        this.pinosBrancos = 0;
        this.pinosPretos = 0;

        this.chute.addAll(chute);
    }

    public boolean verificaChute(ArrayList<String> resposta) {
        for(int i=0;i<resposta.size();i++) {
            if (resposta.get(i).equals(chute.get(i))) {
                this.pinosPretos++;
            } else if (resposta.contains(chute.get(i))) {
                this.pinosBrancos++;
            }
        }

        return this.pinosPretos>=4;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        for(String c : chute) {
            String codCor = retornaCodCor(c);
            s.append("@|").append(codCor).append(" O ").append("|@ ");
        }

        s.append("@|black o |@".repeat(pinosPretos));
        s.append("@|white o |@".repeat(pinosBrancos));

        return s.toString();
    }

    private String retornaCodCor(String cor) {
        switch (cor) {
            case "Vermelho": return "red";
            case "Azul": return "cyan";
            case "Verde": return "green";
            case "Amarelo": return "yellow";
            case "Rosa": return "magenta";
            case "Roxo": return "blue";
        }
        return null;
    }
}
