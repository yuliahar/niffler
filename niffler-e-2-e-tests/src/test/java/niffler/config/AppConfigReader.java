package niffler.config;

import org.aeonbits.owner.ConfigFactory;

public final class AppConfigReader {

    public static final AppConfig appConfig = ConfigFactory.create(AppConfig.class);

}
