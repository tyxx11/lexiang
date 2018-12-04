package com.lexiang.test;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

public class TestString {

    @Test
    public void test(){
        String a = "{qweqwewq\"qqqq\"ss}";
        System.out.println(JSON.toJSONString(a));
        System.out.println(JSON.toJSONString(a).replaceAll("\\\\\"","\""));
    }

    @Test
    public void toJson(){
        String t = "<div>\n" +
                "\t<div>\n" +
                "\t\t<div class=\"xc-img-b\">\n" +
                "\t\t\t<img src=\"./images/jhabout.a8ae0c4.png\" class=\"xc-img-icon\" /> \n" +
                "\t\t</div>\n" +
                "\t\t<div style=\"color:#AF0102;font-weight:bold;font-size:14px;\">\n" +
                "\t\t\t<strong>上午主题：滑雪体验<br />\n" +
                "<br />\n" +
                "下午主题：返回之旅&amp;继续滑雪<br />\n" +
                "<strong><span style=\"font-family:-apple-system-font, BlinkMacSystemFont, &quot;font-size:14px;background-color:#FFFFFF;\"></span></strong></strong><strong><strong><strong></strong></strong></strong><strong><strong><strong><strong><strong><strong><strong><strong><strong><strong><strong><strong><strong><strong><strong><strong><strong></strong></strong></strong></strong></strong></strong></strong></strong></strong></strong></strong></strong></strong></strong></strong></strong></strong> \n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "\t<p>\n" +
                "\t\t<p>\n" +
                "\t\t\t<br />\n" +
                "\t\t</p>\n" +
                "\t\t<p>\n" +
                "\t\t\t<span style=\"color:#333333;\"><span style=\"font-family:-apple-system-font, BlinkMacSystemFont, &quot;font-size:14px;background-color:#FFFFFF;color:#337FE5;\"><strong> </strong></span></span> \n" +
                "\t\t</p>\n" +
                "\t\t<p style=\"color:#3F3F3F;font-family:-apple-system-font, BlinkMacSystemFont, &quot;font-size:14px;text-align:justify;background-color:#FFFFFF;\">\n" +
                "\t\t\t<strong><span style=\"color:#3F3F3F;font-family:-apple-system-font, BlinkMacSystemFont, &quot;font-size:14px;background-color:#FFFFFF;\"> </span></strong> \n" +
                "\t\t</p>\n" +
                "\t\t<p style=\"color:#3F3F3F;font-family:-apple-system-font, BlinkMacSystemFont, &quot;font-size:14px;text-align:justify;background-color:#FFFFFF;\">\n" +
                "\t\t\t<strong><span style=\"color:#3F3F3F;font-family:-apple-system-font, BlinkMacSystemFont, &quot;font-size:14px;background-color:#FFFFFF;\">前往罗瓦涅米机场，搭乘航班返回温馨的家。</span></strong>\n" +
                "\t\t</p>\n" +
                "\t\t<p style=\"color:#3F3F3F;font-family:-apple-system-font, BlinkMacSystemFont, &quot;font-size:14px;text-align:justify;background-color:#FFFFFF;\">\n" +
                "\t\t\t<strong><span style=\"color:#3F3F3F;font-family:-apple-system-font, BlinkMacSystemFont, &quot;font-size:14px;background-color:#FFFFFF;\"><br />\n" +
                "如果希望延长滑雪的家长小朋友，我们还可以留在营地继续体验滑雪的乐趣。<br />\n" +
                "<br />\n" +
                "</span></strong> \n" +
                "\t\t</p>\n" +
                "\t\t<div>\n" +
                "\t\t</div>\n" +
                "\t</p>\n" +
                "</div>";
        String t2 = "<div>\n" +
                "\t<div>\n" +
                "\t\t<div class=\"xc-img-b\">\n" +
                "\t\t\t<img src=\"./images/jhabout.a8ae0c4.png\" class=\"xc-img-icon\" /> \n" +
                "\t\t</div>\n" +
                "\t\t<div style=\"color:#AF0102;font-weight:bold;font-size:14px;\">\n" +
                "\t\t\t&nbsp;<strong><strong>下午主题：滑雪营地</strong></strong><strong><strong><strong><strong><strong><strong><strong><strong><strong><strong><strong><strong><strong><strong><strong><strong><strong></strong></strong></strong></strong></strong></strong></strong></strong></strong></strong></strong></strong></strong></strong></strong></strong></strong> \n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "\t<div class=\"xcleft\">\n" +
                "\t\t<p>\n" +
                "\t\t\t<br />\n" +
                "\t\t</p>\n" +
                "\t\t<p>\n" +
                "\t\t\t<span style=\"color:#333333;\"><span style=\"font-family:-apple-system-font, BlinkMacSystemFont, &quot;font-size:14px;background-color:#FFFFFF;color:#337FE5;\"><strong> </strong></span></span> \n" +
                "\t\t</p>\n" +
                "\t\t<p style=\"color:#3F3F3F;font-family:-apple-system-font, BlinkMacSystemFont, &quot;font-size:14px;text-align:justify;background-color:#FFFFFF;\">\n" +
                "\t\t\t<strong><span style=\"color:#3F3F3F;font-family:-apple-system-font, BlinkMacSystemFont, &quot;font-size:14px;background-color:#FFFFFF;\"> </span></strong> \n" +
                "\t\t</p>\n" +
                "\t\t<p style=\"color:#3F3F3F;font-family:-apple-system-font, BlinkMacSystemFont, &quot;font-size:14px;text-align:justify;background-color:#FFFFFF;\">\n" +
                "\t\t\t<strong><span style=\"color:#3F3F3F;font-family:-apple-system-font, BlinkMacSystemFont, &quot;font-size:14px;background-color:#FFFFFF;\">Syote营地是由芬兰教育部批准的芬兰10个青年中心之一。营地宗旨是促进芬兰和国际青少年的成长和发展。20多年来， Syote国际青年和夏令营中心为各年龄段的学生们安排了各种各样的活动。例如芬兰学生最热门的神奇北极山夏令营和以加强技能为目标的奥特培训等冬夏令营也深受芬兰和国际学生的欢迎。<br />\n" +
                "</span></strong> \n" +
                "\t\t</p>\n" +
                "\t\t<div>\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "</div>";
        String t3 = "<div>\n" +
                "\t<div>\n" +
                "\t\t<div class=\"xc-img-b\">\n" +
                "\t\t\t<img src=\"./images/jhabout.a8ae0c4.png\" class=\"xc-img-icon\" /> \n" +
                "\t\t</div>\n" +
                "\t\t<div style=\"color:#AF0102;font-weight:bold;font-size:14px;\">\n" +
                "\t\t\t&nbsp;<strong><strong><strong>晚上体验：营地晚会</strong></strong></strong>\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "\t<div class=\"xcleft\">\n" +
                "\t\t<p style=\"color:#3F3F3F;font-family:-apple-system-font, BlinkMacSystemFont, &quot;font-size:14px;text-align:justify;background-color:#FFFFFF;\">\n" +
                "\t\t\t<br />\n" +
                "\t\t</p>\n" +
                "\t\t<div>\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "</div>";
        System.out.println(JSON.toJSONString(t.replaceAll("\n","").replaceAll("\t","")));
        System.out.println(JSON.toJSONString(t2.replaceAll("\n","").replaceAll("\t","")));
        System.out.println(JSON.toJSONString(t3.replaceAll("\n","").replaceAll("\t","")));

    }
}
