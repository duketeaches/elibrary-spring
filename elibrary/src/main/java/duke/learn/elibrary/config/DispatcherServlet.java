package duke.learn.elibrary.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author Kazi
 *
 */
public class DispatcherServlet extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
	return new Class[] { SpringConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    protected String[] getServletMappings() {
	return new String[] { "/" };
    }

}
