package by.skakun.carrentalsystem.command.admin;

import by.skakun.carrentalsystem.command.ActionCommand;
import by.skakun.carrentalsystem.connectionpool.ConnectionPool;
import by.skakun.carrentalsystem.dao.impl.OrderDaoImpl;
import by.skakun.carrentalsystem.exception.DAOException;
import by.skakun.carrentalsystem.manager.ConfigurationManager;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;

public class DeleteApplicationACommand implements ActionCommand {

    private static final Logger LOG = Logger.getLogger(DeleteApplicationACommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page;

        LOG.info("DeleteApplicationACommand");
        boolean flag = false;
        String idA = (String) request.getParameter("applId");
        LOG.info(idA);
        int id = Integer.parseInt(idA);
        LOG.info("Application id" + id);
        OrderDaoImpl applDao;
        try {
            applDao = new OrderDaoImpl();
        } catch (DAOException ex) {
            LOG.fatal("Couldn't establish the connection to the database");
            LOG.info("->errorpage");
            page = ConfigurationManager.getProperty("path.page.error");
            return page;
        }
        try {
            flag = applDao.delete(id);
        } catch (DAOException ex) {
            LOG.info("DAOException while PayCommand: " + ex);
        }
        if (flag) {
        //    LOG.info("True");
            //    request.setAttribute("success", "1");
            page = new UnpaidOrdersCommand().execute(request);
            return page;
        } else {
        //    LOG.info("False");
            //    request.setAttribute("fail", "1");
            page = new UnpaidOrdersCommand().execute(request);
            return page;
        }

    }
}
