package com.vinaylogics.junit5.dynamictests;

import java.util.HashMap;
import java.util.Map;

public class DomainNameResolver {

    private Map<String, String> ipByDomainName = new HashMap<>();

    DomainNameResolver() {
        this.ipByDomainName.put("www.somedomain.com", "154.174.10.56");
        this.ipByDomainName.put("www.anotherdomain.com", "211.152.104.132");
        this.ipByDomainName.put("www.yetanotherdomain.com", "178.144.120.156");
    }

    public String resolveDomain(String domainName) {
        return ipByDomainName.get(domainName);
    }
}
