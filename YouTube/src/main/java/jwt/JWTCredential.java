/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jwt;

/**
 *
 * @author Laptop_Thomas
 */
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.security.enterprise.credential.Credential;

public class JWTCredential implements Credential {

    private String caller;
    private Set<String> groups;
    private Map<String, Serializable> info;

    public JWTCredential(String caller) {
        this(caller, new HashSet<String>());
    }

    public JWTCredential(String caller, Set<String> groups) {
        this.caller = caller;
        this.groups = groups;
        this.info = new HashMap<>();
    }

    public void addInfo(String key, Serializable value) {
        this.info.put(key, value);
    }

    public String getCaller() {
        return caller;
    }

    public Set<String> getGroups() {
        return groups;
    }

    public Serializable getInfo(String key) {
        return info.get(key);
    }
}
