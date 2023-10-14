package Arrays.utils;

public class Index {
    // size -> amount elements structure    (lenght -> spaces in memory)

    private Index(){}
    
    // Class methods for any Indexed Structure
    public static void checkValidIndex(int i, int size) throws Exception {
        if(i < 0 || i >= size){
            throw new Exception("Invalid Index: Index out of range.");
        }
    }

}
