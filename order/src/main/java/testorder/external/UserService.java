
package testorder.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;


@FeignClient(name = "user", url = "${api.url.user}")
 
public interface UserService {
    @GetMapping(path="/users/search/findByGetUser/{id}")
    public User getUser(@PathVariable GetUserQuery getUserQuery);

}



