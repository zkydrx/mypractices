package test.Enum;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2018-07-06
 * Time: 16:56:11
 * Description:
 */
public enum AEnum
{
    A111("A", "a"), B111("B", "b"), C111("C", "c"), D111("D", "d");
    private String code;
    private String desc;

    AEnum(String code, String desc)
    {
        this.code = code;
        this.desc = desc;
    }


    public static AEnum newInstance(String srcCode)
    {
        AEnum result = null;
        for (AEnum code : AEnum.values())
        {
            if (code.getCode().equals(srcCode))
            {
                result = code;
                break;
            }
        }
        return result;
    }


    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getDesc()
    {
        return desc;
    }

    public void setDesc(String desc)
    {
        this.desc = desc;
    }
}
