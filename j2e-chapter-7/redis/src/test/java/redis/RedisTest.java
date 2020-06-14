package redis;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisTest {
	@Test
	public void test1() {
		//连接redis服务，localhost为本地	
		Jedis jedis = new Jedis("localhost");
		//进行auth密码认证
		jedis.auth("123456");
		//测试连接，连接正常会返回pong字符串
		String ping = jedis.ping();
		System.out.println(ping);
		//关闭连接，和JDBC一样，连接是非常消耗资源切不会自动关闭，需要调用close将连接关闭
		jedis.close();
	}
	@Test
	public void test2() {
		//创建Jedis连接池
		JedisPool pool = new JedisPool("localhost");
		//通过连接池获取Jedis连接
		Jedis jedis = pool.getResource();
		jedis.auth("123456");
		String ping = jedis.ping();
		System.out.println(ping);
		//销毁连接池
		pool.destroy();
	}
	@Test
	public void test3() {
		JedisPoolConfig config = new JedisPoolConfig();
		//当新任务到达，而没有空闲的连接时是否阻塞任务，直到超时，默认值为true，设置false则会直接抛出异常阻止任务的提交
		config.setBlockWhenExhausted(false);
		//设置Pool的最大空闲连接数，默认值为8，当空闲连接数超过此设定值，Pool则会销毁多余的连接
		config.setMaxIdle(5);
		//设置Pool的最大连接数，默认值为8
		config.setMaxTotal(10);
		//设置任务阻塞最大等待时间(毫秒)，当setBlockWhenExhausted设值为false时此设置无效
		config.setMaxWaitMillis(5000);
		//设置最小空闲连接数，默认为0
		config.setMinIdle(2);
		//获取Jedis连接时检测此连接是否有效，默认不检查
		config.setTestOnBorrow(true);
		JedisPool pool = new JedisPool("localhost");
		Jedis jedis = pool.getResource();
		jedis.auth("123456");
		String ping = jedis.ping();
		System.out.println(ping);
		pool.destroy();
	}
	private static JedisPool pool;
	private static Jedis getJedis() {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setBlockWhenExhausted(false);
		config.setMaxIdle(5);
		config.setMaxTotal(10);
		config.setMaxWaitMillis(5000);
		config.setMinIdle(2);
		config.setTestOnBorrow(true);
		pool = new JedisPool("localhost");
		Jedis jedis = pool.getResource();
		jedis.auth("123456");
		return jedis;
	}
	@Test
	public void test() throws InterruptedException {
		Jedis jedis = getJedis();
		//清空Redis中的所有键值对，测试时可以使用
		jedis.flushDB();
        System.out.println("新增键值对~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        //新增键值对，设置成功返回ok
        System.out.println(jedis.set("k1","value1"));
        System.out.println(jedis.set("k2","value2"));
        System.out.println(jedis.set("k3", "value3"));
        //删除成功返回ok，删除失败(比如没有该key)则返回0
        System.out.println("删除k2:"+jedis.del("k2"));
        //获取key的值，key不存在则返回null
        System.out.println("获取k2的值:"+jedis.get("k2"));
        //在key的value最后追加，如果key不存在则会新建一个key
        System.out.println("追加字符串："+jedis.append("k3", "End"));
        System.out.println("k3的值："+jedis.get("k3"));
        //mset,设置成功返回OK
        System.out.println("同时设置多个键值对："+jedis.mset("k1","v1","k2","v2","k3","v3"));
        //mget,以字符串数组的形式返回，key不存在会返回null
        System.out.println("获取多个键值对的值："+jedis.mget("k1","k2","k3"));
        System.out.println("同时获取多个key的值："+jedis.mget("k1","k2","k3","k4"));
        System.out.println("同时删除多个key的值："+jedis.del(new String[]{"k1","k2"}));
        System.out.println("同时获取多个key的值："+jedis.mget("key01","key02","key03"));
        jedis.flushDB();
        //setnx,在key不存在的情况下，设值才会成功
        System.out.println(jedis.setnx("k1", "value1"));
        System.out.println(jedis.setnx("k2", "value2"));
        System.out.println(jedis.setnx("k2", "value2-new"));
        System.out.println(jedis.get("k1"));
        System.out.println(jedis.get("k2"));
        //设置key-value键值对，并设置有效时间
        System.out.println(jedis.setex("k3", 2, "value3"));
        System.out.println(jedis.get("k3"));
        //
        TimeUnit.SECONDS.sleep(3);
        System.out.println(jedis.get("k3"));
        //获取key的值并为其设置新的值
        System.out.println(jedis.getSet("k2", "k2GetSet"));
        System.out.println(jedis.get("k2"));
        //getrange,获取下标2-4的子串，包含2不包含4，下标从0开始，length-1介绍，
        System.out.println("获取k2的值的子串："+jedis.getrange("key2", 2, 4));
	}
	@After
	public void after() {
		pool.destroy();
	}
	@Test
	public void test4() {
		Jedis jedis = getJedis();
	    jedis.flushDB();
	    //向列表添加元素，支持一个或者多个
	    jedis.lpush("myList", "List", "Set", "Map", "Tree");
	    jedis.lpush("myList", "ArrayList");
	    //获取指定区间的元素，同时也支持从后向前的下标，如果是-1则表示倒数第一个元素，-2表示倒数的第二个元素，依次
	    System.out.println("myList的全部元素："+jedis.lrange("myList", 0, -1));
	    System.out.println("指定myList区间1-2的元素："+jedis.lrange("myList",1,2));
	    
	    // 将列表指定的值删除 ，第二个参数为指定参数的个数(list类型是可重复的列表)，并且遵循‘先进后出原则‘，后保存的数据优先会被删除掉
	    System.out.println("将myList的指定元素删除："+jedis.lrem("myList", 2, "HashMap"));
	    System.out.println("myList的全部元素："+jedis.lrange("myList", 0, -1));
	    System.out.println("删除指定区间以外的元素："+jedis.ltrim("myList", 0, 3));
	    System.out.println("myList的全部元素："+jedis.lrange("myList", 0, -1));
	    //出栈操作，即取出最左端的元素，并将此元素移除
	    System.out.println("myList列表出栈："+jedis.lpop("myList"));
	    System.out.println("myList的全部元素："+jedis.lrange("myList", 0, -1));
	    //在list的最后添加元素，返回List所有元素的个数(添加之后)
	    System.out.println("向myList添加元素："+jedis.rpush("myList", "EnumMap"));
	    System.out.println("myList的全部元素："+jedis.lrange("myList", 0, -1));
	   //取出列表最右端的元素，并将此元素移除
	    System.out.println("myList列表出栈（右端）："+jedis.rpop("myList"));
	    System.out.println("myList的全部元素："+jedis.lrange("myList", 0, -1));
	    System.out.println("修改myList指定下标1的内容："+jedis.lset("myList", 1, "LinkedList"));
	    System.out.println("myList的全部元素："+jedis.lrange("myList", 0, -1));
	    
	    System.out.println("myList的元素个数："+jedis.llen("myList"));
	    System.out.println("获取myList指定下标为2的元素内容："+jedis.lindex("myList", 2));
	    
	    jedis.lpush("sorted", "3","6","2","0","7","4");
	    System.out.println("sorted排序前："+jedis.lrange("sorted", 0, -1));
	    //为list进行排序，返回排序后的数据，但是排序并不能改变原list的内容
	    //如果是非number的数据则会按照ASCII码进行排序
	    System.out.println(jedis.sort("sorted"));
	    System.out.println("sorted排序后："+jedis.lrange("sorted", 0, -1));
	}
	@Test
	public void test5() {
		Jedis jedis = getJedis();
		jedis.flushDB();
        //返回添加成功元素的个数
        System.out.println(jedis.sadd("mySet", "s1","s2","s4","s3","s0","s8","s7","s5"));
        //Set不可重复，相同元素不能添加成功
        System.out.println(jedis.sadd("mySet", "s6"));
        System.out.println(jedis.sadd("mySet", "s6"));
        System.out.println("mySet的所有元素："+jedis.smembers("mySet"));
        //删除成功返回1，失败返回0
        System.out.println("删除一个元素s0："+jedis.srem("mySet", "s0"));
        System.out.println("mySet的所有元素："+jedis.smembers("mySet"));
        //返回删除成功的元素个数
        System.out.println("删除两个元素s7和s6："+jedis.srem("mySet", "s7","s6"));
        System.out.println("mySet的所有元素："+jedis.smembers("mySet"));
        //返回被移除的元素
        System.out.println("随机的移除集合中的一个元素："+jedis.spop("mySet"));
        System.out.println("mySet的所有元素："+jedis.smembers("mySet"));
        System.out.println("mySet中包含元素的个数："+jedis.scard("mySet"));
        //判断set是否存在某元素，返回boolean
        System.out.println("判断mySet中是否在元素s3："+jedis.sismember("mySet", "s3"));
        System.out.println("判断mySet中是否在元素s1："+jedis.sismember("mySet", "s1"));
        System.out.println("判断mySet中是否在元素s5："+jedis.sismember("mySet", "s5"));
        //两个Set之间的元素移动
        System.out.println(jedis.sadd("mySet1", "s1","s2","s4","s3","s0","s8","s7","s5"));
        System.out.println(jedis.sadd("mySet2", "s1","s2","s4","s3","s0","s8"));
        System.out.println("将mySet1中的元素e1删除并存入mySet3中："+jedis.smove("mySet1", "mySet3", "s1"));
        System.out.println("将mySet1中的元素e2删除并存入mySet3中："+jedis.smove("mySet1", "mySet3", "s2"));
        System.out.println("mySet1中的所有元素："+jedis.smembers("mySet1"));
        System.out.println("mySet3中的所有元素："+jedis.smembers("mySet3"));
	}
	@Test
	public void test6() {
		Jedis jedis = getJedis();
		jedis.flushDB();
        Map<String,String> map = new HashMap<String,String>();
        map.put("k1","v1");
        map.put("k2","v2");
        map.put("k3","v3");
        map.put("k4","v4");
        //设置一个散列，并存入多个键值对数据
        jedis.hmset("hash",map);
        //设置一个键值对
        jedis.hset("hash", "k5", "v5");
        //返回Map<String,String>
        System.out.println("获取hash的所有键值对："+jedis.hgetAll("hash"));
        //返回Set<String> 类似于Java中Map的keySet方法
        System.out.println("获取hash的所有键为："+jedis.hkeys("hash"));
        //返回List<String> 类似于Java中Map的values方法
        System.out.println("获取hash的所有值："+jedis.hvals("hash"));
        //Map增量操作，返回增量操作之后的值
        System.out.println("将k6保存的值加上一个整数，如果k6不存在则添加k6："+jedis.hincrBy("hash", "k6", 6));
        System.out.println("获取hash的所有键值对："+jedis.hgetAll("hash"));
        System.out.println("将k6保存的值加上一个整数，如果key6不存在则添加key6："+jedis.hincrBy("hash", "k6", 3));
        System.out.println("获取hash的所有键值对："+jedis.hgetAll("hash"));
        System.out.println("删除一个或者多个键值对："+jedis.hdel("hash", "k2"));
        System.out.println("获取hash的所有键值对："+jedis.hgetAll("hash"));
        System.out.println("获取hash中键值对的个数："+jedis.hlen("hash"));
        //判断散列是否存在某个key，boolean
        System.out.println("判断hash中是否存在k2："+jedis.hexists("hash","k2"));
        System.out.println("判断hash中是否存在k3："+jedis.hexists("hash","k3"));
        //获取散列某个key的值，不存在则返回null
        System.out.println("获取hash中的值："+jedis.hmget("hash","k3"));
        //获取散列多个key的值，不存在则返回null
        System.out.println("获取hash中的值："+jedis.hmget("hash","k3","k7"));
	}
	@Test
	public void test7() {
		Jedis jedis = getJedis();
		jedis.flushDB();
        Map<String,Double> map = new HashMap<>();
        map.put("k3",4.0);
        map.put("k4",5.0);
        //为SortedSet添加一个分数为3的元素,返回添加的元素个数
        System.out.println(jedis.zadd("mySorted", 3,"k1"));
        //向有序set添加多个元素以及对应的分数,返回添加的元素个数
        System.out.println(jedis.zadd("mySorted",map));
        //获取所有元素
        System.out.println("获取mySorted中的元素：\r\n  "+jedis.zrange("mySorted", 0, -1));
        //获取所有元素以及元素对应的分数
        System.out.println("获取mySorted中的元素以及分数：\r\n  "+jedis.zrangeWithScores("mySorted", 0, -1));
        System.out.println("获取mySorted中的所有元素：\r\n  "+jedis.zrangeByScore("mySorted", 0,100));
        //获取指定分数范围的元素
        System.out.println("获取mySorted中的元素：\r\n  "+jedis.zrangeByScoreWithScores("mySorted", 0,100));
        System.out.println("获取mySorted中k2的分值："+jedis.zscore("mySorted", "k2"));
        System.out.println("获取mySorted中k2的排名："+jedis.zrank("mySorted", "k2"));
        //删除成功返回1，失败返回0
        System.out.println("将mySorted中的元素k3删除："+jedis.zrem("mySorted", "k3"));
        System.out.println("获取mySorted中的元素：\r\n  "+jedis.zrange("mySorted", 0, -1));
        System.out.println("获取mySorted中元素的个数："+jedis.zcard("mySorted"));
        System.out.println("mySorted中分值在1-4之间的元素的个数："+jedis.zcount("mySorted", 1, 4));
        //分值增量操作
        System.out.println("key2的分值加上5："+jedis.zincrby("mySorted", 5, "k2"));
        System.out.println("key3的分值加上4："+jedis.zincrby("mySorted", 4, "k3"));
        System.out.println("mySorted中的所有元素：\r\n  "+jedis.zrange("mySorted", 0, -1));
	}
	@Test
	public void test8() throws InterruptedException {
		Jedis jedis = getJedis();
        jedis.flushDB();
        System.out.println("判断某个键是否存在："+jedis.exists("name"));
        System.out.println("新增键值对："+jedis.set("name", "zhangsan"));
        //判断键是否存在
        System.out.println(jedis.exists("name"));
        System.out.println("新增键值对："+jedis.set("pwd", "pwd"));
        System.out.println("获取所有的key：");
        Set<String> keys = jedis.keys("*");
        //循环输出所有的key
        keys.forEach((key) -> System.out.println( "         " + key));
        System.out.println("删除键pwd:"+jedis.del("pwd"));
        System.out.println("判断键pwd是否存在："+jedis.exists("pwd"));
        //设置过期时间，单位为秒，返回1表示设置成功
        System.out.println("设置键name的过期时间为5s:"+(jedis.expire("name", 5)==1?"成功":"失败"));
        TimeUnit.SECONDS.sleep(2);
        //返回剩余时间，单位秒
        System.out.println("name的剩余生存时间："+jedis.ttl("name"));
        //撤销过期时间
        System.out.println("撤销name的过期时间："+jedis.persist("name"));
        //在2.8及以上版本，返回-1表示没有设置过期时间，返回-2表示键不存在
        //在没有设置过期时间或者键不存在都返回-1
        System.out.println("name的剩余生存时间："+jedis.ttl("name"));
        System.out.println("name所存储的值的类型："+jedis.type("name"));
	}
	@Test
	public void test12() {
		Jedis jedis = getJedis();
		jedis.del("sorted");
		jedis.del("myList");
	}
}
