package com.celonis.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:general.properties",
})
public interface Configuration extends Config {

    @Config.Key("url.base")
    String url();

    @Key("browser")
    String browser();
}
