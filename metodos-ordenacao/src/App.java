import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner scan = new Scanner(System.in);

        String size = scan.nextLine();

        List<Acomodacoes> ac2 = new ArrayList<>();


        for(int i = 0; i<Integer.valueOf(size);i++){
            String s = scan.nextLine();
            ac2 = ListaAcomodacoes.inserirPorRoomId(Integer.valueOf(s), ac2);
            if (s.equals("FIM") || s.isEmpty()) {
                break;
            }
        }

        scan.close();
   
        ac2 = Ordenador.merge(ac2);

        for (Acomodacoes acomocadao : ac2) {
                acomocadao.imprimir();
                //System.out.println(acomocadao.getOverallSatisfaction());
        }
    }
}
