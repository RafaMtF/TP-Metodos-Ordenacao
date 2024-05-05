import java.util.Arrays;
import java.util.List;

public class Ordenador {

    public static List<Acomodacoes> bolha(List<Acomodacoes> ac) {

        Acomodacoes[] ac2 = ac.toArray(new Acomodacoes[ac.size()]);

        for (int i = (ac.size() - 1); i > 0; i--) {

            for (int j = 0; j < i; j++) {
                if (ac2[j].getOverallSatisfaction() > ac2[j + 1].getOverallSatisfaction()) {
                    Logger.incrementarComparacoesRealizadas();

                    Acomodacoes temp = ac2[j];
                    ac2[j] = ac2[j + 1];
                    Logger.incrementarMovimentacoesEntreElementos();
                    ac2[j + 1] = temp;

                } else if (ac2[j].getOverallSatisfaction() == ac2[j + 1].getOverallSatisfaction()) {
                    Logger.incrementarComparacoesRealizadas();

                    if (ac2[j].getRoomId() > ac2[j + 1].getRoomId()) {
                        Logger.incrementarComparacoesRealizadas();
                        Acomodacoes temp = ac2[j];
                        ac2[j] = ac2[j + 1];
                        Logger.incrementarMovimentacoesEntreElementos();
                        ac2[j + 1] = temp;
                    }

                }
            }
        }

        return Arrays.asList(ac2);
    }

    public static List<Acomodacoes> merge(List<Acomodacoes> ac) {

        Acomodacoes[] ac2 = ac.toArray(new Acomodacoes[ac.size()]);

        mergesort(ac2, 0, ac2.length - 1);

        return Arrays.asList(ac2);

    }

    private static void mergesort(Acomodacoes[] array, int esq, int dir) {
        if (esq < dir) {
            int meio = (esq + dir) / 2;
            mergesort(array, esq, meio);
            mergesort(array, meio + 1, dir);
            intercalar(array, esq, meio, dir);
        }
    }

    private static void intercalar(Acomodacoes[] array, int esq, int meio, int dir) {

        int n1, n2, i, j, k;

        n1 = meio - esq + 1;
        n2 = dir - meio;

        Acomodacoes[] a1 = new Acomodacoes[n1];
        Acomodacoes[] a2 = new Acomodacoes[n2];

        for (i = 0; i < n1; i++) {
            a1[i] = array[esq + i];
        }

        for (j = 0; j < n2; j++) {
            a2[j] = array[meio + j + 1];
        }

        for (i = j = 0, k = esq; (i < n1 && j < n2); k++) {
            if (a1[i].getHostId() < a2[j].getHostId()
                    || (a1[i].getHostId() == a2[j].getHostId() && a1[i].getRoomId() <= a2[j].getRoomId())) {
                Logger.incrementarComparacoesRealizadas();
                array[k] = a1[i++];
                Logger.incrementarMovimentacoesEntreElementos();
            } else {
                array[k] = a2[j++];
                Logger.incrementarMovimentacoesEntreElementos();
            }
        }

        if (i == n1)
            for (; k <= dir; k++) {
                array[k] = a2[j++];
                Logger.incrementarMovimentacoesEntreElementos();
            }
        else
            for (; k <= dir; k++) {
                array[k] = a1[i++];
                Logger.incrementarMovimentacoesEntreElementos();
            }
    }

    public static List<Acomodacoes> heap(List<Acomodacoes> ac) {

        Acomodacoes[] ac2 = ac.toArray(new Acomodacoes[ac.size()]);

        heapsort(ac2);

        return Arrays.asList(ac2);

    }

    static void heapsort(Acomodacoes[] array) {
        Acomodacoes[] tmp = new Acomodacoes[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            tmp[i + 1] = array[i];
        }

        for (int tamHeap = (tmp.length - 1) / 2; tamHeap >= 1; tamHeap--) {
            restaura(tmp, tamHeap, tmp.length - 1);
        }

        int tamHeap = tmp.length - 1;
        troca(tmp, 1, tamHeap--);
        while (tamHeap > 1) {
            restaura(tmp, 1, tamHeap);
            troca(tmp, 1, tamHeap--);
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = tmp[i + 1];
        }
    }

