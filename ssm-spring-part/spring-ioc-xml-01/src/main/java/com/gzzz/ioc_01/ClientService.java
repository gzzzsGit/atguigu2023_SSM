package com.gzzz.ioc_01;

/**
 * className: ClientService
 * Package : com.gzzz.ioc_01
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/25 11:11
 * @Version 1.0
 */
public class ClientService {
    private static ClientService clientService = new ClientService();
    private ClientService() {}
    public static ClientService createInstance() {

        return clientService;
    }
}
