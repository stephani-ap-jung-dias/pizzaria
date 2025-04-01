import java.util.Scanner;

public class InputHelp {
    Scanner leitor = new Scanner(System.in);

    public void InputText(String a) {
        System.out.println(a);
    }

    public int InputInt(String a) {
        System.out.println(a);
        int num = leitor.nextInt();
        leitor.nextLine();
        return num;
    }

    public float InputFloat(String a) {
        System.out.println(a);
        float num = leitor.nextFloat();
        leitor.nextLine();
        return num;
    }


    public String InputString(String a) {
        System.out.println(a);
        return leitor.nextLine();
    }

    public double InputDouble(String a) {
        System.out.println(a);
        double num = leitor.nextDouble();
        leitor.nextLine();
        return num;
    }
}