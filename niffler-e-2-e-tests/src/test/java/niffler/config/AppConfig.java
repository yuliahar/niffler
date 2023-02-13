package niffler.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/app.properties")
public interface AppConfig extends Config {

    @Key("niffler.frontend.url")
    String frontendUrl();

    @Key("niffler.spend.url")
    String spendUrl();

    @Key("niffler.userdata.url")
    String userdataUrl();
}
