package mn.pcode.carrent.resourceserver.config;

import org.springframework.core.io.Resource;

public class JwtProperties {
    private Resource publicKey;

    public Resource getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(Resource publicKey) {
        this.publicKey = publicKey;
    }
}
