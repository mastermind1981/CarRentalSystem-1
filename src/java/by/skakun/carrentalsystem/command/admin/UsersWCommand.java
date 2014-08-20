package by.skakun.carrentalsystem.command.admin;

import by.skakun.carrentalsystem.command.ActionCommand;
import by.skakun.carrentalsystem.manager.ConfigurationManager;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;

/**
 *
 * @author Skakun
 */
public class UsersWCommand implements ActionCommand{
    private static final Logger LOG = Logger.getLogger(UsersWCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        LOG.info("->usersW");
        String page = ConfigurationManager.getProperty("path.page.users");
        return page;
    
    }
    
}
