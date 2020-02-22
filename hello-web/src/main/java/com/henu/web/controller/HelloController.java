package com.henu.web.controller;

import com.henu.kfk.KafkaSend;
import com.henu.service.IAreaService;
import com.henu.service.impl.AreaServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
public class HelloController {
    //@Autowired
    IAreaService areaService;
   // @Autowired
  //  KafkaSend kafkaSend;
   // @Autowired
   // KafkaTemplate<Integer, String> kafkaTemplate;

    public HelloController() {
        System.out.println("我被初始化了。。。。HelloController");
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        //KafkaSend kafkaSend = new KafkaSend();
       // kafkaSend.sendMsg("hello ....");
       // kafkaTemplate.send("HelloWorld", "mmsg");

        //通过request获取IOC容器，还可以通过配置文件获取ApplicationContext（这个容器是超级容器）
        WebApplicationContext webApplicationContext= ContextLoader.getCurrentWebApplicationContext();
                //WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
       areaService= webApplicationContext.getBean(AreaServiceImpl.class);
        return "" + areaService.queryByAreaId(1);
    }

    @RequestMapping("/test")
    @ResponseBody
    public ResponseEntity<String> test(HttpServletRequest request, HttpServletResponse response, Model model) {
       Enumeration headerNames=request.getHeaderNames();
       Map<String,String> headerMap=new HashMap<>();
       while (headerNames.hasMoreElements()){
           String key = (String) headerNames.nextElement();
           String value = request.getHeader(key);
           System.out.println(key+" : "+value);
           headerMap.put(key, value);
       }
       response.addHeader("JSESSIONID",UUID.randomUUID().toString().replaceAll("-","").toUpperCase());
       model.addAttribute("map",headerMap.toString());
      return new ResponseEntity<>(headerMap.toString(), HttpStatus.ACCEPTED);
    }
}
