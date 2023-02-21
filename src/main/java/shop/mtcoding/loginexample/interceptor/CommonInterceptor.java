package shop.mtcoding.loginexample.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;

// public class CommonInterceptor implements HandlerInstan {

// // 컨트롤러가 호출되기 전에 실행
// @Override
// public boolean preHandle(
// HttpServletRequest request, HttpServletResponse response,
// Object obj) throws Exception {

// System.out.println("MyInterCeptor - preHandle");
// return false;
// }

// // controller의 handler가 끝나면 처리됨
// @Override
// public void postHandle(
// HttpServletRequest request, HttpServletResponse response,
// Object obj, ModelAndView mav)
// throws Exception {
// }

// // view까지 처리가 끝난 후에 처리됨
// @Override
// public void afterCompletion(
// HttpServletRequest request, HttpServletResponse response,
// Object obj, Exception e)
// throws Exception {
// }

// }
