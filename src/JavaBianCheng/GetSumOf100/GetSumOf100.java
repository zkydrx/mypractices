package JavaBianCheng.GetSumOf100;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-08-31
 * Time: 11:20
 * Description:
 * 编写一个在1，2，…，9（顺序不能变）数字之间插入+或-或什么都不插入，
 * 使得计算结果总是100的程序，并输出所有的可能性。
 * 例如：1 + 2 + 34 – 5 + 67 – 8 + 9 = 100。
 */
public class GetSumOf100
{
    /**
     * 自己没有实现，方法摘自网上。
     * @param args
     */
    public static void main(String args[]){
        String num[] = new String[17];
        int count1 = 1;
        for (int i = 0; i < num.length; i++) {
            if(i%2 == 0){
                num[i] = count1 + "";
                count1++;
            }
            else{
                num[i] = "";
            }
        }//准备好特定格式的数组

        System.out.println("Start");
        get100(num, 1, 16, num);
        System.out.println("End");
    }

    /**
     * 找出结果为100的表达式
     * @param data1
     * @param count
     * @param times
     * @param data2
     */
    static void get100(String data1[], int count,int times,String data2[]){
        if(count >= times){
            if (calculate100(data2) == 100){

                for (int j = 0; j < data2.length; j++) {
                    System.out.print(data2[j]);
                }
                System.out.println( " = 100");
            }
            return;

        }

        String temp1[] = new String[data1.length];
        String temp2[] = new String[data1.length];
        String temp3[] = new String[data1.length];
        String add = "+";
        String minus = "-";
        String empty = "";
        copyStringArray(temp1, data2);
        copyStringArray(temp2, data2);
        copyStringArray(temp3, data2);

        temp1[count] = add;
        temp2[count] = minus;
        temp3[count] = empty;

        temp1[count+1] = data1[count+1];
        temp2[count+1] = data1[count+1];
        temp3[count+1] = data1[count+1];
        count+=2;

        get100(data1, count, times, temp1);
        get100(data1, count, times, temp2);
        get100(data1, count, times, temp3);
    }
    /**
     * 复制字符数组的方法，从from[]复制到to[]
     * @param to
     * @param from
     */
    static void copyStringArray(String to[], String from[]){
        for (int i = 0; i < from.length ; i++) {
            to[i] = from[i];
        }
    }
    /**
     * 求和方法，输入一个String[]运算式子
     * 数组要写成指定的格式,大于10的数之间要用""隔开。
     * @see ["1","","4"<span style="font-family: Arial, Helvetica, sans-serif;">,""</span>,"7","+","7"]
     * @param cal
     * @return 表达式的和
     */
    static int calculate100(String cal[]){
        int sum = 0;
        int bitCount = 0;
        int tempNum = 0;
        for (int i = cal.length - 1; i >= 0; i--) {

            if (cal[i] == "+") {
                sum+=tempNum;
                tempNum = 0;
                bitCount = 0;
            }
            else if (cal[i] == "-"){
                sum-=tempNum;
                tempNum = 0;
                bitCount = 0;
            }
            else if (cal[i] == ""){
                bitCount++;
            }
            else{
                tempNum+=Math.pow(10, bitCount) * Integer.parseInt(cal[i]);
            }
        }
        return sum+=tempNum;
    }
}
