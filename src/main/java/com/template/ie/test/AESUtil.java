package com.template.ie.test;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.security.Security;
import java.util.Base64;

public class AESUtil {

    /**
     * 密钥算法
     */
    private static final String ALGORITHM = "AES";
    /**
     * 加解密算法/工作模式/填充方式
     */
    private static final String ALGORITHM_MODE_PADDING = "AES/ECB/PKCS7Padding";

    /**
     * AES解密
     *
     * @param base64Data
     * @return
     * @throws Exception
     */
    public static String decryptData(String base64Data,String lowMad5Key) throws Exception {
        SecretKeySpec key = new SecretKeySpec(lowMad5Key.getBytes(), ALGORITHM);
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        Cipher cipher = Cipher.getInstance(ALGORITHM_MODE_PADDING);
        cipher.init(Cipher.DECRYPT_MODE, key);
        Base64.Decoder decoder = Base64.getDecoder();
        String newData= new String(decoder.decode(base64Data), "ISO-8859-1");
        return new String(cipher.doFinal(newData.getBytes("ISO-8859-1")), "utf-8");
    }
    public static String MD5(String data) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] array = md.digest(data.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        byte[] var4 = array;
        int var5 = array.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            byte item = var4[var6];
            sb.append(Integer.toHexString(item & 255 | 256).substring(1, 3));
        }

        return sb.toString().toUpperCase();
    }

    public static void main(String[] args) throws Exception {
        String a = "0KC5hoCVPyMaxOn5AfQpKjE1Z6Jm6PWI7uCnpCGZXy05YaqOuJXPeMwG6tMvcxwfJOe6u4vKyVZggcwmN0wI2y3CMYG6Z2uS4nluG1Aa/F5ctXurcNH9aGajo3D4Kx/J6hN7/p0IoInVl8gePBzjC5eRxC66ju2W+OaSOlDHT68yrkqeatfcYgjkYk6RGClMvKnl0mM6Nllwr9Bi6ca2vDNqA6TKIq52zu7o0/TBxRctpG4hnfssaQWhGQVMu50arWPyU+6f0aJ/GkJ21nJE/vD5NrjaKWxAOtRpHUWRkvOuUGsA2cx5snrZlRdtRNpAgs72RtoCGjp7IZx4mW88SdcIFG1DEgkzQe+IoVPWf3uAdS+ijbQ6xb7WFoHBrNzBJz84UZjN/tRIqA4qWv8ixIzQ4XUN7REBA4onBCeh/U7FckSuxmkIo8YcNDIrZoJs5KSuymQx6yxZ+Ik5TkGUP6KZZEhkICKy9nK6Tx/Nug2OgxKOhfCivIXe0hrbLd70IqWtypm4PDV8u6YB+uajtNrZY0r5166UZVFWYtn7eOj8OF2PqvWggsK82Mf+R2FykTH0p9NrnoR34h2eNrY4qtbi/J6MrJIGy54Ijuq9ywzV4CFSkJpqWyTezDOtPBJuD9qVNFVXavGYVpWEYGfxNwWYNJVlbNz9iXhWrKLdma4b6VYBJggQnkE53SLlXDuSt9o3BEPYkeWU1WTUhTLyZQosS527QbsigDaiM5Bn4C6Vp7un8Kz2A9j1VmAYV6SyxVivzTe83/2bU8WAORu8wCAfjCk9d9r0AeothIyiagZe9MAFBI9AiGEs5vnrmRgLRYHY7dg4DlpFzBKKucMGFLVLYu/olovrQ6cIfpqB2i7NArunn15Uu62MMhrAicZHUpp72OXT64u4VdOS15kiN8a8q7PjoP13r8IjaWQP9XR9ivAdThYDBbvJaGsCN8qduwa4ndwp7m/GG0c9V1SFo4nAlhI9RCAYkA+eoKIwtmROcgHZBXieOeNF/G3bIHmBAL5uPo2xZqyrvMpTice2lA==";
        String ab = AESUtil.decryptData(a,AESUtil.MD5("4567qwer53321ty444rewq87656uyt").toLowerCase());
        System.out.println(ab);
    }
}