package demo;

import demo.model.Address;
import demo.model.User;
import demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@Controller
public class DemoController {

	@Autowired
	private DemoService demoService;

	@GetMapping("/my-addresses")
	@ResponseBody
	Collection<Address> demo(@AuthenticationPrincipal User user) {
		return demoService.findAddressesByUser(user);
	}
}
