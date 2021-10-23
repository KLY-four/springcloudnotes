package springcloudalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class SentienlController {

    /**
     * 对最新版的sentinel来说，经自测，@SentinelResource似乎只在热点key下才有效。
     *
     * 该注解熔断规则就是web上面配的，降级处理由fallback来配置(也就是程序要是有异常了，会走兜底方法)
     * 该属性自测不生效
     * 由于视频上版本问题，目前这里最新版本很多都不生效，需要后期处理
     * */

    @RequestMapping("/test")
    @SentinelResource(value="/test",blockHandler = "de1",fallback = "de2")
    public String de(@RequestParam("id") Integer id) throws InterruptedException {
        int a=1/0;
        return "test sentienl";
    }

    public String de1(Integer id,BlockException exception){
        return "兜底";
    }

    public String de2(Integer id,BlockException exception){
        return "运行异常";
    }
}
