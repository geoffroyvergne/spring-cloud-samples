package com.base.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix="oauthClients")
public class OauthClients {

    private List<Client> clients;

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public static class Client {
        private String name;
        private String secret;
        private int accessTokenValiditySeconds;
        private String[] authorizedGrantTypes;
        private String[] scopes;
        private String[] resourcesId;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSecret() {
            return secret;
        }

        public void setSecret(String secret) {
            this.secret = secret;
        }

        public String[] getAuthorizedGrantTypes() {
            return authorizedGrantTypes;
        }

        public void setAuthorizedGrantTypes(String[] authorizedGrantTypes) {
            this.authorizedGrantTypes = authorizedGrantTypes;
        }

        public String[] getScopes() {
            return scopes;
        }

        public void setScopes(String[] scopes) {
            this.scopes = scopes;
        }

        public int getAccessTokenValiditySeconds() {
            return accessTokenValiditySeconds;
        }

        public void setAccessTokenValiditySeconds(int accessTokenValiditySeconds) {
            this.accessTokenValiditySeconds = accessTokenValiditySeconds;
        }

        public String[] getResourcesId() {
            return resourcesId;
        }

        public void setResourcesId(String[] resourcesId) {
            this.resourcesId = resourcesId;
        }

    }
}
