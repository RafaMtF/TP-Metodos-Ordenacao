import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class Merge {

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

        public static List<Acomodacoes> merge(List<Acomodacoes> ac) {

            int[] acHostId = {};

            for (Acomodacoes acomodacao : ac) {
                acHostId = addElement(acHostId, acomodacao.getHostId());
            }

            mergesort(acHostId, 0, acHostId.length - 1);

            List<Acomodacoes> ac2 = new ArrayList<>();

            for (int i = 0; i < acHostId.length; i++) {

                List<Integer> roomIds = ListaAcomodacoes.getHostIdMap().get(acHostId[i]);

                int[] acRoomId = {};

                for (int id : roomIds) {
                    acRoomId = addElement(acRoomId, id);
                }

                mergesort(acRoomId, 0, acRoomId.length - 1); // Do menor pro maior ou contrario?

                for (int id : acRoomId) {
                    if (ac.contains(ListaAcomodacoes.getPorRoomId(id))&&!ac2.contains(ListaAcomodacoes.getPorRoomId(id))) {
                        ac2 = ListaAcomodacoes.inserirPorRoomId(id, ac2);
                    }
                }
            }

            return ac2;

        }

        private static int[] addElement(int[] a, int e) {
            a = Arrays.copyOf(a, a.length + 1);
            a[a.length - 1] = e;
            return a;
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

    public class Acomodacoes {
        private int roomId;
        private int hostId;
        private int reviews;
        private int accommodates;
        private String roomType;
        private String country;
        private String city;
        private String neighbourhood;
        private String propertyType;
        private double overallSatisfaction;
        private double bedrooms;
        private double price;

        public Acomodacoes(int roomId, int hostId, String roomType, String country, String city, String neighbourhood,
                int reviews, double overallSatisfaction, int accommodates,
                double bedrooms, double price, String propertyType) {
            this.roomId = roomId;
            this.hostId = hostId;
            this.reviews = reviews;
            this.accommodates = accommodates;
            this.roomType = roomType;
            this.country = country;
            this.city = city;
            this.neighbourhood = neighbourhood;
            this.propertyType = propertyType;
            this.overallSatisfaction = overallSatisfaction;
            this.bedrooms = bedrooms;
            this.price = price;
        }

        // Segundo construtor??

        public void ler() {

            Scanner scanner = new Scanner(System.in);

            this.roomId = scanner.nextInt();
            this.hostId = scanner.nextInt();
            this.roomType = scanner.nextLine();
            this.country = scanner.nextLine();
            this.city = scanner.nextLine();
            this.neighbourhood = scanner.nextLine();
            this.reviews = scanner.nextInt();
            this.overallSatisfaction = scanner.nextDouble();
            this.accommodates = scanner.nextInt();
            this.bedrooms = scanner.nextDouble();
            this.price = scanner.nextDouble();
            this.propertyType = scanner.nextLine();

            scanner.close();

        }

        public void imprimir() {
            System.out.println("[" + roomId + " ## " + hostId + " ## " + roomType + " ## " + country + " ## " + city
                    + " ## " + neighbourhood + " ## " + reviews + " ## " + overallSatisfaction + " ## " + accommodates
                    + " ## " + bedrooms + " ## " + price + " ## " + propertyType + "]");
        }

        public Acomodacoes clone() {
            return new Acomodacoes(this.roomId, this.hostId, this.roomType, this.country, this.city, this.neighbourhood,
                    this.reviews, this.overallSatisfaction, this.accommodates, this.bedrooms, this.price,
                    this.propertyType);
        }

        public int getRoomId() {
            return roomId;
        }

        public void setRoomId(int roomId) {
            this.roomId = roomId;
        }

        public int getHostId() {
            return hostId;
        }

        public void setHostId(int hostId) {
            this.hostId = hostId;
        }

        public int getReviews() {
            return reviews;
        }

        public void setReviews(int reviews) {
            this.reviews = reviews;
        }

        public int getAccommodates() {
            return accommodates;
        }

        public void setAccommodates(int accommodates) {
            this.accommodates = accommodates;
        }

        public String getRoomType() {
            return roomType;
        }

        public void setRoomType(String roomType) {
            this.roomType = roomType;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getNeighbourhood() {
            return neighbourhood;
        }

        public void setNeighbourhood(String neighbourhood) {
            this.neighbourhood = neighbourhood;
        }

        public String getPropertyType() {
            return propertyType;
        }

        public void setPropertyType(String propertyType) {
            this.propertyType = propertyType;
        }

        public double getOverallSatisfaction() {
            return overallSatisfaction;
        }

        public void setOverallSatisfaction(double overallSatisfaction) {
            this.overallSatisfaction = overallSatisfaction;
        }

        public double getBedrooms() {
            return bedrooms;
        }

        public void setBedrooms(double bedrooms) {
            this.bedrooms = bedrooms;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

    }

    public class ListaAcomodacoes {

        private static Map<Integer, List<Integer>> hostIdMap = new HashMap<>();
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

        public static Acomodacoes getPorRoomId(int id) {
            for (Acomodacoes acomodacao : arrayArquivo) {
                if (acomodacao.getRoomId() == id) {
                   return acomodacao;
                }
            }
            System.out.println("getporroomId nao encontrou");
            return null;
        }

        public static List<Acomodacoes> getArrayArquivo() {
            return arrayArquivo;
        }

        public static void setArrayArquivo(List<Acomodacoes> arrayArquivo) {
            ListaAcomodacoes.arrayArquivo = arrayArquivo;
        }

        public static Map<Integer, List<Integer>> getHostIdMap() {
            return hostIdMap;
        }

        public static void setHostIdMap(Map<Integer, List<Integer>> hostIdMap) {
            ListaAcomodacoes.hostIdMap = hostIdMap;
        }

    }

    class Leitor {

        public static List<Acomodacoes> lerArquivo() {
            File arq = new File("/tmp/dados_airbnb.txt");
            // "/tmp/dados_airbnb.txt"
            // "metodos-ordenacao/src/tmp/dados_airbnb.txt"

            try {
                Scanner reader = new Scanner(arq);

                ArrayList<Acomodacoes> acList = new ArrayList<>();

                reader.nextLine();

                while (reader.hasNextLine()) {
                    String data = reader.nextLine();
                    Acomodacoes ac = quebrarLinha(data);

                    acList.add(ac);

                    if (ListaAcomodacoes.getHostIdMap().containsKey(ac.getHostId())) {
                        ListaAcomodacoes.getHostIdMap().get(ac.getHostId()).add(ac.getRoomId());
                    } else {
                        List<Integer> idArray = new ArrayList<>();
                        idArray.add(ac.roomId);
                        ListaAcomodacoes.getHostIdMap().put(ac.hostId, idArray);
                    }
                }

                reader.close();
                return acList;

            } catch (Exception e) {
                System.out.println(e);
                return new ArrayList<>();
            }

        }

        private static Acomodacoes quebrarLinha(String s) {
            String[] sp = s.split("\\t");

            Merge merge = new Merge();

            Acomodacoes ac = merge.new Acomodacoes(Integer.valueOf(sp[0]), Integer.valueOf(sp[1]), sp[2], sp[3], sp[4],
                    sp[5],
                    Integer.valueOf(sp[6]), Double.valueOf(sp[7]), Integer.valueOf(sp[8]), Double.valueOf(sp[9]),
                    Double.valueOf(sp[10]), sp[11]);

            // ac.imprimir();

            return ac;
        }

        private Leitor() {
            // O sonarlint insistiu tbm
        }

    }

    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);

        String size = scan.nextLine();

        List<Acomodacoes> ac2 = new ArrayList<>();

        for (int i = 0; i < Integer.valueOf(size); i++) {
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
            // System.out.println(acomocadao.getOverallSatisfaction());
        }
    }
}
