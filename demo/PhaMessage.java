public class PhaMessage {
    public static void main(String[] args) {
        String msgInfo = "";
        msgInfo = PhaMessage.Msg("U00001", "H000001", "SUBSCRIPT%IsExistType+3~PHA.SYS.ComDict.Save.1 ~DHCSTSCDI");
        System.out.println(msgInfo);
        // tipinfo / stackInfo 非必要时, 允许为空
        msgInfo = PhaMessage.Msg("U00002", "", "");
        System.out.println(msgInfo);
        // 举例1, 库存不足, tipinfo
        String[] tipValueArr = {"阿莫西林胶囊"};
        msgInfo = PhaMessage.Msg("S00001", GetModelTip("M00001", tipValueArr), "");
        System.out.println(msgInfo);
        // 举例2, 门诊药房8号窗口还需要取药, 依然是通过调用字典模板, 替换关键字信息的方式
        msgInfo = GetModelTip("M00001", new String[]{"门诊药房", "8号窗口"});
        System.out.println(msgInfo);
    }

    private void msgExample() {
        String msgInfo = "";
        String tipInfo = "";
        // 仅提醒错误码信息
        msgInfo = PhaMessage.Msg("130001", "", ""); // 发送到发药机失败
        // 包含堆栈信息
        msgInfo = PhaMessage.Msg("130001", "", "SUBSCRIPT%IsExistType+3~PHA.SYS.ComDict.Save.1 ~DHCSTSCDI"); // 发送到发药机失败
        // 包含提醒信息, 获取模板并转换后的提醒消息
        tipInfo = GetModelTip("901001", new String[]{"门诊药房", "8号窗口"});
        msgInfo = PhaMessage.Msg("130001", tipInfo, "SUBSCRIPT%IsExistType+3~PHA.SYS.ComDict.Save.1 ~DHCSTSCDI"); // 待取药信息
    }

    /**
     * 公共的返回值处理
     *
     * @param msgCode   错误代码
     * @param tipInfo   提醒信息, 翻译后的内容
     * @param stackInfo 堆栈信息, 原始信息, 不需要任何处理, 根据情况, 适当截断200个字符等
     * @return String 拼接的错误信息
     */
    public static String Msg(String msgCode, String tipInfo, String stackInfo) {
        String msgContent = "";
        // 测试代码, 此处再调数据库, 获取字典数据, 或者, 再前台匹配? 还是直接前台匹配
        // 基础的错误代码字典在前台应该都加载
        if ("U00001".equals(msgCode)) {
            msgContent = "代码重复";
        }
        if ("S00001".equals(msgCode)) {
            msgContent = "库存不足";
        }
        return msgContent + "::" + tipInfo + "::" + msgCode + "::" + stackInfo;
    }

    public static String GetModelTip(String tipCode, String[] args) {
        String tipInfo = "咱也不知道";
        return String.join(",", args);
    }
}