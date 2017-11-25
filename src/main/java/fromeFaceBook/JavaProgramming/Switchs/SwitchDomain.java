package fromeFaceBook.JavaProgramming.Switchs;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-11-14
 * Time: 23:32
 * Description:
 * switch 开关之意。只有switch的值满足case的值时才开始执行那个case内部的语句
 * 在这个case,如果那个case没有做break操作，那么该case后的case内部的语句也会被执行。
 * 直到遇到break。
 * 如果没有任何一个case 的值满足要求。那么直接执行 default 语句。不管default是否有break都会在执行了default
 * 以后退出switch()语句块。
 * 如果没有case 满足要求，也没有default分支那么switch中的任何语句都不会执行。直接跳过switch语句块。
 */
public class SwitchDomain
{
    public static void main(String[] args)
    {
        int x = 2;
        switch (x)
        {
            case 1:
                x += 2;
                break;
            case 2:
                x++;
            case 3:
                x += 4;
            default:
                x += 2;
        }

        System.out.println(x);
    }
}
