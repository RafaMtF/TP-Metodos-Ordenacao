import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Bolha {


public class Logger {

    private static String logName = "823413_bolha.txt";
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

    }

    public class ListaAcomodacoes {

        private static List<Acomodacoes> arrayArquivo = Leitor.lerArquivo();
        private static List<Acomodacoes> arrayAOrdenar = new ArrayList<Acomodacoes>() {
        };

        public static void inserirPorRoomId(int id) {
            for (Acomodacoes acomodacao : arrayArquivo) {
                if (acomodacao.getRoomId() == id) {
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

        public void addToArrayAOrdenar(Acomodacoes acomodacao) {
            arrayAOrdenar.add(acomodacao);
        }
    }

    class Leitor {

        public static List<Acomodacoes> lerArquivo() {
            File arq = new File("/tmp/dados_airbnb.txt");

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

            Bolha bolha = new Bolha();

            Acomodacoes ac = bolha.new Acomodacoes(Integer.valueOf(sp[0]), Integer.valueOf(sp[1]), sp[2], sp[3], sp[4], sp[5],
                    Integer.valueOf(sp[6]), Double.valueOf(sp[7]), Integer.valueOf(sp[8]), Double.valueOf(sp[9]),
                    Double.valueOf(sp[10]), sp[11]);

            // ac.imprimir();

            return ac;
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

        public Acomodacoes() {
            this.roomId = 0;
            this.hostId = 0;
            this.reviews = 0;
            this.accommodates = 0;
            this.roomType = "roomType";
            this.country = "country";
            this.city = "city";
            this.neighbourhood = "neighbourhood";
            this.propertyType = "propertyType";
            this.overallSatisfaction = 0;
            this.bedrooms = 0;
            this.price = 0;
        }

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

    public static void main(String[] args) throws Exception {

        long tempoInicial = System.currentTimeMillis();

        Scanner scan = new Scanner(System.in);

        String size = scan.nextLine();

        for (int i = 0; i < Integer.valueOf(size); i++) {
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

        Logger.setTempoDeExecussao(System.currentTimeMillis()-tempoInicial);

        Logger.escreverLog();
    }
}
