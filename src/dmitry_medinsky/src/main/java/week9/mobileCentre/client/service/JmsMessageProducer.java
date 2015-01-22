package week9.mobileCentre.client.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.jms.*;

@Component
public class JmsMessageProducer {

    private static final Logger logger = LoggerFactory.getLogger(JmsMessageProducer.class);

    @Autowired
    private JmsTemplate template;

    @Autowired
    private Topic topic;

    @PostConstruct
    public void generateMessages() throws JMSException, InterruptedException {
        while (true){
            template.send(new MessageCreator() {
                public Message createMessage(Session session) throws JMSException {
                    TextMessage message = session.createTextMessage("HelloWorld");
                    return message;
                }
            });
            Thread.sleep(1000);
        }
    }
}
