package com.example.lchms.Controllder;

import com.example.lchms.Result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author kuangfeng
 * @date 2020-10-09 14:21
 */
@Controller
@RequestMapping("miaosha")
public class MiaoShaController {
    @RequestMapping("/do_miaosha")
    @ResponseBody
    public String list(){
        return "去秒杀";
    }
}
