package com.bigc;


import com.bigc.dao.DiscussPostMapper;
import com.bigc.dao.LoginTicketMapper;
import com.bigc.dao.MessageMapper;
import com.bigc.dao.elasticsearch.DiscussPostRepository;
import com.bigc.pojo.DiscussPost;
import com.bigc.pojo.LoginTicket;
import com.bigc.pojo.Message;
import com.bigc.utils.MailClient;
import com.bigc.utils.SensitiveFillter;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;

import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class CommunityApplicationTests {


    @Autowired
    private DiscussPostMapper discussPostMapper;
    @Test
    public void testSelectPosts() {
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(0, 0, 10, 0);
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

    @Autowired
    private MessageMapper messageMapper;
    @Test
    public void testSelectLetters() {
        List<Message> messages = messageMapper.selectConversations(111, 0, 20);
        for (Message message : messages) {
            System.out.println(message);
        }
    }

    // Redis
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testStrings() {
        String rediskey = "test:count";
        redisTemplate.opsForValue().set(rediskey, 1);
        System.out.println(redisTemplate.opsForValue().get(rediskey));
        System.out.println(redisTemplate.opsForValue().increment(rediskey));
        System.out.println(redisTemplate.opsForValue().decrement(rediskey));

    }

    @Test
    public void testHashes() {
        String rediskey = "test:user";
        redisTemplate.opsForHash().put(rediskey, "id", "1");
        redisTemplate.opsForHash().put(rediskey, "username", "qianlong");

        System.out.println(redisTemplate.opsForHash().get(rediskey, "id"));
        System.out.println(redisTemplate.opsForHash().get(rediskey, "username"));
    }

    @Test
    public void testLists() {
        String redisKey = "test:ids";

        redisTemplate.opsForList().leftPush(redisKey, 101);
        redisTemplate.opsForList().leftPush(redisKey, 102);
        redisTemplate.opsForList().leftPush(redisKey, 103);

        System.out.println(redisTemplate.opsForList().size(redisKey));
        System.out.println(redisTemplate.opsForList().index(redisKey, 0));
        System.out.println(redisTemplate.opsForList().range(redisKey, 0, 2));

        System.out.println(redisTemplate.opsForList().leftPop(redisKey));
        System.out.println(redisTemplate.opsForList().leftPop(redisKey));
        System.out.println(redisTemplate.opsForList().leftPop(redisKey));
    }

    @Test
    public void testSets() {
        String redisKey = "test:teachers";
        redisTemplate.opsForSet().add(redisKey, "q1", "q2", "q3", "q4");

        System.out.println(redisTemplate.opsForSet().size(redisKey));
        System.out.println(redisTemplate.opsForSet().pop(redisKey));
        System.out.println(redisTemplate.opsForSet().members(redisKey));
    }

    @Test
    public void testSortedSets() {
        String redisKey = "test:students";
        redisTemplate.opsForZSet().add(redisKey, "s1", 60);
        redisTemplate.opsForZSet().add(redisKey, "s2", 80);
        redisTemplate.opsForZSet().add(redisKey, "s3", 90);
        redisTemplate.opsForZSet().add(redisKey, "s4", 75);

        System.out.println(redisTemplate.opsForZSet().zCard(redisKey));
        System.out.println(redisTemplate.opsForZSet().score(redisKey, "s3"));
        System.out.println(redisTemplate.opsForZSet().reverseRank(redisKey, "s3"));
        System.out.println(redisTemplate.opsForZSet().range(redisKey, 0, 2));
    }

    @Test
    public void testKeys() {
        redisTemplate.delete("test:user");
        System.out.println(redisTemplate.hasKey("test:user"));
        redisTemplate.expire("test:students", 10, TimeUnit.SECONDS);
    }

    @Test
    public void testBoundOperations() {
        String redisKey = "test:count";
        BoundValueOperations opsForValue = redisTemplate.boundValueOps(redisKey);
        opsForValue.increment();
        System.out.println(opsForValue.get());
    }

    // 编程式事务
    @Test
    public void testTransactional() {
        Object obj = redisTemplate.execute(new SessionCallback() {
            @Override
            public Object execute(RedisOperations operations) throws DataAccessException {
                String redisKey = "test:tx";

                operations.multi();

                operations.opsForSet().add(redisKey, "s1");
                operations.opsForSet().add(redisKey, "s2");
                operations.opsForSet().add(redisKey, "s3");

                return operations.exec();

            }

        });
        System.out.println(obj);
    }

    // Kafka
    @Autowired
    private KafkaProducer kafkaProducer;
    @Test
    public void testKafka() {
        kafkaProducer.sendMessage("test", "Hello, Kafka!");
        kafkaProducer.sendMessage("test", "Hello, QL!");

        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


@Component
class KafkaProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void sendMessage(String topic, String content) {
        kafkaTemplate.send(topic, content);
    }
}

@Component
class KafkaConsumer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @KafkaListener(topics = {"test"}, groupId =  "community-consumer-group")
    public void handleMessage(ConsumerRecord record) {
        System.out.println(record.value());
    }

    }

}
