import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Merge {


    public class Logger {
    
        private static String logName = "823413_mergesort.txt";
        private static String matricula = "823413";
        private static long tempoDeExecussao;
        private static int comparacoesRealizadas;
        private static int movimentacoesEntreElementos;
        
        public static void escreverLog(){
            try{
            BufferedWriter escritor = new BufferedWriter(new FileWriter(logName));
    
            escritor.append(matricula);
            escritor.append("\t");
            escritor.append(String.valueOf(tempoDeExecussao));
            escritor.append("\t");
            escritor.append(String.valueOf(comparacoesRealizadas));
            escritor.append("\t");
            escritor.append(String.valueOf(movimentacoesEntreElementos));
            
            escritor.close();
    
        }catch(Exception e){
                System.out.println(e);
            }
        }
    
        public static void incrementarComparacoesRealizadas(){
            comparacoesRealizadas++;
        }
    
        public static void incrementarMovimentacoesEntreElementos(){
            movimentacoesEntreElementos++;
        }
    
        public static void setTempoDeExecussao(long t){
            tempoDeExecussao = t;
        }
    
    }
    



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
                if (a1[i].getHostId() < a2[j].getHostId()||(a1[i].getHostId() == a2[j].getHostId()&&a1[i].getRoomId() <= a2[j].getRoomId()))
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

    }

    public static void main(String[] args) throws Exception {

        long tempoInicial = System.currentTimeMillis();

        Scanner scan = new Scanner(System.in);

        String size = scan.nextLine();

        List<Acomodacoes> listResposta = new ArrayList<>();

        for (int i = 0; i < Integer.valueOf(size); i++) {
            String s = scan.nextLine();
            listResposta = ListaAcomodacoes.inserirPorRoomId(Integer.valueOf(s), listResposta);
            if (s.equals("FIM") || s.isEmpty()) {
                break;
            }
        }

        scan.close();

        listResposta = Ordenador.merge(listResposta);

        for (Acomodacoes acomocadao : listResposta) {
            acomocadao.imprimir();
        }

        Logger.setTempoDeExecussao(System.currentTimeMillis()-tempoInicial);

        Logger.escreverLog();
    }
}
