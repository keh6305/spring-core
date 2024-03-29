package hello.core.lifecycle;

import ch.qos.logback.classic.joran.action.ConfigurationAction;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest
{
    @Test
    public void lifeCycleTest()
    {
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);

        NetworkClient client = ac.getBean(NetworkClient.class);

        ac.close();
    }

    @Configuration
    static class LifeCycleConfig
    {
        // 초기화, 소멸 메소드 선언
//        @Bean(initMethod = "init", destroyMethod = "close")
//        public NetworkClient networkClient()
//        {
//            NetworkClient networkClient = new NetworkClient();
//            networkClient.setUrl("http://hello-spring.dev");
//
//            return networkClient;
//        }

        @Bean
        public NetworkClient networkClient()
        {
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev");

            return networkClient;
        }
    }
}