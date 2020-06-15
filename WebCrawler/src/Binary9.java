import java.util.Scanner;

public class Binary9 {
    private static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;

        System.out.print("Nhap n: ");
        n = sc.nextInt();

        System.out.print("Nhap m: ");
        m = sc.nextInt();

        int[] x = new int[n];
        tries(0, x, m);

        sc.close();
    }

    public static void tries(int i, int[] x, int m) {
        for (int v = 0; v <= 1; v++) {
            int temp = count;
            if (check(v, i, x, m)) {
                //System.out.println("v="+v+", i="+i+", count="+count);
                x[i] = v;
                if (i == x.length-1) print(x);
                else tries(i+1, x, m);
            }
            count = temp;
        }
    }

    // kiểm tra thành phần v có hợp lệ để đưa vào vị trí i trong x[]
    private static boolean check(int v, int i, int[] x, int m) {
        // nếu vị trí i chưa tạo đủ 1 dãy dài m thì v là hợp lệ
        if (i < m) return true;

        // nếu v giống với x[i-m] thì biến count tăng lên
        if (v == x[i-m]) count++;
        else count = 0;

        // nếu count = m tức là tồn tại 2 dãy có độ dài m giống nhau
        if (count == m) {
            return false;
        }

        return true;
    }

    public static void print(int[] x) {
        for (int i=0; i < x.length; i++) {
            System.out.print(x[i]);
        }
        System.out.println();
    }
}
