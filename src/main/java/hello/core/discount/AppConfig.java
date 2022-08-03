package hello.core.discount;

import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig
{
    // @Bean memberService -> new MemoryMemberRepository()
    // @Bean orderService -> new MemoryMemberRepository()

    @Bean
    public MemberService memberService()
    {
        System.out.println("Call AppConfig.memberService");

        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository()
    {
        System.out.println("Call AppConfig.memberRepository");

        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService()
    {
        System.out.println("Call AppConfig.orderService");

//        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
        return new OrderServiceImpl(memberRepository(), discountPolicy());
//        return null;
    }

    @Bean
    public DiscountPolicy discountPolicy()
    {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}