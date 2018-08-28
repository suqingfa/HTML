package application;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping
public class IndexController
{
    @GetMapping("")
    public String index()
    {
        return "index";
    }

    @GetMapping("image.svg")
    public void image(@Valid ImageInput input, ServletResponse response) throws IOException
    {
        response.setContentType("image/svg+xml");

        PrintWriter writer = response.getWriter();

        writer.format("<svg width=\"%d\" height=\"%d\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 %d %d\" preserveAspectRatio=\"none\">\n" +
                        "    <defs>\n" +
                        "        <style type=\"text/css\">#holder_1657fbb2c16 text {\n" +
                        "            fill:rgba(255,255,255,.75);font-weight:normal;font-family:Helvetica, monospace;font-size:10pt }\n" +
                        "        </style>\n" +
                        "    </defs>\n" +
                        "    <g id=\"holder_1657fbb2c16\">\n" +
                        "        <rect width=\"%d\" height=\"%d\" fill=\"#%d\"></rect>\n" +
                        "        <g>\n" +
                        "            <text x=\"%d\" y=\"%d\">%s</text>\n" +
                        "        </g>\n" +
                        "    </g>\n" +
                        "</svg>",
                input.getW(), input.getW(),
                input.getW(), input.getH(),
                input.getW(), input.getH(),
                input.getFg(),
                (input.getW() - 50) / 2, (input.getH() - 10) / 2, input.getText());

        writer.flush();
    }

    @Getter
    @Setter
    @Validated
    public static class ImageInput
    {
        private int w = 200;
        private int h = 200;
        private int fg = 777;
        private String text = "image";
    }
}
