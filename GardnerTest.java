import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;

public class GardnerTest {
  public GardnerTest() {
  }
  public static void main(String args[]){
    GardnerTest test = new GardnerTest();
    try{
      test.random();
      test.FIFO();
      test.LRU();
      test.LFU();
    }
    catch (IOException i) {
      System.out.println("file not found");
    }
  }

  public void random() throws IOException{
    ExperimentRandom e = new ExperimentRandom(100000);
    double[] hitRatesU = e.runGardner();
    File file = new File("gardner_random.csv");
    PrintWriter p = new PrintWriter(file);
    for (double d: hitRatesU){
      System.out.println(d);
      p.println(d);
    }
    p.close();
  }

  public void FIFO() throws IOException{
    ExperimentFIFO e = new ExperimentFIFO(100000);
    double[] hitRatesU = e.runGardner();
    File file = new File("gardner_FIFO.csv");
    PrintWriter p = new PrintWriter(file);
    for (double d: hitRatesU){
      System.out.println(d);
      p.println(d);
    }
    p.close();
  }

  public void LRU() throws IOException{
    ExperimentLRU e = new ExperimentLRU(100000);
    double[] hitRatesU = e.runGardner();
    File file = new File("gardner_LRU.csv");
    PrintWriter p = new PrintWriter(file);
    for (double d: hitRatesU){
      System.out.println(d);
      p.println(d);
    }
    p.close();
  }

  public void LFU() throws IOException{
    ExperimentLFU e = new ExperimentLFU(100000);
    double[] hitRatesU = e.runGardner();
    File file = new File("gardner_LFU.csv");
    PrintWriter p = new PrintWriter(file);
    for (double d: hitRatesU){
      System.out.println(d);
      p.println(d);
    }
    p.close();
  }
}
