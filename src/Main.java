import java.lang.String;

/**
 * Created by Nikita on 19.02.15.
 */
public class Main {
    public static void main(String[] arg) {
//        List<Double> coeff = new ArrayList<Double>();         //Первая контрольная
//        coeff.add(0.0);
//        coeff.add(-72.0);
//        coeff.add(-6.0);
//        coeff.add(8.0);
//        coeff.add(1.0);
//        Dihotomiya dihotomiya = new Dihotomiya(1.5, 2, 0.05, 0.01, 4, coeff);
//        dihotomiya.methodForPolynom();
//        Dihotomiya dihotomiya = new Dihotomiya(0,2,0.05,0.01,79,23/2);
//        dihotomiya.methodForExp();
//        System.out.println(" ");
//        GoldenMiddle goldenMiddle = new GoldenMiddle(0,2,0.05,0.01,79,23/2);
//        goldenMiddle.methodForExp();
//        Dihotomiya dihotomiya = new Dihotomiya(1.5, 2, 0.05, 0.01, 293/4, 11);
//        double tmp = dihotomiya.methodForExp();
//        System.out.print(tmp);
        DME DME = new DME(1);
        DeformingMultiEdgeFactory.findMin(DME);
    }
}
