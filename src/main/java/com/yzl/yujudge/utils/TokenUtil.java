package com.yzl.yujudge.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yuzhanglong
 * @date 2020-08-03 16:24:53
 * @description token相关工具类
 */

public class TokenUtil {
    /**
     * @param userId    用户id
     * @param expiredIn 在expiredIn秒后到期
     * @param secretKey 验证密钥
     * @return String 生成的token
     * @author yuzhanglong
     * @date 2020-08-03 16:25:22
     * @description 传入userId。生成对应的token
     */
    public static String generateAuthToken(String userId, String secretKey, Integer expiredIn) {
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        Map<String, Date> map = calculateExpiredInfo(expiredIn);
        return JWT.create()
                .withClaim("userId", userId)
                .withExpiresAt(map.get("expiredIn"))
                .withIssuedAt(map.get("now"))
                .sign(algorithm);
    }

    /**
     * @param expiredIn 到期时间
     * @return map 返回一系列kv对，具体内容查看 @description
     * @author yuzhanglong
     * @date 2020-08-03 16:25:37
     * @description 处理token中时间相关信息，这包括：
     * now: 当前时间
     * expiredIn: 过期时间
     */
    public static Map<String, Date> calculateExpiredInfo(Integer expiredIn) {
        Map<String, Date> map = new HashMap<>(2);
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        calendar.add(Calendar.SECOND, 10);
        map.put("now", now);
        map.put("expiredIn", calendar.getTime());
        return map;
    }

    /**
     * @param token     用户传入的token
     * @param secretKey 验证密钥
     * @return boolean token是否验证通过
     * @author yuzhanglong
     * @date 2020-08-03 16:27:16
     * @description 检测传入的token是否合法、正确
     */
    public static Boolean checkAuthToken(String token, String secretKey) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            JWTVerifier jwtVerifier = JWT.require(algorithm).build();
            DecodedJWT decodedJwt = jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            return false;
        }
        return true;
    }
}
