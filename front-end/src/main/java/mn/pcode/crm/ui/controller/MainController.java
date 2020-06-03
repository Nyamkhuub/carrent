package mn.pcode.crm.ui.controller;

import com.vaadin.flow.component.notification.Notification;
import org.springframework.stereotype.Service;

@Service
public class MainController {

    public void greetingBtn(String text) {
        Notification.show("From controller");
    }
}
