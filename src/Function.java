/**
 * Created by Nikita on 18.05.15.
 */
public class Function {
    public static double taskTwoFuncOne(double x1, double x2) {
        return 100 * Math.pow((x2 - Math.pow(x1, 2)), 2) + 5 * Math.pow((1 - x1), 2);
    }

    public static double taskTwoFuncTwo(double x1, double x2) {
        return Math.pow(Math.pow(x1, 2) + x2 - 11, 2) + Math.pow(x1 + Math.pow(x2, 2) - 7, 2);
    }
}
