package AmAmAm.demo.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@Slf4j
@Controller
//@RequestMapping
public class IndexController {

    @GetMapping("/")
    public String index(Map<String, Object> model){
        model.put("key1", 15);
        return "index";
    }
    @GetMapping(value = "/check")
    public String check(String ans,  String ans2, Map<String, Object> model){
        log.info("Запрос: {}, {}",ans, ans2);
        if (ans.equals("4") && ans2.equals("10")){
            return "success";
        }else {
            model.put("right1", 4);
            model.put("right2", 10);
            return "error";
        }
    }
}

