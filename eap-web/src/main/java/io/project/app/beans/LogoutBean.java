package io.project.app.beans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Named
@SessionScoped
public class LogoutBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private FacesContext context = null;
    private ExternalContext externalContext = null;

    @Inject
    private UserContext userContext;

    public LogoutBean() {

    }

    public String doLogout() {

        context = FacesContext.getCurrentInstance();
        externalContext = context.getExternalContext();
        //remove from BE logic
        userContext.getContextHolder().getAccounts().remove(userContext.getAccount().getId());
        externalContext.getSessionMap().remove("userContext");
        //  externalContext.getApplicationMap().remove("userContext");
        externalContext.getSessionMap().clear();
        HttpSession session = (HttpSession) externalContext.getSession(true);
        session.invalidate();

        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
        Cookie cookie = new Cookie("JSESSIONID", "");
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);

        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.invalidateSession();
        // externalContext.getSessionMap().put("localeCode", localeCode);

        return "logout";
    }
}
