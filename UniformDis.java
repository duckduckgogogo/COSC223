import java.util.Random;

public class UniformDis {
  private int ram_size;
  private Random gen;
  public UniformDis(int ram){
    ram_size = ram;
    gen = new Random();
  }
  public int[] generateUniform(int l){
    int[] requests= new int[l];
    //filling array from 1 to 1000
    for (int i =0; i< l;i++){
      requests[i] = gen.nextInt(ram_size);

    }
    return requests;
  }


}
