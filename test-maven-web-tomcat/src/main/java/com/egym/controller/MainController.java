package com.egym.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.egym.entity.User;
import com.egym.entity.enums.RoleEnum;
import com.egym.repository.UserRepositoryInterface;
import com.egym.utils.UserContext;

@Controller
@RequestMapping(value = "/")
public class MainController {

	@Autowired
	UserContext userContext;

	@Autowired
	private UserRepositoryInterface userRepository;

	@GetMapping(value = "/view")
	String getView() {

		User user = new User("amine8", "amine", "amine", "jabri", Arrays.asList(RoleEnum.values()));
		userRepository.save(user);

		return "view";
	}

	@Transactional
	@GetMapping(value = "/view2")
	String getView2() {

		return "view2";
	}

	@GetMapping(value = "/view3")
	public ModelAndView handleRequest(HttpServletRequest request, //
			HttpServletResponse reponse) throws ServletException, IOException {

		Test now = new Test();
		Test2 now2 = new Test2();
		now.setX("x");
		now.setY("y");
		now2.setX(now);

		return new ModelAndView("view", "now", now2);
	}

	public class Test {
		private String x;
		private String y;

		public String getX() {
			return x;
		}

		public void setX(String x) {
			this.x = x;
		}

		public String getY() {
			return y;
		}

		public void setY(String y) {
			this.y = y;
		}

	}

	public class Test2 {
		private Test x;
		private String y;

		public Test getX() {
			return x;
		}

		public void setX(Test x) {
			this.x = x;
		}

		public String getY() {
			return y;
		}

		public void setY(String y) {
			this.y = y;
		}

	}

}
