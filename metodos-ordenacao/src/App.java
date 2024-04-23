import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        
        List<Acomodações> ac2 = Ordenador.bolha(ListaAcomodacoes.getArrayArquivo());

        for (Acomodações acomocadao : ac2) {
                System.out.println(acomocadao.getHostId());
        }



    }
}
