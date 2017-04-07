import cache.RedisDao;

import static sun.java2d.cmm.ColorTransform.In;

/**
 * Created by logan on 2017/4/5.
 */
public class TestRedis {
    public static void main(String[] args){
        Person person = new Person(106, "bruce");
        RedisDao redisDao = new RedisDao();
        redisDao.putObject(100,person);
        Person person1 = redisDao.getObject(100,person.getClass());
        System.out.println(person1.getId());
    }
}
