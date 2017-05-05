package si.tim1.oglasi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Adnan on 5/5/2017.
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void untitleMethod() {

    }
}
