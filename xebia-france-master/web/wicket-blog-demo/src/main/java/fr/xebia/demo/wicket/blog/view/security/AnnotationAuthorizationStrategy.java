package fr.xebia.demo.wicket.blog.view.security;

import org.apache.log4j.Logger;
import org.apache.wicket.Component;
import org.apache.wicket.RestartResponseAtInterceptPageException;
import org.apache.wicket.Session;
import org.apache.wicket.authorization.Action;
import org.apache.wicket.authorization.IAuthorizationStrategy;
import org.apache.wicket.markup.html.WebPage;

import fr.xebia.demo.wicket.blog.view.BasePage;
import fr.xebia.demo.wicket.blog.view.BlogWebSession;

public class AnnotationAuthorizationStrategy implements IAuthorizationStrategy {

	private static final Logger logger = Logger.getLogger(AnnotationAuthorizationStrategy.class);
    private final Class<? extends WebPage> signInPageClass;
	
	public AnnotationAuthorizationStrategy(Class<? extends WebPage> signInPageClass) {
        super();
        this.signInPageClass = signInPageClass;
    }

    public boolean isActionAuthorized(Component component, Action action) {
		if ((component instanceof WebPage) == false ) {
		    // return fast
			return true;
		}
		if (component instanceof BasePage) {
            BasePage requestedPage = (BasePage) component;
            if (requestedPage.isSecured()) {
                logger.debug("Component: " + component + " is secured");
                // Check session for user data
                BlogWebSession session = (BlogWebSession) Session.get();
                if (session.getUser() == null) {
                    // If no user in session
                    logger.debug("User not authenticated, redirecting to LoginPage");
                    // Redirect to LoginPage
                    // La lev�e de l'exception RestartResponseAtInterceptPageException
                    // ou l'appel � redirectToInterceptPage(page) permet de stocker la page
                    // qui aurait du �tre afich�e.
                    // L'appel � continueToOriginalDestination() permet d'�tre redirig�e
                    // vers cette page sauvegard�e.
                    throw new RestartResponseAtInterceptPageException(signInPageClass);
                } else {
                    logger.debug("User already authenticated");
                }
            } else {
                logger.debug("Component: " + component + " is NOT secured");
            }
        }
		return true;
	}

	@SuppressWarnings("unchecked")
    public boolean isInstantiationAuthorized(Class componentClass) {
		return true;
	}
}
