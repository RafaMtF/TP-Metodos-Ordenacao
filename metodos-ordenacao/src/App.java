import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner scan = new Scanner(System.in);

        String size = scan.nextLine();


        for(int i = 0; i<Integer.valueOf(size);i++){
            String s = scan.nextLine();
            ListaAcomodacoes.inserirPorRoomId(Integer.valueOf(s));
            if (s.equals("FIM") || s.isEmpty()) {
                break;
            }
        }

        scan.close();
   
        List<Acomodacoes> ac2 = Ordenador.bolha(ListaAcomodacoes.getArrayAOrdenar());

        for (Acomodacoes acomocadao : ac2) {
                acomocadao.imprimir();
        }
    }
}
