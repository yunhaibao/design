public class PhaMessage {
    public static void main(String[] args) {
        System.out.println(PhaMessage.Msg("U00001","H000001","SUBSCRIPT%IsExistType+3~PHA.SYS.ComDict.Save.1 ~DHCSTSCDI(0,\"TYPE\",\"\")"));
//        中文唯一弊端就是不通用, 如果不会中文的人翻译中文的字典时, 将完全不能理解也难以区分, 如同我们看韩文日文, 字母+数字,才是最通用且容易识别的
//        x 因此中文的方式, 不适合
//        System.out.println(PhaMessage.Msg("代码重复","",""));
//        
//        相比中文, 如下英文的方式较为通用, 也有使用的, 如intersystems 的错误代码
//        @link http://localhost:57772/csp/docbook/DocBook.UI.Page.cls?KEY=RERR_tsql
//        System.out.println(PhaMessage.Msg("code is null","",""));
//
    }
    public static String Msg(String msgCode, String tipInfo, String strackInfo){
        String msgContent = "";
        // 测试代码, 此处再调数据库, 获取字典数据, 或者, 再前台匹配? 还是直接前台匹配
        // 基础的错误代码字典在前台应该都加载
        if ("U00001".equals(msgCode)) {
            msgContent = "代码重复";
        }
        return msgContent + "::" + tipInfo + "::" + msgCode + "::" + strackInfo;
    }
}