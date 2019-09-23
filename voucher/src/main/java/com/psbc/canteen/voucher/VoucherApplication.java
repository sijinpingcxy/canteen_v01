package com.psbc.canteen.voucher;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@MapperScan("com.psbc.canteen.voucher.mapper") //扫描的mapper
@SpringBootApplication(scanBasePackages = {"com.psbc.canteen.voucher", "com.psbc.canteen.common"})
@ServletComponentScan
public class VoucherApplication {

    public static void main(String[] args) {
        SpringApplication.run(VoucherApplication.class, args);
    }

}