    static void restaura(Acomodacoes[] array, int i, int tamHeap) {
        int maior = i;
        int filho = getMaiorFilho(array, i, tamHeap);

        if (array[i].getReviews() < array[filho].getReviews()) {
            maior = filho;
            Logger.incrementarComparacoesRealizadas();
        } else if (array[i].getReviews() == array[filho].getReviews()) {
            Logger.incrementarComparacoesRealizadas();
            if (array[i].getRoomId() < array[filho].getRoomId()) {
                Logger.incrementarComparacoesRealizadas();
                maior = filho;
            }
        }

        if (maior != i) {
            troca(array, i, maior);
            if (maior <= tamHeap / 2) {
                restaura(array, maior, tamHeap);
            }
        }
    }

    static int getMaiorFilho(Acomodacoes[] array, int i, int tamHeap) {
        int filho;
        if (2 * i == tamHeap || array[2 * i].getReviews() > array[2 * i + 1].getReviews()
                || (array[2 * i].getReviews() == array[2 * i + 1].getReviews()
                        && array[2 * i].getRoomId() > array[2 * i + 1].getRoomId())) {
            Logger.incrementarComparacoesRealizadas();
            Logger.incrementarComparacoesRealizadas();
            filho = 2 * i;
        } else {
            filho = 2 * i + 1;
        }
        return filho;
    }

    static void troca(Acomodacoes[] array, int i, int j) {
        Acomodacoes temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        Logger.incrementarMovimentacoesEntreElementos();
    }

    static void quicksort(Acomodacoes[] acomodocoes, int beg, int end) {
        int part;
        if (beg < end) {
            part = partition(acomodocoes, beg, end);
            quicksort(acomodocoes, beg, part - 1);
            quicksort(acomodocoes, part + 1, end);
        }
    }

    static int partition(Acomodacoes[] acomodocoes, int beg, int end) {
        Acomodacoes pivot = acomodocoes[end];
        int part = beg - 1;
        for (int i = beg; i < end; i++) {
            if (acomodocoes[i].getPrice() < pivot.getPrice() ||
                    (acomodocoes[i].getPrice() == pivot.getPrice() &&
                            (acomodocoes[i].getRoomType().compareTo(pivot.getRoomType()) < 0 ||
                                    (acomodocoes[i].getRoomType().equals(pivot.getRoomType()) &&
                                            acomodocoes[i].getRoomId() < pivot.getRoomId())))) {
                part++;
                swap(acomodocoes, part, i);
            }
        }
        part++;
        swap(acomodocoes, part, end);
        return part;
    }

    static void selectionSort(Acomodacoes[] acomodacoes) {
        int n = acomodacoes.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (compareAcomodacoesSel(acomodacoes[j], acomodacoes[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(acomodacoes, i, minIndex);
            }
        }
    }

    static int compareAcomodacoesSel(Acomodacoes a1, Acomodacoes a2) {
        if (!a1.getCountry().equals(a2.getCountry())) {
            return a1.getCountry().compareTo(a2.getCountry());
        } else if (!a1.getCity().equals(a2.getCity())) {
            return a1.getCity().compareTo(a2.getCity());
        } else if (!a1.getNeighbourhood().equals(a2.getNeighbourhood())) {
            return a1.getNeighbourhood().compareTo(a2.getNeighbourhood());
        } else {
            return Integer.compare(a1.getRoomId(), a2.getRoomId());
        }
    }

    static void swap(Acomodacoes[] array, int i, int j) {
        Acomodacoes temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    static void insertionSort(Acomodacoes[] acomodacoes) {
        int n = acomodacoes.length;
        for (int i = 1; i < n; ++i) {
            Acomodacoes key = acomodacoes[i];
            int j = i - 1;
    
            while (j >= 0 && compareAcomodacoesInsert(acomodacoes[j], key) > 0) {
                acomodacoes[j + 1] = acomodacoes[j];
                j = j - 1;
            }
            acomodacoes[j + 1] = key;
        }
    }
    
    static int compareAcomodacoesInsert(Acomodacoes a1, Acomodacoes a2) {
        if (a1.getAccommodates() != a2.getAccommodates()) {
            return Integer.compare(a1.getAccommodates(), a2.getAccommodates());
        } else {
            return Integer.compare(a1.getRoomId(), a2.getRoomId());
        }
    }

}
