package week8.chat.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@Component("clientMessageListener")
public class ClientMessageListener implements MessageListener {

    private static final Logger logger = LoggerFactory.getLogger(ClientMessageListener.class);


    /**
     * Implementation of <code>MessageListener</code>.
     */
    public void onMessage(Message message) {
        try {

            if (message instanceof TextMessage) {
                TextMessage tm = (TextMessage)message;
                String msg = tm.getText();
                 tm.getIntProperty("messageCount");

                System.out.printf("<< Received from server message" + msg + "\n");
            } else {
                System.out.printf("Not text message");
            }
        } catch (JMSException e) {
            logger.error(e.getMessage(), e);
        }
    }


}