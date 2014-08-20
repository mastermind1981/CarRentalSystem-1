package by.skakun.carrentalsystem.command.admin;

import by.skakun.carrentalsystem.command.ActionCommand;
import by.skakun.carrentalsystem.connectionpool.ConnectionPool;
import by.skakun.carrentalsystem.dao.impl.CarDaoImpl;
import by.skakun.carrentalsystem.exception.DAOException;
import by.skakun.carrentalsystem.manager.ConfigurationManager;
import java.util.logging.Level;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;

/**
 *
 * @author Skakun
 */
public class ChangeCarPriceCommand implements ActionCommand {

    private static final Logger LOG = Logger.getLogger(ChangeCarPriceCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        boolean flag;
        LOG.info("ChangeCarPriceCommand");
        String carid = (String) request.getParameter("carid");
        int id = Integer.parseInt(carid);
        String carprice = (String) request.getParameter("newprice");
        int price = Integer.parseInt(carprice);
        CarDaoImpl carDao = new CarDaoImpl(ConnectionPool.getConnection());
        try {
            flag = carDao.changeCarprice(price, id);
            if (flag) {
                request.setAttribute("psuccess", "1");
                page = ConfigurationManager.getProperty("path.page.carchange");
                return page;
            } else {
                request.setAttribute("pfail", "1");
                page = ConfigurationManager.getProperty("path.page.carchange");
                return page;
            }
        } catch (DAOException ex) {
            LOG.info("DAOException while ChangeCarPriceCommand");
            page = ConfigurationManager.getProperty("path.page.carchange");
            return page;
        }

    }

}
