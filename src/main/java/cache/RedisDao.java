package cache;

import com.google.gson.Gson;
import redis.clients.jedis.Jedis;
import utils.RedisPoolManager;
import utils.SerializeUtil;

/**
 * Created by logan on 2017/4/5.
 */
public class RedisDao {

    Gson gson = new Gson();

    public <T>T getObject(int id,Class<T> c){
        //获得jedis实例
         Jedis jedis = RedisPoolManager.createInstance();
        try {
            String object = jedis.get(id+"");

            if (object!=null){
                return gson.fromJson(object,c);
            }
        }finally {
            jedis.close();
        }
        return  null;

    }


    public String putObject(int id,Object object){
        //获得jedis实例
        Jedis jedis = RedisPoolManager.createInstance();
        try {
            int timeout = 60 * 60;
            String result = jedis.setex(id+"", timeout, gson.toJson(object));
            return result;
        }finally {
            jedis.close();
        }
    }
}
