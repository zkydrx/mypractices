package knowledgeable.review202101.alibaba;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2021-03-04
 * Time: 21:22:57
 * Description:
 */
public class AlibabaNode
{


    /**
     * 尝试用java编写一个转账接口，传入主要业务参数包括转出账号，转入账号，转账金额，完成转出和转入账号的资金处理，
     * 该服务要确保在资金处理时转出账户的余额不会透支，金额计算准确。
     *
     * @param outNo
     * @param inNo
     * @param money
     * @return
     */
    // @Transactional//事务保证多个数据操作的一致性。
    // public MsgResult transfer(String outNo, String inNo, BigDecimal money)
    // {
    //     /**
    //      * 1.基础校验
    //      */
    //     if (StringUtils.isEmpty(outNo) || StringUtils.isEmpty(inNo))
    //     {
    //         return new MsgResult(errorCode, message);
    //     }
    //     if (checkIsBigdecimal(money))
    //     {
    //         return new MsgResult(errorCode, message);
    //     }
    //     /**
    //      * checkNum检查库里是否存在相应的账号
    //      */
    //     if (checkNum(outNo) || checkNumber(inNo))
    //     {
    //         return new MsgResult(errorCode, message);
    //     }
    //     /**
    //      * 2.查询账户资金是否足够该次转账
    //      */
    //     if (checkTheBalanceisEnough(outNo, money))
    //     {
    //         return new MsgResult(errorCode, message);
    //     }
    //
    //     /**
    //      * 3.转账
    //      */
    //     if (doTransfer(outNo, inNo, money))
    //     {
    //         return new MsgResult(errorCode, message);
    //     }
    //     else
    //     {
    //         return new MsgResult(errorCode, message);
    //     }
    // }
    //
    // public Boolean doTransfer(String outNo, String inNo, BigDecimal money)
    // {
    //     /**
    //      * 从转出账户扣钱
    //      */
    //     int i1 = subMoney(outNo, money);
    //     /**
    //      * 从转入账户加钱
    //      * 保证事务的一致性。
    //      */
    //     int i2 = addMoney(inNo, money);
    //     return i1 == i2 && i1 == 1;
    // }

}
