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
        String t = "<div class=\\\"story-container container rem_init\\\">\n" +
                "她那天早晨起的很早，在床边坐了很久的时间，大女儿叫了好几遍也没有理会，用完早餐，她叫住64岁的大女儿，说出了埋在自己心底已久的愿望。<br />\n" +
                "<br />\n" +
                "“我想去一次梵蒂冈。”<br />\n" +
                "<br />\n" +
                "母亲突然地这样一句话，已经64岁的大女儿却并不感到惊讶。想要去看一眼这座上帝的国度，为自己一辈子的信仰做一个最后的总结，母亲的心愿很简单，也很坚定。<br />\n" +
                "<br />\n" +
                "大女儿放下正要准备洗的碗筷，想了很久，给在大城市工作的儿子打了电话，大女儿问儿子，该怎么办？<br />\n" +
                "<br />\n" +
                "儿子说，砸锅卖铁，也要满足姥姥的心愿。<br />\n" +
                "<br />\n" +
                "但却并没有那么简单。儿子一家旅行社一家旅行社的去问，得到的却是一次次的拒绝。87岁了，身体撑不住怎么办？农村户口+白本，签证下不来怎么办？再说了，根本就没有适合的旅行产品，总不能单独为老奶奶研发一条吧！<br />\n" +
                "<br />\n" +
                "后来，儿子发了狠，直接买了机票来北京想办法。<br />\n" +
                "<br />\n" +
                "<p>\n" +
                "\t再后来，二零一四年九月二日，星期二，飞往罗马的SU3202次班机缓缓的降落在菲乌米奇诺机场，她的第一次旅行，也是最后一次旅行，便在亚平宁半岛热烈的阳光下，拉开了帷幕。\n" +
                "</p>\n" +
                "<p>\n" +
                "\t<img src=\"http://47.106.250.195:80/customer_story/detail/story1/story1_1.jpg\" alt=\"\" /> \n" +
                "</p>\n" +
                "<p>\n" +
                "\t<br />\n" +
                "</p>\n" +
                "<p>\n" +
                "\t奶奶人生中第一次坐飞机，长途飞行的疲劳，并不能削弱奶奶的好奇与期待。\n" +
                "</p>\n" +
                "<p>\n" +
                "\t<br />\n" +
                "</p>\n" +
                "<p>\n" +
                "\t<img src=\"http://47.106.250.195:80/customer_story/detail/story1/story1_2.jpg\" alt=\"\" /> \n" +
                "</p>\n" +
                "<p>\n" +
                "\t奶奶体力不好，下了飞机立刻就要坐上提前预约好的轮椅，方便奶奶出行\n" +
                "</p>\n" +
                "<p>\n" +
                "\t<br />\n" +
                "</p>\n" +
                "<p>\n" +
                "\t<img src=\"http://47.106.250.195:80/customer_story/detail/story1/story1_3.jpg\" alt=\"\" /> \n" +
                "</p>\n" +
                "<p>\n" +
                "\t但你说这是你生命中最踏实的一段时光\n" +
                "</p>\n" +
                "<p>\n" +
                "\t<img src=\"http://47.106.250.195:80/customer_story/detail/story1/story1_4.jpg\" alt=\"\" /> \n" +
                "</p>\n" +
                "<p>\n" +
                "\t其实，陪伴你的这些天，也是我生命中最光荣的时刻。愿你永远健康，坚定。\n" +
                "</p>\n" +
                "<div class=\"aurora-theme pc-bottom-form\" style=\"border:0px;margin:0px;padding:0px;color:#333333;font-family:&quot;font-size:14px;background-color:#F0F0F0;\">\n" +
                "\t<div class=\"bg-mask\" style=\"border:0px;margin:0px auto;padding:0px;\">\n" +
                "\t\t<div class=\"form_text_wrapper\" style=\"border:0px;margin:0px;padding:0px 40px;\">\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "</div>\n" +
                "<p>\n" +
                "\t<br />\n" +
                "</p>\n" +
                "<p>\n" +
                "\t<br />\n" +
                "</p>\n" +
                "<p>\n" +
                "\t<br />\n" +
                "</p>\n" +
                "</div>";
        System.out.println(JSON.toJSONString(t.replaceAll("\n","").replaceAll("\t","")));
    }
}
