package br.com.mrksFelipe.filter;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Fecha os entity managers da thread ao final da requisição, se houver
 */
@WebFilter
public class FilterJPA implements Filter {

    public void destroy() {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    	EntityManager em = JPA.em();
        em.getTransaction().begin();
    	chain.doFilter(request, response);
    	System.out.println();
    	
    	try {
    		
    		em.getTransaction().commit();
    		
        }catch(Exception ex){
        	System.out.println("Erro do Filtro");
        	ex.printStackTrace();
        	em.getTransaction().rollback();

        }finally {
       
            //Filtra urls com extensão 
            String path = ((HttpServletRequest) request).getRequestURI();
            String resource = path.substring(path.lastIndexOf('/'));
            if (resource.indexOf(".") <= 0) {
                 em = JPA.em(false);
                if (em != null && em.isOpen()) {
                    em.close();
                }
            }
        }

    }

    public void init(FilterConfig filterConfig) throws ServletException {


    }

}