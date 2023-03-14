package TFIP.Test1.Config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
 
    @Value("${spring.data.redis.host}")
    private String redisHost;
    

    @Value("${spring.data.redis.port}")
    private Optional<Integer> redisPort;
    

    @Value("${spring.data.redis.username}")
    private String redisUsername;
    

    @Value("${spring.data.redis.password}")
    private String redisPassword;
    
    @Bean
    @Scope("singleton")
    public RedisTemplate<String, Object> redisTemplate(){
        //cannot autowired
        final RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
        config.setHostName(redisHost);
        config.setPort(redisPort.get());

        if(!redisUsername.isEmpty() && !redisPassword.isEmpty()){
            config.setUsername(redisUsername);
            config.setPassword(redisPassword);
        }
        config.setDatabase(0);
        final JedisClientConfiguration jedisClient =  JedisClientConfiguration.builder().build();

        final JedisConnectionFactory jedisFac = new JedisConnectionFactory(config, jedisClient);
        jedisFac.afterPropertiesSet();
        
        RedisTemplate<String, Object> r = new RedisTemplate<>();
        r.setConnectionFactory(jedisFac);

        // //for json
        // r.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());

        //for String
        r.setKeySerializer(new StringRedisSerializer());
        r.setHashKeySerializer(new StringRedisSerializer());

        // RedisSerializer<Object> objSerializer = new JdkSerializationRedisSerializer(getClass().getClassLoader());  
        r.setValueSerializer(new StringRedisSerializer());
        r.setHashValueSerializer(new StringRedisSerializer());
        
        System.out.println("redisHost > " + redisHost);
        return r;
    }
}