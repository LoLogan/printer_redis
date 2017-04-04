package cache;

import redis.clients.jedis.Jedis;
import utils.RedisPoolManager;
import utils.SerializeUtil;

/**
 * Created by logan on 2017/4/5.
 */
public class RedisDao {


    public Object getObject(int id){
        //获得jedis实例
         Jedis jedis = RedisPoolManager.createInstance();
        try {
            byte[] object = jedis.get((id + "").getBytes());
            if (object!=null)
            return SerializeUtil.unserialize(object);
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
            String result = jedis.setex((id + "").getBytes(), timeout, SerializeUtil.serialize(object));
            return result;
        }finally {
            jedis.close();
        }
    }
}
