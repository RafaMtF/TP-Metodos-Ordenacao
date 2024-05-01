import java.io.BufferedWriter;
import java.io.FileWriter;

public class Logger {

    private static String logName = "PLACEHOLDER LOGNAME";
    private static String matricula = "PLACEHOLDER MATRICULA";
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
