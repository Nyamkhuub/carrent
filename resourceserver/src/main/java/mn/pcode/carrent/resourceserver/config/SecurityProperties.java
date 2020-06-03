package mn.pcode.carrent.resourceserver.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("security")
public class SecurityProperties {
    private JwtProperties properties;

    public JwtProperties getProperties() {
        return properties;
    }

    public void setProperties(JwtProperties properties) {
        this.properties = properties;
    }
}
