
public class LongestPalindromeTester {
    public static void main(String[] args) {
        String sampleIn = "hackerrekcahba";
        String sampleOut = "hackerrekcah";
        LongestPalindrome lp = new LongestPalindrome();
        lp.printmessage();
        String actualOut = lp.getLongestPalindrome(sampleIn);
        if (actualOut.equals(sampleOut)) {
            System.out.println("Success:" + actualOut);
        } else {
            System.out.println("Failure:" + actualOut);
        }
    }
}