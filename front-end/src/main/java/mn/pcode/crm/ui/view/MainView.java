package mn.pcode.crm.ui.view;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import mn.pcode.crm.ui.config.MainProperties;
import mn.pcode.crm.ui.controller.MainController;
import mn.pcode.crm.ui.service.CarInfoService;
import mn.pcode.crm.ui.widget.CarUI;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.awt.*;

enum TabName {
    HOME,
    ABOUT,
    LOGIN
}
/**
 * Car rent main view class.
 *
 */
@Route
@Viewport("width=device-width, minimum-scale=1, initial-scale=1, user-scalable=yes, viewport-fit=cover")
@PWA(name = "Car-rent",
        shortName = "CR",
        description = "Car rent open source platform",
        enableInstallPrompt = false)
@EnableConfigurationProperties(MainProperties.class)
public class MainView extends AppLayout {

    @Autowired
    private MainController controller;

    @Autowired
    private CarInfoService carInfoService;

    private final LoginForm loginForm;
    private final MainProperties properties;
    private final Tabs mainTabs;
    private final Image logo;
    private final HorizontalLayout mainCarList;

    private boolean isInitialized = false;

    public MainView(final MainProperties mainProperties) {
        this.properties = mainProperties;
        this.loginForm = new LoginForm();
        this.logo = new Image(properties.getLogo(), properties.getAlt());
        mainCarList = new HorizontalLayout();
        this.mainTabs = new Tabs(
                new Tab(StringUtils.capitalize(TabName.HOME.toString().toLowerCase())),
                new Tab(StringUtils.capitalize(TabName.ABOUT.toString().toLowerCase())),
                new Tab(StringUtils.capitalize(TabName.LOGIN.toString().toLowerCase())));

        initUI();
    }

    /**
     * initialize main view.
     */
    private void initUI() {
        logo.setHeight(properties.getHeight());
        addToNavbar(new DrawerToggle(), logo);
        mainTabs.setOrientation(Tabs.Orientation.VERTICAL);
        addToDrawer(mainTabs);
        loginSetup();
        addListeners();
    }

    private void loginSetup() {
        loginForm.setI18n(loginInfo());
        this.loginForm.addLoginListener(loginEvent -> {
            mainTabs.setSelectedIndex(0);
        });
    }

    /**
     * add required Event listeners to components.
     */
    private void addListeners() {
        mainTabs.addSelectedChangeListener(event -> {
            String selectedMenu = event.getSelectedTab().getLabel().toUpperCase();
            switch (TabName.valueOf(selectedMenu)) {
               case HOME:
                   showListOfCar();
                   break;
                case ABOUT:
                    setContent(new Text("About section"));
                    break;
                case LOGIN:
                    showLoginWindow();
                    break;
            }
        });
    }
    private void showLoginWindow() {
        Dialog loginWindow = new Dialog();
        loginWindow.add(this.loginForm);
        loginWindow.open();
        loginWindow.addDialogCloseActionListener(dialogCloseActionEvent -> {
            mainTabs.setSelectedIndex(0);
            loginWindow.close();
        });
    }

    private void showListOfCar() {
        if (this.isInitialized) {
            setContent(mainCarList);
        } else {
            carInfoService.getCarInfoList().stream().forEach(car -> {
                mainCarList.add(new CarUI(car));
            });
            this.isInitialized = true;
            setContent(mainCarList);
        }
    }

    private LoginI18n loginInfo() {
        final LoginI18n login = LoginI18n.createDefault();
        login.setHeader(new LoginI18n.Header());
        login.getForm().setForgotPassword("Forget password/Sign up");
        login.getForm().setTitle(properties.getAppName());
        return login;
    }
}
