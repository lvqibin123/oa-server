package com.lvqibin.oa.common.JWT;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
 
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
 
/**
 * APP登录Token的生成和解析
 * 
 */
public class JwtToken {
 
	/** token秘钥，请勿泄露，请勿随便修改 backups:JKKLJOoasdlfj */
	public static final String SECRET = "OA_SYS";
	/** token 过期时间: 1天 */
	public static final int calendarField = Calendar.DATE;
	public static final int calendarInterval = 1;
 
	/**
	 * JWT生成Token.<br/>
	 * 
	 * JWT构成: header, payload, signature
	 * 
	 * @param CodeHelp user
	 */
	public static String createToken(String id ,String name,String loginName,String password) throws Exception {
		Date iatDate = new Date();
		// expire time
		Calendar nowTime = Calendar.getInstance();
		nowTime.add(calendarField, calendarInterval);
		Date expiresDate = nowTime.getTime();
 
		// header Map
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("alg", "HS256");
		map.put("typ", "JWT");
		// build token
		// param backups {iss:Service, aud:APP}
		
		String token = JWT.create().withHeader(map) // header
				.withClaim("iss", "Service") // payload
				.withClaim("aud", "APP")
				.withClaim("id", id)
				.withClaim("password", password)
				.withClaim("username", name)
				.withClaim("loginName", loginName)
				.withIssuedAt(iatDate) // sign time
				.withExpiresAt(expiresDate) // expire time
				.sign(Algorithm.HMAC256(SECRET)); // signature
 
		return token;
	}
 
	/**
	 * 解密Token
	 * 
	 * @param token
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Claim> verifyToken(String token) {
		DecodedJWT jwt = null;
		try {
			JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
			jwt = verifier.verify(token);
		} catch (Exception e) {
			// e.printStackTrace();
			// token 校验失败, 抛出Token验证非法异常
			return null;
		}
		return jwt.getClaims();
	}
 
	/**
	 * 校验token
	 * 
	 * @param token
	 * @param CodeHelp user
	 * @return boolean
	 */
	public static boolean isVerify(String token, String loginName, String password) {
		Map<String, Claim> claims = verifyToken(token);
		if(claims!=null) {
			if (claims.get("password").asString().equals(password)&&claims.get("loginName").asString().equals(loginName)) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
}

