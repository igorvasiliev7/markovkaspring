package ua.com.markovka.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class IpFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
       String ip = request.getRemoteAddr();
       try(BufferedReader br = Files.newBufferedReader(Paths.get("blacklist.txt"))){
           if(ip==null) return;
           String blackIp;
           while ((blackIp=br.readLine())!=null){
               if(ip.equals(blackIp)) {
                   servletRequest.getRequestDispatcher("/error-page").forward(servletRequest, servletResponse);
               }
           }
           filterChain.doFilter(servletRequest,servletResponse);
       }catch (IOException ex){
           ex.getStackTrace();
       }



    }

    @Override
    public void destroy() {

    }
}
