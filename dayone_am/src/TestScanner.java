import java.util.Scanner;
public class TestScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您的名字");
        String uname = scanner.nextLine();
        System.out.println("请输入您的年龄");
        int age = scanner.nextInt();
        System.out.println("请输入您的月薪");
        double monthSalary = scanner.nextDouble();
        System.out.println("姓名:"+ uname+"\t年龄:"+age+"\t月薪:"
                +monthSalary+"\t年薪:"+(18*monthSalary));
    }
}
