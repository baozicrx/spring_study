package com.example.demo.beanUtils;

import org.apache.commons.beanutils.BeanUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.core.Converter;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: crx
 * @Create: 11:28 2020/7/13
 */
public class BeanUtilsMain {
    public static void main(String[] args) {
        List<Account> accountList = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            Account po = new Account();
            po.setId(i);
            po.setCreateTime(new Date());
            po.setBalance(BigDecimal.valueOf(i));
            accountList.add(po);
        }
//        testBeanCopier(accountList);
        testBeanUtils(accountList);
        testSpringBeanUtils(accountList);
    }

    //使用CGlib实现Bean拷贝BeanCopier
    public static void testBeanCopier(List<Account> accountList) {
        AccountConverter accountConverter = new AccountConverter();
        long startTime = System.currentTimeMillis();
        BeanCopier copier = BeanCopier.create(Account.class, AccountDto.class, true);
        List<AccountDto> accountDtoList = new ArrayList<>();
        accountList.forEach(po -> {
            AccountDto vo = new AccountDto();
            copier.copy(po, vo, accountConverter);
            accountDtoList.add(vo);
        });
        System.out.println("集合大小=" + accountDtoList.size() + ",耗时=" + (System.currentTimeMillis() - startTime));
        System.out.println(accountDtoList.get(99999));
    }

    //使用Apache的BeanUtils
    public static void testBeanUtils(List<Account> accountList) {
        long startTime = System.currentTimeMillis();
        List<AccountDto> accountDtoList = new ArrayList<>();
        accountList.forEach(po -> {
            AccountDto vo = new AccountDto();
            try {
                BeanUtils.copyProperties(vo, po);
            } catch (Exception e) {
                e.printStackTrace();
            }
            accountDtoList.add(vo);
        });
        System.out.println("集合大小=" + accountDtoList.size() + ",耗时=" + (System.currentTimeMillis() - startTime));
        System.out.println(accountDtoList.get(99999));
    }

    //使用Spring的BeanUtils
    public static void testSpringBeanUtils(List<Account> accountList) {
        long startTime = System.currentTimeMillis();
        List<AccountDto> accountDtoList = new ArrayList<>();
        accountList.forEach(po -> {
            AccountDto vo = new AccountDto();
            try {
                org.springframework.beans.BeanUtils.copyProperties(po, vo);
            } catch (Exception e) {
                e.printStackTrace();
            }
            accountDtoList.add(vo);
        });
        System.out.println("集合大小=" + accountDtoList.size() + ",耗时=" + (System.currentTimeMillis() - startTime));
        System.out.println(accountDtoList.get(99999));
    }

    //使用mapStruct的BeanUtils
    public static void testMapStructBeanUtils(List<Account> accountList) {
        long startTime = System.currentTimeMillis();
        List<AccountDto> accountDtoList = new ArrayList<>();
        Mappers.getMapper(AccountDto.class);
        System.out.println("集合大小=" + accountDtoList.size() + ",耗时=" + (System.currentTimeMillis() - startTime));
        System.out.println(accountDtoList.get(99999));
    }
}

//使用CGlib实现Bean拷贝BeanCopier,自定义Converter转换器
class AccountConverter implements Converter {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @SuppressWarnings("rawtypes")
    @Override
    public Object convert(Object source, Class target, Object context) {
        if (source instanceof Integer) {
            return source;
        } else if (source instanceof Date) {
            Date date = (Date) source;
            return sdf.format(date);
        } else if (source instanceof BigDecimal) {
            BigDecimal bd = (BigDecimal) source;
            return bd.toPlainString();
        }
        return null;
    }
}
