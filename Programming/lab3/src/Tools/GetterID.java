package Tools;

public class GetterID {
    private static int id = 0;
    public static int getID(){
        id++;
        return id;
    }
}
