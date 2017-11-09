package top.mothership.cabbage.pojo.osu;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.Date;
@Data
public class Score {
    //仅用于get_user_best
    private Integer beatmapId;
    //这个不在API返回值
    private String beatmapName;
    //这六个仅仅用于db解析
    private Byte mode;
    private Integer scoreVersion;
    private String mapMd5;
    private String repMd5;
    //永远是-1,在osr文件中代表LZMA流大小？
    private Integer size;
    //这个可能是get_scores的score_id值
    private Long onlineId;

    private Long score;
@SerializedName("maxcombo")
    private Integer maxCombo;
    private Integer count50;
    private Integer count100;
    private Integer count300;
@SerializedName("countmiss")
    private Integer countMiss;
@SerializedName("countkatu")
    private Integer countKatu;
@SerializedName("countgeki")
    private Integer countGeki;
    private Integer perfect;
    private Integer enabledMods;
    private Date date;
    private String rank;
    //recent的API里没有
    private Float pp;
    //md ppysb
    @SerializedName("username")
    private String userName;
    private Integer userId;

}