import java.util.List;

public class ListaAcomodacoes {

    private static List<Acomodacoes> arrayArquivo = Leitor.lerArquivo();

    public static List<Acomodacoes> inserirPorRoomId(int id, List<Acomodacoes> ac) {
        for (Acomodacoes acomodacao : arrayArquivo) {
            if (acomodacao.getRoomId() == id) {
                ac.add(acomodacao);
                return ac;
            }
        }
        return ac;
    }

}
