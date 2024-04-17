import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Leitor {

    public static ArrayList lerArquivo() throws FileNotFoundException {
        File arq = new File("metodos-ordenacao/src/tmp/dados_airbnb.txt");

        Scanner reader = new Scanner(arq);

        ArrayList<Acomodações> acList = new ArrayList<>();

        reader.nextLine();

        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            Acomodações ac = quebrarLinha(data);

            acList.add(ac);
        }

        reader.close();

        return acList;
    }

    private static Acomodações quebrarLinha(String s) {
        String[] sp = s.split("\\t");

        Acomodações ac = new Acomodações(Integer.valueOf(sp[0]), Integer.valueOf(sp[1]), sp[2], sp[3], sp[4], sp[5],
                Integer.valueOf(sp[6]), Double.valueOf(sp[7]), Integer.valueOf(sp[8]), Double.valueOf(sp[9]),
                Double.valueOf(sp[10]), sp[11]);

        //ac.imprimir();

        return ac;
    }

}
