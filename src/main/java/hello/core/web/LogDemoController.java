package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController
{
    private final LogDemoService logDemoService;
    private final MyLogger myLogger;
//    private final ObjectProvider<MyLogger> myLoggerProvider;

    @ResponseBody
    @RequestMapping("log-demo")
    public String logDemo(HttpServletRequest request) throws InterruptedException
    {
        System.out.println("myLogger = " + myLogger.getClass());

//        MyLogger myLogger = myLoggerProvider.getObject();

        String requestURL = request.getRequestURL().toString();

        myLogger.setRequestURL(requestURL);
        myLogger.log("controller test");

        Thread.sleep(100);

        logDemoService.logic("testId");

        return "OK";
    }
}