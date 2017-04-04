import cache.RedisDao;

/**
 * Created by logan on 2017/4/5.
 */
public class TestRedis {
    public static void main(String[] args){
        Person person = new Person(102, "bruce");
        RedisDao redisDao = new RedisDao();
        redisDao.putObject(101,person);

        Person person1 = (Person) redisDao.getObject(101);
        System.out.println(person1.getId());
    }
}
