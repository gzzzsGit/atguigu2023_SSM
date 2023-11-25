package com.gzzz.ioc_01;

/**
 * className: DefaultServiceLocator
 * Package : com.gzzz.ioc_01
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/25 11:26
 * @Version 1.0
 */
public class DefaultServiceLocator {
    private static ClientServiceImpl clientService = new ClientServiceImpl(); ;
    public ClientServiceImpl createClientServiceInstance() {
        return clientService;
    }
}
