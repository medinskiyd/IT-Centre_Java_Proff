package week9.chat.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.jms.*;
import java.util.Scanner;

@Component("messageListener")
public class JmsMessageListener implements MessageListener {

    private static final Logger logger = LoggerFactory.getLogger(JmsMessageListener.class);
    protected static final String MESSAGE_COUNT = "messageCount";

    @Autowired
    private JmsTemplate template;

    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
                TextMessage tm = (TextMessage)message;
                String msg = tm.getText();
                 tm.getIntProperty("messageCount");

                System.out.printf("Processed message" + msg + "\n");
            } else {
                System.out.printf("Not text message");
            }
        } catch (JMSException e) {
            logger.error(e.getMessage(), e);
        }
    }

    @PostConstruct
    public void generateMessages() throws JMSException {
/*        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        Scanner scan = new Scanner(System.in);
        final String text = scan.nextLine();

        template.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                TextMessage message = session.createTextMessage(text);
                message.setIntProperty(MESSAGE_COUNT, 1);

                //System.out.printf("Sending message to " + dest1.getQueueName() +" : " + text + "\n");

                return message;
            }
        });
    }


}