package by.skakun.carrentalsystem.logic;

import org.apache.log4j.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class PasswordHashing {
    private static final Logger LOG = Logger.getLogger(PasswordHashing.class);
    private PasswordHashing() {
    }

    public static String getHashValue(String password) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            LOG.info("NoSuchAlgorithmException while handling password. " + e);
        }
        md.update(password.getBytes());
        byte byteData[] = md.digest();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
}
