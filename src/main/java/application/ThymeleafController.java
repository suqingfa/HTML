package application;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping("thymeleaf")
public class ThymeleafController
{
    private static final String PREFIX = "/thymeleaf/";

    @GetMapping({"", "index"})
    public String index(Model model)
    {
        model.addAttribute("dateTime", LocalDateTime.now());
        model.addAttribute("list", new int[]{1, 2, 3, 4, 5});
        return PREFIX + "index";
    }
}
