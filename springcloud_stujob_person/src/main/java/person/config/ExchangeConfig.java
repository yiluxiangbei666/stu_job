package person.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExchangeConfig {


    /******************************************死信队列***************************************************/
    //exchange name
    public static final String DEFAULT_EXCHANGE = "buybookorderexchange";
    //DLX repeat QUEUE 死信转发队列
    public static final String DEFAULT_QUEUE_NAME = "buybookorderqueue";

    //信道配置
    @Bean
    public DirectExchange defaultExchange() {
        return new DirectExchange(DEFAULT_EXCHANGE, true, false);
    }

    @Bean
    public Queue repeatTradeQueue() {
        Queue queue = new Queue(DEFAULT_QUEUE_NAME,true,
                false,false);
        return queue;
    }

    @Bean
    public Binding drepeatTradeBinding() {
        return BindingBuilder.bind(repeatTradeQueue()).to(defaultExchange()).
                with(DEFAULT_QUEUE_NAME);
    }
}