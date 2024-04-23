import java.util.ArrayList;

public class ListaAcomodacoes {

    private static ArrayList<Acomodações> arrayArquivo = Leitor.lerArquivo();
    private ArrayList<Acomodações> array;

    public void inserirPorRoomId(int id){
        for (Acomodações acomodacao : arrayArquivo) {
            if(acomodacao.getRoomId()==id){
                this.array.add(acomodacao);
                break;
            }   
        }
    }

    public static ArrayList<Acomodações> getArrayArquivo() {
        return arrayArquivo;
    }

    public static void setArrayArquivo(ArrayList<Acomodações> arrayArquivo) {
        ListaAcomodacoes.arrayArquivo = arrayArquivo;
    }

    public ArrayList<Acomodações> getArray() {
        return array;
    }

    public void setArray(ArrayList<Acomodações> array) {
        this.array = array;
    }
}

