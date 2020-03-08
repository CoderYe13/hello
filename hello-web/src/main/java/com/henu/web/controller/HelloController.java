package com.henu.web.controller;

import com.henu.entity.Area;
import com.henu.redis.util.RedisPoolUtil;
import com.henu.service.IAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
public class HelloController {
    @Autowired
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
       // WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
        //WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
       // areaService = webApplicationContext.getBean(AreaServiceImpl.class);
        return "" + areaService.queryByAreaId(1);
    }

    @RequestMapping("/test")
    @ResponseBody
    public ResponseEntity<String> test(HttpServletRequest request, HttpServletResponse response, Model model) {
        Enumeration headerNames = request.getHeaderNames();
        Map<String, String> headerMap = new HashMap<>();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            System.out.println(key + " : " + value);
            headerMap.put(key, value);
        }
        response.addHeader("JSESSIONID", UUID.randomUUID().toString().replaceAll("-", "").toUpperCase());
        model.addAttribute("map", headerMap.toString());
        return new ResponseEntity<>(headerMap.toString(), HttpStatus.ACCEPTED);
    }

    @RequestMapping("/test01")
    public String test01() {
        System.out.println("test01");
        return "redirect:/test02";
    }
    @RequestMapping(value = "/test02" ,method = RequestMethod.POST)
    public void test02() {
//        System.out.println(10/0);
        System.out.println("test02");
    }

    @RequestMapping(value = "/test03")
    @ResponseBody
    public String test03() {
        Map<Integer, Area>areaMap=areaService.queryAreaByMap();
        for(Map.Entry<Integer,Area> area :areaMap.entrySet()){
            System.out.println(area.getKey()+":"+area.getValue());
        }
        return "success";
    }
    @RequestMapping(value = "/test04")
    @ResponseBody
    public String test04() {
        Map<Integer, Area>areaMap=areaService.queryAreaByMap();
        for(Map.Entry<Integer,Area> area :areaMap.entrySet()){
            RedisPoolUtil.append("areaMap",area.getValue().toString());
        }
        return "success";
    }
}
