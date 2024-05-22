package Utils;

public class Numbers {
    public static int prependNumber(int origNum, int prepend){
        String numberAsString = Integer.toString(origNum);
        String prepended = prepend + numberAsString;
        return Integer.parseInt(prepended);
    }
}
