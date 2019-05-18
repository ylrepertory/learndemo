
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCommands;

import java.util.Objects;


@Service
public class RedisLockUtil {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 返回OK代表持有锁
     */
    private static final String LOCK_RESULT = "OK";

    /**
     * 加锁
     * @param lockKey
     * @param lockValue
     * @param expire 超时时间
     * @return
     */
    public boolean lock(String lockKey, String lockValue, int expire) {
        // 加锁
        String lock = stringRedisTemplate.execute((RedisCallback<String>) connection -> {
            JedisCommands commands = (JedisCommands) connection.getNativeConnection();
            return commands.set(lockKey, lockValue, "NX", "EX", expire);
        });

        return Objects.equals(LOCK_RESULT, lock);
    }

    /**
     * 解锁
     * @param lockKey
     */
    public void unlock(String lockKey){
        // 解锁
        stringRedisTemplate.delete(lockKey);
    }


}
