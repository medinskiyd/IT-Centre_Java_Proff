package week9.mobileCentre.client.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@Component("jmsMessageListener")
public class JmsMessageListener implements MessageListener {

    private static final Logger logger = LoggerFactory.getLogger(JmsMessageListener.class);

    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
                TextMessage tm = (TextMessage)message;
                String msg = tm.getText();
                System.out.printf("Message:" + msg + "\n");
            } else {
                System.out.printf("Not text message");
            }
        } catch (JMSException e) {
            logger.error(e.getMessage(), e);
        }
    }
}