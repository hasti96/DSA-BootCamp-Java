package bitwise.lecture;

public class RangeXOR {

    public static void main(String[] args) {
        //range zor for a,b = xor(b) ^ xor(a-1);
        int a =3;
        int b = 9;

        int ans = xor(b) ^ xor(a-1);

        System.out.println(ans);
    }

    // this give xor from 0 to a
    static int xor(int a) {
        if(a%4 == 0) {
            return a;
        }
        if(a%4 == 1) {
            return 1;
        }
        if(a%4 == 2) {
            return a+1;
        }

        return 0;
    }
}
