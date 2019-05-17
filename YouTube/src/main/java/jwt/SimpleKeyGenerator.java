/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jwt;

import java.security.Key;
import javax.crypto.spec.SecretKeySpec;
import javax.ejb.Stateless;

/**
 *
 * @author Laptop_Thomas
 */
@Stateless
public class SimpleKeyGenerator {

    public Key generateKey() {
        String keyString = "YoutubeTVD";
        Key key = new SecretKeySpec(keyString.getBytes(), 0, keyString.getBytes().length, "DES");
        return key;
    }
}
