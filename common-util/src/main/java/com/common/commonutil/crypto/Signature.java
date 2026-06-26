package com.common.commonutil.crypto;

import java.security.*;
import java.security.spec.ECGenParameterSpec;
import java.util.Base64;

public class Signature {

    public static KeyPair generateKeyPair() throws NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
        keyPairGenerator.initialize(new ECGenParameterSpec("secp256r1"));
        return keyPairGenerator.generateKeyPair();
    }

    public static String sign(byte[] data, PrivateKey privateKey) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        java.security.Signature sign = java.security.Signature.getInstance("SHA256withECDSA");
        sign.initSign(privateKey);
        sign.update(data);
        byte[] signature = sign.sign();
        return Base64.getEncoder().encodeToString(signature);
    }

    public static boolean verify(byte[] data, String base64, PublicKey publicKey) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        java.security.Signature ver = java.security.Signature.getInstance("SHA256withECDSA");
        ver.initVerify(publicKey);
        ver.update(data);
        byte[] verify = Base64.getDecoder().decode(base64);
        return ver.verify(verify);
    }
}
