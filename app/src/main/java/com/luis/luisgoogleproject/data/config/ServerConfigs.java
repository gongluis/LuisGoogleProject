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
    String DEFAULT_IMG_URL2 = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1587650074399&di=92075f57d2c49073e4bddd525073cc8d&imgtype=0&src=http%3A%2F%2Fimg4.imgtn.bdimg.com%2Fit%2Fu%3D2204610834%2C3091553390%26fm%3D214%26gp%3D0.jpg";
    String DEFAULT_IMG_URL3 = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1587650073830&di=92fec00d14b26606630ea9683e7b2a10&imgtype=0&src=http%3A%2F%2Fimage.biaobaiju.com%2Fuploads%2F20190508%2F18%2F1557310281-uADByfZaFU.jpg";

    String LOGIN_REQUEST_URL = "http://v2.ffu365.com/index.php?m=Api&c=Member&a=login";
    String REGISTER_REQUEST_URL = "http://v2.ffu365.com/index.php?m=Api&c=Member&a=register";
    String SEND_CODE_URL = "http://v2.ffu365.com/index.php?m=Api&c=Util&a=sendVerifyCode";
}
