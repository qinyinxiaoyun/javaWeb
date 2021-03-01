namespace java searchApi.out

include "../base/base.thrift"

/****************** searchNotes start **********************/

struct StructuredQuery {
    1: string id;
    2: string rawName;
    3: string name;
    4: string type;
    5: string itemId;
}

enum QueryMode {
    DEFAULT = 0; // 普通模式
    YOUNG = 1; // 青少年模式
}

struct SearchRequest {
    1: optional string target;
    2: optional string query;
    3: optional i32 posFrom;
    4: optional i32 size;
    5: optional string sortby;
    6: optional string userId;
    7: optional i32 gender;
    8: optional string requestId;
    9: optional string searchId;
    10: optional string platform;
    11: optional string version;
    12: optional bool showRecommend;
    13: optional string appFirstTime;
    14: optional list<StructuredQuery> structuredQuery;
    15: optional i32 pagePos = -1;
    16: optional string filterJson;
    17: optional bool rewrittenFlag;
    18: optional bool notMergeAds; // 是否不merge广告。 true:不需要合并广告。
    19: optional bool notMergeRecQueryWords; // 是否不merge推荐词。 true:不需要合并推荐词。
    20: optional QueryMode queryMode; // 查询模式
    21: optional string manufacturer;
    22: optional i32 networkType;
    23: optional string deviceId;
    24: optional bool loggedIn;
    25: optional string wordRequestId;
    26: optional string sessionId;
    27: optional i32 queryRiskLevel;
    28: optional SearchAdsRequest searchAdsRequest;
    29: optional string type;
    30: optional string queryExtraInfo;
}

enum Source {
    APP = 1,
    WE_CHAT = 2, //微信小程序
    BAIDU_APPLET = 3,//百度小程序
    BYTE_DANCE_APPLET = 4, //头条小程序
    WEB = 5, //网页端
    KRATOS = 6, // 增长投放后台
    GROWTH_ADS = 7, // 增长投放后台C端
    GROWTH_NEW = 8, // 增长投放新人C端
    WE_CHAT_QUICK = 9, //不过精排的搜索，目前提供给微信搜一搜
    TOP_APP = 10 // 视频APP-TOP 来源
}

enum CardType {
    NOTE = 1, // 笔记
    ADS = 2, // 广告
    REC_QUERY_WORD = 3, // 推荐词
    USER = 4,//用户
    AI_SKIN = 5, // 测肤异形卡片
    LIVE = 6, // 直播卡片
    EXCLUSIVE = 7 //专属搜索卡片
}

struct SearchAdsRequest {
    1: optional string loadedAdsId;
}

struct CommonRequest {
    1: optional string appBuild;
    2: optional string platform;
    3: optional string userId;
    4: optional string deviceId;
    5: optional Source source;
    6: optional double longitude; // 经度
    7: optional double latitude;  // 纬度
    8: optional string ipAddress; // ip地址
    9: optional i32 identifierFlag; // 二进制标识别 是否有系统版本
}

struct SearchResponse {
    1: i32 status;
    2: string message;
    3: optional list<string> flatFiltersPos;
    4: optional i32 noteHits;
    5: optional list<Note> notes;
    6: optional string searchId;
    7: optional list<string> recommendWordList;
    8: optional i32 recommendWordPosition;
    9: optional RecommendInfo recommendInfo;
    10: optional string rewrittedQuery;
    11: optional bool rewritten;
    12: optional string recCardTitle;
    13: optional list<string> recCardTagId;
    14: optional i32 recSource;
    15: optional list<string> recCardValue;
}

enum CreativeJumpTypeEnum {
    NONE = 0,           // 无跳转
    NOTE = 1,           // 笔记
    H5 = 2,             // H5
    GOODS = 3,          // 商品页
    BANNER = 4,         // 场次
    LANDING_PAGE = 5,   // 落地页
    SHOP = 6,           // 店铺页
    HUATI = 7,          // 话题页
    EXTERNAL_LINK = 8,  // 外链
    SEARCH_RESULT_PAGE = 9,  // 搜索结果页
    DONWLOAD_LINK = 10,  // 下载
}

