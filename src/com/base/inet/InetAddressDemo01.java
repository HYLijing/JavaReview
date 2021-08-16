package com.base.inet;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo01 {

    public static void main(String[] args) throws UnknownHostException {

//        InetAddress inetAddress = InetAddress.getByName("www.oreilly.com");
//        InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
//        System.out.println(inetAddress);
//        byte[] address = inetAddress.getAddress();
//
//        String hostAddress = inetAddress.getHostAddress();
//        System.out.println(hostAddress);
//        String hostName = inetAddress.getCanonicalHostName();
//        System.out.println(hostName);
//        String hostName1 = inetAddress.getHostName();
//        System.out.println(hostName1);

//        InetAddress address1 = InetAddress.getByName("208.201.239.100");
//        InetAddress address1 = InetAddress.getByName("36.152.44.96");
//        System.out.println(address1.getHostName());
//        System.out.println(address1.getHostAddress());

//        InetAddress[] addresses = InetAddress.getAllByName("www.baidu.com");
//        InetAddress[] addresses = InetAddress.getAllByName("www.baidu.com");
//        for (InetAddress address : addresses) {
//
//            System.out.println(address);
//
//        }

        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);

    }

}
