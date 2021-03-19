package cn.enjoy.service;

import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    /*
    * 如果一个程序员，如果要在业务代码关心怎么选择数据源的问题，或者说架构就是失败的
    *
    * */
    @Override
    public String queryAccount(String id) {
        System.out.println("==========AccountServiceImpl.queryAccount");
        return "==========AccountServiceImpl.queryAccount";
    }
}
