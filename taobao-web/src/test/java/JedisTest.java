import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.store.pojo.Person;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.Set;

/**
 * Created by kd_gavin on 2017/8/1,11:11.
 *
 * @dicription
 */
public class JedisTest extends BasicTest {

    @Autowired
    private JedisPool jedisPool;

    @Autowired
    private JedisCluster jedisCluster;

    @Test
    public void testJedis(){
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            String str = jedis.get("str_1");
            jedis.set("str_2",str);
            System.out.println(str);
            List<String> stringList =  jedis.mget("str_1","str_2");//mget
            jedis.mset("a1","1","a2","2");
            jedis.del("a1");
            jedis.incr("a2");//每次递增
            System.out.println(str);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            jedis.close();
        }
    }

    @Test
    public void testJedisHash(){
        Jedis jedis = null;//hashTable练习
        try{
            jedis = jedisPool.getResource();
            Person person = new Person();
            person.setName("gavin");
            person.setOpenId("1234545");
            jedis.hset("person","name","gavin");
            jedis.hset("person","openId","12345");

            jedis.hget("person","name");
            jedis.hincrBy("person","openId",1);
            System.out.println();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            jedis.close();
        }
    }

    @Test
    public void testJedisList(){//List练习
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            jedis.lpush("list1",new String[]{"s1","s2"});
            jedis.rpush("list2",new String[]{"s1","s2"});
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id","001");
            jsonObject.put("name","很好");
            jsonObject.put("date",System.currentTimeMillis());
            jedis.lpush("comment:1001",jsonObject.toJSONString());

            jsonObject = new JSONObject();
            jsonObject.put("id","002");
            jsonObject.put("name","很好");
            jsonObject.put("date",System.currentTimeMillis());
            jedis.lpush("comment:1001",jsonObject.toJSONString());

            String comment1 =  jedis.lindex("comment:1001",0);
            JSONObject jsonObject1 = JSONObject.parseObject(comment1);
            //String comments = jedis.get("comment:1001");//这样无法获取整个字符串

           // JSONArray array = JSON.parseArray(comments);
            System.out.println();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            jedis.close();
        }
    }

    @Test
    public void testJedisSet(){//List练习
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            jedis.zadd("scoreset",20,"gavin");
            jedis.zadd("scoreset",30,"gavin1");
            jedis.zadd("scoreset",40,"gavin4");

            Set<String> sroceSet =  jedis.zrevrange("scoreset",0,3);
            System.out.println();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            jedis.close();
        }
    }

    @Test
    public void testJedisCluster(){
        jedisCluster.set("s1","111");//设置的是随机分配的node
        String s1 = jedisCluster.get("s1");
        jedisCluster.lpush("comment:10001","1","2","3");
        System.out.println(s1);
    }
}
