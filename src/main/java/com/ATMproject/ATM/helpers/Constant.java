package com.ATMproject.ATM.helpers;

public class Constant {

    public static class ACCOUNT_STATUS{
        public static String VERIFY = "VERIFY";
        public static String UNVERIFY = "UNVERIFY";

    }
    public static class TRANSACTION_STATUS{
        public static final String PENDING = "PENDING";
        public static final String CONFIRMED = "CONFIRMED";
        public static final String COMPLETED = "COMPLETED";
        public static final String DEPOSIT = "DEPOSIT";
        public static final String WITHDRAW = "WITHDRAW";
        public static final String TRANSFER = "TRANSFER";
        public static final String SENDER ="SENDER";
        public static final String RECEIVER = "RECEIVER";
    }
    public static final String FIND_QUERY_BY_ID_CUSTOMER= "Select c from Customer c where c.id = :id";
    public static final String FIND_QUERY_ALL_CUSTOMER = "from Customer ";
    public static final String FIND_QUERY_BY_ID_ACCOUNT= "Select a from Account a where a.id = :id";
    public static final String FIND_QUERY_BY_ID_TRANSACTION= "Select t from Transaction t where t.id = :id";




    public static final String API_LAYER_POINTCUT = "com.ATMproject.ATM.aspect.PointcutConfig.apiLayerPointcut()";
    public static final String SERVICE_LAYER_POINTCUT = "com.ATMproject.ATM.aspect.PointcutConfig.serviceLayerPointcut()";
    public static final String POINTCUT_CONTROLLER = "execution(* com.ATMproject.ATM.controller.*.*(..))";
    public static final String POINTCUT_SERVICE = "execution(* com.ATMproject.ATM.service.*.*(..))";
    public static final String POINTCUT_SERVICE_CONTROLLER = "execution(* com.ATMproject.ATM.controller.*.*(..)) || execution(* com.ATMproject.ATM.service.*.*(..))";
    public static final String POINTCUT_VALIDATE ="execution(* com.ATMproject.ATM.controller.*.*(..)) || execution(* com.ATMproject.ATM.service.*.*(..)) && args(accountId, withdrawalAmount)" ;

    public static final String VALIDATE_LAYER = "com.ATMproject.ATM.aspect.PointcutConfig.withdrawValidate()";



}
