
import java.util.Arrays;
import java.util.List;

public class Ordenador {

    
    public static List<Acomodacoes> bolha(List<Acomodacoes> ac) {
        
        Acomodacoes[] ac2 = ac.toArray(new Acomodacoes[ac.size()]);
        
        for (int i = (ac.size() - 1); i > 0; i--) {
            
            //System.out.println(ac.size()-i+"/"+ac.size());
            
            for (int j = 0; j < i; j++) {
                if (ac2[j].getOverallSatisfaction() > ac2[j+1].getOverallSatisfaction()) {
                    
                    Acomodacoes temp = ac2[j];
                    ac2[j] = ac2[j+1];
                    ac2[j+1] = temp;
                }
                else if(ac2[j].getOverallSatisfaction() == ac2[j+1].getOverallSatisfaction()){
                    
                    if(ac2[j].getRoomId() > ac2[j+1].getRoomId()){
                        Acomodacoes temp = ac2[j];
                        ac2[j] = ac2[j+1];
                        ac2[j+1] = temp;
                    }
                    
                    
                }
            }
        }
        
        return Arrays.asList(ac2);
    }
    
    private Ordenador(){
        //O sonarlint insistiu 
    }
}
