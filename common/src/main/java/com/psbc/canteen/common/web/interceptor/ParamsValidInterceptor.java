package com.psbc.canteen.common.web.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

/**
 * 签名验证拦截器
 *
 * @author zhangdd
 * @ClassName: ParamsValidInterceptor
 * @create 2019/8/21 15:55
 * @since 1.0.0
 */
@Component
public class ParamsValidInterceptor extends HandlerInterceptorAdapter {
    private final static Logger log = LoggerFactory.getLogger(ParamsValidInterceptor.class);

    String pubKey = "12312";

    String priKey;

    String pwd;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String times = (System.currentTimeMillis()/1000)+"";
        log.info("当前时间戳为{}",times);
        log.info("传入验证签名方法的路径为{}",request.getRequestURL());
        return true;
        /*Map<String,String[]> maps = request.getParameterMap();
        //时间戳是否失效
        //Assert.isTrue(checkTimeStamp(new Long(maps.get("timeStamp")[0])), "时间失效");
        //签名数据
        String signStr = maps.get("sign")[0];
        log.info("传入签名数据为{}",signStr);
        //参与签名数据
        String returnString = key_sort(maps);
        log.info("传入参与签名数据为{}",returnString);
        //拿取公钥
        File pubfile = ResourceUtils.getFile(pubKey);
        String publicKey = txt2String(pubfile).replaceAll("(\\\r\\\n|\\\r|\\\n|\\\n\\\r)", "");

        //拿取私钥
        File prifile = ResourceUtils.getFile(priKey);
        String privateKey = txt2String(prifile).replaceAll("(\\\r\\\n|\\\r|\\\n|\\\n\\\r)", "");

        //对现有数据进行签名---本地签名校验
        byte [] signValidStr = RSA2.sign(returnString.getBytes(),privateKey);
        String signValid = Base64.getEncoder().encodeToString((signValidStr));
        boolean verfiy;
        if(signValid.equals(signStr)){
            verfiy = RSA2.verify(returnString.getBytes(),signValidStr,publicKey);
            log.info("当前验签结果为{}",verfiy);
        }else{
            verfiy=false;
        }
        if(verfiy==false){
            Assert.isTrue(verfiy,"签名验证失败");
        }
        return verfiy;*/
    }



    /**
     *排序
     **/
    public static String key_sort(Map<String, String[]> map) {
        String key_sort = "";

        TreeMap<String, String[]> map2 = new TreeMap<String, String[]>(new Comparator<String>() {
            public int compare(String obj1, String obj2) {
                // 降序排序
                return obj2.compareTo(obj1);
            }
        });
        map2 = new TreeMap<>(map);
        map2.remove("sign");

        Set<String> keySet = map2.keySet();
        Iterator<String> iter = keySet.iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            key_sort = key_sort + key + "=" + map2.get(key)[0] + "&";
        }
        return key_sort.substring(0, key_sort.length() - 1);
    }

    /**
     *判断时间戳是否在一分钟内
     **/
    private static boolean checkTimeStamp(long ts)
    {
        if (Math.abs(ts - System.currentTimeMillis() / 1000) > 60)
        {
            return false;
        }
        return true;
    }

    /**
     *读取文本文件中的数据并输出为String
     **/
    public static String txt2String(File file){
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append(System.lineSeparator()+s);
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }


}