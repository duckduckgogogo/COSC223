import java.util.Random;
public class ZipfD{
  private int ram_size;
  private Random gen;

  public ZipfD(int ram){
    ram_size = ram;
    gen = new Random();
  }

  public int[] generateZipf(int l){
    int[] requests = new int[l];
    //calculating the denominator for probabilites
    double sum = calcSum();
    System.out.println("done with sum" + sum);

    //calculating probabilities * l and length of master list
    //this is to help fill the array toPickFrom
    int[] probs = new int[ram_size];
    int array_length = 0;
    for (int i = 1; i<=ram_size;i++){
      double numorator = 1.0/i;
      int numToEnter = (int)((numorator/sum) * l);
      probs[i-1] = numToEnter;
      array_length += numToEnter;
    }
    
    //creating master list of indexes to pick from for distribution
    int[] toPickFrom = createToPickFrom(array_length, probs);

    //shuffle
    toPickFrom = shuffle(toPickFrom);

    //fill requests
    for(int i =0; i < l; i++){
      int index = gen.nextInt(array_length);
      requests[i] = toPickFrom[index];
    }
    return requests;

  }

  public double calcSum(){
    double sum = 0;
    for (int i =1; i<= ram_size; i++){
        sum += 1.0/i;
    }
    return sum;

  }

  public int[] createToPickFrom(int array_length, int[] probs){
    int[] toPickFrom = new int[array_length];
    int start = 0;
    for (int i =0; i<ram_size;i++){
        for(int j = 0; j<probs[i]; j++){
          toPickFrom[start+j] = i + 1;
        }
        start += probs[i];
    }

    return toPickFrom;

  }

  public int[] shuffle(int[] toPickFrom){
    int array_length = toPickFrom.length;
    for(int i =0; i < array_length; i++){
      int toSwap = toPickFrom[i];
      int index = gen.nextInt(array_length);
      toPickFrom[i] = toPickFrom[index];
      toPickFrom[index] = toSwap;
    }
    return toPickFrom;
  }

}
