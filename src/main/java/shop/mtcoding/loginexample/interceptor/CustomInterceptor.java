package shop.mtcoding.loginexample.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CustomInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession();
        Object principal = session.getAttribute("principal");
        if (principal == null) {
            response.sendRedirect("/loginForm");
            return false;
        }
        return true;
    }

    // @Autowired
    // private HttpSession session;

    // 컨트롤러가 호출되기 전에 실행

    // @Override
    // public boolean preHandle(HttpServletRequest request, HttpServletResponse
    // response, Object handler) {
    // // User principal = (User) session.getAttribute("principal");
    // // if (principal == null) {
    // // throw new CustomException("인증이 되지 않았습니다", HttpStatus.UNAUTHORIZED);
    // // }
    // System.out.println("Pre Handle");
    // return true;
    // }

    // @Override
    // public void postHandle(HttpServletRequest request, HttpServletResponse
    // response, Object handler,
    // ModelAndView modelAndView) {
    // System.out.println("Post Handle");
    // }

    // @Override
    // public void afterCompletion(HttpServletRequest request, HttpServletResponse
    // response, Object handler,
    // Exception ex) {
    // System.out.println("After Completion");
    // }
}

// controller의 handler가 끝나면 처리됨
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
