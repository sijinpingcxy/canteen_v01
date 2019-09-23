package com.psbc.canteen.common.utils;

import com.alibaba.druid.filter.config.ConfigTools;

public class RsaEncryptAndDecodeUtil {

    /**
     * 私钥加密(用于加密)
     */
    private static final String DEFAULT_PRIVATE_KEY_STRING = "MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEAocbCrurZGbC5GArEHKlAfDSZi7gFBnd4yxOt0rwTqKBFzGyhtQLu5PRKjEiOXVa95aeIIBJ6OhC2f8FjqFUpawIDAQABAkAPejKaBYHrwUqUEEOe8lpnB6lBAsQIUFnQI/vXU4MV+MhIzW0BLVZCiarIQqUXeOhThVWXKFt8GxCykrrUsQ6BAiEA4vMVxEHBovz1di3aozzFvSMdsjTcYRRo82hS5Ru2/OECIQC2fAPoXixVTVY7bNMeuxCP4954ZkXp7fEPDINCjcQDywIgcc8XLkkPcs3Jxk7uYofaXaPbg39wuJpEmzPIxi3k0OECIGubmdpOnin3HuCP/bbjbJLNNoUdGiEmFL5hDI4UdwAdAiEAtcAwbm08bKN7pwwvyqaCBC//VnEWaq39DCzxr+Z2EIk=";
    /**
     * 公钥(用于解密)
     */
    public static final String DEFAULT_PUBLIC_KEY_STRING = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKHGwq7q2RmwuRgKxBypQHw0mYu4BQZ3eMsTrdK8E6igRcxsobUC7uT0SoxIjl1WveWniCASejoQtn/BY6hVKWsCAwEAAQ==";



    public static void main(String[] args) {
        String miwen = encrypt("Hipay2016");
        System.out.println("密文=====>" + miwen);
        String mingwen = decrypt(miwen);
        System.out.println("名文=====>" + mingwen);
    }

    /**
     * 描述 私钥加密
     *
     */
    public static String encrypt(String strMing) {
        try {
            return ConfigTools.encrypt(DEFAULT_PRIVATE_KEY_STRING, strMing);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     * 描述 公钥解密
     *
     */
    public static String decrypt(String strMi) {
        try {
            return ConfigTools.decrypt(DEFAULT_PUBLIC_KEY_STRING, strMi);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
