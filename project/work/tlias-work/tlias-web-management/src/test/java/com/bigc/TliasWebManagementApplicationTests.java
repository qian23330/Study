package com.bigc;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class TliasWebManagementApplicationTests {

    @Test
    void contextLoads() {
    }

    /**
     * JWT 生成
     */
    // @Test
    public void testGenJwt() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("name", "ql");
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "bigc") // 签名算法
                .setClaims(claims) // 自定义内容(载荷)
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000)) // 设置有效期
                .compact();
        System.out.println(jwt);
    }

    // @Test
    public void testParseJwt() {
        Claims claims = Jwts.parser()
                .setSigningKey("bigc")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoicWwiLCJpZCI6MSwiZXhwIjoxNzAxNDI5NjU2fQ.Rw-7hXp_z_vI5yranZjjv4qzyx4PhfQnJlSuZlB3BCM")
                .getBody();
        System.out.println(claims);
    }

    @Autowired
    private SAXReader saxReader;

    @Test
    public void testThirdBean() throws DocumentException {
        // SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(this.getClass().getClassLoader().getResource("1.xml"));
        Element rootElement = document.getRootElement();
        String name = rootElement.element("name").getText();
        String age = rootElement.element("age").getText();
        System.out.println(name + ":" + age);
    }

}
