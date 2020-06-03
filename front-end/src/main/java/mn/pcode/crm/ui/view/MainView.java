package mn.pcode.crm.ui.view;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import mn.pcode.crm.ui.controller.MainController;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Car rent main view class.
 *
 */
@Route
@PWA(name = "Car-rent",
        shortName = "CR",
        description = "Car rent open source platform",
        enableInstallPrompt = false)
@CssImport("./styles/shared-styles.css")
public class MainView extends VerticalLayout {
    @Autowired
    private MainController controller;

    private final String appName = "Car rent platform";

    public MainView() {
        addClassName("centered-content");
        initUI();
    }


    private void initUI() {
        LoginForm loginForm = new LoginForm();
        loginForm.setI18n(loginInfo());
        add(loginForm);
    }

    private LoginI18n loginInfo() {
        final LoginI18n login = LoginI18n.createDefault();
        login.setHeader(new LoginI18n.Header());
        login.getForm().setTitle(appName);
        return login;
    }
}
