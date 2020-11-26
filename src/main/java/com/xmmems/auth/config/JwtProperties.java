package com.xmmems.auth.config;

import com.xmmems.common.auth.utils.RsaUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;

@Data
@Slf4j
@ConfigurationProperties(prefix = "ly.jwt")
public class JwtProperties {

    private String pubKeyPath;
    private String priKeyPath;

    private PublicKey publicKey;
    private PrivateKey privateKey;

    private AuthUser user = new AuthUser();

    @Data
    public class AuthUser{
        private Integer expire;
        private Integer refreshTime;
        private String cookieName;
        private String cookieDomain;
    }

    @PostConstruct
    public void createKey() throws InvalidKeySpecException, NoSuchAlgorithmException, IOException {
        this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
        this.privateKey = RsaUtils.getPrivateKey(priKeyPath);
    }

}