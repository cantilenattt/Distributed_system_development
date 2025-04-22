import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


class Sensor{
    Double AccX,AccY,AccZ;
    Double GyroX,GyroY,GyroZ;
    Double Roll,Pitch,Yaw;
    Sensor(double Roll,double Pitch,double Yaw){
        this.Roll = Roll;
        this.Pitch = Pitch;
        this.Yaw = Yaw;
    }
}
class Flexion{
    public static double Left(Sensor L1,Sensor L2,Sensor L3,Sensor R1,Sensor R2,Sensor R3){
        double a = L1.Roll;
        return a;
    }
    public static double Right(Sensor L1,Sensor L2,Sensor L3,Sensor R1,Sensor R2,Sensor R3){
        double a = R1.Roll;
        return a;
    }
}
class Extension{
    public static double Left(Sensor L1,Sensor L2,Sensor L3,Sensor R1,Sensor R2,Sensor R3){
        double a = L1.Roll;
        return a;
    }
    public static double Right(Sensor L1,Sensor L2,Sensor L3,Sensor R1,Sensor R2,Sensor R3){
        double a = R1.Roll;
        return a;
    }
}
class Abduction{
    public static double Left(Sensor L1,Sensor L2,Sensor L3,Sensor R1,Sensor R2,Sensor R3){
        double a = L2.Roll;
        return a;
    }
    public static double Right(Sensor L1,Sensor L2,Sensor L3,Sensor R1,Sensor R2,Sensor R3){
        double a = R2.Roll;
        return a;
    }
}
class Adduction{
    public static double Left(Sensor L1,Sensor L2,Sensor L3,Sensor R1,Sensor R2,Sensor R3){
        double a = L2.Roll;
        return a;
    }
    public static double Right(Sensor L1,Sensor L2,Sensor L3,Sensor R1,Sensor R2,Sensor R3){
        double a = R2.Roll;
        return a;
    }
}
class ExRotation{
    public static double Left(Sensor L1,Sensor L2,Sensor L3,Sensor R1,Sensor R2,Sensor R3){
        double a = L3.Yaw;
        if(a<0) a += 360;
        return a;
    }
    public static double Right(Sensor L1,Sensor L2,Sensor L3,Sensor R1,Sensor R2,Sensor R3){
        double a = R3.Yaw;
        if(a<0) a += 360;
        return a;
    }
}
class InRotation{
    public static double Left(Sensor L1,Sensor L2,Sensor L3,Sensor R1,Sensor R2,Sensor R3){
        double a = L3.Yaw;
        if(a<0)  a += 360;
        return a;
    }
    public static double Right(Sensor L1,Sensor L2,Sensor L3,Sensor R1,Sensor R2,Sensor R3){
        double a = R3.Yaw;
        if(a<0)  a += 360;
        return a;
    }
}
public class Analysis {
    static ArrayList<Double> FlexionLeft = new ArrayList<>();
    static ArrayList<Double> FlexionRight = new ArrayList<>();

    static ArrayList<Double> ExtensionLeft = new ArrayList<>();
    static ArrayList<Double> ExtensionRight = new ArrayList<>();

    static ArrayList<Double> AbductionLeft = new ArrayList<>();
    static ArrayList<Double> AbductionRight = new ArrayList<>();

    static ArrayList<Double> AdductionLeft = new ArrayList<>();
    static ArrayList<Double> AdductionRight = new ArrayList<>();

    static ArrayList<Double> ExRotationLeft = new ArrayList<>();
    static ArrayList<Double> ExRotationRight = new ArrayList<>();

    static ArrayList<Double> InRotationLeft = new ArrayList<>();
    static ArrayList<Double> InRotationRight = new ArrayList<>();

    static double GetMaxMid(ArrayList<Double> Angle){
        Collections.sort(Angle);
        int n = Angle.size();
        int delta = n / 20;
        int MIN = 0 + delta;
        int MID = n / 2;
        int MAX = n - delta;
        double res = Angle.get(MAX) - Angle.get(MID); 
//        if(res < 0) res += 360;
        return res;
    }
    static double GetMidMin(ArrayList<Double> Angle){
        Collections.sort(Angle);
        int n = Angle.size();
        int delta = n / 20;
        int MIN = 0 + delta;
        int MID = n / 2;
        int MAX = n - delta;
        double res = Angle.get(MID) - Angle.get(MIN);
//        if(res < 0) res += 360;
        return res;
    }

    public static void Calculate(ArrayList<Double> Data){
       
        Sensor L1 = new Sensor(Data.get(6),Data.get(7),Data.get(8));
        Sensor L2 = new Sensor(Data.get(15),Data.get(16),Data.get(17));
        Sensor L3 = new Sensor(Data.get(24),Data.get(25),Data.get(26));
        Sensor R1 = new Sensor(Data.get(33),Data.get(34),Data.get(35));
        Sensor R2 = new Sensor(Data.get(42),Data.get(43),Data.get(44));
        Sensor R3 = new Sensor(Data.get(51),Data.get(52),Data.get(53)); 

        FlexionLeft.add(Flexion.Left(L1,L2,L3,R1,R2,R3));
        FlexionRight.add(Flexion.Right(L1,L2,L3,R1,R2,R3));

        ExtensionLeft.add(Extension.Left(L1,L2,L3,R1,R2,R3));
        ExtensionRight.add(Extension.Right(L1,L2,L3,R1,R2,R3));

        AbductionLeft.add(Abduction.Left(L1,L2,L3,R1,R2,R3));
        AbductionRight.add(Abduction.Right(L1,L2,L3,R1,R2,R3));

        AdductionLeft.add(Adduction.Left(L1,L2,L3,R1,R2,R3));
        AdductionRight.add(Adduction.Right(L1,L2,L3,R1,R2,R3));

        ExRotationLeft.add(ExRotation.Left(L1,L2,L3,R1,R2,R3));
        ExRotationRight.add(ExRotation.Right(L1,L2,L3,R1,R2,R3));

        InRotationLeft.add(InRotation.Left(L1,L2,L3,R1,R2,R3));
        InRotationRight.add(InRotation.Right(L1,L2,L3,R1,R2,R3));

//        ExternalRotationLeft.add(ExternalRotation.Left(L1,L2,L3,R1,R2,R3));
    }
    public static HashMap<String,Double> Statistic(){
        HashMap<String,Double> res = new HashMap<>();
        res.put("左前屈",GetMidMin(FlexionLeft));
        res.put("右前屈",GetMidMin(FlexionRight));
       
        res.put("左后伸",GetMaxMid(ExtensionLeft));
        res.put("右后伸",GetMaxMid(ExtensionRight));

        res.put("左外展",GetMidMin(AbductionLeft));
        res.put("右外展",GetMaxMid(AbductionRight));

        res.put("左内收",GetMaxMid(AdductionLeft));
        res.put("右内收",GetMidMin(AdductionRight));

        res.put("左外旋",GetMaxMid(ExRotationLeft));
        res.put("右外旋",GetMidMin(ExRotationRight));

        res.put("左内旋",GetMidMin(InRotationLeft));
        res.put("右内旋",GetMaxMid(InRotationRight));
       
        return res;
    }
}
