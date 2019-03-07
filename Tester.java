public class Tester {

  public static void main (String[] args) {
    int[] myArray = new int[5];
    myArray[0] = 1;
    myArray[1] = 2;
    myArray[2] = 1;
    myArray[3] = 5;
    myArray[4] = 2;

    RandomCache RC = new RandomCache (2, myArray);
    System.out.println("RC rate " + RC.simulation());

    FIFOCache FIFO = new FIFOCache (2, myArray);
    System.out.println("FIFO rate " + FIFO.simulation());

    LRUCache LRU = new LRUCache (2, myArray);
    System.out.println("LRU rate " + LRU.simulation());
  }
}
