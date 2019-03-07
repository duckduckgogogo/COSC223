import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;
public class BigRun{
  public static void main(String args[]){
    BigRun test = new BigRun();
    try {
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
    ExperimentRandom e = new ExperimentRandom(100);
    double[] hitRatesU = e.runUniform();
    File file = new File("uniform_random.csv");
    PrintWriter p = new PrintWriter(file);
    for (double d: hitRatesU){
      System.out.println(d);
      p.println(d);
    }
    p.close();

    double[] hitRatesZ = e.runZipf();
    file = new File("zipf_random.csv");
    p = new PrintWriter(file);
    for (double d: hitRatesZ){
      System.out.println(d);
      p.println(d);
    }
    p.close();
  }

  public void FIFO() throws IOException{
    ExperimentFIFO e = new ExperimentFIFO(100);
    double[] hitRatesU = e.runUniform();
    File file = new File("uniform_FIFO.csv");
    PrintWriter p = new PrintWriter(file);
    for (double d: hitRatesU){
      System.out.println(d);
      p.println(d);
    }
    p.close();

    double[] hitRatesZ = e.runZipf();
    file = new File("zipf_FIFO.csv");
    p = new PrintWriter(file);
    for (double d: hitRatesZ){
      System.out.println(d);
      p.println(d);
    }
    p.close();
  }

  public void LRU() throws IOException{
    ExperimentLRU e = new ExperimentLRU(100);
    double[] hitRatesU = e.runUniform();
    File file = new File("uniform_LRU.csv");
    PrintWriter p = new PrintWriter(file);
    for (double d: hitRatesU){
      System.out.println(d);
      p.println(d);
    }
    p.close();

    double[] hitRatesZ = e.runZipf();
    file = new File("zipf_LRU.csv");
    p = new PrintWriter(file);
    for (double d: hitRatesZ){
      System.out.println(d);
      p.println(d);
    }
    p.close();
  }

  public void LFU() throws IOException{
    ExperimentLFU e = new ExperimentLFU(100);
    double[] hitRatesU = e.runUniform();
    File file = new File("uniform_LFU.csv");
    PrintWriter p = new PrintWriter(file);
    for (double d: hitRatesU){
      System.out.println(d);
      p.println(d);
    }
    p.close();

    double[] hitRatesZ = e.runZipf();
    file = new File("zipf_LFU.csv");
    p = new PrintWriter(file);
    for (double d: hitRatesZ){
      System.out.println(d);
      p.println(d);
    }
    p.close();
  }
}
