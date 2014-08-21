package by.skakun.carrentalsystem.command.user;

import by.skakun.carrentalsystem.command.ActionCommand;
import by.skakun.carrentalsystem.dao.impl.OrderDaoImpl;
import by.skakun.carrentalsystem.exception.DAOException;
import by.skakun.carrentalsystem.util.ConfigurationManager;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;

/**
 *
 * @author Skakun
 * 
 * deleting not wanted order
 */
public class DeleteOrderCommand implements ActionCommand {

    private static final Logger LOG = Logger.getLogger(DeleteOrderCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page;

        LOG.info("DeleteApplicationCommand");
        boolean flag = false;
        String idA = (String) request.getParameter("applid");
        int id = Integer.parseInt(idA);
        OrderDaoImpl orderDao;
        try {
            orderDao = new OrderDaoImpl();
        } catch (DAOException ex) {
            LOG.fatal("Couldn't establish the connection to the database", ex);
            LOG.info("->errorpage");
            page = ConfigurationManager.getProperty("path.page.error");
            return page;
        }
        try {
            flag = orderDao.delete(id);
        } catch (DAOException ex) {
            LOG.info("DAOException while PayCommand: " + ex);
        }
        if (flag) {
            page = new BasketCommand().execute(request);
            return page;
        } else {
            page = new BasketCommand().execute(request);
            return page;
        }

    }
}