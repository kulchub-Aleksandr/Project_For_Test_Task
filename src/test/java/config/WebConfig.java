package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties",

})
public interface WebConfig extends Config {

    @Key("browser")
    @DefaultValue("CHROME")
    String browser();

    @Key("browserVersion")
    @DefaultValue("144")
    String browserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();

    @Key("baseUrl")
    @DefaultValue("https://www.tbank.ru")
    String baseUrl();

    @Key("isRemote")
    @DefaultValue("false")
    boolean isRemote();

    @Key("remoteUrl")
    String remoteUrl();
}
