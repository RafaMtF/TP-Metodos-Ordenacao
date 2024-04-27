
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ordenador {

    public static List<Acomodacoes> bolha(List<Acomodacoes> ac) {

        Acomodacoes[] ac2 = ac.toArray(new Acomodacoes[ac.size()]);

        for (int i = (ac.size() - 1); i > 0; i--) {

            // System.out.println(ac.size()-i+"/"+ac.size());

            for (int j = 0; j < i; j++) {
                if (ac2[j].getOverallSatisfaction() > ac2[j + 1].getOverallSatisfaction()) {

                    Acomodacoes temp = ac2[j];
                    ac2[j] = ac2[j + 1];
                    ac2[j + 1] = temp;
                } else if (ac2[j].getOverallSatisfaction() == ac2[j + 1].getOverallSatisfaction()) {

                    if (ac2[j].getRoomId() > ac2[j + 1].getRoomId()) {
                        Acomodacoes temp = ac2[j];
                        ac2[j] = ac2[j + 1];
                        ac2[j + 1] = temp;
                    }

                }
            }
        }

        return Arrays.asList(ac2);
    }

    static int[] addElement(int[] a, int e) {
        a  = Arrays.copyOf(a, a.length + 1);
        a[a.length - 1] = e;
        return a;
    }

    public static List<Acomodacoes> merge(List<Acomodacoes> ac) {

        Acomodacoes[] ac2 = ac.toArray(new Acomodacoes[ac.size()]);

        int[] acHostId = {};
        int[] acRoomId = {};

        for (Acomodacoes acomodacao : ac2) {
            acHostId = addElement(acHostId, acomodacao.getHostId());
            acRoomId = addElement(acRoomId, acomodacao.getRoomId());
        }

        mergesort(acHostId, 0, acHostId.length-1);

        List<Acomodacoes> ac3 = new ArrayList<>();

        for (int i = 0; i<acHostId.length; i++) {
            try{
            if(acHostId[i] == acHostId[i+1]){
                if(acRoomId[i]>=acRoomId[i+1]){
                    ac3=ListaAcomodacoes.inserirPorHostIdERoomId(acHostId[i], acRoomId[i], ac3);
                }else{
                    ac3=ListaAcomodacoes.inserirPorHostIdERoomId(acHostId[i], acRoomId[i+1], ac3);
                }
            }else{
            ac3 = ListaAcomodacoes.inserirPorHostId(acHostId[i], ac3);
            }}
            catch(Exception e){
                ac3 = ListaAcomodacoes.inserirPorHostId(acHostId[i], ac3);
            }
        }

        return ac3;


    }

    private static void mergesort(int[] array, int esq, int dir) {
        if (esq < dir) {
            int meio = (esq + dir) / 2;
            mergesort(array, esq, meio);
            mergesort(array, meio + 1, dir);
            intercalar(array, esq, meio, dir);
        }
    }

    private static void intercalar(int[] array, int esq, int meio, int dir) {

        int n1, n2, i, j, k;

        n1 = meio - esq + 1;
        n2 = dir - meio;

        int[] a1 = new int[n1];
        int[] a2 = new int[n2];

        for (i = 0; i < n1; i++) {
            a1[i] = array[esq + i];
        }

        for (j = 0; j < n2; j++) {
            a2[j] = array[meio + j + 1];
        }

        for (i = j = 0, k = esq; (i < n1 && j < n2); k++) {
            if (a1[i] <= a2[j])
                array[k] = a1[i++];
            else
                array[k] = a2[j++];
        }

        if (i == n1)
            for (; k <= dir; k++) {
                array[k] = a2[j++];
            }
        else
            for (; k <= dir; k++) {
                array[k] = a1[i++];
            }
    }

    private Ordenador() {
        // O sonarlint insistiu
    }
}
