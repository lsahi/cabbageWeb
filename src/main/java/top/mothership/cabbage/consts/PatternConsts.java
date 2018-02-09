package top.mothership.cabbage.consts;

import java.util.regex.Pattern;

/**
 * 正则表达式的常量类。
 *
 * @author QHS
 */
public class PatternConsts {
    /**
     * 匹配出带/不带数字的常规命令，简单的用空格分割命令字符串。
     * 当处理!statme类命令时：group(1)为statme，2和3为""
     * !setid xxx类命令是：group(1)为setid，group(2)为xxx，3为""
     */
    public final static Pattern REG_CMD_REGEX = Pattern.compile("[!！]([^ ]*)[ ]?(.*)");
    /**
     * 匹配出用#号分隔的数字的常规命令
     * !bp xx #n类命令时：group(1)为setid，group(2)为xxx，3为n
     * !bpme #n类命令时：group(1)为setid，group(2)为""，3为n
     */
    public final static Pattern REG_CMD_REGEX_SHARP_NUM_PARAM = Pattern.compile("[!！]([^ ]*)[ ]?(.*)(?: #)(.*)");
    /**
     * 匹配出用：号分隔的数字的常规命令
     * !bp xx ：n类命令时：group(1)为setid，group(2)为xxx，3为n
     * !bpme ：n类命令时：group(1)为setid，group(2)为""，3为n
     */
    public final static Pattern REG_CMD_REGEX_COLON_NUM_PARAM = Pattern.compile("[!！]([^ ]*)[ ]?(.*)(?: :| ：|：|:)(.*)");
    /**
     * 匹配出带两个参数的常规命令，单个参数不匹配
     * !bp xx #m：n类命令时：group(1)为setid，group(2)为xxx，3为m,4为n
     * !bpme #m：n类命令时：group(1)为setid，group(2)为""，3为m,4为n
     */
    public final static Pattern REG_CMD_REGEX_TWO_PARAMS = Pattern.compile("[!！]([^ ]*)[ ]?(.*)(?: #)(.*)(?: :| ：|：|:)(.*)");

    /**
     * 也是两个参数的常规命令，只不过m和n相反
     */
    public final static Pattern REG_CMD_REGEX_TWO_PARAMS_REVERSE = Pattern.compile("[!！]([^ ]*)[ ]?(.*)(?: :| ：|：|:)(.*)(?: #)(.*)");


    /**
     * 匹配出带图片的消息
     */
    public final static Pattern IMG_REGEX = Pattern.compile("\\[CQ:image,file=.+]");
    /**
     * 匹配出艾特消息中的QQ号
     */
    public final static Pattern AT_REGEX = Pattern.compile("\\[CQ:at,qq=(.*)]");
    /**
     * 匹配出纯图片的消息
     */
    public final static Pattern SINGLE_IMG_REGEX = Pattern.compile("^\\[CQ:image,file=.+]$");
    /**
     * 匹配出sudo命令
     * 当处理!sudo listInvite类命令时：group(1)为listInvite
     * 当处理!sudo recent xxx类命令时：group(2)为xxx
     * 当处理!sudo add xxx:yyy类命令是：group(2)为xxx,group(3)为yyy
     */
    public final static Pattern ADMIN_CMD_REGEX = Pattern.compile("[!！]sudo ([^ ]*)[ ]?([^:：]*)[:|：]?(.*)");
    /**
     * !add/!del专用……
     */
    public final static Pattern CHART_ADMIN_CMD_REGEX = Pattern.compile("[!！]([^ ]*)[ ]?([^#]*)#?(.*)");
    /**
     * MP系列命令,和sudo一样
     */
    public final static Pattern MP_CMD_REGEX = Pattern.compile("[!！]mp ([^ ]*)[ ]?([^:]*)[:]?(.*)");


