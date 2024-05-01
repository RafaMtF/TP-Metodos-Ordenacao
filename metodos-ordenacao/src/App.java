import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        long tempoInicial = System.currentTimeMillis();

        Scanner scan = new Scanner(System.in);

        String size = scan.nextLine();

        List<Acomodacoes> listResposta = new ArrayList<>();

        for (int i = 0; i < Integer.valueOf(size); i++) {
            String s = scan.nextLine();
            listResposta = ListaAcomodacoes.inserirPorRoomId(Integer.valueOf(s), listResposta);
            if (s.equals("FIM") || s.isEmpty()) {
                break;
            }
        }

        scan.close();

        listResposta = Ordenador.merge(listResposta);

        for (Acomodacoes acomocadao : listResposta) {
            acomocadao.imprimir();
        }

        Logger.setTempoDeExecussao(System.currentTimeMillis()-tempoInicial);

        Logger.escreverLog();
        
    }
}
