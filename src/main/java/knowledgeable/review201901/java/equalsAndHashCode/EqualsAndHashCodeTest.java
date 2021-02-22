package knowledgeable.review201901.java.equalsAndHashCode;


/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-01-23
 * Time: 10:38:24
 * Description:
 */
public class EqualsAndHashCodeTest
{
    private int version;

    public EqualsAndHashCodeTest(int version)
    {
        this.version = version;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof EqualsAndHashCodeTest)
        {
            EqualsAndHashCodeTest equalsAndHashCodeTest = (EqualsAndHashCodeTest) obj;
            return version == equalsAndHashCodeTest.version;
        }
        return super.equals(obj);
    }

    public static void main(String[] args)
    {
        EqualsAndHashCodeTest e1 = new EqualsAndHashCodeTest(1);
        EqualsAndHashCodeTest e2 = new EqualsAndHashCodeTest(1);
        EqualsAndHashCodeTest e3 = new EqualsAndHashCodeTest(1);
        System.out.println(e1.equals(e2));
        System.out.println(e1 == e2);
        System.out.println("自反性：\n" + e1.equals(e1));
        System.out.println("对称性：");
        System.out.println(e1.equals(e2));
        System.out.println(e2.equals(e1));
        System.out.println("传递性：");
        System.out.println(e1.equals(e2));
        System.out.println(e2.equals(e3));
        System.out.println(e1.equals(e3));
        System.out.println("一致性：");
        for (int i = 0; i < 1000; i++)
        {
            if (e1.equals(e2) != e1.equals(e2))
            {
                System.out.println("equals方法没有遵守一致性！");
                break;
            }
        }
        System.out.println("equals方法遵守一致性！");
        System.out.println("与null比较：");
        System.out.println(e1.equals(null));

    }
}
