package com.bigc;

import com.bigc.mapper.DiscussPostMapper;
import com.bigc.mapper.LoginTicketMapper;
import com.bigc.pojo.DiscussPost;
import com.bigc.pojo.LoginTicket;
import com.bigc.utils.MailClient;
import com.bigc.utils.SensitiveFillter;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.StringWriter;
import java.util.Date;
import java.util.List;

@SpringBootTest
class CommunityApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private DiscussPostMapper discussPostMapper;
    @Test
    public void testSelectPosts() {
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(0, 0, 10);
        for (DiscussPost post : list) {
            System.out.println(post);
        }

        int rows = discussPostMapper.selectDiscussPostRows(149);
        System.out.println(rows);
    }

    private static final Logger logger = LoggerFactory.getLogger(CommunityApplicationTests.class);
    @Test
    public void testLogger() {
        System.out.println(logger.getName());

        logger.debug("debug log");
        logger.info("info log");
        logger.warn("warn log");
        logger.error("error log");
    }

    @Autowired
    private MailClient mailClient;
    @Test
    public void testTextMail() {
        mailClient.sendMail("ql18092264121@sina.com", "TEST", "Welcome.");
    }

    @Autowired
    private TemplateEngine templateEngine;
    @Test
    public void testHtmlMail() {
        Context context = new Context();
        context.setVariable("username", "sunday");

        String content = templateEngine.process("/mail/demo", context);
        System.out.println(content);

        mailClient.sendMail("ql18092264121@sina.com", "HTML", content);
    }

    @Autowired
    private LoginTicketMapper loginTicketMapper;

    @Test
    public void testInsertLoginTicket() {
        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setUserId(101);
        loginTicket.setTicket("abc");
        loginTicket.setStatus(0);
        loginTicket.setExpired(new Date(System.currentTimeMillis() + 1000 * 60 * 10));

        loginTicketMapper.insertLoginTicket(loginTicket);
    }


    @Autowired
    private SensitiveFillter sensitiveFillter;

    @Test
    public void testSensitiveFilter() {
        String text = "这里可以$赌$博$，可以x嫖x娼x，可以吸毒，可以开票。哈哈哈";
        text = sensitiveFillter.filter(text);
        System.out.println(text);
    }

}
