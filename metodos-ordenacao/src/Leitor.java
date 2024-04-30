import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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

        return new Acomodacoes(Integer.valueOf(sp[0]), Integer.valueOf(sp[1]), sp[2], sp[3], sp[4],
                sp[5],
                Integer.valueOf(sp[6]), Double.valueOf(sp[7]), Integer.valueOf(sp[8]), Double.valueOf(sp[9]),
                Double.valueOf(sp[10]), sp[11]);
    }

}
