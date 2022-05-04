package smallchange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;



public class SmallChangeSys {
    public static void main(String[] args) {
        
        boolean loop = true;
        Scanner scanner =  new Scanner(System.in);
        String key = "";

        //2.完成零钱通明细
        String details = "\t\t\t-------------零钱通明细------------";

        //3.完成收益入账
        double money = 0;//花的钱
        double balance = 0;//余额
        Date date = null;//表示日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        do{

            System.out.println("\t");
            System.out.println("\t\t\t----零钱通菜单----");
            System.out.println("\t\t\t1 零钱通明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 消费");
            System.out.println("\t\t\t4 退出");

            System.out.println("请选择（1-4）：");

            key = scanner.next();

            switch(key){
                case "1":
                System.out.println(details);
                break;

                case "2":
                System.out.print("收益入账金额：");
                money = scanner.nextDouble();//money 值的范围需要校验
                //账目余额通过修改balance来进行计算
                balance += money;
                date = new Date();
                System.out.println("收入时间为：" + sdf.format(date));

                //修改details，每次出账，入账利用修改details 来进行累计
                details += "\n收益入账\t+" + money + "\t" + "入账时间为：" + sdf.format(date) + "\t" +"余额为：" +  balance;
                money = 0;
                break;

                case "3":
                System.out.print("消费金额：");
                money = scanner.nextDouble();//money 值的范围需要校验
                if(money>balance){
                    
                    System.out.println("消费金额不可以大于余额，您目前余额为" + balance);
                    break;
                }
                balance = balance-money;
                date = new Date();
                System.out.println("消费时间为：" + sdf.format(date));
                details += "\n消费出张\t-" + money + "\t" + "消费时间为：" + sdf.format(date) + "\t" +"余额为：" +  balance;
                break;

                case "4":
                System.out.println("4 退出");
                loop = false;
                break;
                default:
                System.out.println("选择有误，请重新选择");
            }
           

        }while(loop);
        System.out.println("零钱通已退出");
    }
}
