package io.codeforall.fanstatics;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URL;

public class Main {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Ipinfo ipinfo = mapper.readValue(new URL("https://ipinfo.io/json"), Ipinfo.class);
            System.out.println(ipinfo.getIp());
            System.out.println(ipinfo.getCity());
            System.out.println(ipinfo.getRegion());
            System.out.println(ipinfo.getCountry());
            System.out.println(ipinfo.getLoc());
            System.out.println(ipinfo.getOrg());
            System.out.println(ipinfo.getPostal());
            System.out.println(ipinfo.getTimezone());
            System.out.println(ipinfo.getReadme());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
