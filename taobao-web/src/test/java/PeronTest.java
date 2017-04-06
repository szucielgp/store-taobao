import com.taobao.store.service.PersonService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.taobao.store.pojo.Person;
/**
 * Created by kd_gavin on 2017/4/6,15:37.
 *
 * @dicription
 */
public class PeronTest extends BasicTest {

    @Autowired
    private PersonService personService;

    @Test
    public void testFindPerson(){

        Person p =   personService.selectByPrimaryKey("10315332","58ad72dde4b037738f73e580");
        System.out.print("");

    }
}