struct RecQueryWordInfo {
    1: optional list<string> recommendWordList;
    2: optional string recCardTitle;
    3: optional list<string> recCardTagId;
    4: optional i32 recSource;
    5: optional list<string> recCardValue;
}

struct Note {
    1: string note_id;  //笔记id
    2: optional i32 index;  //出价
    3: optional string title;  //标题
    4: optional string type;  //类型
    5: optional bool isAds;
    6: optional AdInfo adInfo;
    7: optional string trackId;
    8: optional CardType cardType; //卡片类型
    9: optional RecQueryWordInfo recQueryWordInfo;
    10: optional i32 recallEngageType; //亲密展示优先级:关注=6,评论=5,分享=4,收藏=3,点赞=2,高亲密度=1,其他=0
    11: optional RecUserInfo recUserInfo; //推荐用户信息
    12: optional i64 noteIdLong; // noteIdLong
    13: optional AiSkinInfo aiSkinInfo;
    14: optional LiveItem liveItem; //直播卡片
    15: optional Exclusive exclusive;
}

struct AdInfo {
    1: string noteId;  //笔记id
    2: optional string adsId; //广告id
    3: optional string adsUuid; // cpd广告的UUID
    4: optional string advertiserId; // 广告主id
    5: optional string campaignId; // 计划id
    6: optional i32 creativeType; // 创意类型：1.笔记 2.H5 3.商品
    7: optional string clickUrl;
    8: optional string expoUrl;
    9: optional i32 trackingType;
    10: optional bool showTag; //是否展示广告标
    11: optional string goodsId; // 商品的ID
    12: optional string trackId; // 从ads-service传回的trackId
    13: optional CreativeJumpTypeEnum secondJumpType; // 二跳类型：0 无, 1 笔记, 2 H5, 3 商品, 4 场次, 5 落地页, 6 店铺页, 7 话题页, 8 外链, 9 搜索页, 10 app下载'
    14: optional string materialJson; // 创意维度的多个字段json
    15: optional string extraJson; // 其他维度的过个字段json
    16: optional i32 insertPosition; // 广告在自然结果中的绝对位置索引(2、12、22……)
}

struct RecUserInfo {
    1: optional string userId;
    2: optional list<string> noteIds; //该推荐用户的笔记list
    3: optional i64 userIdLong;
}

struct AiSkinInfo {
    1: optional string category // 类别
    2: optional i32 relevence // 0 弱 1 强
    3: optional bool isShow // 是否显示
    4: optional bool hasTest // 是否测过
}

struct LiveItem {
    1: optional string roomId;
    2: optional string itemId;
    3: optional i32 type;
    4: optional string reason;
    5: optional string recommendType;
    6: optional string contractId;
}

struct Exclusive {
    1: optional i32 added; //是否添加过 1表示添加过，0表示未添加
}

struct RecommendInfo {
    1: string title;
    2: optional i32 note_hits;
    3: optional list<string> words;
    4: optional list<Note> notes;
}

/****************** searchNotes end **********************/

/****************** autoComplete start *******************/
struct SearchAutoCompleteRequest {
    1: optional string type;
    2: optional string target;
    3: optional string keyword;
    4: optional string version;
    5: optional string userId;
    6: optional string requestId;
    7: optional i32 pageSize;
    8: optional QueryMode queryMode; // 查询模式
}

struct SearchAutoCompleteResponse {
    1: optional i32 status;
    2: optional string message;
    3: optional string searchId;
    4: optional i32 acHits;
    5: optional list<AutoCompleteResult> acResult;
}

struct AutoCompleteResult {
    1: optional string name;
    2: optional string acType;
    3: optional string targetId;
    4: optional string pageId;
    5: optional double score;
    6: optional string link;
}
/****************** autoComplete end *******************/


service SearchService {
	SearchResponse search(
	      1: base.Context ctx,
	      2: SearchRequest req,
	      3: CommonRequest commonReq
	);

	SearchAutoCompleteResponse searchAutoCompleteV2(
	      1: base.Context ctx,
	      2: SearchAutoCompleteRequest req,
	      3: CommonRequest commonReq
	);
}
