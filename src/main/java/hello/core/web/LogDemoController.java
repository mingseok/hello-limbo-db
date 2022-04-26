package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {


    private final LogDemoService logDemoService;
    private final MyLogger myLogger;


    @RequestMapping("log-demo") //log-demo 라는 요청이 오면 동작.
    @ResponseBody
    public String logDemo(HttpServletRequest request) {

        // 고객이 어떤 URL로 요청했는지 알 수 있다.
        String requestURL = request.getRequestURI().toString();

        // url 정보까지 넣어 주는 것이다.
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";
    }

}