    /**
     * 复读禁言时抗干扰的匹配表达式
     */
    public final static Pattern REPEAT_FILTER_REGEX = Pattern.compile("[^\\u4e00-\\u9fa5a-zA-Z0-9]");
    /**
     * 从.osu文件中匹配出BG文件名的表达式
     */
    public final static Pattern BGNAME_REGEX = Pattern.compile("(?<=[\\d*],[\\d*],\")(?:.*\\\\)*(.*\\.(?i)(jpg|png|jpeg))");
    /**
     * osu官网中添加好友连接的表达式
     */
    public final static Pattern ADD_FRIEND_REGEX = Pattern.compile("<div class='centrep'>\\n<a href='([^']*)");
    /**
     * osu search命令的表达式
     * 2017-12-4 10:45:55 现在支持分隔符后带空格了，横杠前的空格还是手动处理
     */
    public final static Pattern OSU_SEARCH_KETWORD = Pattern.compile("^([^-]*)-[ ]?(.*)[ ]?\\[(.*)][ ]?\\((.*)\\)\\{(.*)}");

    /**
     * The constant OSU_SEARCH_KETWORD_SHELL.
     */
    public final static Pattern OSU_SEARCH_KETWORD_SHELL = Pattern.compile("((?:-(a|t|d|m|ar|od|cs|hp)) ([^-]*)){1,8}");
    /**
     * osu!search功能用的带mod表达式
     */
    public final static Pattern OSU_SEARCH_MOD_REGEX = Pattern.compile("[!！]([^ ]*)[ ]?(.*)(?:\\+| \\+)(.*)");

    /**
     * 取出四维
     */
    public final static Pattern OSU_SEARCH_FOUR_DEMENSIONS_REGEX = Pattern
            .compile("(?:AR(\\d{1,2}(?:\\.|。)?(?:\\d{1,2})?))?(?:OD(\\d{1,2}(?:\\.|。)?(?:\\d{1,2})?))?(?:CS(\\d{1,2}(?:\\.|。)?(?:\\d{1,2})?))?(?:HP(\\d{1,2}(?:\\.|。)?(?:\\d{1,2})?))?", Pattern.CASE_INSENSITIVE);

    /**
     * 用来处理纯数字搜索词（bid）的表达式
     */
    public final static Pattern ALL_NUMBER_SEARCH_KEYWORD = Pattern.compile("^(\\d{1,7})$");
    /**
     * UNICODE转String的表达式。
     */
    public final static Pattern UNICODE_TO_STRING = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");

    /**
     * 对所有服务器消息（不是banchobot发送的私聊消息）进行基本的筛选……
     */
    public final static Pattern IRC_SERVER_MSG = Pattern.compile(":cho.ppy.sh (\\d\\d\\d) (.+)");
    /**
     * The constant ROOM_NOT_EXIST.
     */
    public final static Pattern ROOM_NOT_EXIST = Pattern.compile(":cho.ppy.sh 401 .+ #mp_(.+) :No such nick");

    /**
     * The constant ROOM_LIMITED.
     */
    public final static Pattern ROOM_LIMITED = Pattern.compile(
            ":BanchoBot!cho@ppy.sh PRIVMSG [.*] :You cannot create any more tournament matches. Please close any previous tournament matches you have open.");

    /**
     * The constant IRC_MSG.
     */
    public final static Pattern IRC_PRIVATE_MSG = Pattern.compile(":(.+)!cho@ppy.sh PRIVMSG (.+) :(.+)");

    /**
     * The constant QIANESE_RECENT.
     */
    public final static Pattern QIANESE_RECENT = Pattern.compile("((?:4|5|t|f|d|e|r)(?:1|q|w|3|e|r|4)(?:x|d|f|v|c)(?:1|q|w|3|e|r|4)(?:b|h|j|m|n)(?:r|5|6|y|g|f|t))");

    /**
     * 从旧官网取出正确的S和SS数据
     */
    public final static Pattern CORRECT_X_S = Pattern.compile("<td width='42'><img height='42' src='//s.ppy.sh/images/X.png'></td><td width='50'>(\\d*)</td>\n" +
            "<td width='42'><img height='42' src='//s.ppy.sh/images/S.png'></td><td width='50'>(\\d*)</td>\n");

    /**
     * 赛事分析系统中用来处理bid
     */
    public final static Pattern ANALYZE_BID_PARAM = Pattern.compile("[!！]([^ ]*)[ ]?(\\d*)");
    /**
     * 匹配osu的UID（1-8个数字）
     */
    public final static Pattern OSU_USER_ID = Pattern.compile("^(\\d{1,8})$");
    public final static Pattern OSU_USER_NAME = Pattern.compile("^([\\w \\-\\[\\]]{1,15})$");
}
