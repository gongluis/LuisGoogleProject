package com.luis.luisgoogleproject.data.config;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2020/12/3  20:58
 * desc   :
 */
public interface ServerConfigs {

    String SERVER_URL = "http://v2.ffu365.com/index.php?m=Api&c=Index&a=home";
    String PART = "appid";
    String DEFAULT_IMG_URL = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1587649284854&di=74b6d1b0b5c40bfbc8964376131d7e88&imgtype=0&src=http%3A%2F%2Fpic26.nipic.com%2F20130122%2F5056611_171645641000_2.jpg";
    String DEFAULT_IMG_URL2 = "https://img1.baidu.com/it/u=2034774651,2788510823&fm=253&fmt=auto&app=138&f=JPG?w=400&h=300";
    String DEFAULT_IMG_URL3 = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1587650073830&di=92fec00d14b26606630ea9683e7b2a10&imgtype=0&src=http%3A%2F%2Fimage.biaobaiju.com%2Fuploads%2F20190508%2F18%2F1557310281-uADByfZaFU.jpg";

    String LOGIN_REQUEST_URL = "http://v2.ffu365.com/index.php?m=Api&c=Member&a=login";
    String REGISTER_REQUEST_URL = "http://v2.ffu365.com/index.php?m=Api&c=Member&a=register";
    String SEND_CODE_URL = "http://v2.ffu365.com/index.php?m=Api&c=Util&a=sendVerifyCode";
}
