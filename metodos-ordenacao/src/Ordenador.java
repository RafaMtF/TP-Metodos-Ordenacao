
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ordenador {

    public static List<Acomodações> bolha(ArrayList<Acomodações> ac) {

        Acomodações[] ac2 = ac.toArray(new Acomodações[ac.size()]);

        for (int i = (ac.size() - 1); i > 0; i--) {

            System.out.println(ac.size()-i+"/"+ac.size());

            for (int j = 0; j < i; j++) {
                if (ac2[j].getOverallSatisfaction() > ac2[j+1].getOverallSatisfaction()) {

                    Acomodações temp = ac2[j];
                    ac2[j] = ac2[j+1];
                    ac2[j+1] = temp;
                }
                else if(ac2[j].getOverallSatisfaction() == ac2[j+1].getOverallSatisfaction()){

                    if(ac2[j].getRoomId() > ac2[j+1].getRoomId()){
                        Acomodações temp = ac2[j];
                        ac2[j] = ac2[j+1];
                        ac2[j+1] = temp;
                    }


                }
            }
        }

        return Arrays.asList(ac2);
    }

}
