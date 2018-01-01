/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.Util;

import com.disperindag.dao.daoData_Master;
import com.disperindag.model.Master;
import com.disperindag.tableModel.TabelModel_master;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;

/**
 *
 * @author oscar
 */
public class WorkerMaster extends SwingWorker<List<Master>, String> {

    private Connection con;
    private TabelModel_master model;
    private ResultSet result;
    private WorkerAction w;

    public WorkerMaster(Connection con, TabelModel_master model, WorkerAction w) throws SQLException {
        this.con = con;
        this.model = model;
        this.w = w;
        this.result = daoData_Master.getMaster(con);
        w.startLoading();
    }

    @Override
    protected List<Master> doInBackground() throws Exception {
        return daoData_Master.getAllMaster(result);
    }
    
    @Override
    protected void done() {
        try {
            model.setData(get());
        } catch (InterruptedException ex) {
            Logger.getLogger(WorkerMaster.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(WorkerMaster.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                w.doneLoading();
                result.close();
            } catch (SQLException ex) {
                Logger.getLogger(WorkerMaster.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
