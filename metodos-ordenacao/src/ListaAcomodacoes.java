
import java.util.ArrayList;
import java.util.List;

public class ListaAcomodacoes {

    private static List<Acomodacoes> arrayArquivo = Leitor.lerArquivo();
    private static List<Acomodacoes> arrayAOrdenar = new ArrayList<Acomodacoes>() {
    };

    public static List<Acomodacoes> inserirPorRoomId(int id, List<Acomodacoes> ac) {
        for (Acomodacoes acomodacao : arrayArquivo) {
            if (acomodacao.getRoomId() == id) {
                ac.add(acomodacao);
                return ac;
            }
        }
        return ac;
    }

    public static List<Acomodacoes> inserirPorHostId(int id, List<Acomodacoes> ac) {
        for (Acomodacoes acomodacao : arrayArquivo) {
            if (acomodacao.getHostId() == id) {
                ac.add(acomodacao);
                return ac;
            }
        }
        return ac;
    }

    public static List<Acomodacoes> inserirPorHostIdERoomId(int Hostid,int Roomid, List<Acomodacoes> ac) {
        for (Acomodacoes acomodacao : arrayArquivo) {
            if (acomodacao.getHostId() == Hostid&&acomodacao.getRoomId()==Roomid) {
                ac.add(acomodacao);
                return ac;
            }
        }
        return ac;
    }


    

    public static List<Acomodacoes> getArrayArquivo() {
        return arrayArquivo;
    }

    public static void setArrayArquivo(List<Acomodacoes> arrayArquivo) {
        ListaAcomodacoes.arrayArquivo = arrayArquivo;
    }

    public static List<Acomodacoes> getArrayAOrdenar() {
        return arrayAOrdenar;
    }

    public static void setArrayAOrdenar(List<Acomodacoes> arrayIn) {
        arrayAOrdenar = arrayIn;
    }

    public void addToArrayAOrdenar(Acomodacoes acomodacao) {
        arrayAOrdenar.add(acomodacao);
    }
}
