public class GardnerDist{
  public RequestGenerator gen;
  private int ram_size;
  public GardnerDist(int ram) {
    gen = new RequestGenerator();
    ram_size = ram;
  }
  public int[] generateGardner(int l){
    int[] requests= new int[l];
    //filling array from 1 to 1000
    for (int i =0; i< l;i++){
      requests[i] = gen.generateRequest();

    }
    return requests;
  }
}
