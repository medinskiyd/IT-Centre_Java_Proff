package week7.async.chat.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.jms.*;
import java.util.Scanner;

@Component
public class ClientMessageProducer {

    private static final Logger logger = LoggerFactory.getLogger(ClientMessageProducer.class);

    protected static final String MESSAGE_COUNT = "messageCount";

    @Autowired
    private JmsTemplate template;

    @Autowired
    private Queue fromClientToServer;

    private int messageCount = 3;

    private Scanner scan = new Scanner(System.in);
    /**
     * Generates JMS messages
     */
    @PostConstruct
    public void generateMessages() throws JMSException {
/*        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        while (true) {
            if(!scan.hasNextLine()) {
                return;
            }
            final String text = scan.nextLine();

            template.send(fromClientToServer,new MessageCreator() {
                public Message createMessage(Session session) throws JMSException {
                    TextMessage message = session.createTextMessage(text);
//                    message.setIntProperty(MESSAGE_COUNT, index);

                    System.out.printf("Sending message to " + fromClientToServer.getQueueName() +" : " + text + "\n");

                    return message;
                }
            });
        }
    }

}
