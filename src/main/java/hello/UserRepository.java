package hello;

/**
 * Created by sushantkumar on 13/6/17.
 */
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User,String>{

}
