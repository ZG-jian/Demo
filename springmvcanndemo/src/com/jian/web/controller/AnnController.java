package com.jian.web.controller;

import com.jian.pojo.Address;
import com.jian.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
//http://localhost:8080/srpingmvcanndemo/suibian/ann
@RequestMapping("/suibian")//在类上的意思就是，请求这个控制器的所以URI时，前面都要加/suibian前缀
public class AnnController {

    //http://localhost:8080/srpingmvcanndemo/ann
    @RequestMapping("/ann")//给定URI
    public ModelAndView annDemo() {
        ModelAndView modelAndView = new ModelAndView();
        //设置跳转
        modelAndView.setViewName("/index.jsp");
        modelAndView.addObject("msg", "Hello Jian");
        return modelAndView;
    }

    /**
     * springMVC会帮我们自动注入这个request对象
     *
     * @return
     */
    @RequestMapping("/getData")
    public ModelAndView getRequestParameter(HttpServletRequest request) {
        String username = request.getParameter("name");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index.jsp");
        modelAndView.addObject("username", username);
        return modelAndView;
    }
    //springMVC在做参数注入时会自动帮我们做类型转换
    //在请求当中的数据，请求参数，都是字符串类型的，这里用户年龄我们用int存放测试自动类型转换

    /**
     * 通过SpringMVC参数注入方式获取请求参数-注入多参数
     *
     * @param username
     * @param userage
     * @return
     */
    @RequestMapping("/addUsers")
    public ModelAndView addUsers(String username, int userage) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index.jsp");//设置视图名称
        modelAndView.addObject("name", username);
        modelAndView.addObject("age", userage);
        return modelAndView;
    }

    /*
    @RequestParam的value属性就是来指定请求参数的key的
    这样springMVC就知道了原来你是需要把请求参数当中的name这个key的值注入到String类型的username这个参数当中
    age也一样    @RequestParam(value = "name",required = true)当required给了true后，请求时如果没有给这个参数，就会报400错误，false的话没有也没问题  defaultValue:没给默认值，会让required失效变为false
     */
    @RequestMapping("/addUsers2")
    public ModelAndView addUsers2(@RequestParam(value = "name", required = true, defaultValue = "JianJianBaoBao") String username, @RequestParam("age") int userage) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index.jsp");//设置视图名称
        modelAndView.addObject("name", username);
        modelAndView.addObject("age", userage);
        return modelAndView;
    }

    @RequestMapping("/addUsers3")
    //这里就跟jsp里的参数名一样不用注解了
    public ModelAndView addUsers3(String username, @RequestParam List<String> userlike) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index.jsp");//设置视图名称
        modelAndView.addObject("name", username);
        String temp = "";
        for (String str : userlike
        ) {
            temp += str + " ";
        }
        //因为在项目中没有加JSTL标签库，所以不能用c标签下的foreach循环数组，所以拼一个字符串传过去来展示
        modelAndView.addObject("userlike", temp);
        return modelAndView;
    }

    @RequestMapping("/addUsers4")
    public ModelAndView addUsers4(Users users) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index.jsp");//设置视图名称
        modelAndView.addObject("name", users.getUsername());
        String temp = "";
        for (String str : users.getUserlike()
        ) {
            temp += str + " ";
        }
        modelAndView.addObject("userlike", temp);
        return modelAndView;
    }

    @RequestMapping("/addUsers5")
    public ModelAndView addUsers5(Users users) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index.jsp");
        modelAndView.addObject("user", users.toString());
        modelAndView.addObject("address", users.getAddress().toString());
        return modelAndView;
    }

    @RequestMapping("/addUsers6")
    public ModelAndView addUsers6(Users users) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index.jsp");
        modelAndView.addObject("user", users.toString());
        modelAndView.addObject("address", users.getAddressList());
        return modelAndView;
    }

   // @RequestMapping(value = "/addUsers7",method = RequestMethod.POST)
   // @GetMapping("/addUsers7")//有个name属性绑定URI到这个方法上
    @PostMapping("/addUsers7")//也有一个name属性绑定URI
    @DeleteMapping
    @PutMapping
    public ModelAndView addUsers7(Users users) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index.jsp");
        modelAndView.addObject("user", users.toString());
        Set<Map.Entry<String , Address>> set = users.getAddressMap().entrySet();
        modelAndView.addObject("address", set);
        return modelAndView;
    }
}
