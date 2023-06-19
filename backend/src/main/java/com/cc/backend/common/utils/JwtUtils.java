package com.cc.backend.common.utils;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.alibaba.fastjson.JSON;
import com.cc.backend.dao.entity.SysUser;

import java.util.Date;
import java.util.UUID;

public class JwtUtils {

    // 秘钥
    private static final String SECRET_KEY = "FENG_YE_LIN_C";

    /*获取签发的token，返回给前端*/
    public static String generTokenByRS256(Object t) throws Exception{
        RSA256Key rsa256Key = SecretKeyHelper.getRSA256Key(); // 获取公钥/私钥
        Algorithm algorithm = Algorithm.RSA256(
                rsa256Key.getPublicKey(),rsa256Key.getPrivateKey());
        return createToken(algorithm, t);
    }

    /**
     * 生成JWT token
     * @return token
     */
    public static String createToken(Algorithm algorithm,Object t) {
        String[] audience  = {"app"};
        return JWT.create()
                .withIssuer(SECRET_KEY)   		//发布者
                .withAudience(audience)     //观众，相当于接受者
                .withIssuedAt(new Date())   // 生成签名的时间
//                .withExpiresAt(DateHelper.addMinute(new Date(),30))// 生成签名的有效期
                .withClaim("data", JSON.toJSONString(t)) //存数据
                .withNotBefore(new Date())  //生效时间
                .withJWTId(UUID.randomUUID().toString())    //编号
                .sign(algorithm);							//签入
    }

    /*验证token*/
    public static DecodedJWT verifierToken(String token)throws Exception{
        RSA256Key rsa256Key = SecretKeyHelper.getRSA256Key(); // 获取公钥/私钥
        //其实按照规定只需要传递 publicKey来校验即可,这可能是auth0 的缺点
        Algorithm algorithm = Algorithm.RSA256(rsa256Key.getPublicKey(), rsa256Key.getPrivateKey());
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer(SECRET_KEY)
                .build(); //Reusable verifier instance 可复用的验证实例
        return verifier.verify(token);
    }


    public static SysUser getUserInfo(String token) throws Exception {
        DecodedJWT jwt = verifierToken(token);
        return JSON.parseObject(jwt.getClaim("data").asString(), SysUser.class);
    }


}
