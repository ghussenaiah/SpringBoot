package springboot.example.dbconfig;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

 
// Configuration class to set up the Redis configuration.
@Configuration
public class RedisConfig {
 
    // Setting up the Jedis connection factory.
	
	/*
	 * @Bean public LettuceConnectionFactory redisConnectionFactory() {
	 * LettuceConnectionFactory lcf = new LettuceConnectionFactory();
	 * lcf.setHostName("127.0.0.1"); lcf.setPort(6379); lcf.setDatabase(1);
	 * lcf.afterPropertiesSet(); return lcf; }
	 */
    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
    	JedisConnectionFactory j=new JedisConnectionFactory();
    	j.setDatabase(1);
        return new JedisConnectionFactory();
    }
      
    // Setting up the Redis template object.
    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        final RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        redisTemplate.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
        return redisTemplate;
    }
}