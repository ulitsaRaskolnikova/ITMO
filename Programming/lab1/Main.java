/**
 * @malyshev_n_a
 * 409067
 */
public class Main {
    public static void main(String[] args) {
        int[] c = new int[10];
        for (int i = 0, n = 20; i < 10; i++, n -= 2){
            c[i] = n;
        }
        float[] x = new float[15];
        for (int i = 0; i < 15; i++){
            x[i] = (float) (Math.random() * 6.0 - 2.0);
        }
        float[][] m = new float[10][15];
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 15; j++){
                if (c[i] == 6){
                    m[i][j] = (float) Math.cos(Math.cbrt(Math.cos(x[j])));
                }
                else if (c[i] == 2 || c[i] == 4 || c[i] == 8 || c[i] == 12 || c[i] == 18){
                    m[i][j] = (float) Math.pow(Math.pow(Math.pow(2.0*x[j],2), 0.5 * Math.tan(x[j])), (Math.asin(Math.cos(x[j])) + 0.25) / 6.0);
                }
                else{
                    m[i][j] = (float) Math.cbrt(Math.pow(2.0 * Math.cos(Math.sin(x[j])) / 3.0, 2));
                }
                System.out.printf("%.3f ", m[i][j]);
            }
            System.out.println();
        }
    }
}
