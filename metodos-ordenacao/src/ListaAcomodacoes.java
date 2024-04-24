
import java.util.ArrayList;
import java.util.List;

public class ListaAcomodacoes {

    private static List<Acomodacoes> arrayArquivo = Leitor.lerArquivo();
    private static List<Acomodacoes> arrayAOrdenar = new ArrayList<Acomodacoes>() {
    };

    public static void inserirPorRoomId(int id){
        for (Acomodacoes acomodacao : arrayArquivo) {
            if(acomodacao.getRoomId()==id){
                arrayAOrdenar.add(acomodacao);
                break;
            }   
        }
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

    public void addToArrayAOrdenar(Acomodacoes acomodacao){
        arrayAOrdenar.add(acomodacao);
    }
}

